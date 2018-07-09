package com.karelin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TableTag extends BodyTagSupport {
	private int count;

	public void setCount(int count) {
		this.count = Integer.valueOf(count);
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("<table border='2'> <tr><td>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		JspWriter out = pageContext.getOut();
		while (count-- > 1) {

			try {
				out.print("</td></tr><tr><td>");
				return EVAL_BODY_AGAIN;
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("</td></tr></table>");
		} catch (IOException e) {

			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
