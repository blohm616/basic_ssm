package maven_ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import maven_ssm.entity.User;
import maven_ssm.service.UserService;
import maven_ssm.utils.JsonUtil;
import maven_ssm.utils.LogUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/findUserById")
	public String findUserById(HttpServletRequest request,User user) {
		User u = userService.findUserById(user.getId());
		request.setAttribute("u", u);
		
		//地址：http://echarts.baidu.com/echarts2/doc/example/bar14.html
        Option option = new Option();
        option.title().text("ECharts例子个数统计").subtext("Rainbow bar example")
            .link("http://echarts.baidu.com/doc/example.html").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.grid().borderWidth(0).y(80).y2(60);
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.xAxis(new CategoryAxis().data("Line", "Bar", "Scatter", "K", "Pie", "Radar", "Chord", "Force", "Map", "Gauge", "Funnel"));
        option.yAxis(new ValueAxis().show(false));

        Bar bar = new Bar("ECharts例子个数统计");
        bar.itemStyle().normal().color("function(params) {" +
                "                        var colorList = [" +
                "                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'," +
                "                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD'," +
                "                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'" +
                "                        ];" +
                "                        return colorList[params.dataIndex]" +
                "                    }")
                .label().show(true).position(Position.top).formatter("{b}{c}");
        bar.data(12,21,10,4,12,5,6,5,25,23,7);

        option.series(bar);
		
        List<Option> options = new ArrayList<Option>();
        options.add(option);
        request.setAttribute("options", JsonUtil.obj2Json(options));
		LogUtil.d(JsonUtil.obj2Json(options));
		
//		for(int i = 0 ; i <= 9; i++) {
//			user = new User();
//			user.setUsername("张三" + i);
//			user.setPassword("123" + i);
//			userService.addUser(user);
//		}
		return "user-info";
	}
	
	@RequestMapping("/helloFreemarker")
	public String helloFreemarker(HttpServletRequest request) {
		request.setAttribute("hello", "hello Freemarker");
		return "index.ftl";
	}
}
