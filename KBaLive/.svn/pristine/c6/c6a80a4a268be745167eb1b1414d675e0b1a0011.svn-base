/**
 *对象类 
 *1、URL
 *2、方式（get,post）
 *3、数据（json）
 *4、如何返回数据处理（回调函数）
 *JSON对象
 */
var ajax={
		
		
}
//
function Ajax(url, method, data, callBack) {
	var this_ = this;
	//请求地址
	this.url = url;
	//方式
	this.method = method;
	//数据
	this.data = data;
	this.callBack = callBack;
	//创建ajax组件
	this.xmlHttpRequest = function() {
		if (window.ActiveXObject) { //IE
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //
			return new XMLHttpRequest();
		}
	}();
	//回调函数:json xml
	this.callBack_ = function() {
		if (this_.xmlHttpRequest.readyState == 3) {
			//添加进度条
		} else if (this_.xmlHttpRequest.readyState == 4 && this_.xmlHttpRequest.status == 200) {
			var returnData = null;
			//分析响应头
			var respType = this_.xmlHttpRequest.getResponseHeader("Content-Type");
			returnData = this_.xmlHttpRequest.responseText;
			if (respType.indexOf("json") != -1) {
				returnData = JSON.parse(returnData);
			} else if (respType.indexOf("xml") != -1) {
				returnData = this_.xmlHttpRequest.responseXML;
			}
			//处理数据
			this_.callBack(returnData);
		}
	};
	//发送
	this.sendRequest = function() {
		//注册事件
		this.xmlHttpRequest.onreadystatechange = this.callBack_;
		//发送之前，创建一个请求包
		this.xmlHttpRequest.open(this.method, this.url, true);
		if (this.method.toLowerCase() == "post") {
			//构建请求头
			this.xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		}
		//发送
		this.xmlHttpRequest.send(this.data);
	};


}