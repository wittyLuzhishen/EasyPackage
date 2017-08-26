<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打包</title>

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
	<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}" />
	<input type="hidden" id="appId" value="${app.id}" />
	<input type="hidden" id="appName" value="${app.name}" />
	<input type="hidden" id="versionName" name="versionName" />

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>打包${app.desc}(${app.name})</h1>

				<form action="${pageContext.request.contextPath}/package/${app.id}" method="post" role="form">
					<div class="container">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label for="branchName">分支</label> <select name="branchName" id="branchName"
										onChange="onBranchChanged()" class="form-control">
									</select>
								</div>
							</div>
							<div clas="col=md-3">
								<div class="form-group">
									<label for="packageName">包名</label> <input type="text" class="form-control" disabled
										id="packageName">
								</div>
							</div>
							<div clas="col=md-3">
								<div class="form-group">
									<label for="packageNamePostfix">包名后缀</label> <input type="text" class="form-control"
										id="packageNamePostfix" name="packageNamePostfix">
								</div>
							</div>
							<div clas="col=md-3">
								<input type="submit" id="commitBtn" value="开始打包" disable="true" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">

								<div class="form-group">
									<label>渠道</label>
									<c:forEach items="${channelList}" var="channel">
										<div class="checkbox">
											<label><input type="checkbox" name="channelItem" value="${channel.id}" />${channel.name}(${channel.desc})</label>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>邮件接收者</label>
									<c:forEach items="${mailReceiverList}" var="mailReceiver">
										<div class="checkbox">
											<label><input type="checkbox" value="${mailReceiver.email}" />${mailReceiver.name}</label>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/log.js"></script>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/js/biz/packagePage.js"></script>
</body>
</html>