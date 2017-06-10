<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
<c:set var="imageFolder" value="resources/img/" />
	<table>
		<tr>
			<th align="left" width="80">Cart ID</th>
			<th align="left" width="120">Product Name</th>
			<th align="left" width="200">Date Added</th>
			<th align="left" width="80">Price</th>
			<th colspan="2" align="center" width="60">Action</th>

		</tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
				<td align="left">${cart.id}</td>
				<td align="left">${cart.productName}</td>
				<td align="left">${cart.addedDate}</td>
				<td align="left">${cart.price}</td>
				<td align="left"><a
					href="<c:url value='/cart/delete/${cart.id}'  />">Delete</a></td>
					
					<img alt="download.jpg"  src="resources/images/download.jpg">
			</tr>
		</c:forEach>

	</table>

	<h2>Total cost : ${totalAmount}</h2>
	<br>
	<a href="cart_checkout">Checkout </a>
	<br>
	<br>


</body>
</html>
 --%>





<link href="resources/css/cart.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:30%">User_id</th>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					    
					    <c:forEach items="${cartList}" var="cart">
			<tr>
				<td align="left">${cart.user_id}</td>
				<td align="left">${cart.product}</td>
				<td align="left">${cart.price}</td>
				<td align="left">${cart.quantity}</td>
				<td align="left">${cart.price}*${cart.quantity}</td>
				<td align="left"><a
					href="<c:url value='/cart/delete/${cart.id}'  />">Delete</a></td>
					
					<img alt="download.jpg"  src="resources/images/download.jpg">
			</tr>
		</c:forEach>
					    
					    
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">Product Name</h4>
									
									</div>
								</div>
							</td>
							<td data-th="Price"></td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="1">
							</td>
							<td data-th="Subtotal" class="text-center"></td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong> Rs.</strong></td>
						</tr>
						<tr>
							<td><a href="Home" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total Rs. ${totalAmount}</strong></td>
							<td><a href="CheckOut" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>