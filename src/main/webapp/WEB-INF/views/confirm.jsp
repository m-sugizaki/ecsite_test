<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- git test -->
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header2.jsp" />
		<div class="main">
			<h2>確認画面</h2>
			<form>
				<dl>
					<dt>ユーザーID</dt>
					<dd class="disp">${user_StoreEntity.user_id}</dd>

					<dt>ニックネーム</dt>
					<dd class="disp">${userEntity.nickname}</dd>

					<dt>郵便番号</dt>
					<dd class="disp">${userEntity.postal_code}</dd>

					<dt>住所1(都道府県・市区町村・丁目・番地)</dt>
					<dd class="disp">${userEntity.address1}</dd>

					<dt>住所2(建物名・部屋番号)</dt>
					<dd class="disp">${userEntity.address2}</dd>

					<dt>電話番号(ハイフンを除く)</dt>
					<dd class="disp">${userEntity.phone_number}</dd>

					<dt>メールアドレス</dt>
					<dd class="disp">${userEntity.email}</dd>

					<dt>生年月日</dt>
					<dd class="disp">${userEntity.birthday}</dd>
				</dl>
			</form>
			<form:form action="confirm">
				<input type="submit" name="regist" value="登録して次へ" class="btn"/>
				<nobr></nobr>
				<input type="submit" name="modify" value="戻る" class="btn"/>
				<br />
			</form:form>
		</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
	</div>
</body>
</html>