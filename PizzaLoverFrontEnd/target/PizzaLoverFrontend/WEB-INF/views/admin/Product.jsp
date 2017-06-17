<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>

<h2>Manage Products</h2>


 <c:url var="action" value="manage_product_add"></c:url>
	<form action="${action}" enctype="multipart/form-data" >
	


		<input type="text" name="product_id" placeholder=" Product Id"></br>
		 <label>Select Category:</label> <select name="category_name" class="form-control" id="category_name">
			<c:forEach var="category" items="${categoryList}">
				<option ><a href=#><h5>${category.name}</h5></a></option>

			</c:forEach>
		</select> 
		 <input type="text" name="description" placeholder="Descrpition"></br>
		<input type="text" name="name" placeholder="Name"></br>
		<input type="text" name="price" placeholder="Price"> </br>
		 <label>Select Supplier:</label> </br>
		 <select name="supplier_name"class="form-control" id="supplier_name">
			<c:forEach var="supplier" items="${supplierList}">
				<option><a href=#><h5>${supplier.name}</h5></a></option>

			</c:forEach>
		</select>
		<input type="text" name="type" placeholder=" Type"></br>
		
		 <label>Image Upload:</label> </br>
				<input type="file" name="image" placeholder="Upload Image" > </br>
		<input  type="submit" value="CreateProduct">
		
	</form>

</br>

<div id="UpdateProduct">
	
	<form action="manage_product_update" method="post">
		<input type="text" name="product_id" placeholder="Product Id" value="${selectedProduct.product_id }">
		<input type="text" name="category_id" placeholder="Category Id" value="${selectedProduct.category_id }">
		<input type="text" name="description" placeholder="Description" value="${selectedProduct.description}"> 
		<input type="text" name="name" placeholder="Name" value="${selectedProduct.name}">
		<input type="text" name="price" placeholder="Price" value="${selectedProduct.price}"> 
		<input type="text" name="supplier_id" placeholder="Supplier Id" value="${selectedProduct.supplier_id}">
		<input type="text" name="type" placeholder="Type" value="${selectedProduct.type}">
		 
		 <input type="submit" value="UpdateProduct">

	</form>

	</div> 


<h2>Delete/Update Products</h2>
	<div id="showProducts">
		<table border="1">
			<thead>
				<tr>
					<td>&nbsp; Product Id &nbsp; &nbsp;</td>
					<td>&nbsp; Category Id &nbsp; &nbsp;</td>
					<td>&nbsp; Product Description &nbsp; &nbsp;</td>
					<td>&nbsp; Product Name &nbsp; &nbsp;</td>
					<td>&nbsp; Product Price &nbsp; &nbsp;</td>
					<td>&nbsp; Supplier Id &nbsp; &nbsp;</td>
					<td>&nbsp; Product Type &nbsp; &nbsp;</td>
					<td>&nbsp; Action &nbsp; &nbsp;</td>
				</tr>
			</thead>
					
					
<!-- 				<h3> Product List</h3>	 -->	
		
			<c:forEach var="product" items="${productList}">
				<tr>
					<td>&nbsp;${product.product_id}</td>
					<td>&nbsp;${product.category_id}</td>
					<td>&nbsp;${product.description}</td>
					<td>&nbsp;${product.name}</td>
					<td>&nbsp;${product.price}</td>
					<td>&nbsp;${product.supplier_id}</td>
					<td>&nbsp;${product.type}</td>
					
				
					
					<td><a href="<c:url value='/manage_product_delete/${product.product_id}'/>">&nbsp; Delete | </a>
					<a href="<c:url value='/manage_product_edit/${product.product_id}'/>"> Update &nbsp; </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>
</html>