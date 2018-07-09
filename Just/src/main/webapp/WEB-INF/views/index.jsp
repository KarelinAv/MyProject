<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<div class="container">
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
	<div class="row">
		<div class="col-sm-6">
			<h2><my:i18n name="str1"/></h2>
			<form action="registration" method="POST">
				<div class="form-group">
					<label>
					<my:i18n name="str3"/>
					</label> 
					<span class="required_field">*</span><input class="form-control" type="text"
						name="login" placeholder="<my:i18n name="str15"/>" required />
				</div>
				<div class="form-group">
					<label><my:i18n name="str4"/> </label> <span class="required_field">*</span> <input class="form-control" type="password"
						name="password" placeholder="<my:i18n name="str16"/>" required />
				</div>
				<div class="form-group">
					<label><my:i18n name="str5"/> </label> <span class="required_field">*</span><input class="form-control"
						type="password" name="repeat_password"
						placeholder="<my:i18n name="str17"/>" required />
				</div>
				<div class="form-group">
					<label><my:i18n name="str6"/> </label> <span class="required_field">*</span><input class="form-control" type="text"
						name="email" placeholder="<my:i18n name="str18"/>" />
				</div>
				<div class="form-group">
				
					<div class="radio"> 
						 <label> <input type="radio" name="roles" value="1"checked="checked">
							<my:i18n name="str7"/></label>
					</div>
					<div class="radio">
						 <label><input type="radio" name="roles" value="2"><my:i18n name="str8"/></label>
					</div>
				</div>
				<button type="submit" class="btn btn-primary"><my:i18n name="str9"/></button>
			</form>
		</div>
		<div class="col-sm-6">
			<h2><my:i18n name="str2"/></h2>
			<form action="autorization" method="POST">
				<div class="form-group">
					<label><my:i18n name="str10"/> <span class="required_field">*</span><input class="form-control" type="text"
						name="login" id="login" placeholder="<my:i18n name="str3"/>" required /></label>
				</div>
				<div class="form-group">
					<label><my:i18n name="str11"/><span class="required_field">*</span> <input class="form-control" type="password"
						name="password" placeholder="<my:i18n name="str4"/>" required /></label>
				</div>
				<button type="submit" class="btn btn-primary"><my:i18n name="str12"/></button>
			</form>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>