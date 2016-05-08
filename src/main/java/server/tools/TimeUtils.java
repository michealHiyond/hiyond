package server.tools;
/**
 * 
 * @author Hiyond
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;


public class TimeUtils {

	public static void main(String[] args) throws Exception {
//		System.out.println(util_timeFormat("2015-12-31 14:21:21", "YYYY-MM-dd HH:MM:ss"));
//		System.out.println(DateUtils.addDays(null, -10));
//		System.out.println(util_timeFormat(DateUtils.addDays(null, -10),"YYYY-MM-dd HH:MM:ss"));
//		Calendar c = Calendar.getInstance();
//		c.setTime(new Date());
//		c.add(Calendar.DATE, 10);
//		Date date = c.getTime();
//		System.out.println(date);
//		System.out.println(util_timeFormat(new Date(),-1,"yyyy-MM-dd"));
//		Date date = util_timeFormat("2016-01-02",-1,"yyyy-MM-dd","yyyy-MM-dd");
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
		System.out.println(util_dateFormat(null));
		System.out.println("ok");
	}
	
	/**
	 * 根据传入的日期和日期类型返回格式化的字符串
	 * @param date
	 * @param dateType
	 * @return String/null
	 */
	public static String util_timeFormat(Date date,String dateType){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateType);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	/**
	 * 根据传入的日期字符串和日期类型返回日期
	 * @param date
	 * @param dateType
	 * @return
	 */
	public static Date util_timeFormat(String date,String dateType){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateType);
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据传入的日期，日期的格式，返回改日期向前/后backNum天的日期字符串
	 * @param dateOri 原始的日期
	 * @param backNum 要反回几天前（后）的日期
	 * @param newDateType 原始的日期的格式
	 * @return
	 */
	public static String util_timeFormat(final Date dateOri,final int backNum,final  String newDateType){
		if(StringUtils.isEmpty(newDateType) || dateOri == null){
			return null;
		}
		Date date = null;
		try {
			date = DateUtils.addDays(dateOri, backNum);
			SimpleDateFormat sdf = new SimpleDateFormat(newDateType);
			return sdf.format(date);
		} catch (Exception e) {
		}
		
		return null;
	}
	
	/**
	 * 根据传入的日期字符串，日期的格式，返回改日期向前/后backNum天的日期
	 * @param dateOri 原始的日期字符串
	 * @param backNum 要反回几天前（后）的日期字符串
	 * @param oldDateType 原始的日期字符串的格式
	 * @param newDateType 要反回的日期字符串的格式
	 * @return
	 */
	public static Date util_timeFormat(final String dateOri,final int backNum,final  String oldDateType,final  String newDateType){
		if(StringUtils.isEmpty(oldDateType) ||StringUtils.isEmpty(newDateType) || dateOri == null){
			throw new IllegalArgumentException("some parameter is null");
		}
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(oldDateType);
			date = sdf.parse(dateOri);
			date = DateUtils.addDays(date, backNum);
			sdf = new SimpleDateFormat(newDateType);
			String dateStr = sdf.format(date);
			return sdf.parse(dateStr);
		} catch (Exception e) {
			throw new IllegalArgumentException("some parameter is Exception");
		}
	}
	
	/**
	 * 返回一个经过格式化的日期字符串
	 * @param dateType 日期格式
	 * @return
	 */
	public static String util_dateFormat(String dateType){
		if(StringUtils.isEmpty(dateType)){
			throw new IllegalArgumentException("参数dateType是空的");
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateType.trim());
		String result = sdf.format(new Date());
		if(StringUtils.isEmpty(result)){
			throw new IllegalArgumentException("返回的结果是空的，可能是由于参数dateType的格式不正确！");
		}
		return result;
	}
	
}
