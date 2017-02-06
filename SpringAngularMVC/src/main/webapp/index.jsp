<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="demo">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" ></script>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/angular.min.js" />"></script>
	<script>
		$(function() {
		    $('#login-form-link').click(function(e) {
		    	$("#login-form").delay(100).fadeIn(100);
		 		$("#register-form").fadeOut(100);
				$('#register-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});
			$('#register-form-link').click(function(e) {
				$("#register-form").delay(100).fadeIn(100);
		 		$("#login-form").fadeOut(100);
				$('#login-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});
		});

		
		angular.module('demo',[]).controller("Login",function($scope,$http){
			$scope.txtUsuarioLogin = {
					text : ""
			}
			$scope.txtPasswordLogin = {
					text : ""
			}
			
			$scope.txtUsuarioRegistro = {
					text : ""
			}
			
			$scope.txtEmailRegistro = {
					text : ""
			}
			
			$scope.txtPasswordRegistro = {
					text : ""
			}
			
			$scope.ingresarUsuario = function(){
				console.log($scope.txtUsuarioLogin.text);
				console.log($scope.txtPasswordLogin.text);
			}
			
			$scope.registrarUsuario = function(){
				console.log($scope.txtUsuarioRegistro.text);
				console.log($scope.txtEmailRegistro.text);
				console.log($scope.txtPasswordRegistro.text);
			}
			
		});
	</script>
</head>
<body>

<div class="container" ng-controller="Login">
   <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
              <form id="login-form" action="#" method="post" role="form" style="display: block;" >
                <h2>Login</h2>
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="" ng-model = "txtUsuarioLogin.text">
                  </div>
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" ng-model = "txtPasswordLogin.text">
                  </div>
                  <div class="col-xs-6 form-group pull-right">     
                        <input type="button" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Ingresar" ng-click="ingresarUsuario()">
                  </div>
              </form>
              
              <form id="register-form" action="#" method="post" role="form" style="display: none;">
                <h2>Registro</h2>
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Usuario" value="" ng-model = "txtUsuarioRegistro.text">
                  </div>
                  <div class="form-group">
                    <input type="text" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="" ng-model = "txtEmailRegistro.text">
                  </div>
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" ng-model = "txtPasswordRegistro.text">
                  </div>
                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="button" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Registrarte" ng-click="registrarUsuario()">
                      </div>
                    </div>
                  </div>
              </form>
            </div>
          </div>
        </div>
        <div class="panel-heading">
          <div class="row">
            <div class="col-xs-6 tabs">
              <a href="#" class="active" id="login-form-link"><div class="login">LOGIN</div></a>
            </div>
            <div class="col-xs-6 tabs">
              <a href="#" id="register-form-link"><div class="register">REGISTER</div></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<footer>
</footer>		
</body>
</html>