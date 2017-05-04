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
<form action="manage_category_add">
<input type="text" name="category_id" placeholder="Category Id">
<input type="text" name="name" placeholder="Name">
<input type="text" name="description" placeholder="Description">
<input type="submit" name="createCategory">
</form>



<h2>Delete/Update Categories</h2>
<div id="showCategories">
<table border="1">
<thead>
<tr>
<td> &nbsp; Category Id  &nbsp; &nbsp;</td> 
<td> &nbsp; Category Name  &nbsp; &nbsp;</td>
<td> &nbsp; Category Description &nbsp; &nbsp;</td>
<td> &nbsp; Action &nbsp; &nbsp;</td>
</tr>
</thead>

<c:forEach var="category" items="${categoryList}">
<tr>
<td> &nbsp;${category.category_id}</td>
<td> &nbsp;${category.name}</td>
<td> &nbsp;${category.description}</td>
 <td> <a href="#"> Delete | </a>   
	   <a href=""> Update  </a> </td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>