package server.convert;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import server.tools.TimeUtils;

/**
 * 自定义日期参数绑定
 * @author Hiyond
 *
 */
public class DateConvert implements Converter<String, Date>{

	private String dateType;
	
	private final String DATETYPEREP = "yyyy-MM-dd HH:mm:ss";
	
	public DateConvert(String dateType) {
		super();
		this.dateType = StringUtils.isEmpty(dateType) ? DATETYPEREP : dateType;
	}



	@Override
	public Date convert(String dateStr) {
		Date date = TimeUtils.util_timeFormat(dateStr, dateType);
		return date;
	}

}
