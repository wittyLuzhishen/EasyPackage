var mAppId = $('#appId').val();
var mAppName = $('#appName').val();
var mBranchName = null;
var mBranchShortName = null;
var mVersionName = null;

function getBranchList() {
	$("#commitBtn").attr({
		"disabled" : "disabled"
	});
	$.get(getContextPath() + '/data/getBranchList', {
		appId : mAppId
	}, function(result, status) {
		logd("result:" + result + ", status:" + status);
		var r = $.parseJSON(result);
		if (r.code != 0) {
			loge("get branch list failed, msg:" + r.message);
			return;
		}
		var select = $('#branchName');
		$.each(r.data, function(index, value) {
			if (index == 0) {
				select.append('<option selected="selected" value="' + value
						+ '">' + value + '</option>');
			} else {
				select.append('<option value="' + value + '">' + value
						+ '</option>');
			}
		});
		onBranchChanged();
	});
}

function onBranchChanged() {
	mBranchName = $('#branchName').val();
	var arr = mBranchName.split('/');
	mBranchShortName = arr[arr.length - 1];
	getVersionName();
	getGitInfo(mAppId, mBranchName);
}

function getVersionName() {
	$("#commitBtn").attr({
		"disabled" : "disabled"
	});
	$.get(getContextPath() + '/data/getVersionName', {
		appId : mAppId,
		branchName : mBranchName
	}, function(result, status) {
		logd("result:" + result + ", status:" + status);
		var r = $.parseJSON(result);
		if (r.code != 0) {
			loge("get version name failed, msg:" + r.message);
			return;
		}
		mVersionName = r.data;
		$('#versionName').val(mVersionName);
		changeApkName();
	});
}

function getGitInfo(appId, branch) {
	/*
	 * $.get("/package/data/getLatestGitLogList", { appId : appId, branch :
	 * branch }, function(data) { $("#gitInfo").html(data); });
	 */
}

/**
 * Deprecated 从数据库中读取频道信息并不慢，不用在页面用Ajax异步获取
 */
function getChannelList() {
	$.get(getContextPath() + '/data/getChannelList', {
		appId : mAppId
	}, function(result, status) {
		logd("result:" + result + ", status:" + status);
		var r = $.parseJSON(result);
		if (r.code != 0) {
			loge("get channel list failed, msg:" + r.message);
			return;
		}
		// TODO
	});
}

function onCheckedChannelChanged(channelItem, checked) {
	changeApkName();
}

function onCheckedMailReceiverChanged(channelItem, checked) {
	changeApkName();
}

/**
 * app1-DEBUG-test_channel_android-release-4.7.12
 * appName-branchName-channelName-release-versionName
 */
function changeApkName() {
	if (mBranchName == null || mVersionName == null) {
		return;
	}
	/**
	 * 只有flag<=0时才可以打包
	 */
	var flag = 2;
	var channelList = $(':checkbox[name="channelIdList"]:checked');
	if (channelList.length == 0) {
		$('#packageName').val(
				mAppName + '-' + mBranchShortName + '-<请选择渠道>-release-'
						+ mVersionName);
	} else if (channelList.length == 1) {// 单个打包
		$('#packageName').val(
				mAppName + '-' + mBranchShortName + '-'
						+ $(channelList[0]).val() + '-release-' + mVersionName);
		flag--;
	} else {// 批量打包
		$('#packageName').val(
				mAppName + '-' + mBranchShortName + '-***-release-'
						+ mVersionName);
		flag--;
	}

	var mailReceiverList = $(':checkbox[name="mailReceiverIdList"]:checked');
	if (mailReceiverList.length > 0) {
		flag--;
	}
	if (flag > 0) {
		$("#commitBtn").attr({
			"disabled" : "disabled"
		});
	} else {
		$("#commitBtn").removeAttr("disabled");
	}
}

function setAllCheckbox(name, checked) {
	$.each($(':checkbox[name="' + name + '"]'), function() {
		if (checked) {
			$(this).prop('checked', checked);
		} else {
			$(this).removeAttr('checked');
		}
	});
	changeApkName();
}

$(document).ready(function() {
	getBranchList();
	$('#branchName').change(function() {
		onBranchChanged();
	});
	$('[name="channelIdList"]:checkbox').change(function() {
		onCheckedChannelChanged($(this), $(this).is(':checked'));
	});
	$('[name="mailReceiverIdList"]:checkbox').change(function() {
		onCheckedMailReceiverChanged($(this), $(this).is(':checked'));
	});
	$('#selectAllChannel').click(function() {
		setAllCheckbox('channelIdList', true);
	});
	$('#selectNoneChannel').click(function() {
		setAllCheckbox('channelIdList', false);
	});
	$('#editChannel').click(function() {

	});
	$('#selectNoneMailReceiver').click(function() {
		setAllCheckbox('mailReceiverIdList', false);
	});
	// 即使设置了checked有时状态也显示为未选中，这里用jQuery设置一下选中的显示状态，注意这里用了[checked="checked"]而不是:checked
	$(':checkbox[name="mailReceiverIdList"][checked="checked"]').each(function() {
		$(this).prop('checked', true);
	});
});