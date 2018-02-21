<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>刷脸签到</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/vue.js"></script>
<style type="text/css">
* {
	margin-top: 6px;
	background: #f3f3f3;
}

strong {
	color: #434343;
	font-size: 1.2em;
}

.container {
	text-align: center;
}

.col-xs-12 img {
	width: 200px;
	height: 280px;
}

#self {
	margin: 10px auto;
}

.btn {
	width: 200px;
	height: 40px;
}
</style>
</head>

<body>
	<div class="container col-xs-12">
		<!-- 	 <iframe id='target_upload' name='target_upload' src='' style='display: none'></iframe>
 -->
		<form action="" target="target_upload">
			<strong>Face Sign In System</strong>
			<p style="margin-top: 10px;" id="s_time">距离本次签到结束还有 {{s_time}} 分钟</p>
			<label for="num">学号:</label> <input type="number" id="num" name="num"
				placeholder="请输入学号" onblur="button_abled()">
		</form>
		<form action="RecentFiles" method="post" id="form"
			enctype="multipart/form-data" target="target_upload">
			<div class="col-xs-12">
				<img src="img/self_pic.jpg" alt="" id="img">
			</div>
			<input type="file" id="self" name="self" capture="camera "
				accept="image/*" onchange="button_enabled()"> <input type="button" value="签到"
				class="btn btn-primary" id="btn" disabled="true">
			<p>进度:
			<div id="progressStatus" style="color: red;"></div>
			</p>
			<p
				style="background: #cccccc; margin-top: 10px; height: 80px; line-height: 80px; font-size: 3em">
				未签到人数:<span style="color: red; font-weight: bold;"></span>
			</p>

		</form>
	</div>
	<script type="text/javascript">
		var person_t = setInterval(function(){
			$.get("Count_residue", null, function(p_data) {
				document.getElementsByTagName("span")[0].innerHTML = p_data;
			});
		}, 5000);
		
		//设置未签到人数
		new Vue({
			el : 'span',
			data : {
				people : 0
			}
		});
		
		//设置剩余时间
		new Vue({
			el : '#s_time',
			data : {
				s_time : '8'
			}

		});
		function button_enabled(){
			if (document.getElementById("num").value == null || document.getElementById("num").value == "") {
				$('#btn').attr('disabled',true);
				alert("学号不能为空！");
			}else{
				$('#btn').attr('disabled',false);
			}
		}
		function button_abled(){
			if (document.getElementById("num").value == null || document.getElementById("num").value == "") {
				alert("学号不能为空！");
			}
		}
		$(document).ready(function() {
			$("#btn").click(upload);
		});
		//提交，上传文件函数
		var intervalId = 0;
		function upload() {
			$("#progressStatus").innerHTML = "";
			$.post("ReceiveInf?num=" + document.getElementById("num").value,
					null, null);
			clearInterval(person_t);//不再获取未签到人数
			$("#form").submit();
			intervalId = setInterval("getProgress()", 100); // 每隔100ms获取上传进度  
		}

		//获取上传进度
		function getProgress() {
			$.get("GetUploadProgress", null, function(response) {
				try {
					$("#progressStatus")[0].innerHTML = response;

					if (response == "100") { // 若进度已为100，停止获取进度  
						clearInterval(intervalId);
					}
				} catch (err) {
					alert(err.message);
				}
			});
		}

		//添加事件监听，photo预览
		document.getElementById('self').addEventListener(
				'change',
				function() {
					document.getElementById('img').setAttribute('src',
							getObjectURL(this.files[0]));
				}, false);

		//返回照片地址
		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) {
				url = window.createObjectURL(file);
			} else if (window.URL != undefined) {
				url = window.URL.createObjectURL(file);
			} else if (window.webkitURL != undefined) {
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
	</script>
</body>
</html>