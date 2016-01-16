var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
// facultate get,add,update,delete
  $scope.facultati = [];
  $scope.keys = [];

  $scope.faculty = {};
  $scope.editFaculty = {};
  
  $http.get('http://localhost:8080/facultate').then(
  	function successCallback(response){
  	  $scope.facultati = response;
  	  $scope.keys = Object.keys(response.data[0]);
  	});
	
  $scope.addFacultate = function(faculty){
  	$scope.facultati.data.push(faculty);
  	$http.post('http://localhost:8080/facultate', faculty);
  	$scope.faculty = {};
  };
  
  $scope.setUpdateFacultate  = function(faculty){
  	$scope.editFaculty = faculty;
  };

  $scope.updateFaculty = function () {
  	$http.put('http://localhost:8080/facultate/' + $scope.editFacultate.id, $scope.editFaculty);
  	$scope.editFaculty = {};
  };
  
  $scope.deleteFacultate = function (id) {
  	$http.delete('http://localhost:8080/facultate/' + id).then(
  	  function successCallback(response){
        $scope.facultati.splice(id, 1);

  	  },
  	  function errorCallback(response){
  	  	angular.element('[data-id=' + id + ']').remove();
  	  });
  };

// player get,add,update,delete
  $scope.players = [];
  $scope.keysc = [];

  $scope.player = {};
  $scope.editPlayer = {};
  
  $http.get('http://localhost:8080/player').then(
    function successCallback(response) {
      $scope.players = response;
      $scope.keysc = Object.keys(response.data[0]);
  });
  
  $scope.addPlayer = function (player) {
    $scope.players.data.push(player);
    $http.post('http://localhost:8080/player', player);
    $scope.player = {};
  };
  
  $scope.setUpdatePlayer  = function(player){
    $scope.editPlayer = player;
  };

  $scope.updatePlayer = function () {
    $http.put('http://localhost:8080/player/' + $scope.editPlayer.id, $scope.editPlayer);
    $scope.editPlayer = {};
  };
  
   $scope.deletePlayer = function (id) {
    $http.delete('http://localhost:8080/player/' + id).then(
      function successCallback(response){
        $scope.players.splice(id, 1);
      },
      function errorCallback(response){
        angular.element('[data-id=' + id + ']').remove();
      });
  }; 

// produs get,add,update,delete
  $scope.produse = [];
  $scope.keysp = [];

  $scope.produs = {};
  $scope.editProdus = {};

  $http.get('http://localhost:8080/produs').then(
    function successCallback(response){
      $scope.produse = response;
      $scope.keysp = Object.keys(response.data[0]);
    }); 

  $scope.addProdus = function(produs){
    $scope.produse.data.push(produs);
    $http.post('http://localhost:8080/produs', produs);
    $scope.produs = {};
  };
  
  $scope.setUpdateProdus  = function(produs){
    $scope.editProdus = produs;
  };

  $scope.updateProdus = function () {
    $http.put('http://localhost:8080/produs/' + $scope.editProdus, $scope.editProdus);
    $scope.editProdus = {};
  };  

  $scope.deleteProdus = function (id) {
    $http.delete('http://localhost:8080/produs/' + id).then(
      function successCallback(response){
        $scope.produse.splice(id, 1);

      },
      function errorCallback(response){
        angular.element('[data-id=' + id + ']').remove();
      });
  };
  
  $scope.readFacultate = {};
  $scope.readProdus = {};
  $scope.readPlayer = {};
  
  $scope.setReadFacultate = function(faculty) {
    $scope.readFacultate = faculty;
    
  };

  $scope.setReadProdus = function (produs) {
  	$scope.readProdus = produs;
  };

  $scope.setReadPlayer = function (player) {
  	$scope.readPlayer = player;
  };



  $scope.myArray = ['Elem1', 'Elem2', 'Elem3', 'Elem 4'];
}]);