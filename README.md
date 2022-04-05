# Zemoga
##Local
###Prerequisitos 
* docker
* docker-compose
* maven
* nodejs
* java11
1. Ingresar en la terminal a la raiz del proyecto angular-app
2. Generar la imagen del proyecto frontend
````
docker build -t frontend:latest .
````
3. Ingresar en la terminal en la raíz del zemoga
4. Compilar el proyecto
````
mvn clean install -DskipTests
````
5. Generar la imagen del proyecto backend
````
docker build -t backend:latest .
````
7. Luego de generar las imagenes del frontend y el backend, regresar a la raiz del proyecto donde se encuentra el archivo docker-compose.yml
8. Levantar la imagen de MySQL
````
docker-compose up -d mysql
````
9. Levantar la imagen del backend
````
docker-compose up -d backend
````
9. Levantar la imagen del frontend
````
docker-compose up -d frontend
````
10. En el navegador puede acceder a la documentación de la API que esta disponible en http://localhost:20212/zemoga/swagger-ui/
11. En el navegador puede acceder a la interfaz grafica http://localhost:20213/
Si desea conectarse a la base de datos a través de un cliente utilice los siguientes datos
````
usuario: root
contraseña: 123456
url: jdbc:mysql://localhost:20211
````