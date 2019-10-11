<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Stack Storm Management</title>  
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
	<div>
		</br>
		</br>
		<div id="navigation">
			<a style="margin-left: 22px; color:#000000;; font-size:32px;" href="#/actions">Actions   </a> 
			<a style="margin-left: 22px; color:#000000;; font-size:32px;" href="#/execution">Executions   </a>
			<a style="margin-left: 22px; color:#000000;; font-size:32px;" href="#/inquiry">Inquiries   </a>
		</div>

		<div ng-view=""></div>
	</div>

	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
      <script src="http://apps.bdimg.com/libs/angular-route/1.3.13/angular-route.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/action_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/action_controller.js' />"></script>
      <script src="<c:url value='/static/js/controller/test.js' />"></script>  
      
      <script src="<c:url value='/static/js/controller/actions.controller.js' />"></script>
      <script src="<c:url value='/static/js/controller/action.controller.js' />"></script>
	</body>
</html>