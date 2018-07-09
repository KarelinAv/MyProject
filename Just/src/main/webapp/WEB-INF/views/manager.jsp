<%@ page import="java.util.List"%>
<%@page import="com.karelin.dao.DaoProjects"%>
<%@page import="com.karelin.entity.Projects"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
				<li><a href="<%=request.getContextPath()%>/manager"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str20"/> </a></li>
						<li><a href="<%=request.getContextPath()%>/task"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str62"/> </a></li>
				<li><a href="<%=request.getContextPath()%>/my_projects"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str21"/> </a></li>
				<li><a href="<%=request.getContextPath()%>/my_tasks"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str22"/> </a></li>
				<li><a href="<%=request.getContextPath()%>/about"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str23"/> </a></li>
				
			</ul>		</div>
		<div class="col-sm-9 col-md-10 main">
			<h1 class="page-header"><my:i18n name="str24"/></h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th><my:i18n name="str25"/></th>
						<th><my:i18n name="str26"/></th>
						<th><my:i18n name="str27"/></th>
						<th><my:i18n name="str29"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="info4" items="${listProjects}">
						<tr>
							<td><c:out value="${info4.id}" /></td>
							<td><c:out value="${info4.date}" /></td>
							<td><c:out value="${info4.name}" /></td>
							<td><c:out value="${info4.users.login}" /></td>
							<td><a class="btn btn-primary btn-xs"
								href="dropProject?id=${info4.id}"><my:i18n name="str28"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>