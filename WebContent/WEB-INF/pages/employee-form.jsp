<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/test.js" />"></script>

</head>
<body>

   <jsp:directive.include file="../layout/navbar.jsp" />

 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Manage Employees</h2>
   <div class="panel panel-default">
    <div class="panel-heading">
     <div class="panel-title">Add Employee</div>
    </div>
    <div class="panel-body">
     <form:form action="saveEmployee" cssClass="form-horizontal"
      method="post" modelAttribute="employee">
 	<form:input path="id" type="hidden" />
  

      <div class="form-group">
       <label for="firstname" class="col-md-3 control-label">First
        Name</label>
       <div class="col-md-9">
        <form:input path="firstName" cssClass="form-control" />
        <div class="has-error">
                        <form:errors path="firstName" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>
      <div class="form-group">
       <label for="lastname" class="col-md-3 control-label">Last
        Name</label>
       <div class="col-md-9">
        <form:input path="lastName" cssClass="form-control" />
            <div class="has-error">
                        <form:errors path="lastName" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>

      <div class="form-group">
       <label for="email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" />
        <div class="has-error">
                        <form:errors path="email" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>
      
         <div class="form-group">
       <label for="tele" class="col-md-3 control-label">Téléphone</label>
       <div class="col-md-9">
        <form:input type="number" path="tele" cssClass="form-control" />
        <div class="has-error">
                        <form:errors path="tele" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>  
      
      
      
      
   

        <div class="form-group">
                <label for="myDept" class="col-md-3 control-label">Département</label>
                   <div class="col-md-9">
            <form:select id="myDept" path="myDept"   name="myDept" cssClass="form-control">
            
              <c:forEach items="${mydepts}" var="dept">
        <option value="${dept.getId()}">${dept.getNom()}</option>
    </c:forEach>
            </form:select>
                   <div class="has-error">
                        <form:errors path="myDept" cssClass="alert-danger"/>
                    </div>
            </div>
            </div>
            
             <div class="form-group">
                <label for="grade" class="col-md-3 control-label">Grade</label>
                   <div class="col-md-9">
            <form:select path="grade" items="${grades}" id="grade" name="grade" cssClass="form-control"></form:select>
                   <div class="has-error">
                        <form:errors path="grade" cssClass="alert-danger"/>
                    </div>
            </div>
            </div>
            
            
            
         <div class="form-group">
                <label for="myRenum" class="col-md-3 control-label">Rénumération</label>
                   <div class="col-md-9">
            <form:select id="myRenum" path="myRenum"   name="myRenum" cssClass="form-control">
            
              <c:forEach items="${myrenums}" var="renum">
        <option value="${renum.getId()}">${renum.getNom()}</option>
    </c:forEach>
            </form:select>
                   <div class="has-error">
                        <form:errors path="myRenum" cssClass="alert-danger"/>
                    </div>
            </div>
            </div>
            
            
             <div class="form-group">
       <label for="salaire" class="col-md-3 control-label">Salaire</label>
       <div class="col-md-9">
        <form:input type="number" path="salaire"  id="salaire" name ="salaire" cssClass="form-control" />
        <div class="has-error">
                        <form:errors path="salaire" cssClass="alert-danger"/>
                    </div>
       </div>
      </div> 
      
          <div class="form-group">
                <label for="manager" class="col-md-3 control-label">Manager</label>
                   <div class="col-md-9">
            <form:select path="manager" items="${managers}"  id="man" name ="man" cssClass="form-control"></form:select>
                   <div class="has-error">
                        <form:errors path="manager" cssClass="alert-danger"/>
                    </div>
            </div>
            </div>
            
            
            <div class="form-group">
                <label for="sup" class="col-md-3 control-label">Supérieur</label>
                   <div class="col-md-9">
            <form:select path="sup" items="${superieur}" id="sup" name ="sup" cssClass="form-control"></form:select>
                   <div class="has-error">
                        <form:errors path="sup" cssClass="alert-danger"/>
                    </div>
            </div>
            </div>
              <div class="form-group">
       <label for="adresse" class="col-md-3 control-label">Adresse</label>
       <div class="col-md-9">
        <form:textarea path="adresse" cssClass="form-control" />
        <div class="has-error">
                        <form:errors path="adresse" cssClass="alert-danger"/>
                    </div>
       </div>
      </div>
            
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9" style="position: relative;left: 88px">
        <form:button class="btn btn-info">Submit</form:button>
        <a href="${pageContext.request.contextPath}/employee/listE" class="btn btn-info">Retour</a>
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