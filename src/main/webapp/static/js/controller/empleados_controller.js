'use strict';

angular.module('examenApp',[]).controller('EmpleadosController', ['$scope', 'EmpleadosService', function($scope, passedEmpleadosService){
	var self = this;
	self.empleados = [];

	obtenerAllEmpleados();

	function obtenerAllEmpleados(){
		passedEmpleadosService.getAllEmpleados()
			.then(
				function(d){
					console.log("Obteniendo empleados...");
					if(d.status == 1)
						self.empleados = d.data;
				},
				function(err){
					console.error("Error al obtener los empleados");
					console.log(err);
				}
			);
	}
}]);