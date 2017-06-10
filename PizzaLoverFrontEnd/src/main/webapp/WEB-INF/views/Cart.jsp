<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
						
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%">Actions</th>
						</tr>
					</thead>
					<tbody>
					    
					    <c:forEach items="${cartList}" var="cart">
	

												
					    
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img alt="download.jpg"  src="resources/images/download.jpg"  class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cart.product_name}</h4>
									
									</div>
								</div>
							</td>
							<td data-th="Price">${cart.price}</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value='${cart.quantity}'>
							</td>
							<td data-th="Subtotal" class="text-center">${cart.price * cart.quantity}</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								
								<button onclick="cart/delete/${cart.cart_id}" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
							   <td align="left"><a href="<c:url value='/cart/delete/${cart.cart_id}'/>">Delete</a></td>
							</td>
						</tr>
						</c:forEach>
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