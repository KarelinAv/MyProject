<%@ page import="java.util.List"%>
<%@page import="com.karelin.dao.DaoProjects"%>
<%@page import="com.karelin.entity.Projects"%>
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
			<h1 class="page-header"><my:i18n name="str21"/></h1>

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
								href="projectTasks?id=${info4.id}"><my:i18n name="str33"/></a> <c:if
									test="${sessionScope.role=='manager'}">
									<a class="btn btn-primary btn-xs" href="addUser?id=${info4.id}"><my:i18n name="str34"/></a>
								</c:if>
								<c:if
									test="${sessionScope.role=='manager'}">
									<a class="btn btn-primary btn-xs" href="dropUser?id=${info4.id}"><my:i18n name="str35"/></a>
								</c:if></td>
								</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${sessionScope.role=='manager'}">
				<h2><my:i18n name="str30"/></h2>
				<form action="addProject" method="POST">
					<div class="form-group">
						<label for="nameProject"><my:i18n name="str31"/> </label> <input
							class="form-control" id="nameProject" type="text"
							required="required" name="nameProject" />
					</div>
					<button type="submit" class="btn btn-primary"><my:i18n name="str32"/></button>
				</form>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>