<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String s = (String) session.getAttribute("sourceCode");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="0;url=/IDE/CompileServlet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="Styles/SyntaxHighlighter.css" />
<script language="javascript" src="Scripts/shCore.js"></script>
<script language="javascript" src="Scripts/xbdpl.js"></script>
<title>Compiling</title>
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
			<td><br /><br />
					<img src="Styles/wait.png" style="width:200px"/>
					<h4>Please do not press BACK button.</h4>
				</td>
		
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
</html>