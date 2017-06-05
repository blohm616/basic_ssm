<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<%@ include file="head.jspf" %>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a href="${pageContext.request.contextPath }/index.jsp" class="navbar-brand">SayGo</a>
				</div>
				<div class="navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							<a href="#">Home</a>
						</li>
						<li>
							<a href="#">Home</a>
						</li>
						<li>
							<a href="#">Home</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div id="parent" style="width: 80%; height: 400px;margin:0 auto;">
		</div>
		<script type="text/javascript">
			$().ready(function() {
				echarts_extra(${options}, "parent");
			});
		</script>
	</body>
</html>
