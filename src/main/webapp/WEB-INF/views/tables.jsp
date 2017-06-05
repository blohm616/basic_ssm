<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<%@ include file="head.jspf" %>
	</head>
	<body>
		<div class="container">
			<table class="table table-hover">
				<tr>
					<th>编号</th>
					<th>表名</th>
					<th>注释</th>
				</tr>
				<c:forEach items="${tables }" var="table" varStatus="tableCount">
					<tr>
						<td>${tableCount.count }</td>
						<td>${table.name }</td>
						<td>${table.comment }</td>
					</tr>
				</c:forEach>
			</table>
			<form class="form-inline navbar-right" action="${pageContext.request.contextPath }/code/generation" method="post">
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail3">包名</label>
					<input type="text" class="form-control" id="packageName" name="packageName" placeholder="package name">
				</div>
				<button type="submit" class="btn btn-default">generation</button>
			</form>
		</div>
	</body>
</html>