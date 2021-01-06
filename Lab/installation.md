Install JDK 8: https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html

Install Tomcat 9.0.37:  https://tomcat.apache.org/download-70.cgi 

Install MySQL 8.0.21: https://dev.mysql.com/downloads/installer/

Download mysql connector from below link and save in the folder Tomcat 9.0\lib

https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.21/mysql-connector-java-8.0.21.jar

Use this [code](https://github.com/sarithdm/java/blob/master/Lab/database.jsp) to test database connectivity 



Ubuntu:

sudo apt-get install tomcat7 tomcat7-examples
sudo apt-get install mysql-server

To start/stop/restart Tomcat

sudo service tomcat7 start
sudo service tomcat7 stop
sudo service tomcat7 restart

To connect to MySQL
mysql -u root -p

Tomcat Webapps Folder

/var/lib/tomcat7/

Folder to save jar file
/usr/share/tomcat7/lib




 
