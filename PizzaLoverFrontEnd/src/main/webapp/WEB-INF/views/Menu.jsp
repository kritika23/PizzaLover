<%-- 
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>

<ul id="menu">

  <c:forEach var="category" items="${categoryList}">
  <li><a href=${category.name}><h3>${category.name}</h3></a>

<ul>
<c:forEach var="product" items="${category.products}">
<a href=${product.name}><h3>${product.name}</h3></a>
</c:forEach>
</ul>
</li>


</c:forEach>
 </ul>
</body>
 --%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav">
    
    <c:forEach var="category" items="${categoryList}">
    
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach var="product" items="${category.products}">
<li><a href=${product.name}><h5>${product.name}</h5></a></li>
</c:forEach>
          <!-- <li><a href="#">Chesse Burst</a></li>
          <li><a href="#">Plain crust</a></li>
          <li><a href="#">Simple Toppings</a></li> -->
        </ul>
      </li>
      
    </c:forEach>
      
    </ul>
  </div>
</nav>
  


</body>
</html>