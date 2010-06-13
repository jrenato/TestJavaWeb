<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Edição de Estabelecimento</title>
</head>
<body>
<f:view>
	<h:form id="form">
		<h:panelGrid columns="3">
			<h:outputText value="Nome:" />
			<h:inputText id="nome" value="#{estabelecimentoBean.estabelecimentoSelecionado.nome}" required="true" maxlength="100" />
            <h:message for="nome" />

			<h:outputText value="Logradouro:" />
			<h:inputText id="logradouro" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.logradouro}" required="true" maxlength="100" />
			<h:message for="logradouro" />
			
			<h:outputText value="Numero:" />
			<h:inputText id="numero" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.numero}" required="true" />
			<h:message for="numero" />

			<h:outputText value="Bairro:" />
			<h:inputText id="bairro" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.bairro}" required="true" maxlength="100" />
			<h:message for="bairro" />
			
			<h:outputText value="Cidade:" />
			<h:inputText id="cidade" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.cidade}" required="true" maxlength="100" />
			<h:message for="cidade" />
			
			<h:outputText value="Estado:" />
			<h:inputText id="estado" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.estado}" required="true" maxlength="2" />
			<h:message for="estado" />

			<h:outputText value="&nbsp;" escape="false" />
	    	<h:commandButton value="Adicionar Telefone" action="#{estabelecimentoBean.criarTelefone}" />
	    	
	    	<br />

	        <h:outputText value="Telefones:" />
	        <h:dataTable id="dt2" value="#{estabelecimentoBean.telefones}" var="telefone" border="1">
	            <h:column>
	               <h:commandLink action="#{estabelecimentoBean.selecionarTelefone}">
	               		<h:outputText value="#{telefone.numero}" />
	               	</h:commandLink>
	               (<h:outputText value="#{telefone.tipo}" />)
	            </h:column>
	            <h:column>
	            	<h:commandButton value="Apagar" action="#{estabelecimentoBean.apagarTelefone}" />
	            </h:column>
	        </h:dataTable>
	        
        <br />
        <h:commandButton value="Confirmar Alterações" action="#{estabelecimentoBean.gravar}" />		
		
		</h:panelGrid>

	</h:form>
</f:view>
</body>
</html>
