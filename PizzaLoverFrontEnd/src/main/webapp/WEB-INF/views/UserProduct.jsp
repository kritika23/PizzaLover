



	<c:if test="${!empty productList}">
	<c:forEach items="${productList}" var="product">
<div class="container" style="margin-top:50px;">
	<div class="row">
    	<div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-images-content">
                    <images src="resources/images/" class="images-responsive" />
                    <span class="post-title">
                        <b>${category.name}</b><br>
                    </span>
              
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5>${product.name}</h5>
                           
                        </div>
                       <div class="rating hidden-sm col-md-6">
                           
                             <h5 class="price-text-color">Rs:${product.price}/-</h5>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="cart/add/${product.product_id}" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="selectedProduct/${product.product_id}" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        </div>
        </div>
        </c:forEach>
        </c:if>
