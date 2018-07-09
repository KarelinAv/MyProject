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
				<li><a href="<%=request.getContextPath()%>/manager"><span
						class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> <span
						class="glyphicon-class"></span><my:i18n name="str20"/> </a></li>
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
			<c:if test="${result=='success'}">
				<div class="alert alert-success" role="alert">
					<c:out value="${notification}"></c:out>
				</div>
			</c:if>
			<c:if test="${result=='fail'}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${notification}"></c:out>
				</div>
			</c:if>
			<h1 class="page-header"><my:i18n name="str54"/></h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th><my:i18n name="str10"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list1" items="${listUser}">
						<tr>
							<td><c:out value="${list1.users.id}" /></td>
							<td><c:out value="${list1.users.login}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h1 class="page-header"><my:i18n name="str34"/></h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th><my:i18n name="str10"/></th>
						<th><my:i18n name="str29"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list2" items="${listUser2}">
						<tr>
							<td><c:out value="${list2.id}" /></td>
							<td><c:out value="${list2.login}" /></td>
							<td><a class="btn btn-primary btn-xs"
								href="addToProject?id=${list2.id}"><my:i18n name="str53"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>