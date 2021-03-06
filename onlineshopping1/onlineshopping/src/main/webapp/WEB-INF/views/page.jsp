<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />




<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title }</title>
    
    <script>
    	window.menu = '${title}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css }/mycss.css" rel="stylesheet">
    
        <!-- Bootstrap Themes  CSS -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

</head>

<body>


	<div class="wrapper">

    <!-- Navigation Bar -->
    
    <%@include file="./shared/navbar.jsp" %>
    
    
    
    
    
    
    
    <!-- Page Content -->
    
    <div class="content">
    
	<!-- Load Only When User Click Home Page  -->
	<c:if test="${userClickHome == true }">
		<%@include file="home.jsp" %>
	</c:if>
	
	<!-- Load Only When User Click About us -->
	<c:if test="${userClickAbout == true }">
		<%@include file="about.jsp" %>
	</c:if>
	
	<!-- Load Only When User Click Contact us -->
	<c:if test="${userClickContact == true }">
		<%@include file="contact.jsp" %>
	</c:if>
	
	<!-- Load Only When User Click All Products or Category Products -->
	<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
		<%@include file="listProducts.jsp" %>
	</c:if>
	
   </div>
   
   
   
   
   
   
   
   
   
   
   <!-- Footer Part -->
   <%@include file="./shared/footer.jsp" %>

    <!-- JavaScript -->
    <script src="${js }/jquery.js"></script>
    <script src="${js }/bootstrap.js"></script>
    
    <!-- DataTable plugin -->
	<script src="${js }/jquery.dataTables.js"></script>
	
	
	<!-- my custome js -->
	<script src="${js }/myapp.js"></script>

</div>
</body>

</html>
