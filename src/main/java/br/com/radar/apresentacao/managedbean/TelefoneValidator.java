package br.com.radar.apresentacao.managedbean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.teste.utils.Utils;

public class TelefoneValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object arg2)
			throws ValidatorException {

		String telefone = (String) arg2;

		// Checa endereços de email que iniciem com simbolos invalidos, e www.
		Pattern p = Pattern.compile("[^-) (0-9]");
		Matcher m = p.matcher(telefone);
		if (m.find()) {
			Utils.gerarErroValidacao(context, "telefoneInvalido.somenteNumeros");
		}
	}

}
