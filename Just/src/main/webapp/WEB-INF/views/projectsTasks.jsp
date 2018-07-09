<%@ page import="java.util.List"%>
<%@page import="com.karelin.dao.DaoProjects"%>
<%@page import="com.karelin.entity.Projects"%>
<%@page import="com.karelin.dao.DaoTasks"%>
<%@page import="com.karelin.entity.Tasks"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/MyTagsLib.tld"%>

<%@ include file="header.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
				<c:if test="${sessionScope.role=='manager'}"><li><a href="<%=request.getContextPath()%>/manager"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str20"/> </a></li></c:if>
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
			<h1 class="page-header"><my:i18n name="str41"/></h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th><my:i18n name="str36"/></th>
						<th><my:i18n name="str37"/></th>
						<th><my:i18n name="str38"/></th>
						<th><my:i18n name="str42"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="task" items="${listTasks}">
						<tr>
							<td><c:out value="${task.id}" /></td>
							<td><c:out value="${task.date}" /></td>
							<td><a href="task?id=${task.id}"><c:out
										value="${task.description}" /></a></td>
							<td><select class="task-status form-control input-sm"
								data-task-id="${info4.id}">
									<c:forEach var="status" items="${statusesList}">
										<option value="${status.id}"
											<c:if test="${task.status.id==status.id}">selected</c:if>>${status.label}</option>
									</c:forEach>
							</select></td>
							<td><a class="btn btn-primary btn-xs"
								href="comments?id=${task.id}"><my:i18n name="str45"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${sessionScope.role=='manager'}">
				<h2><my:i18n name="str43"/></h2>
				<form action="addTask" method="POST">
					<input type="hidden" value="${id_projects}" name="id_projects" />
					<div class="form-group">
						<label for="description"><my:i18n name="str44"/> </label> <input
							class="form-control" id="description" type="text"
							required="required" name="description" />
					</div>
					<div class="form-group">
						<label for="description" required="required"><my:i18n name="str27"/></label>
						<select name="userId" class="form-control">
							<c:forEach var="user" items="${users}">
								<option value="${user.id}"><c:out value="${user.login}" /></option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary"><my:i18n name="str32"/></button>
				</form>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>