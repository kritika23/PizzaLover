<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>



<c:set var="imageFolder" value="resources/img/" />

<c:if test="${!empty productList}">
		<table class="tg">
		
<c:forEach var="product" items="${productList}">
<tr>

					<%-- <td>${product.product_id}</td>
					<td>${product.category_id}</td>
					<td>${product.description}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.supplier_id}</td>
					<td>${product.type}</td> --%>
<td>
<img alt="" src="">
</td>


<td>
<a href="cart/add/{product.product_id}" >Add to Cart</a>
</td>

</tr>
</c:forEach>
</table>
</c:if>

</body>
</html>