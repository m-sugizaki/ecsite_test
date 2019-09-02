
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/loginstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<meta charset="UTF-8">
<title>画像テスト</title>
<style>
button{
  cursor: pointer;
  border: none;
  background: none;
  color: red;
}
button{
  color: blue;
}
</style>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp" />
<div class="main">
	<h1>商品詳細</h1>
	<table border="0">
	<form:form action="detail" modelAttribute="searchProductInfoModel">
	<tr>
	<th>商品ID</th>
	<td>${product.product_id}</td>
	</tr>
	<tr>
	<th>商品名</th>
	<td>${product.product_name}</td>
	</tr>
	<tr>
	<th>メーカー</th>
	<td>${product.maker}</td>
	</tr>
	<tr>
	<th>価格</th>
	<td>${product.price}</td>
	</tr>
	<tr>
	<th>サイズ</th>
	<td>${product.size}</td>
	</tr>
	<tr>
	<th>色</th>
	<td>${product.color}</td>
	</tr>
	<tr>
	<th>セールスポイント</th>
	<td>${product.sale_point}</td>
	</tr>
	<tr>
	<th>在庫数</th>
	<td>${product.stock_quantity}</td>
	</tr>
	<tr>
	<th>写真</th>
	<td><img src="data:image/.jpg;base64,${product.base64string}"></td>
	</tr>
	<tr>
	<th>類似商品コード</th><!-- similar_product_idは使わないので、コントローラーででき次第変更 -->
	<td><form:button name="detail">${product.similar_product_id}</form:button></td>
	</tr>
	<tr>
	<th>数量</th>
	<td></td>
	</tr>
	<tr>
	<th>購入金額</th>
	<td>${product.price}</td>
	</tr>
		<!-- 画像の表示 拡張子は.jpgで固定 -->
		<!-- <img src="data:image/.jpg;base64,${product.base64string}"> -->
		</form:form>
</table>
<form:form modelAttribute="searchProductInfoModel">
	<form:button name="#" class="btn">カートに入れる</form:button>
	<form:button name="#" class="btn">レジに進む</form:button>
	<form:button name="return" class="btn">戻る</form:button>
			</form:form>
	</div>
			<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />

		</div>

</body>
</html>