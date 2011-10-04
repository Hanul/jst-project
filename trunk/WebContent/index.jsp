<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Java &amp; JavaScript Secure Transfer</title>
		<style type="text/css">
			.g {
				border: 1px solid #ddd;
				background-color: #eee;
				padding: 5px;
				margin: 5px;
			}
		</style>
	</head>
	<body>
		<h1>Java &amp; JavaScript Secure Transfer</h1>
		<h3>작성자 : Mr. 하늘 (<a href="http://mr.hanul.co">http://mr.hanul.co</a>, mr@hanul.co)</h3>
		<p>
			Java &amp; JavaScript Secure Transfer은 웹 페이지에서 폼 전송 시의 모든 정보를 암호화 시켜 전송하는 웹 사이트 암호화 솔루션 입니다.<br>
			이는 ActiveX 암호화 모듈이나 SSL 프로토콜 대용으로 사용하실 수 있습니다.<br>
			<br>
			[정보통신망 이용촉진 및 정보보호 등에 관한 법률(시행 2011. 7. 6)]에서<br>			
			제28조(개인정보의 보호조치)의
			<p class="g">
				4. 개인정보를 안전하게 저장ㆍ전송할 수 있는 암호화기술 등을 이용한 보안조치
			</p>
			와<br>
			제47조의3(이용자의 정보보호)의
			<p class="g">
				③ 「소프트웨어산업 진흥법」 제2조에 따른 소프트웨어사업자는 보안에 관한 취약점을 보완하는 프로그램을 제작하였을 때에는 한국인터넷진흥원에 알려야 하고, 그 소프트웨어 사용자에게는 제작한 날부터 1개월 이내에 2회 이상 알려야 한다.
			</p>
			에 따라 영리목적의 모든 사이트에서는 개인정보(비밀번호 혹은 주민번호, 전화번호 등 개인신상정보)의 보안을 위해 보안서버를 구축해야합니다.<br>
			<br>
			[개인정보의 기술적.관리적 보호조치 기준]에서
			<p class="g">
				제6조(개인정보의 암호화) ① 정보통신서비스 제공자등은 비밀번호 및 바이오정보는 복호화 되지 아니하도록 일방향 암호화하여 저장한다.<br>
				② 정보통신서비스 제공자등은 주민등록번호, 신용카드번호 및 계좌번호에 대해서는 안전한 암호알고리듬으로 암호화하여 저장한다.<br>
				③ 정보통신서비스 제공자등은 정보통신망을 통해 이용자의 개인정보 및 인증정보를 송·수신할 때에는 안전한 보안서버 구축 등의 조치를 통해 이를 암호화해야 한다. 보안서버는 다음 각 호 중 하나의 기능을 갖추어야 한다.<br>
				1. 웹서버에 SSL(Secure Socket Layer) 인증서를 설치하여 전송하는 정보를 암호화하여 송·수신하는 기능<br>
				<b>2. 웹서버에 암호화 응용프로그램을 설치하여 전송하는 정보를 암호화하여 송·수신하는 기능</b><br>
				④ 정보통신서비스 제공자등은 이용자의 개인정보를 개인용컴퓨터(PC)에 저장할 때에는 이를 암호화해야 한다.
			</p>
			중 <b>2. 웹서버에 암호화 응용프로그램을 설치하여 전송하는 정보를 암호화하여 송·수신하는 기능</b>에 해당하는 솔루션입니다.<br>
		</p>
		<ul>
			<li><a href="${pageContext.request.contextPath}/demo.jsp">데모 페이지</a></li>
		</ul>
	</body>
</html>