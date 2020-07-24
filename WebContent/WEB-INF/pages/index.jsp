<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html">
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body">

   <jsp:directive.include file="../layout/navbar.jsp" />
  
<div class="container">
  <h3>HRMS -  Welcome to the Human Resource Management Space</h3>
  <p>Manage your entities</p>
</div>



  <jsp:directive.include file="../layout/footer.jsp" />
</body>
</html>