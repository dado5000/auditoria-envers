# Auditoria de dados com Hibernate Envers
Aplicação java spring boot rest api

Projeto básico demostrando como auditar tabelas do banco de dados com hibernate Envers
* Java 11
* Spring Boot 2.7.7
* Banco de dados MySql - geração automática pelo jpa

Para utilizar o projeto basta fazer o clone deste repositório e rodar uma instalancia do MySQL5 localmente, dados de usuário e senha devem ser configurados na arquivo application.properties na pasta resourses do projeto.
* spring.datasource.url=jdbc:mysql://localhost/envers?createDatabaseIfNotExist=true&serverTimezone=UTC 
* spring.datasource.username=usuario-aqui
* spring.datasource.password=senha-aqui
