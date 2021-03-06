<div class="container">
	<div class="row">

		<!-- In row div 2 parts is their first is side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>


		<!-- another part is for products -->
		<div class="col-md-9">

			<!-- added bredcrumb component -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>



				</div>

			</div>


			<!-- jquery Table Demo Purpose -->
			<div class="row">
			
				<div class="col-xs-12">
					<table id="proudctListTable" class="table table-striped table borderd">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								
							</tr>
						</thead>			
					</table>
				</div>


		</div>

	</div>



</div>