## 1.  Write a JSP code to implement hit counter for the session
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
## 2.  Write a JSP code to implement hit counter for the application
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
