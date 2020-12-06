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

## 11. Explain the Container Managed Persistence of an EJB ( 5 marks) Dec 2018

* In container-managed persistence, entity bean data is maintained automatically by the container that uses the mechanism of its choosing.
* For example, a container implemented on top of a Relational Database Management System (RDBMS) may manage persistence by storing each bean’s data as a row in a table.
* Container Managed Persistent Entity Beans’s Life Cycle

## 12. Explain the Bean Managed Persistence of an EJB ( 5 marks)

* This is a complex and intricate task.
* Thus, this mode must not be seen as a general development model, but more as a means to implement a low-level persistence mechanism if necessary
* When using bean-managed persistence (BMP), it is the bean that is responsible for storing and retrieving its persisted data.
* In BMP mode, the EJB must implement persistence. To do this, methods such as ejbStore and ejbLoad must be created and used, and communication with SQL databases must be implemented manually using JDBC.

## 13. Compare Container-Managed Persistence (CMP) and Bean-Managed Persistence (BMP) (5 marks)

* There are two ways that bean persistence can be managed. 
* The first method is to let the container manage the persistence of the bean. This method is called container managed persistence (CMP). 
* The second method for managing persistence is called bean-managed persistence (BMP).
* This method requires that the developer implement the interaction code between the EJB and the persistence engine.

* In container-managed persistence, entity bean data is maintained automatically by the container that uses the mechanism of its choosing.
* For example, a container implemented on top of a Relational Database Management System (RDBMS) may manage persistence by storing each bean’s data as a row in a table.
* Container Managed Persistent Entity Beans’s Life Cycle

* This is a complex and intricate task.
* Thus, this mode must not be seen as a general development model, but more as a means to implement a low-level persistence mechanism if necessary
* When using bean-managed persistence (BMP), it is the bean that is responsible for storing and retrieving its persisted data.
* In BMP mode, the EJB must implement persistence. To do this, methods such as ejbStore and ejbLoad must be created and used, and communication with SQL databases must be implemented manually using JDBC.

## 14. List out the benefits of Enterprise Java Beans (6 marks) Dec 2018

* Reusable application components :
   * component reuse and outsourcing,
   * declarative customization 
   * ability for the developer to focus on business logic only.
* Portability : 
   * can be run on any vendor’s application server.
   * Broad industry adoption:
   * Wider selection of vendor tools and components
* Application portability
   * Code is more than just platform independent; it is also middleware independent.
* No vendor lock-in
   * Architecture decisions are made at deployment, not at development
* Protection of IT investment
   * Wraps and integrates with the existing infrastructure, application, and data stores;


## 15. With a neat diagram show how can we perform distributed programming (5 marks) Dec 2018

* Client makes a call to what appears to be the interface of a business object.
* What it actually calls is a stub that mimics the interface of that business object.
* This layer between clients and business objects is added because it is more practical to place stubs in the remote and distributed locations of clients than it is to place complete copies in the location of business objects.
* In a distributed framework, the client calls a business method on a stub as if it were the real object. 
* The stub then communicates this request to a tie. The tie calls the method on the real business object. 
* The result is returned to the stub and the client
* A stub is also known as a proxy or a surrogate, and a tie is also known as a skeleton.

## 16. What are the characteristics of Stateless and Stateful session bean (3 marks) Dec 2018

* A session bean represents work performed by a single client
* That work can be performed within a single method invocation, or it may span across multiple method invocations.
* If the work spans multiple methods, the object must maintain the user’s object state between method calls. 
* The state management options for session beans are defined in the StateManagementType attribute in the DeploymentDescriptor object.
* Stateless beans are intended to perform individual operations automatically and don’t maintain state across method invocations.
* They’re also amorphous, in that any client can use any instance of a stateless bean at any time at the container’s discretion.
* Stateful session beans maintain state both within and between transactions. 
* Each stateful session bean is associated with a specific client. 
* Containers are able to save and retrieve a bean’s state automatically while managing instance pools of stateful session beans.
* Stateful session beans maintain data consistency by updating their fields each time a transaction is committed. 
* To keep informed of changes in transaction status, a stateful session bean implements the SessionSynchronization interface. 
* The container calls methods of this interface while it initiates and completes transactions involving the bean.

## 17. Summarize the differences between Home and EJBObject Interfaces of a Bean (5 marks) Dec 2019
* EJBHome Object : 
   * object that provides the life cycle operations (create, remove,find) for an EJB
   * The container’s deployment tools generate the class for the EJBHome object.
* EJBObject:
   * EJBObject represents a client view of the EJB.
   * The EJBObject exposes all of the application related interfaces for the object, but not the interfaces that allow the EJB container to manage and control the object.
* Home Interface:
   * The EJBHome object implements the EJB’s Home interface
   * provides access to the bean’s life cycle services and can be utilized by a client to create or destroy bean instances.
* EJBObject Interface:
   * The EJBObject interface provides access to the business methods within the EJB.





