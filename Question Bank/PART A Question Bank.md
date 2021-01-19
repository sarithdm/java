## 1.  Differentiate between 2-tier and 3-tier JDBC architecture. (5 marks)
* The JDBC API supports both two-tier and three-tier processing models for database access.

https://docs.oracle.com/javase/tutorial/jdbc/overview/architecture.html

## 2. Give any three methods to overcome the stateless nature of HTTP protocol (9 marks)

* Cookies

* A cookie is a small piece of information that is persisted between the multiple client requests
* A cookie has a name, a single value, and optional attributes such as a comment, path and domain qualifiers, a maximum age, and a version number

* By default, each request is considered as a new request. 
* In cookies technique, we add cookie with response from the servlet. 
* So cookie is stored in the cache of the browser. 
* After that if request is sent by the user, cookie is added with request by default. 
* Thus, we recognize the user as the old user.

    Cookie ck=new Cookie("user",”shijin knox");//creating cookie object  
    response.addCookie(ck);//adding cookie in      the response  
    
    //deleting value of cookie
    Cookie ck=new Cookie("user","");   
    //changing the maximum age to 0 seconds
    ck.setMaxAge(0);   
    //adding cookie in the response
    response.addCookie(ck);  


* Hidden Form Field

* A hidden (invisible) textfield is used for maintaining the state of an user.
        
        <input type="hidden" name="uname" value=“shijin knox">

* It will always work whether cookie is disabled or not.


* It is maintained at server side.
* Extra form submission is required on each pages.
* Only textual information can be used.


* URL Rewriting

* Assuming a form with a hidden field is submitted using the GET method, what the server really sees is just a request whose URI has been extended with an encoding of the value in the hidden field.
* In URL-rewriting we cut out role of the browser (encoding session data from hidden fields) and directly extend the URL in the action attribute of the form with an encoding of the session data.
* Advantage of URL Rewriting
* It will always work whether cookie is disabled or not (browser independent).
* Extra form submission is not required on each pages.
* Disadvantage of URL Rewriting
* It will work only with links.
* It can send Only textual information.

        <form action="servlet1">  
        Name:<input type="text" name="userName"/><br/>  
        <input type="submit" value="go"/>  
        </form>

        //appending the username in the query string  
                out.print("<a href='servlet2?uname="+n+"'>visit</a>");             
        //getting value from the query string  
                String n=request.getParameter("uname");  
                out.print("Hello "+n); 

* HttpSession

* Container creates a session id for each user.
* The container uses this id to identify the particular user.
* An object of HttpSession can be used to perform two tasks:
bind objects
* View and manipulate information about a session, such as the session identifier, creation time, and last accessed time.


        HttpSession session=request.getSession();  
                session.setAttribute("uname",n);  

# 3. Explain the methods used to implement the life cycle of Servlets.

* The servlet is initialized by calling the init() method.
* The servlet calls service() method to process a client's request.
* The servlet is terminated by calling the destroy() method.
* Finally, servlet is garbage collected by the garbage collector of the JVM

# 4. List out the benefits of Servlets.

* Portability - Write once, serve everywhere
* Power - Can take advantage of all Java APIs
* Elegance - Simplicity due to abstraction
* Efficiency & Endurance - Highly scalable
* Safety 
* Integration - Servlets tightly coupled with server
* Extensibility & Flexibility

# 5. Explain advantage of 3-Tier Systems (5 marks)

* Central Database Server accessed by multiple Application Servers
* In turn, each Application Server could independently manage thousands of users
* Database Server is specially designed to do its job
* Database Operations: Update, Insert, Remove, etc.
* Lots of disk storage and memory needed
* Application Servers can be added to support more users or DIFFERENT APPLICATIONS
* Server Operations: Complex application-dependent computations
* Lots of processor power needed

# 6. Explain any two Session Tracking Techniques

* Hidden Form Field

* A hidden (invisible) textfield is used for maintaining the state of an user.
        
        <input type="hidden" name="uname" value=“shijin knox">

* It will always work whether cookie is disabled or not.


* It is maintained at server side.
* Extra form submission is required on each pages.
* Only textual information can be used.


* URL Rewriting

* Assuming a form with a hidden field is submitted using the GET method, what the server really sees is just a request whose URI has been extended with an encoding of the value in the hidden field.
* In URL-rewriting we cut out role of the browser (encoding session data from hidden fields) and directly extend the URL in the action attribute of the form with an encoding of the session data.
* Advantage of URL Rewriting
* It will always work whether cookie is disabled or not (browser independent).
* Extra form submission is not required on each pages.
* Disadvantage of URL Rewriting
* It will work only with links.
* It can send Only textual information.

        <form action="servlet1">  
        Name:<input type="text" name="userName"/><br/>  
        <input type="submit" value="go"/>  
        </form>

        //appending the username in the query string  
                out.print("<a href='servlet2?uname="+n+"'>visit</a>");             
        //getting value from the query string  
                String n=request.getParameter("uname");  
                out.print("Hello "+n); 
# 7. What is a cookie? List two types of cookies (5 marks)
* A cookie is a small piece of information that is persisted between the multiple client requests
* A cookie has a name, a single value, and optional attributes such as a comment, path and domain qualifiers, a maximum age, and a version number

* By default, each request is considered as a new request. 
* In cookies technique, we add cookie with response from the servlet. 
* So cookie is stored in the cache of the browser. 
* After that if request is sent by the user, cookie is added with request by default. 
* Thus, we recognize the user as the old user.

* There are 2 types of cookies in servlets.
* Non-persistent cookie : It is valid for single session only. It is removed each time when user closes the browser.
* Persistent cookie : It is valid for multiple session . It is not removed each time when user closes the browser

# 8. Explain methods of Cookie class

* public void setMaxAge(int expiry)
Sets the maximum age of the cookie in seconds.
* public String getName()
Returns the name of the cookie. The name cannot be changed after creation.
* public String getValue()
Returns the value of the cookie.
* public void setName(String name)
changes the name of the cookie.
* public void setValue(String value)
changes the value of the cookie.
# 9. With a neat diagram explain the life cycle of a web application

https://docs.oracle.com/javaee/6/tutorial/doc/bnadu.html


# 10. List any five standard services & supporting technologies in J2EE

* Java database connectivity(JDBC) data access API
* Java Messaging Service (JMS)
* Remote Method Invocations (RMI)
* Extensible Markup Languages(XML)
* JavaIDL (Interface Description Language)
* JavaMail
* Java Security
* CORBA technology
* Design Patterns

# 11. Explain JDBC Components (5 marks)
* DriverManager: This class manages a list of database drivers
* Driver: This interface handles the communications with the database server
* Connection: This interface with all methods for contacting a database. 
* Statement: You use objects created from this interface to submit the SQL statements to the database. 
* ResultSet: These objects hold data retrieved from a database
* SQLException: This class handles any errors that occur in a database application.









