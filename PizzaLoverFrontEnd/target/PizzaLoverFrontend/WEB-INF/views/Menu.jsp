
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
