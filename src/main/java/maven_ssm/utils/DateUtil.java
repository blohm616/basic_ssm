package maven_ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
	
	private DateUtil() {}
	
	/**
	 * 
	 *	version:距离某一日子还有多少时间
	 *	@param dateVal
	 *	@return
	 *----------------------
	 * 	author:xiezhyan
	 *	date:2017-5-17
	 */
	public static long currentTime(String dateVal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(dateVal);
			Calendar currentCal = Calendar.getInstance();
			currentCal.setTime(date);
			Calendar today = Calendar.getInstance();
			return (today.getTimeInMillis() - currentCal.getTimeInMillis()) / (24 * 3600 * 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0L;
	}

	/**
	 * 
	 *	version:获取当前时间一周的时间
	 *	@param dateVal
	 *	@return
	 *-------------------------------------
	 *	author:xiezhyan
	 *	date:2017-6-5
	 */
	public static Map<String,String> getThisWeek(Date dateVal) {
		Map<String,String> map = new HashMap<String, String>();
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			cal.setTime(sdf.parse(sdf.format(dateVal)));

			int d = 0;
			if(cal.get(Calendar.DAY_OF_WEEK)==1){	//星期日
				d = -6;
			}else{
				d = 2-cal.get(Calendar.DAY_OF_WEEK);
			}
			cal.add(Calendar.DAY_OF_WEEK, d);
			//所在周开始日期
			map.put("monday", sdf.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_WEEK, 6);
			//所在周结束日期
			map.put("funday", sdf.format(cal.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
