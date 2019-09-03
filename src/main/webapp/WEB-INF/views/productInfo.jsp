
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
	<dl>
		<form:form action="detail" modelAttribute="searchProductInfoModel">
			<dt>商品ID</dt>
				<dd>${product.product_id}</dd>
			<dt>商品名</dt>
				<dd>${product.product_name}</dd>
			<dt>メーカー</dt>
				<dd>${product.maker}</dd>
			<dt>価格</dt>
				<dd>${product.price}</dd>
			<dt>サイズ</dt>
				<dd>${product.size}</dd>
			<dt>色</dt>
				<dd>${product.color}</dd>
			<dt>セールスポイント</dt>
				<dd>${product.sale_point}</dd>
			<dt>在庫数</dt>
				<dd>${product.stock_quantity}</dd>
			<dt>写真</dt>
				<dd><img src="data:image/.jpg;base64,${product.base64string}"></dd>
			<dt>類似商品コード</dt><!-- similar_product_idは使わないので、コントローラーででき次第変更 -->
				<dd><form:button name="detail">${product.similar_product_id}</form:button></dd>
			<dt>数量</dt>
				<dd>${product.quantity}</dd>
			<dt>購入金額</dt>
				<dd>${product.price}</dd>
		</form:form>
	</dl>
		<!-- 画像の表示 拡張子は.jpgで固定 -->
		<!-- <img src="data:image/.jpg;base64,${product.base64string}"> -->

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