<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="ActionController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Workflow List </span></div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Workflows </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ref</th>
                              <th>pack</th>
                              <th>description</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.actions">
                              <td><span ng-bind="u.ref"></span></td>
                              <td><span ng-bind="u.pack"></span></td>
                              <td><span ng-bind="u.description"></span></td>

                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Details</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
              <ul>
            <li><a href="#/">home</a></li>
            <li><a href="oneaction">one action</a></li>
            <li><a href="#/printers">print</a></li>
            <li><a href="#/blabla">others</a></li>
        </ul>
      <div ng-view></div>
      <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
      <script src="http://apps.bdimg.com/libs/angular-route/1.3.13/angular-route.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/action_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/action_controller.js' />"></script>
  </body>
</html>