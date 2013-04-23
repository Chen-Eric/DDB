<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Diary Management</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<sj:head jqueryui="true" jquerytheme="humanity" loadFromGoogle="true" />

<link rel="stylesheet" type="text/css" href="CSS/page.css">

</head>

<body>

	<div id="container">
		<div id="header">
			<h1>Welcome to Food & Activity Diary Database</h1>
		</div>
		<div id="wrapper">
			<div id="content">
				<p>
					<strong>What's new?</strong>
				</p>

				<hr class="hr">
				<p>
					<b>Beta version of Food Intake & Activity Diary
						System.</b>
				</p>
				<p>
					<b>Release Date: 2013-March-24</b>
				</p>
			</div>
		</div>
		<div id="navigation">
			<p>
				<strong>About</strong>
			</p>
			<hr class="hr">
			<p>
				<b> Food & Activity Diary Management System.</b>
			</p>
		</div>
		<div id="extra">
			<p>
				<s:form action="Login" namespace="/User" method="post">
					<table align="left">
						<caption>
							<h3>Login</h3>
						</caption>

						<tr>
							<td>Username:<input type="text" name="username" /></td>
						</tr>
						<tr>
							<td>Password:<input type="password" name="password" /></td>
						</tr>
						<tr align="center">
							<td colspan="2"><input type="submit" value="Login" /> <input
								type="reset" value="Reset" /></td>
						</tr>
					</table>
				</s:form>
			</p>

		</div>
		<div id="footer" style="text-align: right;">
			<p>
				Chen Zheng <br> Dr.Kuda Dube
				<s:debug></s:debug>
			</p>
		</div>
	</div>
</body>
</html>