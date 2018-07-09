package com.karelin.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;

import java.io.IOException;
import java.util.List;

import com.karelin.dao.DaoUsers;
import com.karelin.entity.Users;

public class Number_of_users extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		DaoUsers du = new DaoUsers();
		List<Users> List = du.getAll("FROM Users");
		int size = List.size();
		JspWriter out = pageContext.getOut();
		try {
			out.print(size);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}