<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html">
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body">

   <jsp:directive.include file="../layout/navbar.jsp" />
  
<div class="container" style="text-align: center;position: relative;top:150px;">
  <h3 style="color: red;">HTTP 403 Error</h3>
  <p style="color: red;">Unauthorized Access</p>
</div>



  <jsp:directive.include file="../layout/footer.jsp" />
</body>
</html>