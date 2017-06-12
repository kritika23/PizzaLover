

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

</head>
  <div class="row zsx">
<div align="center" >
					<p class="vcenter">
					<h1><img src="resources/images/download.jpg" height="75" width="75"> PIZZA LOVER</h1>
					<h3>People Disappoint Pizza is Eternal !</h3>
					</p>
				</div>
				</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    	
      <a class="navbar-brand" href="#">Pizza Lover    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${message}</a>
   
    </div>
    
    <ul class="nav navbar-nav navbar-right">
          <li class="active"><a href="Home">Home</a></li>
          
      
<li class="cart-icon-bottom"><a href="cart">Cart {${cartSize}}</a></li>   
      <li><a href="RegistrationPage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
    
            <c:if test="${user_id ==null}" >
      
            <li><a href="LoginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
        <c:if test="${user_id !=null}" >
      <li><a href="/j_spring_security_Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
      </c:if>
    </ul>
  </div>
</nav>

