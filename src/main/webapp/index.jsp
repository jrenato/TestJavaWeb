<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html xmlns="http://www.w3.org/1999/xhtml"> 
 <head>
  <title>enter your name page</title>
 </head>
 <body>
   <f:view>
     <h1>
     <h:form id="aax">
       <h:inputText id="txt" value="#{testeBean.nome}" />
     </h:form>
   </f:view>
 </body>
</html> 