<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String s = (String) session.getAttribute("sourceCode");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="Styles/SyntaxHighlighter.css" />
<script language="javascript" src="Scripts/shCore.js"></script>
<script language="javascript" src="Scripts/xbdpl.js"></script>
<title>Result</title>
</head>
<body>
	<br />
	<br />

	<table border="0" align="center" width=70%>
		<tr>
			<td><center>
					<img src="Styles/logo.png" />
				</center></td>
		</tr>
		<tr>
			<td><img src="Styles/result.png" /><br />
				<%=(String) session.getAttribute("result")%>
			</td>
		</tr>
		<tr>
			<td><textarea name="code" class="java" rows="15" cols="100"
					height=500>
			<%="\n" + s%>	
			</textarea></td>
		</tr>

	</table>
	<script>
		dp.SyntaxHighlighter.HighlightAll('code', true, false, false, 1, false);
		dp.SyntaxHighlighter.HighlightAll('code2');
	</script>
</body>
</body>
</html>