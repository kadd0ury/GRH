<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Lists</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<jsp:directive.include file="../layout/navbar.jsp" />
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>ERM - Employees Relationship Manager</h2>
   <hr />

   <input type="button" value="Add Employee"
    onclick="window.location.href='showFormC'; return false;"
    class="btn btn-info" />
    <br/><br/>
   <div class="panel panel-default">
    <div class="panel-heading">
     <div class="panel-title">Employees List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>First Name</th>
       <th>Last Name</th>
       <th>Email</th>
       <th>Téléphone</th>
       <th>adresse</th>
       <th>Grade</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="employee" items="${employees}">
      
      
        <c:url var="detailLink" value="/employee/view/${employee.id}">
        <c:param name="employeeId" value="${employee.id}" />
       </c:url>
       

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/employee/update">
        <c:param name="employeeId" value="${employee.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/employee/delete">
        <c:param name="employeeId" value="${employee.id}" />
       </c:url>
       
       <tr>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.email}</td>
         <td>${employee.tele}</td>
        <td>${employee.adresse}</td>
        <td>${employee.grade}</td>
        <td>
        <a href="${detailLink}">Details |</a>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <jsp:directive.include file="../layout/footer.jsp" />
</body>
</html>