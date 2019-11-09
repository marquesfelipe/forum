# forum
aplicação REST com Spring Boot, tendo como base projeto da Alura

```
Dicas:
Está sendo utilizado o cache em memória do spring, em produção o ideal é usar um provedor de cache, por exemplo o redis.

1-colocar a dependência:
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>2.1.2.RELEASE</version>
</dependency>

2- configurar no properties:
 
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379

3- colocar nos controllers, exemplo:
    @Cacheable(cacheNames = "Company",key="#root.method.name")
    @CacheEvict(cacheNames = "Company", allEntries = true)
    
    ```
