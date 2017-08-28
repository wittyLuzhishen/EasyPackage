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
<link href="${pageContext.request.contextPath}/css/packagePage.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="${pageContext.request.contextPath}/icon/logo.png" type="image/png">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/icon/logo.png" type="image/png">

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


	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<%-- 内容开始 --%>
				<h1 align="center">${app.desc}(${app.name})打包啦</h1>
				<hr />
				<%-- 导航区域 --%>
				<ul class="list-inline">
					<li><a href="${pageContext.request.contextPath}/index">返回主页</a></li>
					<li><a href="${pageContext.request.contextPath}/taskList/${app.id}">查看打包任务</a></li>
				</ul>
				<%-- 表单区域 --%>
				<form action="${pageContext.request.contextPath}/package/${app.id}" method="post" role="form">
					<%-- 隐藏域 --%>
					<input type="hidden" id="versionName" name="versionName" /> <input type="hidden" id="logTs"
						name="logTs" value="0" />

					<table class="table table-hover table-condensed">
						<tbody>
							<tr>
								<td align="right" width="120px"><label for="branchName">打包分支：</label></td>
								<td>
									<div class="form-group">
										<select name="branchName" id="branchName" class="form-control"></select>
									</div>
								</td>
								<td align="right" width="160px"><label for="packageName">包名：</label></td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" disabled id="packageName" />
									</div>
								</td>
								<td align="right"><label for="packageNamePostfix">包名后缀：</label></td>
								<td width="80px">
									<div class="form-group">
										<input type="text" class="form-control" id="packageNamePostfix" name="packageNamePostfix" />
									</div>
								</td>
								<td><input class="btn btn-primary" type="submit" id="commitBtn" value="开始打包" /></td>
							</tr>
							<tr>
								<td align="right">changeLog范围:</td>
								<td><input class="btn btn-primary" type="button" id="logBtn" name="logBtn" value="点击修改"
									onclick="onClickChangeLogBtn()" /></td>
								<td><label> &nbsp;&nbsp; <input type="checkbox" id="extraParams"
										name="extraParams" checked="checked" value="showModified" />输出log改动模块
								</label></td>
								<td colspan=2><label> &nbsp;&nbsp; <input type="checkbox" id="extraParams"
										name="extraParams" value="aar" /> 仅生成aar包
								</label></td>
								<td></td>
							</tr>
						</tbody>
					</table>

					<hr />
					<%-- 渠道 --%>
					<ul class="list-inline">
						<li><strong>渠道：</strong></li>
						<li><input class="btn btn-primary" type="button" id="selectAllChannel" value="全选" /></li>
						<li><input class="btn btn-primary" type="button" id="selectNoneChannel" value="全不选" /></li>
						<li><input class="btn btn-primary" type="button" id="editChannel" value="修改渠道" /></li>
					</ul>

					<table class="table table-hover table-condensed">
						<c:set var="channelColCount" scope="page" value="4" />
						<tbody>
							<c:forEach items="${channelList}" var="channel" varStatus="status">
								<c:if test="${status.index%channelColCount==0}">
									<tr>
								</c:if>
								<td>
									<div class="checkbox">
										<label> <input type="checkbox" name="channelIdList" value="${channel.id}" />
											${channel.name} <c:if test="${not empty channel.desc}">(${channel.desc})</c:if>
										</label>
									</div>
								</td>
								<c:if test="${status.index%channelColCount==channelColCount-1}">
									</tr>
								</c:if>
								<c:if test="${status.last && status.index%channelColCount!=channelColCount-1}">
									<c:forEach var="i" begin="1" end="${channelColCount-1-status.index%channelColCount }">
										<td></td>
									</c:forEach>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>

					<hr />
					<%-- 邮件接收者 --%>
					<ul class="list-inline">
						<li><strong>邮件发送给：</strong></li>
						<li><input class="btn btn-primary" type="button" id="selectNoneMailReceiver" value="全不选" /></li>
					</ul>

					<table class="table table-hover table-condensed">
						<c:set var="mailColCount" scope="page" value="6" />
						<tbody>
							<c:forEach items="${mailReceiverList}" var="mailReceiver" varStatus="status">
								<c:if test="${status.index%mailColCount==0}">
									<tr>
								</c:if>
								<td>
									<div class="checkbox">
										<label> <input type="checkbox" name="mailReceiverIdList"
											<c:if test="${mailReceiver.defaultSent}"> checked="checked" </c:if>
											value="${mailReceiver.id}" /> ${mailReceiver.name}
										</label>
									</div>
								</td>
								<c:if test="${status.index%mailColCount==mailColCount-1}">
									</tr>
								</c:if>
								<c:if test="${status.last && status.index%mailColCount!=mailColCount-1}">
									<c:forEach var="i" begin="1" end="${mailColCount-1-status.index%mailColCount }">
										<td></td>
									</c:forEach>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</form>

				<div id="cover_div" class="cover_div">
					<div class="cover_div_bg" onclick="$('#cover_div').hide();"></div>
					<div class="table_container_div" onclick="$('#cover_div').hide();">
						<table id="div_table" class="div_table">
							<tbody>
								<tr>
									<th colspan="6">点击选择Change Log生成范围</th>
								</tr>
								<tr>
									<th>项目</th>
									<th colspan="5">${app.desc}</th>
								</tr>
								<tr>
									<th>发布人</th>
									<th colspan="5">${userInfo.id}</th>
								</tr>
								<tr>
									<th>序号</th>
									<th>修改项</th>
									<th>影响模块</th>
									<th>修改类型</th>
									<th>修改人</th>
									<th>修改时间</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<%-- 内容结束 --%>
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