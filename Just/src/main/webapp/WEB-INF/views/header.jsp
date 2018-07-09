<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/MyTagsLib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Главная страница</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">

</head>
<body>
	<header class="header">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<%=request.getContextPath()%>">Main</a>
					<div class="navbar-brand">
						<form action="i18n" method="POST">
						
							<input type="submit" name="language" value="rus" /> 
							<input type="submit" name="language"value="eng" /> 
							<input type="submit" name="language" value="deu" />
						</form>
					</div>

				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<%=request.getContextPath()%>/statistics"
							target="_self"><my:i18n name="str14" /></a></li>
						<c:if test="${sessionScope.id!=null}">
							<li><a href="logout"><my:i18n name="str13" /></a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>