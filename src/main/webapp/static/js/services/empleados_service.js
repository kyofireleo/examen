'use strict';
 
angular.module('examenApp').factory('EmpleadosService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_POST_EMPLEADOS_URI = 'http://localhost:8080/examen/emp/'; 
    
    var factory = {
        getAllEmpleados: getAllEmpleados, 
        getEmpleado: getEmpleado
    };
    
    return factory;
    
    function getAllEmpleados() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_POST_EMPLEADOS_URI + "buscarEmpleados", {})
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while retrieving accounts');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function getEmpleado(id){
        var deferred = $q.defer();
        $http.get(REST_SERVICE_POST_EMPLEADOS_URI + "buscarEmpleados", {idEmpleado:id})
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while retrieving accounts');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
    
}]);