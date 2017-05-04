
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>PIZZA LOVER HOME PAGE</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="resources/css/footer.css" rel="stylesheet">
  
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   

</head>

<body>


	<%@ include file="Header.jsp" %>  
	

	<%@ include file="Menu.jsp" %> 
	 
	<c:if test="${isAdmin=='true'}">
	<%@ include file="admin/AdminHome.jsp" %>  
	</c:if>
	
	<c:if test="${isAdminClickedCategories=='true'}">
	<%@ include file="admin/Category.jsp" %> 
	</c:if>
	
	<c:if test="${isAdminClickedProducts=='true'}">
	<%@ include file="admin/Product.jsp" %> 
	</c:if>
	
	<c:if test="${isAdminClickedSuppliers=='true'}">
	<%@ include file="admin/Supplier.jsp" %> 
	</c:if>

<c:if test="${empty isUserClickedLogin }">
<c:if test="${empty isUserClickedRegisteration }">
<c:if test="${empty isAdmin }">
	<%@ include file="Carousel.jsp" %>  
	</c:if>
</c:if>
</c:if>

	<c:if test="${isUserClickedLogin=='true' }">

	<%@ include file="Login.jsp" %>  

	</c:if>


	<c:if test="${isUserClickedRegisteration=='true' }">
	
		<%@ include file="Registration.jsp" %>  

	</c:if>
	
	
	<%@ include file="Footer.jsp" %>  


</body>
</html>