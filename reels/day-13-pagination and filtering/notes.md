# Day 13 - Pagination and Filtering

## Problem

Returning all records in an API response creates:

* large payloads
* slow database queries
* high memory usage
* poor performance
* scalability issues

## Bad Practice

GET /api/orders

Returns all records from database.

## Good Practice

GET /api/orders?page=0&size=10&status=PAID

Uses pagination and filtering.

## Benefits

* smaller responses
* faster queries
* better performance
* scalable APIs
* controlled data access

## Recommended Parameters

page
size
sort
filter

## Example

GET /api/orders?page=0&size=10&sort=createdAt,desc&status=PAID

## Key Idea

Never return all data in production APIs.
