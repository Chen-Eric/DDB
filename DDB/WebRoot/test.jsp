<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<sj:head jqueryui="true" jquerytheme="start" debug="true"
	loadAtOnce="true" compressed="true" />
</head>

<body>
	This is my JSP page.
	<br>
	<sj:tabbedpanel id="localtabs" >
		<sj:tab id="tab1" target="tone" label="Local Tab One" />
		<sj:tab id="tab2" target="ttwo" label="Local Tab Two" />
		<sj:tab id="tab3" target="tthree" label="Local Tab Three" />
		<sj:tab id="tab4" target="tfour" label="Local Tab Four" />
		<div id="tone">11</div>
		<div id="ttwo">22</div>
		<div id="tthree">33</div>
		<div id="tfour">44</div>
	</sj:tabbedpanel>
</body>
</html>
