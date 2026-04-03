// ❌ BAD PRACTICE - Open API Without Security

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping
    public List<Order> getOrders() {
        return List.of(
                new Order(1L, "Laptop", 1200),
                new Order(2L, "Phone", 800)
        );
    }
}

// ✅ GOOD PRACTICE - Security Configuration

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .headers(headers -> headers
                .contentSecurityPolicy("default-src 'self'")
                .frameOptions(frame -> frame.deny())
                .httpStrictTransportSecurity(hsts ->
                    hsts.includeSubDomains(true)
                        .maxAgeInSeconds(31536000)
                )
            );

        return http.build();
    }
}

// ✅ JWT Filter

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        if (jwtService.validateToken(token)) {

            UsernamePasswordAuthenticationToken auth =
                    jwtService.getAuthentication(token);

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}

// ✅ Rate Limiting Filter

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private final Map<String, Integer> requestCount = new ConcurrentHashMap<>();
    private static final int MAX_REQUESTS = 100;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String ip = request.getRemoteAddr();

        requestCount.put(ip, requestCount.getOrDefault(ip, 0) + 1);

        if (requestCount.get(ip) > MAX_REQUESTS) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.getWriter().write("Too many requests");
            return;
        }

        filterChain.doFilter(request, response);
    }
}

// ✅ Protected Controller

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {

        List<Order> orders = List.of(
                new Order(1L, "Laptop", 1200),
                new Order(2L, "Phone", 800)
        );

        return ResponseEntity.ok(orders);
    }
}