# Day 14 - Caching Strategy

## Problem

Querying the database on every request creates:

* slow responses
* high database load
* performance issues
* scalability problems

## Bad Practice

Client → API → Database

Every request hits the database.

## Good Practice

Client → API → Cache → Database

Cache stores frequently requested data.

## Benefits

* faster responses
* reduced database load
* better performance
* scalable APIs
* improved user experience

## Technologies

* Spring Cache
* Redis
* Memcached
* Caffeine
* CDN Cache
* API Gateway Cache

## Example

@Cacheable("products")

## Key Idea

Do not query the database if the data already exists in cache.
