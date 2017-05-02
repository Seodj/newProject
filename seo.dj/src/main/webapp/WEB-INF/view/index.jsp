<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="utf-8">
	<script src="./resources/lib/angular/angular.min.js"></script>
</head>
<body>
	Hello World!
	<div ng-app="myApp" ng-controller="myCtrl">
		First Name: <input type="text" ng-model="firstName"/><br>
		Last Name: <input tpye="text" ng-model="lastName"/><br>
		
		Full Name: {{firstName + " " + lastName}}
	</div>
</body>
</html>