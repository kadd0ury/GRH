<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/employee/index">GRH</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/employee/index">Home</a></li>
      
        <li class="dropdown">
                <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gestion des employées <span class="caret"></span></a>
                <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/employee/listE">Employees</a></li>
                 <li><a href="${pageContext.request.contextPath}/user/liste">Users</a></li>
                </ul>
              </li>
      <li><a href="${pageContext.request.contextPath}/dept/liste">Departements</a></li>
        <li><a href="${pageContext.request.contextPath}/renum/liste">Remunerations</a></li>
        
        
         <ul class="nav navbar-nav navbar-right">
        <li class="dropdown" style="position: relative;left:670px;">
                <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=session.getAttribute("username")%><span class="caret"></span></a>
                <ul class="dropdown-menu">
                 <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
              </li>
    </ul>
        
       
     
    </ul>
  </div>
</nav>