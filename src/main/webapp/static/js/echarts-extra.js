/**
 * 用来方便展示的函数
 * @param {Object} options	图表数据的集合:option是一个json对象，
 * @param {Object} parentTag	父布局ID
 */
function echarts_extra(options,parentTag) {
	if(null == options || options.length <= 0) {
		alert("数据生成失败，请稍后重试!!!");
		return;
	}
	
	$.each(options,function(i,option) {
		var divHTML = "<div id=main"+i+" style='width:100%;height:100%;'>";
		$("#" + parentTag).append(divHTML);
		
		var myChart = echarts.init(document.getElementById('main' + i));
		myChart.setOption(option);
	});
}