# CloudProject
ERP parte del proyecto de CLOUD SECURITY

## Consideraciones
Se usa Docker para correr la imagen de MySQL y realizar pruebas localmente, usar las siguientes lineas para reemplazar en el properties y correr localmente

```
spring.datasource.url=jdbc:mysql://localhost:3306/cloudDB
spring.datasource.username=root
spring.datasource.password=1234
```

Luego, ejecutar localmente los siguientes comandos (suponiendo que tiene docker en su maquina)

```bash
docker pull mysql
docker run --name cloudProject -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=cloudDB -p 3306:3306 -d mysql:latest
```

comprobar que este corriendo la imagen correspondiente, luego compilar el proyecto y correrlo con los siguientes comandos

```bash
mvn clean install
mvn spring-boot:run
```
