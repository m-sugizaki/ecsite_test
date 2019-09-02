<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<meta charset="UTF-8">
<title>お支払い方法登録</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header2.jsp" />
		<div class="main">
			<h2>お支払い方法登録</h2>
			<form:form modelAttribute="paymentMethodModel" action="registCard">

				<p>
					ユーザーID:${user_StoreEntity.user_id}
					<form:hidden path="user_id" value="${user_StoreEntity.user_id}" />
				</p>
				<dl>
					<dt>カード種類</dt>
					<dd>
						<form:select path="payment_method">
							<form:option label="選択してください" value="" selected="true" />
							<form:option label="VISA" value="VISA" />
							<form:option label="Mastercard" value="Mastercard" />
							<form:option label="JCB" value="JCB" />
							<form:option label="AmericanExpress" value="AmericanExpress" />
						</form:select>
						<form:errors path="payment_method" element="span"
							cssClass="errors" />
					</dd>

					<dt>カード番号</dt>
					<dd>
						<form:input path="card_number" size="16"
							pattern="\d{4}-\d{4,6}-\d{4,5}-*\d{0,4}" />
						<form:errors path="card_number" element="span" cssClass="errors" />
					</dd>

					<dt style="display: inline">有効期限</dt>
					<dd>
						<p style="display: inline">月</p>
						<form:select path="expiration_month" items="${months}"
							itemLabel="label" itemValue="data" style="display: inline" />
						<p style="display: inline">年</p>
						<form:select path="expiration_year" id="expiration_year"
							items="${years}" itemLabel="label" itemValue="data"
							style="display: inline" />
						<form:errors path="expiration_month" element="span"
							cssClass="errors" />
					</dd>
					<dt>カード名義人</dt>
					<dd>
						<form:input path="card_holder_name" size="50"
							placeholder="TARO KYUBE" pattern="[A-Z]{1,20}\s{1}[A-Z]{1,20}" />
						<form:errors path="card_holder_name" element="span"
							cssClass="errors" />
					</dd>
				</dl>
				<p class="errors">${errorMessage}</p>

				<input type="submit" name="regist" value="お届け先登録へ" class="btn"/>
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