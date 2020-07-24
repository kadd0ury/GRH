<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>

   <jsp:directive.include file="../layout/navbar.jsp" />

 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Users Management</h2>
   <div class="panel panel-default">
    <div class="panel-heading">
     <div class="panel-title">Add user</div>
    </div>
    <div class="panel-body">
     <form:form action="save" cssClass="form-horizontal"
      method="post" modelAttribute="user">

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
       <label for="email" class="col-md-3 control-label">Email: </label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" />
         <div class="has-error">
            <form:errors path="email" cssClass="alert-danger"/>
          </div>
       </div>
      </div>
      
       <div class="form-group">
                <label for="role" class="col-md-3 control-label">Rôle</label>
                   <div class="col-md-9">
            <form:select path="role" items="${roles}" id="role" name="role" cssClass="form-control"></form:select>
                   <div class="has-error">
                        <form:errors path="role" cssClass="alert-danger"/>
                    </div>
            </div>
            </div>
            
            
             <div class="form-group">
       <label for="password" class="col-md-3 control-label">Password: </label>
       <div class="col-md-9">
        <form:input type="password" path="password" cssClass="form-control" />
         <div class="has-error">
            <form:errors path="password" cssClass="alert-danger"/>
          </div>
       </div>
      </div>
      
     
     
     
     
      
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9" style="position: relative;left: 88px">
        <form:button class="btn btn-info">Submit</form:button>
        <a href="${pageContext.request.contextPath}/user/liste" class="btn btn-info">Retour</a>
        
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