<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html xmlns="http://www.w3.org/1999/xhtml"> 
 <head>
  <title>Consulta de Estabelecimentos</title>
 </head>
 <body>
   <f:view>
     <h:form id="form">
        Lista de estabelecimentos da base de dados: 
        <br />
        
        <h:dataTable id="dt1" value="#{estabelecimentoBean.estabelecimentos}" var="estabelecimento" border="1">
            <h:column>
                <f:facet name="header"><h:outputText value="Nome" /></f:facet>
                <h:commandLink action="#{estabelecimentoBean.selecionar}">
                    <h:outputText value="#{estabelecimento.nome}" />
                </h:commandLink>
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="Endereco" /></f:facet>
                <h:outputText value="#{estabelecimento.endereco.logradouro}, #{estabelecimento.endereco.numero}" />
            </h:column>
            <h:column>
                <f:facet name="header"><h:outputText value="&nbsp;" escape="false" /></f:facet>
                <h:commandButton value = "Apagar" action="#{estabelecimentoBean.apagar}" />
            </h:column>
        </h:dataTable>
        
        <h:commandButton value="Novo" action="#{estabelecimentoBean.criar}" />
        
     </h:form>
   </f:view>
 </body>
</html>