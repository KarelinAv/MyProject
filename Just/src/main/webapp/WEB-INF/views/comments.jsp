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
			<h1 class="page-header"><my:i18n name="str42"/></h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th><my:i18n name="str36"/></th>
						<th><my:i18n name="str49"/></th>
						<th><my:i18n name="str46"/></th>
						<th><my:i18n name="str29"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="comment" items="${listComments}">
						<tr>
							<td><c:out value="${comment.id}" /></td>
							<td><c:out value="${comment.date}" /></td>
							<td><c:out value="${comment.message}" /></td>
							<td><c:out value="${comment.users.login}" /></td>
							<td><a class="btn btn-primary btn-xs"
								href="deleteComment?id=${comment.id}"><my:i18n name="str52"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h2><my:i18n name="str50"/></h2>
			<form action="addComment" method="POST">
				<div class="form-group">
					<label for="message"> </label> <input
						class="form-control" id="message" type="text"
						required="required" name="message" />
				</div>
				<button type="submit" class="btn btn-primary"><my:i18n name="str50"/></button>
			</form>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>