<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/loginstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/products.css">
<meta charset="UTF-8">
<title>画像テスト</title>
<style>
button {
	cursor: pointer;
	border: none;
	background: none;
	color: blue;
}

input {
	width: 200px;
	height: 30px;
	font-size: 16px;
	border: none;
	outline: 0;
	border-bottom: 1px solid #d1d5db;
}
</style>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header.jsp" />
		<div class="main">
			<h1>商品詳細</h1>
			<table border="0" class="c">
				<form:form action="detail" modelAttribute="productInfoModel">
					<tr>
						<th>商品ID</th>
						<td>${product.product_id}</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>商品名</th>
						<td>${product.product_name}</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>メーカー</th>
						<td>${product.maker}</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><fmt:formatNumber value="${product.price}"
								type="currency" currencySymbol="" maxFractionDigits="0" /></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>サイズ</th>
						<td><form:select path="size" items="${size}" /></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>色</th>
						<td><form:select path="color" items="${color}" /></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>セールスポイント</th>
						<td>${product.sale_point}</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>在庫数</th>
						<td>${product.stock_quantity}</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>写真</th>
						<td><img src="data:image/.jpg;base64,${product.base64string}"
							width="200" height="200"></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>類似商品</th>
						<!-- forEach使う　コントローラー班と要相談 -->
						<td><c:forEach var="similarProduct" items="${likeProduct }">
								<form:button name="detail">
									${similarProduct.product_name}
									<form:hidden path="product_id"
										value="${similarProduct.product_id}" />
								</form:button>
							</c:forEach></td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>数量</th>
						<td><form:input path="quantity" /></td>
					</tr>
					<!-- 画像の表示 拡張子は.jpgで固定 -->
					<!-- <img src="data:image/.jpg;base64,${product.base64string}"> -->
				</form:form>
			</table>
			<br>
			<p class="errors">${loginMessage}</p>
			<p class="errors">${qMessage}</p>
			<p class="errors">${cMessage}</p>
			<form:form modelAttribute="searchProductInfoModel">
				<form:button name="return" class="btn">戻る</form:button>
				<form:button name="addCart" class="btn">カートに入れる</form:button>
				<form:button name="#" class="btn">レジに進む</form:button>
			</form:form>
			<!-- 以下は口コミ表示。reviewの変数が出来次第、書かれている変数を変える -->
			<br> <br>
			<c:choose>
				<c:when test="${empty products}">
					<p>口コミはありません。</p>
				</c:when>
				<c:otherwise>
					<table border="1" class="b">
						<tr>
							<th>口コミNo.</th>
							<th>ニックネーム</th>
							<th>評価</th>
							<th>口コミ内容</th>
							<th>口コミ日時</th>
						</tr>
						<c:forEach var="product" items="${products}">
							<tr>
								<form:form action="detail"
									modelAttribute="searchProductInfoModel">
									<td><form:button name="detail">${product.product_id}</form:button></td>
									<form:hidden path="product_id" value="${product.product_id}" />
									<td>${product.product_name}</td>
									<td>${product.maker}</td>
									<td>${product.price}</td>
									<td>aaaaaaaaaa</td>
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