## 1.  Write a JSP code to implement hit counter for the session (10 marks)
######  hitcount.jsp
        <HTML>
        <HEAD>
       
        </HEAD>
        <BODY>
        <%@ page language="java" %>

        <jsp:useBean id="counter" scope="session" class="com.it409.Counter" />

        <jsp:setProperty name="counter" property="count" param="count" />
        <%

            out.println("Count from scriptlet code : "
              + counter.getCount() + "<BR>");

        %>

        Count from jsp:getProperty :
          <jsp:getProperty name="counter" property="count" /><BR>

        </BODY>
        </HTML>
       
###### Counter.java        
        package com.it409;
        import java.io.Serializable;

        public class Counter implements Serializable{

          // Initialize the bean on creation
          int count = 0;

          // Parameterless Constructor
          public Counter() {

          }

          // Property Getter
          public int getCount() {

            // Increment the count property, with every request
            count++;

            return this.count;
          }

          // Property Setter
          public void setCount(int count) {

            this.count = count;
          }
        }
## 2.  Write a JSP code to implement hit counter for the application (10 marks)
######  hitcount.jsp
        <HTML>
        <HEAD>
       
        </HEAD>
        <BODY>
        <%@ page language="java" %>

        <jsp:useBean id="counter" scope="application" class="com.it409.Counter" />

        <jsp:setProperty name="counter" property="count" param="count" />
        <%

            out.println("Count from scriptlet code : "
              + counter.getCount() + "<BR>");

        %>

        Count from jsp:getProperty :
          <jsp:getProperty name="counter" property="count" /><BR>

        </BODY>
        </HTML>
       
###### Counter.java        
        package com.it409;
        import java.io.Serializable;

        public class Counter implements Serializable{

          // Initialize the bean on creation
          int count = 0;

          // Parameterless Constructor
          public Counter() {

          }

          // Property Getter
          public int getCount() {

            // Increment the count property, with every request
            count++;

            return this.count;
          }

          // Property Setter
          public void setCount(int count) {

            this.count = count;
          }
        }

## 3. List features of JSP Pages (5 marks)
* The Efficient Use of Server-Side Java
* Web Development, Deployment, and Maintenance are easy
* Components are Reusable (uses reusable components such as EJB)
* Separating Business Logic and Presentation
* Large Development Community and Widespread Support
* Platform Independence
* Next Generation Page Development with Tags

## 4. Explain in detail the Components of a JSP Page (10 marks)

* JSP Directives - used to pass instructions to the JSP engine
* JSP Tags – like html
* Scripting Elements – we can include small scripts called scriptlets

* Page directives —These directives communicate page-specific information, such as buffer and thread information or error handling.
* Language directives —These specify the scripting language, along with any extensions.
* The include directive — This directive can be used to include an external document in the page
* A taglib directive—This indicates a library of custom tags that the page can invoke.

* jsp:useBean—This tag declares the usage of an instance of a JavaBeans component.
* jsp:setProperty — This sets the value of a property in a bean.
* jsp:getProperty—This tag gets the value of a bean instance property, converts it to a string, and put it in the implicit object “out”.
* jsp:include — This tag will cause the specified file to be included in the current JSP page.
* jsp:forward — This tag will forward or redirect control to another JSP page.

* Expressions: <%= expression %> 
* Scriptlets: <% java code %> 
* Declarations: <%! code %> 


## 5. Explain any five implicit objects in JSP (5 marks) Dec 2019

* request  - This is the HttpServletRequest object associated with the request.
* response - This is the HttpServletResponse object associated with the response to the client.
* out - This is the PrintWriter object used to send output to the client.
* session - This is the HttpSession object associated with the request.
* application - This is the ServletContext object associated with the application context.
* config - This is the ServletConfig object associated with the page.
* pageContext - This encapsulates use of server-specific features like higher performance JspWriters. 
* page - This is simply a synonym for this, and is used to call the methods defined by the translated servlet class.
* Exception - The Exception object allows the exception data to be accessed by designated JSP.











