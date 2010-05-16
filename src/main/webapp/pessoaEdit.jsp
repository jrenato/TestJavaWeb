<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Consulta de Pessoa</title>
</head>
<body>
<f:view>
	<h:form id="form">
		<h:panelGrid columns="3">
			<h:outputText value="Nome:" />
			<h:inputText id="nome" value="#{pessoaBean.pessoaSelecionada.nome}" required="true" />
            <h:message for="nome" />

			<h:outputText value="Email:" />
			<h:inputText id="email" value="#{pessoaBean.pessoaSelecionada.email}" required="true">
                <f:validator validatorId="emailValidator" />
			</h:inputText>
			<h:message for="email" />
		</h:panelGrid>

        <h:commandButton value="OK" action="#{pessoaBean.gravar}" />
	</h:form>
</f:view>
</body>
</html>
