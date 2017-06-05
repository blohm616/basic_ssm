package maven_ssm.utils;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	private JsonUtil() {}
	
	private static Gson gson = null;
	
	static {
		/**
		 * 这样子当obj中出现特殊字符时，不会转码
		 * 有Date类型时，转换成该格式的日期
		 */
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd hh:MM:ss");
		gson = builder.disableHtmlEscaping().create();
	}
	
	/**
	 * 
	 *	version: 将Object转换成json字符串
	 *	@param obj
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-16
	 */
	public static String obj2Json(Object obj) {
		
		return gson.toJson(obj);
	}
	
	/**
	 * 
	 *	version: 将JSON字符串转换成java对象
	 *	@param jsonStr
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-16
	 */
	public static <T> T json2Obj(String jsonStr,Class<T> clazz) {
		return gson.fromJson(jsonStr, clazz);
	}
	
	/**
	 * 
	 *	version:解析json数组转换成List集合
	 *	@param jsonStr
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-16
	 */
	public static <T> List<T> json2ObjList(String jsonStr) {
		
		return gson.fromJson(jsonStr,  new TypeToken<List<T>>() {}.getType());
	}
	/**
	 * 
	 *	version:转换成Map集合
	 *	@param jsonStr
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-5-16
	 */
	public static <T> Map<Object,T> json2ObjMap(String jsonStr) {
		
		return gson.fromJson(jsonStr,  new TypeToken<Map<Object,T>>() {}.getType());
	}
	
	
}
