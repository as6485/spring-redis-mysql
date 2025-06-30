
# Spring Redis + MySQL

Spring Boot App to demonstrate Redis caching with MySQL database


## Prerequisites

Install Docker Desktop
1. https://docs.docker.com/desktop/setup/install/windows-install/
2. Ensure Docker Desktop is up and running. We can check in command line as well (no errors)
```
docker info
```
3. Start the docker-compose.yaml at project root to spin up MySQL and Redis (with Redis Insights) in local

4. Access Redis Insights at http://localhost:5540/ and connect to the redis db providing details like (host:redis, port:6379). 
Since both redis and redis insights are in the same docker stack, we need to refer that host as "redis" and not "localhost"

5. Optionally we can install MySQL Workbench to connect to the db at 3307 and check the product table

## Start App

The Spring Cache abstraction uses annotations to define cache behavior:
* @EnableCaching: Enables Spring's annotation-driven cache management.
* @Cacheable: Indicates that the method's return value should be cached.
* @CachePut: Updates the cache without interfering with the method execution.
* @CacheEvict: Removes data from the cache.

1. Add products POST http://localhost:8080/api/products

{
"name": "Desktop",
"description": "HP Desktop"
}
Check Redis Insights for cache put entry

2. Fetch all products (not cacheable)
GET http://localhost:8080/api/products

This is fetched directly from my-sql. You can check hibernate query in the log to verify

3. Fetch a particular product (cacheable)
   GET http://localhost:8080/api/products/4

No query fired to database. Check log.


4. Delete a product. DELETE http://localhost:8080/api/products/4
   DB entry is deleted and Cache is evicted as well.


## Cache Eviction policy
1. Create a redis.conf file in the same directory as your docker-compose.yml. This file will contain your desired Redis configuration.
2. Modify your docker-compose.yml to mount the redis.conf file into the Redis container.
```
  - ./redis.conf:/usr/local/etc/redis/redis.conf
    command: redis-server /usr/local/etc/redis/redis.conf
```
3. [Overview of Redis key eviction policies](https://redis.io/docs/latest/develop/reference/eviction/)


## Acknowledgements

- [Spring Boot - Caching with Redis](https://www.geeksforgeeks.org/advance-java/spring-boot-caching-with-redis/)
- [Install Redis using docker and docker compose ](https://www.youtube.com/watch?v=qucL1F2YEKE)

## Authors

- [@as6485](https://github.com/as6485)