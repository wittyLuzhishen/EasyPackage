var mAppId = $('#appId').val();
var mAppName = $('#appName').val();
var mBranchName = null;
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
	getVersionName();
}

function getVersionName() {
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
	});
}

function onChannelCheckChanged(channelItem, checked) {
	changeApkName();
}

/**
 * walilive-DB-meng_1254_1_android-release-4.7.12
 * appName-branchName-channelName-versionName
 */
function changeApkName() {
	if (mBranchName == null || mVersionName == null) {
		return;
	}

}

$(document).ready(function() {
	getBranchList();
	$('[name="channelItem"]:checkbox').change(function() {
		onChannelCheckChanged($(this), $(this).is(':checked'));
	});
});