Title: Validation Layer

Duration: 45 to 60 seconds

Never validate requests manually in Controllers.

If statements everywhere create messy code.

if name is null.

if email is invalid.

if password is empty.

This makes controllers hard to maintain.

Correct approach:

Bean Validation.

Use @Valid.

Use @NotBlank.

Use @Email.

Use @Size.

Validation belongs in the request model.

Controller only receives validated data.

This creates clean controllers.

This creates reusable rules.

This creates better APIs.

Use Bean Validation.

Follow for more Java REST API best practices.