<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<meta charset="UTF-8">
<title>お届け先登録</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header2.jsp" />
		<div class="main">
			<h2>お届け先登録</h2>
			<form:form modelAttribute="shipAddressModel" action="registShip">

				<p>
					ユーザーID:${ user_StoreEntity.user_id }
					<form:hidden path="user_id" value="${ user_StoreEntity.user_id }" />
				</p>

				<dt>郵便番号</dt>
				<dd>
					<form:input path="postal_code" size="15" pattern="\d{3}-\d{4}"
						placeholder="例:123-4567" />
					<form:errors path="postal_code" element="span" cssClass="errors" />
				</dd>
				<dt>住所1(都道府県・市区町村・丁目・番地)</dt>
				<dd>
					<form:input path="address1" size="15" />
					<form:errors path="address1" element="span" cssClass="errors" />
				</dd>

				<dt>住所2(建物名・部屋番号)</dt>
				<dd>
					<form:input path="address2" size="15" />
					<form:errors path="address2" element="span" cssClass="errors" />
				</dd>

				<dt>電話番号(ハイフンを除く)</dt>
				<dd>
					<form:input path="phone_number" size="15" pattern="\d{0,11}" />
					<form:errors path="phone_number" element="span" cssClass="errors" />
				</dd>

				<dt>お届け先名</dt>
				<dd>
					<form:input path="shipping_address_name" size="15" />
					<form:errors path="shipping_address_name" element="span"
						cssClass="errors" />
				</dd>


				<p class="errors">${errorMessage}</p>

				<input type="submit" name="regist" value="登録" class="btn" />
				<nobr></nobr>
				<input type="submit" name="skip" value="今はしない" class="btn"/>
				<br />
			</form:form>
		</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
	</div>
</body>
</html>