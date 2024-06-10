### PROYECTO FIN DE CURSO:
# SISTEMA DE GESTIÓN DE PEDIDOS DE UN SUPERMERCADO
## CFGS DESARROLLO DE APLICACIONES MULTIPLATAFORMA

- *Autor*: **José Antonio Pérez de Prada**
- *Tutora*: **María Fernanda Hoyuela de la Cueva**

# ÍNDICE

1. [Introducción](#introducción)
2. [Funcionalidades del proyecto](#funcionalidades-del-proyecto)
3. [Tecnologías utilizadas](#tecnologías-utilizadas)
4. [Guía de instalación](#guía-de-instalación)
5. [Guía de uso](#guía-de-uso)
6. [Enlace a la documentación](#enlace-a-la-documentación)
7. [Enlace a figma de la interfaz](#enlace-a-figma-de-la-interfaz)
8. [Conclusión](#conclusión)
9. [Agradecimientos](#agradecimientos)
10. [Referencias](#referencias)
11. [Contacto](#contacto)

# Introducción
Una franquicia de supermercados ha solicitado realizar una aplicación para gestionar los pedidos que los clientes realicen en persona o a través de su página web oficial. 
Como se puede ver, la aplicación solicitada será para uso de los empleados y no para el público, por lo que cuenta con un sistema de inicio de sesión 
antes de poder acceder a la página de inicio.

Su objetivo principal es facilitar la gestión eficiente de los pedidos realizados por los clientes, ya sea en persona en las tiendas físicas o a través de la página web 
oficial del supermercado. Esto hace que la página web se caracterice por tener que gestionar tanto los datos de los clientes, como de sus pedidos además del 
stock de productos disponibles en el almacén.

# Funcionalidades del proyecto
Las funcionalidades del proyecto se centran en la gestión de tres áreas que se relacionan entre sí mediante los datos que manejan:
- Gestión de clientes.
- Gestión de pedidos.
- Gestión de productos clasificados en categorías.

Para acceder a cada una de estas funcionalidades, el usuario requiere autorización.

# Tecnologías utilizadas
## Herramientas de desarrollo:
### Eclipse
Eclipse es un entorno de desarrollo integrado utilizado principalmente para el desarrollo de aplicaciones en Java. Bajo el contexto del proyecto, se ha 
utilizado para desarrollar la parte del servidor.

### Visual Studio Code
Visual Studio Code es un editor de código fuente gratuito y de código abierto. Se ha utilizado para desarrollar la parte del cliente del proyecto con React.

### Tomcat
Apache Tomcat es un servidor web y contenedor de servlets que ejecuta aplicaciones Java. Es utilizado para desplegar aplicaciones web basadas en Java. Se ha utilizado para desplegar la aplicación.

### Git
Git es un sistema de control de versiones distribuido que facilita la colaboración y el manejo de diferentes versiones de proyectos, soportando ramificaciones y fusiones complejas. Se ha utilizado 
en la fase del desarrollo para controlar los cambios realizados en el proyecto.

### GitHub
GitHub es una plataforma de desarrollo colaborativo que utiliza Git para el control de versiones. Se ha utilizado una vez finalizado el desarrollo del proyecto para que sea de fácil acceso.

### Swagger
Swagger es un conjunto de herramientas de software para diseñar, construir, documentar y consumir API-REST. Se ha utilizado para desarrollar los endpoints de la 
parte del servidor en una fase previa a incorporar Spring Security.

### Spring Security sobre JWT
Spring Security es un framework de seguridad para aplicaciones basadas en Spring. Se ha utilizado para darle una capa más de seguridad a la aplicación al intentar acceder por el cliente.

### React
React es una biblioteca de JavaScript para construir interfaces de usuario. Permite a los desarrolladores crear componentes reutilizables y gestionar el estado de 
las aplicaciones de manera eficiente, facilitando la creación de aplicaciones web dinámicas y complejas. Se ha utilizado para desarrollar la parte visual de la aplicación.

### Maven
Maven es una herramienta de gestión y construcción de proyectos Java. Automatiza procesos como la compilación, el empaquetado y la gestión de dependencias, utilizando un 
archivo de configuración basado en XML para definir la estructura del proyecto. Se ha utilizado para gestionar la parte del servidor de forma más rápida y eficaz.

### Vite
Vite es una herramienta de desarrollo rápido para proyectos web moderna. Proporciona un entorno de desarrollo ágil con recarga en caliente y una construcción 
optimizada, soportando frameworks populares como Vue y React. Se ha utilizado para poder ejecutar localmente la parte del cliente desarrollada con React.

## Lenguajes utilizados:
### Java
Java es un lenguaje de programación orientado a objetos y una plataforma informática. Utilizado como código para el desarrollo del servidor.

### JavaScript
JavaScript es un lenguaje de programación de alto nivel, dinámico y orientado a objetos. JavaScript se ejecuta del lado del cliente. 

### MySQL
MySQL es un sistema de gestión de bases de datos relacional de código abierto. Es conocido por su rapidez, fiabilidad y facilidad de uso. Se ha usado para crear las tablas de la base de datos.

## Extras
### Google Drive
Google Drive es un servicio de almacenamiento en la nube ofrecido por Google. Se ha utilizado para ir creando y guardando la documentación del proyecto y los diagramas.

### draw.io
draw.io es una aplicación web para crear diagramas y gráficos. Se ha utilizado para crear los diagramas del proyecto.

## Figma
Figma es una herramienta de diseño de interfaces y prototipos basada en la web. Permite a los diseñadores crear, compartir y colaborar en diseños de interfaz de usuario en tiempo real. 
Se ha utilizado para diseñar la parte visual de la aplicación.

### Linux
Linux es un sistema operativo de código abierto basado en Unix. Es conocido por su estabilidad, seguridad y flexibilidad, y se utiliza ampliamente en servidores, 
dispositivos embebidos, y como sistema operativo de escritorio para desarrolladores.

# Guía de instalación
Desde el directorio base del proyecto
Construir el SPA React:
```bash
cd client
npm run build -- --base=/react
mv dist react
```

Colocar el SPA React en el directorio estático del servidor Spring Boot:

mv react ../server/src/main/resources/static/

Creación del JAR del servidor:
```bash
cd ../server
mvn clean package
```

Con esto se crea el archivo **cfgs-dam-tf.jar** en el subdirectorio **target**.
```
target/cfgs-dam-tf.jar
```

# Guía de uso
Si no movemos el archivo JAR, localmente podemos ejecutar la aplicación mediante
```bash
java -jar target/cfgs-dam-tf.jar
```

Para visualizar la aplicación debemos abrir la siguiente dirección mediante un navegador:
```
http://localhost:8080/react/index.html
```
El usuario administrador es **jose** y la contraseña inicial es **321**.

Para desplazarte por las diferentes pantallas de la web puedes usar este diagrama como guía:

# Enlace a la documentación
# Enlace a figma de la interfaz
[Enlace a Figma](https://www.figma.com/design/yPMvaXWOxKpPxtpMQ5nsLd/cliente-proyectoFinal?node-id=0-1&t=mXFJzBq235vmhnZL-1)
# Conclusión
En este apartado, se reflexiona sobre el desarrollo del proyecto de manera resumida. A lo largo del mismo, se ha llevado a cabo la creación de una aplicación de gestión, la cual se centra principalmente en la implementación de funcionalidades CRUD para todas las entidades involucradas. Esta aplicación permite realizar una pequeña y simple simulación de la gestión de pedidos y productos de un supermercado, facilitando así la comprensión y manejo de estos procesos.

Asimismo, gracias a la investigación y el manejo de las tecnologías presentadas a lo largo de la documentación del proyecto, se ha adquirido un conocimiento significativo y se han mejorado las habilidades técnicas relacionadas con dichas tecnologías. Este proceso de aprendizaje ha sido fundamental para el desarrollo exitoso de la aplicación.

Cabe destacar que, debido al desconocimiento inicial de algunas de las tecnologías utilizadas, como React, fue necesario invertir una parte considerable del tiempo de desarrollo en la investigación y práctica de esta herramienta. Esta inversión ha resultado en la consecución de los objetivos propuestos para la parte del frontend, aunque aún queda un amplio margen para futuras mejoras y optimizaciones.

En conclusión, el proyecto no solo ha permitido la creación de una aplicación funcional y efectiva para la gestión de un supermercado, sino que también ha servido como una valiosa experiencia de aprendizaje y desarrollo profesional en el uso de nuevas tecnologías.

# Agradecimientos
Quiero agradecer a los profesores del Grado Superior de Desarrollo de Aplicaciones Multiplataforma (DAM) por todo lo que me han enseñado durante estos dos años. Su dedicación, paciencia y compromiso con nuestra formación han sido invaluables.

Gracias a sus conocimientos y experiencia, he podido adquirir una sólida base en el desarrollo de aplicaciones, lo cual ha sido fundamental para llevar a cabo este proyecto. Su apoyo y orientación durante todo el proceso de desarrollo del proyecto han sido cruciales para superar los desafíos encontrados y lograr los objetivos planteados.

A todos los profesores, muchas gracias por su esfuerzo y por inspirarme a ser mejor cada día.

# Referencias
Materiales didácicos sobre de Spring Boot de Joaquín Borrego Fernández (CFGS DAM FP Vedruna)

Implementación de Spring Security con JWT de Joaquín Borrego Fernández (CFGS DAM FP Vedruna)

Introducción a React de Joaquín Borrego Fernández (CFGS DAM FP Vedruna)

Materiales didácticos sobre Spring Boot, SLF4J + Logback y JUnit5 + Mockito de Alejandro Téllez Rubio y Joaquín Matias Aguirre Oceja (Formación FP Dual NTT Data)

[Curso de Spring Data de Daniel Medina](https://danielme.com/2023/01/18/curso-spring-data-jpa-1-introduccion-que-es-spring-data)

["Deploy Spring Boot App as Traditional WAR on Tomcat Server"](https://howtodoinjava.com/spring-boot/deploy-spring-boot-traditional-war-on-tomcat/)

["Getting started with React"](https://developer.mozilla.org/en-US/docs/Learn/Tools_and_testing/Client-side_JavaScript_frameworks/React_getting_started)

["How to use async functions in useEffect (with examples) de Pierre Ouannes"](https://devtrium.com/posts/async-functions-useeffect)

[Ejemplos del libro React Quickly de M. Barklund y A. Mardan](https://reactquickly.dev/browse)

# Contacto
- **Correo electrónico**: joseanperezdp@gmail.com
- **GitHub**: joseanpdp
- **Linkedin**: [Perfil de Linkedin](https://www.linkedin.com/in/jos%C3%A9-antonio-p%C3%A9rez-de-prada-0305462a6/)

