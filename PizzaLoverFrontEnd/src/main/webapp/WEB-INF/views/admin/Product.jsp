<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Manage Products</h2>
<form action="manage_product_add">

<input type="text" name="product_id" placeholder=" Product Id"> </br> </br>

      <label>Select Category:</label>
      <select class="form-control" id="sel1">
                  <c:forEach var="category" items="${categoryList}">
 	<option><a href=#><h5>${category.name}</h5></a></option>
      
	</c:forEach>
        </select>         
        </br> </br>
<input type="text" name="descrpition" placeholder="Descrpition"> </br> </br>
<input type="text" name="name" placeholder="Name"> </br> </br>
<input type="text" name="price" placeholder="Price"> </br> </br>

<label>Select Supplier:</label>
      <select class="form-control" id="sel1">
                  <c:forEach var="supplier" items="${supplierList}">
 	<option><a href=#><h5>${supplier.name}</h5></a></option>
      
	</c:forEach>
        </select>
             </br> </br>
             
<input type="text" name="type" placeholder=" Type"> </br> </br>
<input type="submit" name="createProduct">
</form>



</body>
</html>