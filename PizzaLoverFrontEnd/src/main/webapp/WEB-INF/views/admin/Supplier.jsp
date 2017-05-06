<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Manage Suppliers</h2>

<form action="manage_supplier_add">
<input type="text" name="supplier_id" placeholder=" Supplier Id">
<input type="text" name="address" placeholder="Address">
<input type="text" name="contact" placeholder="Contact No">
<input type="text" name="name" placeholder="Name">
<input type="submit" value="CreateSupplier">
</form>
</br>

<div id="UpdateSupplier">
	
	<form action="manage_supplier_update" method="post">
		<input type="text" name="supplier_id" placeholder="Supplier Id" value="${selectedSupplier.supplier_id }">
		 <input type="text" name="address" placeholder="Address" value="${selectedSupplier.address}"> 
		  <input type="text" name="contact" placeholder="Contact  No" value="${selectedSupplier.contact}"> 
		<input type="text" name="name" placeholder="Name" value="${selectedSupplier.name}">
		
		 <input type="submit" value="UpdateSupplier">
	</form>

	</div>
	
	
	<h2>Delete/Update Suppliers</h2>
	<div id="showSuppliers">
		<table border="1">
			<thead>
				<tr>
					<td>&nbsp; Supplier Id &nbsp; &nbsp;</td>
					<td>&nbsp; Supplier Address &nbsp; &nbsp;</td>
					<td>&nbsp; Supplier Contact &nbsp; &nbsp;</td>
					<td>&nbsp; Supplier Name &nbsp; &nbsp;</td>
					
					<td>&nbsp; Action &nbsp; &nbsp;</td>
				</tr>
			</thead>

			<c:forEach var="supplier" items="${supplierList}">
				<tr>
					<td>&nbsp;${supplier.supplier_id}</td>
					<td>&nbsp;${supplier.address}</td>
					<td>&nbsp;${supplier.contact}</td>
					<td>&nbsp;${supplier.name}</td>
					
					<td><a href="<c:url value='/manage_supplier_delete/${supplier.supplier_id}'/>">&nbsp; Delete | </a>
					<a href="<c:url value='/manage_supplier_edit/${supplier.supplier_id}'/>"> Update &nbsp; </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	


</body>
</html>