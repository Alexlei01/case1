package com.wonderrobot.ankenmatchingu.common;
// DefaultValueUtilBuild.java
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wonderfulfly.core.constant.SessionConstant;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.DateUtil;

/**
 * 案件マッチング Page: 
 */
public class DefaultValueUtil {
	/**
	 * ログインIDを取得する
	 * 
	 * @param request
	 * @return 
	 * @throws Exception
	 */
	public static String getUserId (HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String loginID  = StringUtil.changeNullToBlank((String)session.getAttribute(SessionConstant.USER_ID));
		return loginID;
	}
	
	/**
	 * 組織IDを取得する
	 * 
	 * @param request
	 * @return 
	 * @throws Exception
	 */
	public static String getOrgID (HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String OrgID  = StringUtil.changeNullToBlank((String)session.getAttribute("ORGID"));
		return OrgID;
	}
	
	/**
	 * システム年度を取得する
	 * 
	 * @return 
	 * @throws Exception
	 */
	public static String getSystemYear() throws Exception {
		Calendar calendar = null;
		calendar = getCalendar();
		return getSystemYear(calendar);
	}
	
	/**
	 * システム年度を取得する
	 * 
	 * @param calendar
	 * @return 
	 * @throws Exception
	 */
	private static String getSystemYear (Calendar calendar) throws Exception {
		return String.valueOf(calendar.get(Calendar.YEAR));
	}
	
	/**
	 * システム月を取得する
	 * 
	 * @return 
	 * @throws Exception
	 */
	public static String getSystemMonth () throws Exception {
		Calendar calendar = null;
		calendar = getCalendar();
		return getSystemMonth(calendar);
	}
	
	/**
	 * システム月を取得する
	 * 
	 * @param calendar
	 * @return 
	 * @throws Exception
	 */
	private static String getSystemMonth (Calendar calendar) throws Exception {
		return String.valueOf(calendar.get(Calendar.MONTH) + 1);
	}
	
	/**
	 * システム月日を取得する
	 * 
	 * @return 
	 * @throws Exception
	 */
	public static String getSystemDayOfMonth () throws Exception {
		Calendar calendar = null;
		calendar = getCalendar();
		return getSystemDayOfMonth(calendar);
	}
	
	/**
	 * システム月日を取得する
	 * 
	 * @param calendar
	 * @return 
	 * @throws Exception
	 */
	private static String getSystemDayOfMonth (Calendar calendar) throws Exception {
		return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * システム当日を取得する
	 * 
	 * @return 
	 * @throws Exception
	 */
	public static String getSystemToday () throws Exception {
		String year = getSystemYear();
		String month = getSystemMonth();
		String day = getSystemDayOfMonth();
		
		return getDateStr(year, month, day);
	}
	
	/**
	 * システム日付を取得する
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return 
	 * @throws Exception
	 */
	private static String getDateStr (String year, String month, String day) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		
		month = StringUtil.addZeroToWord(month, 2);
		day = StringUtil.addZeroToWord(day, 2);
		sBuffer.append(year).append("/").append(month).append("/").append(day);
		return sBuffer.toString();
	}
	
	/**
	 * システム時間を取得する
	 * 
	 * @return 
	 * @throws Exception
	 */
	public static String getSystemHourOfDay () throws Exception {
		Calendar calendar = null;
		calendar = getCalendar();
		return getSystemHourOfDay(calendar);
	}
	
	private static String getSystemHourOfDay (Calendar calendar ) throws Exception {
		return String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
	}
	
	public static String getSystemDecember () throws Exception {
		Calendar calendar = null;
		calendar = getCalendar();
		return getSystemDecember(calendar);
	}
	
	private static String getSystemDecember (Calendar calendar) throws Exception {
		return String.valueOf(calendar.get(Calendar.DECEMBER));
	}
	
	public static String getSystemSecond () throws Exception {
		Calendar calendar = null;
		calendar = getCalendar();
		return getSystemSecond(calendar);
	}
	
	public static String getSystemSecond (Calendar calendar) throws Exception {
		return String.valueOf(calendar.get(Calendar.SECOND));
	}
	
	public static String getSystemTime () throws Exception {
		return DateUtil.getPatternDate("HH:mm:ss");
	}
	
	public static String getSystemDateTime () throws Exception {
		String todayStr = null;
		String timeStr = null;
		StringBuffer sBuffer = new StringBuffer();
		
		todayStr = getSystemToday();
		timeStr = getSystemTime();
		
		sBuffer.append(todayStr).append(" ").append(timeStr);
		
		return sBuffer.toString();
	}
	
	public static String getSystemYearMonth () throws Exception {
		String year = null;
		String month = null;
		StringBuffer sBuffer = new StringBuffer();
		
		year = getSystemYear();
		month = getSystemMonth();
		
		month = StringUtil.addZeroToWord(month, 2);
		sBuffer.append(year).append("/").append(month);
		
		return sBuffer.toString();
	}
	
	public static String getSystemFirstDateOfMonth () throws Exception {
		Calendar calendar = null;
		String year = null;
		String month = null;
		String day = null;
		calendar = getCalendar();
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		year = getSystemYear(calendar);
		month = getSystemMonth(calendar);
		day = getSystemDayOfMonth(calendar);
		
		return getDateStr(year, month, day);
	}
	
	public static String getSystemLastDateOfMonth () throws Exception {
		Calendar calendar = null;
		String year = null;
		String month = null;
		String day = null;
		calendar = getCalendar();
		
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		
		year = getSystemYear(calendar);
		month = getSystemMonth(calendar);
		day = getSystemDayOfMonth(calendar);
		
		return getDateStr(year, month, day);
	}
	
	private static Calendar getCalendar () throws Exception {
		return Calendar.getInstance();
	}
}
