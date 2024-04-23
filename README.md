# solvatesttask

## Swagger

http://localhost:8080/api/v1/swagger-ui/index.html#/


## How to run app
Clone this repository

run `docker-compose up`

### DB migrations
Done by [Flyway](https://flywaydb.org) on application start see `src/main/java/resources/db/migration`
In future more migration, and moments-hibernate-ddl-auto

1. Multi-language project (used Java + Kotlin)
2. API request done by Feign
3. All currencies saved in Redis, ttl: 1day
4. Update currencies by using spring scheduler
5. DB migration script
6. Gradle used