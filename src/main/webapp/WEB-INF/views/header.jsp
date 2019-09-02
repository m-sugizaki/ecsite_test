<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<header id="header">
		<input type="image" src="resources/menubutton.png" alt="送信する" width="80" height="30" id="button" name="menu">
		<img src="resources/cubelogo.png" alt="cubeオンラインのロゴ" />
		<h1>キューブ オンラインショップ</h1>
		<div>
			<form:form modelattribute="userEntity">
				<c:if test="${userEntity.user_id == null}">
					<p>ようこそゲストさま</p>
					<a href="login">ログイン</a>
					<nobr>/</nobr>
					<a href="registUser">新規登録</a>
				</c:if>

				<c:if test="${userEntity.user_id != null}">
					<p>ようこそ${userEntity.nickname}さま</p>
					<p>商品カート:カートの個数出すよ</p>
					<a href="logout">ログアウト</a>
				</c:if>
			</form:form>
		</div>
	</header>
</nav>
</body>
</html>