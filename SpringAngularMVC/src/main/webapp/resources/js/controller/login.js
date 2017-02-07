/**
 * 
 */
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

		
		var app = angular.module('demo',['ngCookies']);
		
		app.controller("Login",function($scope,$http,$cookies,$window){
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
			
			$scope.reasonToShow = false;
			
			$scope.ingresarUsuario = function(){
				var user = new Object();
				user.id = 0;
				user.usuario = $scope.txtUsuarioLogin.text;
				user.email = "";
				user.contrasena = $scope.txtPasswordLogin.text;
				
				var config = {
			                headers : {
			                    'Content-Type': 'application/json'
			                }
			            }
				 
				$http.post("./usuarioService/validarUsuario",JSON.stringify(user),config)
						.then(function(response, status, headers, config){
							$cookies.put("token",response.data);
							$window.location.href = ctx + '/menu';
							
						}, function errorCallback(response) {
							if(response.status = 404){
								$scope.reasonToShow = true;
							}
						});
			}
			
			$scope.registrarUsuario = function(){
				var user = new Object();
				user.id = 0;
				user.usuario = $scope.txtUsuarioRegistro.text;
				user.email = $scope.txtEmailRegistro.text;
				user.contrasena = $scope.txtPasswordRegistro.text;
				
				var config = {
			                headers : {
			                    'Content-Type': 'application/json'
			                }
			            }
				 
				$http.post("./usuarioService/registrarUsuario",JSON.stringify(user),config)
						.then(function(response, status, headers, config){
							$cookies.put("token",response.data);
							$window.location.href = ctx + '/menu';
						})
				
			}
		});