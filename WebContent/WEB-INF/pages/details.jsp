<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Details</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<jsp:directive.include file="../layout/navbar.jsp" />
<div class="container">

 <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Employees Details</h2>
   <div class="panel panel-default">
    <div class="panel-heading">
     <div class="panel-title">personal information: </div>
    </div>
    <div class="panel-body">
      
        
    <table>
         <tr>
            <td><strong>First Name : </strong></td>
            <td>${employee.firstName}</td>
         </tr>
         
           <tr>
            <td><strong>Last Name: </strong></td>
             <td>${employee.lastName}</td>
         </tr>
           <tr>
            <td><strong>Email : </strong></td>
            <td>${employee.email}</td>
         </tr>
           <tr>
            <td><strong>Phone number : </strong></td>
              <td>${employee.tele}</td>
         </tr>
           <tr>
            <td><strong>Grade : </strong></td>
           <td>${employee.grade}</td>
         </tr>
          <tr>
            <td><strong>Salaire : </strong></td>
           <td>${employee.salaire} Dhs</td>
         </tr>
           <tr>
            <td><strong>Manager: </strong></td>
              <td>${employee.manager}</td>
         </tr>
         
           <tr>
            <td><strong>Departement : </strong></td>
           <td>${employee.dept.getNom()}</td>
         </tr>
         
           <tr>
            <td><strong>Rénumération : </strong></td>
           <td>${employee.reum.getNom()}</td>
         </tr>
         
           <tr>
            <td><strong>Superior : </strong></td>
           <td>${employee.sup}</td>
         </tr>
           <tr>
            <td><strong>Adresse : </strong></td>
            <td>${employee.adresse}</td>
         </tr>
         
         
      </table>  
    
 
 
<a  href="${pageContext.request.contextPath}/employee/listE" style="position:relative;left: 284px" class="btn btn-info">Retour</a> 
    </div>
    </div>
   </div>
  </div>
</body>
</html>