##Windows
* Step 1: Create a directory with name lab in C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps 
* Step 2: Create a directory with name WEB-INF in lab
* Step 3: Create a directory with name classes in WEB-INF
* Step 4: Create a directory with name src in WEB-INF
* Step 5: Create the deployment descriptor [web.xml](https://github.com/sarithdm/java/blob/master/Lab/Experiment%201/WEB-INF/web.xml "web.xml") file in WEB-INF
* Step 6: Create [HelloWorld.java](https://github.com/sarithdm/java/blob/master/Lab/Experiment%201/src/HelloWorld.java) file in src folder
* Step 7: Compile class file using below command from the directory src.
javac -classpath "C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar" HelloWorld.java
* Step 8: Copy HelloWorld.class file created to classes directory
* Step 9: Start your tomcat server
* Step 10: Open web browser and accesss servelt from http://localhost:8080/lab/HelloWorld
