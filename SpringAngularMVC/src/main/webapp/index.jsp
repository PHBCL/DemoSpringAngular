<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="demo">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
	<script>
		angular.module('demo',[]).controller("Hello",function($scope,$http){
			$http.get('http://localhost:8050/SpringAngularMVC/usuarioService/listaUsuario').then(function(response){
			 	$scope.listaNombres = response.data;
			});
			
			$scope.txtNombre = {
					text:''
			};
			
			$scope.llamarFuncion = function(){
				var data = {"nombre":$scope.txtNombre.text};
				$http.post('http://localhost:8050/SpringAngularMVC/usuarioService/SaludarNombre',data,"").then(function(response){
				 	$http.get('http://localhost:8050/SpringAngularMVC/usuarioService/listaUsuario').then(function(response){
					 	$scope.txtNombre.text = "";
				 		$scope.listaNombres = response.data;
					});
				});
			}
			
			$scope.eliminar = function(id){
				var data = {"id":id,"nombre":""};
				$http.post('http://localhost:8050/SpringAngularMVC/usuarioService/eliminarUsuario',data,"").then(function(response){
				 	$http.get('http://localhost:8050/SpringAngularMVC/usuarioService/listaUsuario').then(function(response){
					 	$scope.txtNombre.text = "";
				 		$scope.listaNombres = response.data;
					});
				});
				
			}
		});
	</script>
</head>
<body>
	<div ng-controller="Hello">
		<input type="text" ng-model="txtNombre.text" /><input type="button" ng-click="llamarFuncion()" value="click"/>
		<table>
		  <tr ng-repeat="usuario in listaNombres">
		    <td>{{ usuario.nombre }} </td>
		    <td><input  type="button" data="{{usuario.id}}" ng-click="eliminar(usuario.id)" value="Eliminar"/></td>
		  </tr>
		</table>
		<select>
			<option ng-repeat="usuario in listaNombres">
				{{ usuario.nombre }}
			</option>
		</select>
	
	</div>
</body>
</html>