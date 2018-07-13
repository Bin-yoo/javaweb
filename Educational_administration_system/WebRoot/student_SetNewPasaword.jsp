<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/other.css"/>
	</head>
	<body>
		<div class="header">
			<div class="htitle">教务查询系统(学生)</div>
			<div class="user dropdown">
				<button type="button" class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${sessionScope.suser.studentID}<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="login.jsp">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="box">
				<div class="Lmenu">
					<a href="student_Courselist">可选课程<span class="glyphicon glyphicon-list-alt"></span></a>
					<a href="student_Selectedcourselist">已选课程<span class="glyphicon glyphicon-user"></span></a>
					<a href="student_Finishcourselist">已修课程<span class="glyphicon glyphicon-book"></span></a>
					<a href="student_SetNewPasaword.jsp" class="btn btn-info active">修改密码<span class="glyphicon glyphicon-edit"></span></a>
				</div>
				<div class="Rshow">
					<div class="stitle">
						<h1>修改密码</h1>
					</div>
					<div class="updatetable">
						<div>
							<div class="errMsg">${errMsg}</div>
							<form class="form-horizontal" action="student_Setnewpassword" method="post" role="form">
								<div class="from-group">
									<div class="col-sm-2">
										<label for="oldPassword" class="control-label">旧密码:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="oldPassword" id="oldPassword" value=""/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="newPassword" class="control-label">新密码:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="newPassword" id="newPassword" value=""/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-2">
										<label for="rePassword" class="control-label">确认新密码:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="rePassword" id="rePassword" value=""/>
									</div>
								</div>
								<div class="from-group">
									<div class="col-sm-8 lastdiv">
										<input type="submit" class="btn btn-success" name="submit" value="提 交">
										<input type="reset" class="btn btn-default" name="reset" value="重 置">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/other.js"></script>
</html>
