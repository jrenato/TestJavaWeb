<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html xmlns="http://www.w3.org/1999/xhtml"> 
 <head>
  <title>Consulta de Pessoa</title>
 </head>
 <body>
   <f:view>
     <h:form id="form">
        Nome: <h:inputText value="#{pessoaBean.pessoaSelecionada.nome}" />
        <br />
        Email: <h:inputText value="#{pessoaBean.pessoaSelecionada.email}" />
        <br />
        <h:commandButton action="#{pessoaBean.gravar}" />
     </h:form>
   </f:view>
 </body>
</html> 