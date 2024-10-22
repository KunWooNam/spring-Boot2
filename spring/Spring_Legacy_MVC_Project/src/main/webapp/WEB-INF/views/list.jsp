<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<style>
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>매니저번호</th>
					<th>위치번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${depts}" var="info">
					<tr>
						<td>${info.department_id}</td>
						<td>${info.department_name}</td>
						<td>${info.manager_id}</td>
						<td>${info.location_id}</td>
					</tr>
				</c:forEach>			
			</tbody>
			<tfoot>
			
			</tfoot>
		</table>
	</div>
</body>
</html>