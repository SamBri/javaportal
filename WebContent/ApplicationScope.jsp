<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Scope Incident</title>
</head>
<body>
<%@page import="com.*" %>
<%
ServletContext context = getServletContext(); ;
Log log = (Log) context.getAttribute("application_log");

%>
Incident type: <%= log == null? "NULL."+ "<br/>Cannot Retrieve Incident Type" + "<br/>" + Log.ds :log.getIncident() + "<br/>" + "Incident Type Retrieved Successfully<br/>"+Log.ds %>
</body>
</html>