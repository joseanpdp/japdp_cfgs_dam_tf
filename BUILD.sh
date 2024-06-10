# 1. Activar la línea 9 de /client/src/Network.js
#
#       const serverUrl = "";
#
# 2. Eliminar el directorio antiguo

rm -rf server/src/main/resources/static/react

# 3. Construir el cliente y colocarlo en server/src/main/resources/static/

cd client
npm run build -- --base=/react
mv dist react
mv react ../server/src/main/resources/static/

cd ../server

# 4. Asegurar que el pom.xml es copia del apropiado
#
#       pom--JAR-MySQL.xml | pom--JAR-H2.xml

# 5. Asegurar que el aplication.properties es copia del apropiado
#
#       application.properties--MySQL_LOCAL | application.properties--H2 | application.properties--MySQL_WEB 

# 6. Limpiar (compilar) empaquetar en JAR ( target/cfgs-dam-tf.jar )

mvn clean package

# 7. Ejecutar 

java -jar target/cfgs-dam-tf.jar

# 8. Visualizar en el navegador
#
#        http://localhost:8080/react/index.html

