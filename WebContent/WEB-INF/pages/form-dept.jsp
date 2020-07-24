<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departement</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>

   <jsp:directive.include file="../layout/navbar.jsp" />

 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Department Management</h2>
   <div class="panel panel-default">
    <div class="panel-heading">
     <div class="panel-title">Add departement</div>
    </div>
    <div class="panel-body">
     <form:form action="save" cssClass="form-horizontal"
      method="post" modelAttribute="dept">

      <!-- need to associate this data with customer id -->
      <form:hidden path="id" />

      <div class="form-group">
       <label for="nom" class="col-md-3 control-label">Nom : </label>
       <div class="col-md-9">
        <form:input path="nom" cssClass="form-control" />
         <div class="has-error">
                        <form:errors path="nom" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>
      <div class="form-group">
       <label for="sup" class="col-md-3 control-label">Supérieur : </label>
       <div class="col-md-9">
        <form:input path="sup" cssClass="form-control" />
         <div class="has-error">
                        <form:errors path="sup" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>
      
       <div class="form-group">
       <label for="code" class="col-md-3 control-label">Code : </label>
       <div class="col-md-9">
        <form:input path="code" cssClass="form-control" />
         <div class="has-error">
                        <form:errors path="code" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>
      
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9" style="position: relative;left: 88px">
        <form:button class="btn btn-info">Submit</form:button>
        <a href="${pageContext.request.contextPath}/dept/liste" class="btn btn-info">Retour</a>
        
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
  <jsp:directive.include file="../layout/footer.jsp" />
</body>
</html>