package br.com.teste.apresentacao.managedbean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.teste.utils.Utils;

public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object arg2)
			throws ValidatorException {

		String email = (String) arg2;

		// Checa endereços de email que iniciem com simbolos invalidos, e www.
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(email);
		if (m.find()) {
			Utils.gerarErroValidacao(context, "emailInvalido.sinais");
		}
		p = Pattern.compile("^www\\.");
		m = p.matcher(email);
		if (m.find()) {
			Utils.gerarErroValidacao(context, "emailInvalido.www");
		}

		// valida email de forma geral
		p = Pattern.compile(".+@.+\\.[a-z]+");
		m = p.matcher(email);
		if (!m.matches()) {
			Utils.gerarErroValidacao(context, "emailInvalido.geral");
		}
	}

}
