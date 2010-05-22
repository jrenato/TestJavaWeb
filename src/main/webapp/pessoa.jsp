<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://www.medman.com/" prefix="d" %>

<html xmlns="http://www.w3.org/1999/xhtml"> 
 <head>
  <title>Consulta de Pessoa</title>
 </head>
 <body>
   <f:view>
     <h:form id="form">
     
        Lista de pessoas da base de dados: 
        <br />
        
        <h:dataTable id="dt1" value="#{pessoaBean.pessoas}" var="pessoa" border="1">
            <h:column>
                <f:facet name="header"><h:outputText value="Nome" /></f:facet>
                <h:commandLink action="#{pessoaBean.selecionar}">
                    <h:outputText value="#{pessoa.nome}" />
                </h:commandLink>
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Email" /></f:facet>
                <h:outputText value="#{pessoa.email}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Apagar" /></f:facet>
                <h:commandLink action="#{pessoaBean.apagar}">
                    Delete-me
                </h:commandLink>
            </h:column>
        </h:dataTable>

        <h:commandLink action="#{pessoaBean.criar}">
            Cadastrar Nova Pessoa
        </h:commandLink>
        
     </h:form>
   </f:view>
 </body>
</html>