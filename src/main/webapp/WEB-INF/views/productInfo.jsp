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
  color: red;
}
.under{
 width: 200px;
   text-decoration : underline;
}
</style>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp" />
<div class="main">
<form:form modelAttribute="productInfoModel">
	<h1>商品詳細</h1>
	<table border="0">
	<tr>
	<th>商品ID</th>
	<td><span class="under">${product.product_id}</span></td>
	</tr>
	<tr>
	<th>商品名</th>
	<td><span class="under">${product.product_name}</span></td>
	</tr>
	<tr>
	<th>メーカー</th>
	<td><span class="under">${product.maker}</span></td>
	</tr>
	<tr>
	<th>価格</th>
	<td><span class="under">${product.price}</span></td>
	</tr>
	<tr>
	<th>サイズ</th>
	<td><span class="under">
	<form:select path="size" items="${size}" itemLabel="size" itemValue="size"/></span></td>
	</tr>
	<tr>
	<th>色</th>
	<td><span class="under">${product.color}</span></td>
	</tr>
	<tr>
	<th>セールスポイント</th>
	<td><span class="under">${product.sale_point}</span></td>
	</tr>
	<tr>
	<th>在庫数</th>
	<td><span class="under">${product.stock_quantity}</span></td>
	</tr>
	<tr>
	<th>写真</th>
	<td><span class="under"><img src="data:image/.jpg;base64,${product.base64string}"></span></td>
	</tr>
	<tr>
	<th>類似商品コード</th>
	<td><span class="under">${product.similar_product_id}</span></td>
	</tr>
	<tr>
	<th>数量</th>
	<td></td>
	</tr>
	<tr>
	<th>購入金額</th>
	<td><span class="under">${product.price}</span></td>
	</tr>
		<!-- 画像の表示 拡張子は.jpgで固定 -->
		<!-- <img src="data:image/.jpg;base64,${product.base64string}"> -->
</table>
</form:form>
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