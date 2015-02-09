<div ng-app="myApp">
    <div ng-controller="MyCtrl">
        <div class="gridStyle" ng-grid="gridOptions"></div>
        <button ng-click="update()">Update</button>
        <button ng-click="getChanged()">get changed</button>
    </div>
</div>


<script>
    var app = angular.module('myApp', ['ngGrid']);
    app.controller('MyCtrl', function ($scope, $http) {
        $scope.myData = [
            {id: 1, name: "Moroni", age: 50},
            {id: 2, name: "Tiancum", age: 43},
            {id: 3, name: "Jacob", age: 27},
            {id: 4, name: "Nephi", age: 29},
            {id: 5, name: "Enos", age: 34}
        ];
        $scope.gridOptions = {
            data: 'myData',
            enableCellSelection: false,
            enableCellEditOnFocus: true,
            enableRowSelection: false,
            jqueryUITheme: true,
            filterOptions: $scope.filterOptions,
           // sortInfo: $scope.sortOptions,
            columnDefs: [
                {field: 'id', visible: false},
                {field: 'name', displayName: 'NAME', cellClass: 'red'},
                {field: 'age', displayName: 'AGE', cellClass: 'blue'}
            ]
        };

        $scope.filterOptions = {
            filterText: "",
            useExternalFilter: false
        };

        $scope.sortOptions = {
            fields: ["name"],
            directions: ["DESC"]
        };

        $scope.$on('ngGridEventEndCellEdit', function (event, a, b, c) {
            console.log("cell edited");
        });

        $scope.getChanged = function () {
            var data = $scope.myData;
            for (var i = 0, len = data.length; i < len; i++) {
                if (data[i].changed) {
                    console.log(data[i].name);
                }
            }
        };

        $scope.update = function () {
            $http.post("updateGrid.xml", $scope.myData);
        }

    });
</script>
<style>
    .gridStyle {
        border: 1px solid rgb(212, 212, 212);
        width: 400px;
        height: 600px
    }
</style>