<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Manage Categories</h2>
	<form action="manage_category_add" method="get">
		<input type="text" name="category_id" placeholder="Category Id">
		<input type="text" name="name" placeholder="Name"> <input
			type="text" name="description" placeholder="Description"> <input
			type="submit" value="CreateCategory">
	</form>

</br>
<div id="UpdateCategory">
	
	<form action="manage_category_update" method="post">
		<input type="text" name="category_id" placeholder="Category Id" value="${selectedCategory.category_id }">
		<input type="text" name="name" placeholder="Name" value="${selectedCategory.name}">
		 <input type="text" name="description" placeholder="Description" value="${selectedCategory.description}"> 
		 <input type="submit" value="UpdateCategory">
	</form>

	</div>
	
	
	<h2>Delete/Update Categories</h2>
	<div id="showCategories">
		<table border="1">
			<thead>
				<tr>
					<td>&nbsp; Category Id &nbsp; &nbsp;</td>
					<td>&nbsp; Category Name &nbsp; &nbsp;</td>
					<td>&nbsp; Category Description &nbsp; &nbsp;</td>
					<td>&nbsp; Action &nbsp; &nbsp;</td>
				</tr>
			</thead>

			<c:forEach var="category" items="${categoryList}">
				<tr>
					<td>&nbsp;${category.category_id}</td>
					<td>&nbsp;${category.name}</td>
					<td>&nbsp;${category.description}</td>
					<td><a href="<c:url value='/manage_category_delete/${category.category_id}'/>">&nbsp; Delete | </a>
					<a href="<c:url value='/manage_category_edit/${category.category_id}'/>"> Update &nbsp; </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	
</html>