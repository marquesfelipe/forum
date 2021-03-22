# Forum API
##Api para gerenciamento de topicos de um forum de cursos
##As tecnologias utilizadas são Java, Spring Boot

###Build
Antes de executar o build suba o Sonar, por exemplo via docker: docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest <br>
As credenciais padrão são admin:admin<br>
O comando para fazer o build é : clean package sonar:sonar -Dsonar.host.url=HOST_SONAR -Dsonar.login=LOGIN_SONAR -Dsonar.password=PASS_SONAR  



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
