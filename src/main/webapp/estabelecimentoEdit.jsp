<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Edi��o de Estabelecimento</title>
</head>
<body>
<f:view>
	<h:form id="form">
		<h:panelGrid columns="3">
			<h:outputText value="Nome:" />
			<h:inputText id="nome" value="#{estabelecimentoBean.estabelecimentoSelecionado.nome}" required="true" />
            <h:message for="nome" />

			<h:outputText value="Logradouro:" />
			<h:inputText id="logradouro" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.logradouro}" required="true" />
			<h:message for="logradouro" />
			
			<h:outputText value="Numero:" />
			<h:inputText id="numero" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.numero}" required="true" />
			<h:message for="numero" />

			<h:outputText value="Bairro:" />
			<h:inputText id="bairro" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.bairro}" required="true" />
			<h:message for="bairro" />
			
			<h:outputText value="Cidade:" />
			<h:inputText id="cidade" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.cidade}" required="true" />
			<h:message for="cidade" />
			
			<h:outputText value="Estado:" />
			<h:inputText id="estado" value="#{estabelecimentoBean.estabelecimentoSelecionado.endereco.estado}" required="true" />
			<h:message for="estado" />
		</h:panelGrid>

        <h:commandButton value="OK" action="#{estabelecimentoBean.gravar}" />
	</h:form>
</f:view>
</body>
</html>