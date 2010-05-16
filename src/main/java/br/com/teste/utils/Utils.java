package br.com.teste.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class Utils {

	public static String getMessageResourceString(String bundleName,
			String key, Object params[], Locale locale) {
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale, 
				getCurrentClassLoader(params));

		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = "?? key " + key + " não encontrada ??";
		}

		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}

		return text;
	}

	private static ClassLoader getCurrentClassLoader(Object defaultObject) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	public static void gerarErroValidacao(FacesContext context, String keyBundle) {
		String mensagem = Utils.getMessageResourceString("MessageBundle",
				keyBundle, null, context.getViewRoot().getLocale());

		FacesMessage message = new FacesMessage();
		message.setDetail(mensagem);
		message.setSummary(mensagem);
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(message);
	}
}
