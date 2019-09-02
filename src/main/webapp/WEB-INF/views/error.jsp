<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システムエラー</title>
<style>
</style>
</head>
<body>
<div align=center>
<h1><span>「システムエラー発生のご報告」</span></h1>
</div>
<div>
<p><b>利用者各位</b></p>
<p></p>
<p>いつもご利用ありがとうございます。</p>
<p>${error}</p>
<p>大変申し訳ありませんが、ログイン画面にアクセスしていただき、システムへ再度ログインを行ってください。</p>
</div>
<p><a href="${link}">ログイン画面へ</a></p>
</body>
</html>