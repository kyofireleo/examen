<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Empleados</title>
		<style>

		</style>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		<link href="/src/main/resources/static/css/app.css" rel="stylesheet"></link>
	</head>

	<body ng-app="examenApp">
		<div ng-controller="EmpleadosController as ctrl">
			<h1>Empelados</h1>
			<br/>
			<br/>
			<form name="formEmpleados">
				<input type="button" id="btnNuevo" value="Nuevo Empleadao"/>
				<br/>
				<table border="1">
					<tr>
						<td>ID</td>
						<td>Nombre</td>
						<td>Apellido</td>
						<td>Puesto</td>
					</tr>
					<tbody>
						<tr ng-repeat="emp in empleados">
							<td><span ng-bind="emp.idEmpleado"></span></td>
							<td><span ng-bind="emp.nombre"></span></td>
							<td><span ng-bind="emp.apellido"></span></td>
							<td><span ng-bind="emp.puesto"></span></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
		<script src="/src/main/webapp/static/js/app.js"></script>
		<script src="/src/main/webapp/static/js/controller/empleados_controller.js"></script>
		<script src="/src/main/webapp/static/js/services/empleados_service.js"></script>
	</body>
</html>