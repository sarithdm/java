## 1.  Differentiate between 2-tier and 3-tier JDBC architecture. (5 marks)
* The JDBC API supports both two-tier and three-tier processing models for database access.

https://docs.oracle.com/javase/tutorial/jdbc/overview/architecture.html

## 2. Give any three methods to overcome the stateless nature of HTTP protocol (9 marks)

* Cookies

A cookie is a small piece of information that is persisted between the multiple client requests
A cookie has a name, a single value, and optional attributes such as a comment, path and domain qualifiers, a maximum age, and a version number

By default, each request is considered as a new request. 
In cookies technique, we add cookie with response from the servlet. 
So cookie is stored in the cache of the browser. 
After that if request is sent by the user, cookie is added with request by default. 
Thus, we recognize the user as the old user.

    Cookie ck=new Cookie("user",”shijin knox");//creating cookie object  
    response.addCookie(ck);//adding cookie in      the response  
    
    //deleting value of cookie
    Cookie ck=new Cookie("user","");   
    //changing the maximum age to 0 seconds
    ck.setMaxAge(0);   
    //adding cookie in the response
    response.addCookie(ck);  


* Hidden Form Field

A hidden (invisible) textfield is used for maintaining the state of an user.
<input type="hidden" name="uname" value=“shijin knox">

It will always work whether cookie is disabled or not.


It is maintained at server side.
Extra form submission is required on each pages.
Only textual information can be used.


* URL Rewriting

Assuming a form with a hidden field is submitted using the GET method, what the server really sees is just a request whose URI has been extended with an encoding of the value in the hidden field.
In URL-rewriting we cut out role of the browser (encoding session data from hidden fields) and directly extend the URL in the action attribute of the form with an encoding of the session data.
Advantage of URL Rewriting
It will always work whether cookie is disabled or not (browser independent).
Extra form submission is not required on each pages.
Disadvantage of URL Rewriting
It will work only with links.
It can send Only textual information.

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

Container creates a session id for each user.
The container uses this id to identify the particular user.
An object of HttpSession can be used to perform two tasks:
bind objects
view and manipulate information about a session, such as the session identifier, creation time, and last accessed time.

    HttpSession session=request.getSession();  
            session.setAttribute("uname",n);  

