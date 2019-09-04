<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/style.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/products.css">

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

button {
	cursor: pointer;
	border: none;
	background: none;
	color: blue;
}

button.c {
	cursor: pointer;
	border: none;
	background: none;
	color: red;
	position: relative;
	left: 235px;
	font-size: 18px;
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
				<table border="0" class="a">
					<tr>
						<th>商品名</th>
						<td><form:input path="product_name" size="15"></form:input>
							<div class="underline"></div></td>
					</tr>
					<tr>
						<th>メーカー</th>
						<td><form:input path="maker" size="15"></form:input>
							<div class="underline"></div></td>
					</tr>
					<tr>
						<th>価格帯</th>
						<td><form:input path="price_start" size="15" />
							<div class="underline"></div></td>
						<td>～</td>
						<td><form:input path="price_end" size="15" />
							<div class="underline"></div></td>
						<td><form:button name="kensaku" class="btn">検索</form:button></td>
					</tr>
				</table>
			</form:form>
			<br> <br>

			<c:choose>
				<c:when test="${empty products}">
					<p>未検索です</p>
				</c:when>
				<c:otherwise>
					<table border="1" class="b">

						<tr>

							<th>商品名</th>
							<th>メーカー</th>
							<th>価格</th>
						</tr>
						<c:forEach var="product" items="${products}">
							<tr>
								<form:form action="detail"
									modelAttribute="searchProductInfoModel">
									<td><form:button name="detail">${product.product_name}</form:button></td>
									<form:hidden path="product_id" value="${product.product_id}" />
									<td>${product.maker}</td>
									<td><fmt:formatNumber value="${product.price}"
											type="currency" currencySymbol="" maxFractionDigits="0" /></td>
								</form:form>
							</tr>
							<!-- 画像の表示 拡張子は.jpgで固定 -->
							<!-- <img src="data:image/.jpg;base64,${product.base64string}"> -->
						</c:forEach>

					</table>
					<br>
					<form:form action="detail" modelAttribute="searchProductInfoModel">
					<c:if  test="${count != 0}">
						<form:button name="back" class="c">前へ</form:button>
					</c:if>
					<c:if test="${max - count =< 5}">
						<form:button name="next" class="c">次へ</form:button>
					</c:if>
					</form:form>
				</c:otherwise>
			</c:choose>

		</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
	</div>
</body>
</html>