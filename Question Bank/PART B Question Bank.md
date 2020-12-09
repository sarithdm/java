## 1.  With a neat sketch explain the processes involved in the life cycle of an EJB (10 Marks) Dec 2019,Dec 2018
* The client locates the bean’s home using the JNDI(Java Naming and Directory Interface) services in the application server.
* The JNDI service returns a reference to the client’s Home interface.
* The client uses its Home interface to call home.create(). In response to this call, the Home object creates an EJBObject. A new instance of the code in the bean class is also instantiated by the newInstance() method.
* The new instance of the bean class is given a session context. This instantiation is now called a Session Bean.
* The Home object gives the client’s Remote interface a reference to the EJBObject in the container.
* The client’s Remote interface can now invoke methods on the EJBObject in the container. This EJBObject then passes these method calls to the Session Bean
* The session bean returns a resultset to the EJBObject, which in turn returns it to the client’s Remote interface.

