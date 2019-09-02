<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/style.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">

<meta charset="UTF-8">
<title>商品検索</title>
<style>
input {
  width: 200px;
  height: 30px;
  font-size: 16px;
  border: none;
  outline: 0;
  border-bottom: 1px solid #d1d5db;
}

underline {
  width: 200px;
  height: 2px;
  background: skyBlue;
  transform-origin: center center;
  transform: scaleX(0);
  transition: transform 0.18s ease-out;
}

button{
  cursor: pointer;
  border: none;
  background: none;
  color: blue;
}

</style>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp" />
<div class="main">
<form:form modelAttribute="searchProductInfoModel">
	<h1>商品検索</h1>
		<p>${errorMessage10}</p>
		<table border="0">
	<tr>
	<th>商品名</th>
	<td><form:input path="product_name"></form:input><div class ="underline"></div></td>
	</tr>
	<tr>
	<th>メーカー</th>
	<td><form:input path="maker"></form:input><div class ="underline"></div></td>
	</tr>
	<tr>
	<th>価格帯</th>
	<td><form:input path="price_start"></form:input><div class ="underline"></div></td>
	<td>～</td>
	<td><form:input path="price_end"></form:input><div class ="underline"></div></td>
	<td><form:button name="kensaku" class="btn">検索</form:button></td>
	</tr>
	</table>
</form:form>
<c:choose>
		<c:when test="${empty products}">
			<p>未検索です</p>
		</c:when>
		<c:otherwise>
	<table border="1">
		<tr>
			<th>商品コード</th>
			<th>商品名</th>
			<th>メーカー</th>
			<th>価格</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<form:form action="detail" modelAttribute="searchProductInfoModel">
					<td><form:button name="detail">${product.product_id}</form:button></td>
					<form:hidden path="product_id" value="${product.product_id}" />
					<td>${product.product_name}</td>
					<td>${product.maker}</td>
					<td>${product.price}</td>
				</form:form>
			</tr>
			<!-- 画像の表示 拡張子は.jpgで固定 -->
			<!-- <img src="data:image/.jpg;base64,${product.base64string}"> -->

		</c:forEach>

	</table>
	</c:otherwise>
</c:choose>
</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
		</div>
</body>
</html>