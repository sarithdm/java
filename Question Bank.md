## 1.  With a neat sketch explain the processes involved in the life cycle of an EJB (10 Marks) Dec 2019,Dec 2018
* The client locates the bean’s home using the JNDI(Java Naming and Directory Interface) services in the application server.
* The JNDI service returns a reference to the client’s Home interface.
* The client uses its Home interface to call home.create(). In response to this call, the Home object creates an EJBObject. A new instance of the code in the bean class is also instantiated by the newInstance() method.
* The new instance of the bean class is given a session context. This instantiation is now called a Session Bean.
* The Home object gives the client’s Remote interface a reference to the EJBObject in the container.
* The client’s Remote interface can now invoke methods on the EJBObject in the container. This EJBObject then passes these method calls to the Session Bean
* The session bean returns a resultset to the EJBObject, which in turn returns it to the client’s Remote interface.

![EJB Life Cycle](/img/1.png)

## 2. With a neat sketch explain CORBA Architecture (10 Marks) Dec 2018, Dec 2019

* CORBA relies on the protocol Internet InterORB Protocol (IIOP) for communications between objects. 
* The center of the CORBA architecture lies in the Object Request Broker (ORB).
* The ORB is a distributed programming service that enables CORBA objects to locate and communicate with one another.
* CORBA objects have interfaces that expose sets of methods to clients. 
* To request access to an objects method, a CORBA client acquires an object reference to a CORBA server object. 
* Then the client makes method calls on the object reference as if the CORBA object were local to the client.
* The ORB finds the CORBA object and prepares it to receive requests, to communicate requests to it, and then to communicate replies back to the client.

![CORBA](/img/2.png)

## 3. What are Message Driven Beans?

* The Message-Driven Bean (MDB) is a stateless component that is invoked by a container as a result of the arrival of a JMS message
* A MDB acts as a message consumer, it receives messages from a JMS Topic and performs business logic based on the message contents
* Message-Driven Bean Container Services
    * MDB life cycle management
    * Exception handling
    * Threading and concurrency
    * Message acknowledgment
    * Security
## 4. Illustrate the steps involved in the building of a session bean (10 Marks) Dec 2018

* Useful for maintain sessions
* A session bean is an EJB that is created by a client and usually exists only for the duration of a single client-server session
* A session bean usually performs operations such as calculations or database access on behalf of the client
* it is not recoverable if a system crash occurs.

* Define state attribute
   * Stateful / stateless / singleton
* Define the Session Bean Class
   * Public
* Session Beans and Inheritance
* Implement Session Bean Interface
   * ejbActivate()
   * ejbPassivate()
   * ejbRemove()
   * setSessionContext(SessionContext)
      (Remote clients access a session bean via their remote and remote home interfaces (javax.ejb.EJBObject and javax.ejb.EJBHome, respectively))
* Create Remote Interfaces
   * All remote interfaces must extend the class javax.ejb.EJBObject
* Create Home Interface
* Create Session Bean Class Methods
   * Session bean classes are used as the “molds” for instantiating session bean instances.
   * These instances are indirectly called as local and remote clients via home and remote interfaces.
* Create Business Methods
* Create Stub, Tie, and Object
* Package and Deploy the Session Bean

Example: https://docs.oracle.com/cd/B14099_19/web.1012/b15505/session.htm

## 5. Illustrate the steps involved in the building of an entity bean (10 Marks) 

* An entity bean is an object representation of persistent data maintained in a permanent data store such as a database.
* Entity beans represent specific data or collections of data, such as a row in a relational database.
* An entity bean can be created in two ways:
   * by direct action of the client in which a create method is called on the bean’s Home interface
   * by some other action that adds data to the database that the bean type represents.
 
* An entity bean can implement either bean-managed or container-managed persistence.
   * In the case of bean-managed persistence, the implementer of an entity bean stores and retrieves the information managed by the bean through direct database calls. 
   * The bean may utilize either JDBC or SQLJ 
   * In the case of container-managed persistence, the container provider may implement access to the database using standard APIs. 
   * The container provider can offer tools to map instance variables of an entity bean to calls to an underlying database. 
> Steps

* Set Up A Data Source to a Database
* Develop a Primary Key Class
* Develop the Entity Bean Class
* Define the Home or Local Home Interface
* Define the Local or Remote Interface
* Define a Deployment Descriptor
* Deploy Using Container-Provided Tools
* Create a Client Application

Example: https://docs.oracle.com/cd/A97335_02/apps.102/a83725/entity4.htm

## 6. Compare Java Messaging Services with Java Database Connectivity (5 Marks) Dec 2019
* JMS is a vendor-independent API used to access messaging systems. 
* It provides a common way for Java programmers to create, send, receive, and read an enterprise messaging system’s messages
* JMS provides vendor-independent access to messaging services.
* JMS allows messages to be sent from one JMS client to another via a messaging service called a message broker or a router.

* It is similar to Java Database Connectivity (JDBC), an API used to access different relational databases. 
* The Java Database Connectivity (JDBC) API provides universal data access from the Java programming language. 
* Using the JDBC API, you can access virtually any data source, from relational databases to spreadsheets and flat files. 
* JDBC technology also provides a common base on which tools and alternate interfaces can be built.


## 7. Compare two message models in JMS (5 Marks) 

* The Point-to-Point model sends messages to a receiver on a one-to-one basis.
   * Instant messaging
   * Receiving a transaction from another system
   * Sending an order to another system
   * Supply-chain processing
 * The Publish/Subscribe model allows an application to publish messages on either a one-to-many or a many-to-many basis.
   * Sending news stories to interested parties
   * Sending sales forecasts to various people in an organization
   * Sending stock prices to traders on the trading floor


## 8. Compare Message-Driven Beans (MDBs) and Session Beans (5 marks)
* Message bean has neither a Remote nor a Home interface.
* This is because the message bean is not an RPC component
* MDBs do not have business methods that are synchronously invoked by EJB clients
* In addition to MDBs being similar to stateless session beans because both beans maintain no state between requests
* MDBs can consume messages from any topic provided by a JMS-compliant vendor.
* Messages consumed by MDBs may have come from other beans such as session, entity or message beans, non-EJB Java applications or non-Java applications that use a JMS compliant vendor.

* Session beans is useful for maintain sessions
* A session bean is an EJB that is created by a client and usually exists only for the duration of a single client-server session
* A session bean usually performs operations such as calculations or database access on behalf of the client
* it is not recoverable if a system crash occurs.

## 9. Compare Message-Driven Beans (MDBs) and Entity Beans (5 marks)
* Message bean has neither a Remote nor a Home interface.
* This is because the message bean is not an RPC component
* MDBs do not have business methods that are synchronously invoked by EJB clients
* In addition to MDBs being similar to stateless session beans because both beans maintain no state between requests
* MDBs can consume messages from any topic provided by a JMS-compliant vendor.
* Messages consumed by MDBs may have come from other beans such as session, entity or message beans, non-EJB Java applications or non-Java applications that use a JMS compliant vendor.

* An entity bean is an object representation of persistent data maintained in a permanent data store such as a database.
* Entity beans represent specific data or collections of data, such as a row in a relational database.
* An entity bean can be created in two ways:
   * by direct action of the client in which a create method is called on the bean’s Home interface
   * by some other action that adds data to the database that the bean type represents.

## 10. Explain any two distributed programming services (8 marks)

* Naming and Registration : For each class installed in a container, the container automatically registers an EJBHome interface in a directory using the Java Naming and Directory Interface (JNDI) API. 
* Using JNDI, any client can locate the EJBHome interface to create a new bean instance or to find an existing entity bean instance.
* Remote Method Invocation (RMI): RMI is a high-level programming interface that makes the location of the server transparent to the client. 
* The RMI compiler creates a stub object for each Remote interface. The stub object is either installed on the client system or it can be downloaded at runtime, providing a local proxy object for the client. 
* The stub implements all the Remote interfaces and transparently delegates all method calls across the network to the remote object.












