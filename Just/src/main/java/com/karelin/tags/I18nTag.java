package com.karelin.tags;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class I18nTag extends TagSupport {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		HttpSession session = pageContext.getSession();
		String language = String.valueOf(session.getAttribute("lang"));
		String country = String.valueOf(session.getAttribute("coutry"));
		Locale locale = new Locale(language, country);
		ResourceBundle rb = ResourceBundle.getBundle("com/karelin/locales/text", locale);
		JspWriter out = pageContext.getOut();
		try {
			out.print(rb.getString(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
