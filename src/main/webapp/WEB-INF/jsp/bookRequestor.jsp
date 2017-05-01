<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<form name = "searchForm" method="post" action = "search">
<h1 align = "center"> Book Search Page</h1>
<table cols="6" width="80%" border = "0" align="center" cellpadding="20%">
<tr><td></td>

<tr><td>Title  :  </td><td><input type="text" name = "bookTitle"></td>
<td>ISBN No : </td><td><input type="text" name = "bookIsbnno"></td>
<td>Genre: </td><td><input type="text" name = "genre"></td>
<tr></tr><td></td><td></td><td></td><tr></tr>
<tr><td>Author Name  : </td><td><input type="text" name = "authorName"></td>
<td>Available Books </td><td><input type="radio" name = "availableStatus" checked="checked" value ="yes" >Yes</td>
<td><input type="radio" name = "availableStatus" value ="no" >NO</td>
<td></td></tr>
<tr></tr><tr></tr>
<tr><td></td><td></td><td></td><td><input type = "submit" name = "search" value="Search Books" align ="center"/></td></tr>
<tr><td></td><td></td><td></td></tr>
</table>
</div>
	<!-- /.container -->
<div>
<div rowspan ="10"><table></table></div>

<table col="4" width="100%">
<tr>
<td colspan="4" align ="center" ><c:if test="${empty book}"><c:if test="${empty firstLoad }">
  <font color="orange" style="bold" size ="6"> Oops!!!  No Matching Books Found.</font>
  </c:if>
  </c:if>
  </td>
  </tr>
  </table>
 <c:if test="${not empty book}">
<table cols="4" width="60%" border = "1" align="center">

    
<th><tr><td>ISBN No </td><td>Title </td><td>Genre </td><td>publisher </td><td>Request a Book</td></tr></th>
<c:forEach items="${book}" var="list">
    
<tr><td>${list.bookIsbnno}</a></td><td>${list.bookTitle}</td><td>${list.genre}</td><td>${list.publisher}</td><td><a href="/requestBook?bookIsbnno=${list.bookIsbnno}">Request Book</td></tr>
 </c:forEach>
  </c:if>
</table>
<c:if test="${not empty reqMsg}"> Book requested successfully </c:if>
</div>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</form>
</html>
