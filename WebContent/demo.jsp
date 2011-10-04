<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Java &amp; JavaScript Secure Transfer Demo Page</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/SecureTransfer.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jst.pack.min.js"></script>
		<script type="text/javascript">
		$(function(){
			$('.secureForm').secure();
		});
		</script>
	</head>
	<body>
		<h1>Java &amp; JavaScript Secure Transfer Demo Page</h1>
		<p>
			<img src="${pageContext.request.contextPath}/sec.png">
		</p>
		<form class="secureForm" method="post">
			<p>
				Input contents for secure test.
			</p>
			<textarea name="test" cols="50" rows="5">${param.test}</textarea>
			<p>
				<input type="submit">
			</p>
		</form>
    </body>
</html>