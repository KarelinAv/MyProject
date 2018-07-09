package com.karelin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.karelin.dao.DaoUsers;
import com.karelin.entity.Users;

public class Info_of_user extends TagSupport {
	private int id;

	public void setId(String id) {
		this.id = Integer.valueOf(id);
	}

	@Override
	public int doStartTag() throws JspException {

		DaoUsers du = new DaoUsers();
		Users user = du.get(id);
		JspWriter out = pageContext.getOut();
		try {
			out.print("<Lable><strong> Id: </strong> </Lable>" + user.getId() + "<br>");
			out.print("<Lable><strong> Логин: </strong></Lable>" + user.getLogin() + "<br>");
			out.print("<Lable><strong> Пароль: </strong> </Lable>" + user.getPassword() + "<br>");
			out.print("<Lable><strong> Email: </strong></Lable>" + user.getEmail() + "<br>");
			out.print("<Lable><strong> Роль в системе: </strong></Lable>" + user.getRoles().getType() + "<br>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
