<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/style.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav id="slide_menu">
    <ul>

        <li><a href="top">マイページ</a></li>
        <li><a href="search">商品検索</a></li>
        <c:if test="${userEntity.user_id != null}">
        <li><a href="#">カート詳細</a></li>
        <li><a href="#">購入履歴</a></li>
        <li><a href="#">アカウント</a></li>
        </c:if>
    </ul>
</nav>
</body>
</html>