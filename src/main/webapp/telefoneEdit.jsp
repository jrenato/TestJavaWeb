<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Edição de Telefone</title>
</head>
<body>
<f:view>
	<h:form id="form">
		<h:panelGrid columns="3">
			<h:outputText value="Número:" />
			<h:inputText id="numero" value="#{estabelecimentoBean.telefoneSelecionado.numero}" required="true" maxlength="100">
				<f:validator validatorId="telefoneValidator" />
			</h:inputText>
            <h:message for="numero" />

			<h:outputText value="Tipo:" />
			<h:inputText id="tipo" value="#{estabelecimentoBean.telefoneSelecionado.tipo}" maxlength="100" />
			<h:message for="tipo" />
			
		</h:panelGrid>

        <h:commandButton value="OK" action="#{estabelecimentoBean.gravarTelefone}" />
	</h:form>
</f:view>
</body>
</html>
