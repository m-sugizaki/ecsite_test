<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/formstyle.css">
<link rel="stylesheet" type="text/css" href="resources/reset.css">
<meta charset="UTF-8">
<title>新規アカウント登録</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="header2.jsp" />
		<div class="main">
			<h2>新規アカウント登録</h2>
			<form:form modelAttribute="userModel" action="registUser" style="display:inline">

				<dl>
					<dt>ユーザーID(半角英数字)</dt>
					<dd>
						<form:input path="user_id" size="15" placeholder="ユーザーID"
							class="form" />
						<form:errors path="user_id" element="span" cssClass="errors" />
					</dd>

					<dt>パスワード(半角英数字5文字以上)</dt>
					<dd>
						<form:password path="password" size="15" placeholder="パスワード"
							class="form" />
						<form:errors path="password" element="span" cssClass="errors" />
					</dd>
					<!-- パスワード用の「半角英数字それぞれ一つ以上を含む5文字以上100文字以下」を指定する正規表現
				 	実装すると実行上不便なのでテストのときとかリリースのときだけ実装する
				 	 pattern="^(?=.*?[a-zA-Z])(?=.*?\d)[a-zA-Z\d]{5,100}$" -->

					<dt>パスワード(確認用)</dt>
					<dd>
						<form:password path="password2" size="15" placeholder="パスワード確認用"
							class="form" />
						<form:errors path="password2" element="span" cssClass="errors" />
					</dd>
				</dl>
				<p>${errorMessage1}</p>
				<p>${errorMessage2}</p>

				<input type="submit" name="regist" value="ユーザー情報登録へ" class="btn"/>
			</form:form>
			<form:form action="checkUser" style="display:inline">
				<input type="submit" name="cancel" value="戻る" class="btn" />
				<br />
			</form:form>

		</div>
		<jsp:include page="footer.jsp" />
		<jsp:include page="menu.jsp" />
	</div>
</body>
</html>