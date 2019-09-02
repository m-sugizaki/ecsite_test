<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header.jsp" />
		<div class="main">
		<h2>ログイン画面</h2>
		<form:form modelAttribute="loginModel" action="checkUser">


			<dd>
				<form:input path="user_id" size="15" placeholder="ユーザーID"/>
				<form:errors path="user_id" element="span" cssClass="errors"/>
			</dd>
			 <dd>
				<form:password path="password" size="16" placeholder="パスワード" inputmode="verbatim"/>
				<form:errors path="password" element="span" cssClass="errors" />
			</dd>
			<input type="submit" name="login" value="ログイン" class="btn"/>
			<nobr></nobr>
			<input type="submit" name="cancel" value="戻る" class="btn"/>
			<br />


			<p class="errors">${errorMessage}</p>
			<br/>
			<a href="registUser">新規アカウント登録</a><br/>
			<a href="#">パスワード変更</a>
		</form:form>

		</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
	</div>
</body>
</html>