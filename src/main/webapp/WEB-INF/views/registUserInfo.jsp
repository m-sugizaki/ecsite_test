<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<meta charset="UTF-8">
<title>ユーザー情報登録</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header2.jsp" />
		<div class="main">
			<h2>ユーザー情報登録</h2>
			<form:form modelAttribute="userInfoModel" action="registUserInfo">

				<p>
					ユーザーID:${user_StoreEntity.user_id}
					<form:hidden path="user_id" value="${user_StoreEntity.user_id}" />
				</p>
				<dl>
					<dt>氏名</dt>
					<dd>
						<form:input path="name" size="15" value="${ userEntity.name}"   class="form"/>
						<form:errors path="name" element="span" cssClass="errors" />
					</dd>

					<dt>ニックネーム</dt>
					<dd>
						<form:input path="nickname" size="15"
							value="${ userEntity.nickname}" class="form"/>
						<form:errors path="nickname" element="span" cssClass="errors" />
					</dd>

					<dt>郵便番号(ハイフンあり)</dt>
					<dd>
						<form:input path="postal_code" size="15" pattern="\d{3}-\d{4}"
							placeholder="例:123-4567" value="${ userEntity.postal_code}" class="form"/>
						<form:errors path="postal_code" element="span" cssClass="errors" />
					</dd>

					<dt>住所1(都道府県・市区町村・丁目・番地)</dt>
					<dd>
						<form:input path="address1" size="15"
							value="${ userEntity.address1}" class="form"/>
						<form:errors path="address1" element="span" cssClass="errors" />
					</dd>

					<dt>住所2(建物名・部屋番号)</dt>
					<dd>
						<form:input path="address2" size="15"
							value="${ userEntity.address2}" class="form"/>
						<form:errors path="address2" element="span" cssClass="errors" />
					</dd>

					<dt>電話番号(ハイフンを除く)</dt>
					<dd>
						<form:input path="phone_number" size="15" pattern="\d{0,11}"
							value="${ userEntity.phone_number}" class="form"/>
						<form:errors path="phone_number" element="span" cssClass="errors" />
					</dd>

					<dt>メールアドレス</dt>
					<dd>
						<form:input path="email" size="15" value="${ userEntity.email}" class="form"/>
						<form:errors path="email" element="span" cssClass="errors" />
					</dd>

					<dt>生年月日</dt>
					<dd>
						<c:if test="${userEntity.user_id == null}">
							<input type="date" name="birthday" value="2000-01-01"
								min="1900-01-01" class="form"/>
						</c:if>
						<c:if test="${userEntity.user_id != null}">
							<input type="date" name="birthday"
								value="${ userEntity.birthday}" min="1900-01-01" class="form"/>
						</c:if>
					</dd>
				</dl>

				<p>${errorMessage}</p>
				<input type="submit" name="regist" value="確認画面へ" class="btn"/>
				<nobr></nobr>
				<input type="submit" name="back" value="戻る" class="btn"/>
				<br />
			</form:form>

		</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
	</div>
</body>
</html>