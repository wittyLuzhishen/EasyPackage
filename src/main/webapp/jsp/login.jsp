<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 登录部分 -->
			<div class="col-md-4">
				<h1>
					<span class="label label-warning">请登录</span>
				</h1>
				<form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/login"
					method="post">
					<div class="form-group">
						<label for="userName" class="col-md-12 glyphicon glyphicon-user">用户名</label>
						<input type="text" class="form-control" id="userName"
							name="userName" placeholder="请输入用户名">
					</div>
					<div class="form-group">
						<label for="password"
							class="col-md-12 glyphicon glyphicon-asterisk">密码</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="请输入密码">
					</div>
					<div class="form-group">
						<div class="col-md-offset-2">
							<button type="submit" class="btn btn-primary">登录</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 介绍部分 -->
			<div class="col-md-8">
				<div class="jumbotron">
					<h1>易打包</h1>
					<p>支持多个Gradle并行打包apk</p>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>