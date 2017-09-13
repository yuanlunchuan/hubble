package com.hubble.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class UtilDataTime {
	/**
	 * 时间格式定义
	 */
	public static final String fullPattern2 = "yyyyMMddHHmmssSSS";
	
	//字符串转日期，格式兼容列表
	public static final String[] PARSE_SUPPORT_PATTERN = {
			DATE_TIME_FORMAT.YYYYMMDD.getValue(),
			DATE_TIME_FORMAT.YYYYMMDDHHMMSS.getValue(),
			DATE_TIME_FORMAT.YYYYMMDD_NONE_SEPARATOR.getValue(),
			DATE_TIME_FORMAT.YYYYMMDDHHMMSS_NONE_SEPARATOR.getValue(),
			DATE_TIME_FORMAT.YYYYMMDD_LEFT_DIAGONAL_SEPARATOR.getValue(),
			DATE_TIME_FORMAT.YYYYMMDDHHMMSS_LEFT_DIAGONAL_SEPARATOR.getValue()};
	
	public enum DATE_TIME_FORMAT{
		YYYY("yyyy"),
		YYYYMM("yyyy-MM"),											//短横杠分隔
		YYYYMMDD("yyyy-MM-dd"),
		YYYYMMDDHH("yyyy-MM-dd HH"),
		YYYYMMDDHHMM("yyyy-MM-dd HH:mm"),
		YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),						
		YYYYMMDDHHMMSSSSS("yyyy-MM-dd HH:mm:ss SSS"),
		YYYYMMDD_NONE_SEPARATOR("yyyyMMdd"),						//无分隔
		YYYYMMDDHHMMSS_NONE_SEPARATOR("yyyyMMddHHmmss"),
		YYYYMMDDHHMMSSSSS_NONE_SEPARATOR("yyyyMMddHHmmssSSS"),
		YYYYMM_LEFT_DIAGONAL_SEPARATOR("yyyy/MM"),					//左斜线分隔
		YYYYMMDD_LEFT_DIAGONAL_SEPARATOR("yyyy/MM/dd"),
		YYYYMMDDHHMMSS_LEFT_DIAGONAL_SEPARATOR("yyyy/MM/dd HH:mm:ss");
		
		DATE_TIME_FORMAT(String value){
			this.value = value;
		}
		private String value;
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 私有构造方法
	 */
	private UtilDataTime(){		
	}
	
	/**
	 * 获取指定格式日期字附后串
	 * @param format 日期格式
	 * @return 日期字附串
	 */
	public static String getformatdate(String format)
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sp = new SimpleDateFormat(format);
		return sp.format(calendar.getTime());
	}
	
	/**
	 * 将字符串转换成格式为：yyyy-MM-dd日期.注：如不确定str格式，请使用strToDateMatchs
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDate(final String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		try {
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			return fmt.parse(str.trim());

		} catch (Exception ex) {
			FileLog.errorLog(ex, "将字符串转换成格式时出错，原因：" + ex.getMessage());
			return null;
		}
	}
	/**
	 * 将字符串转换日期.兼容格式列表PARSE_SUPPORT_PATTERN
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDateMatchs(final String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		try {
			return null;//DateUtils.parseDate(str, PARSE_SUPPORT_PATTERN);
			
		} catch (Exception ex) {
			FileLog.errorLog(ex, "将字符串转换成格式时出错，原因：" + ex.getMessage());
			return null;
		}
	}
	/**
	 * 将字符串转换成格式为：yyyy-MM-dd日期.注：如不确定str格式，请使用strToDateMatchs
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDate2(final String str) {
		if (str == null || str.trim().length() == 0)
			return null;
		try {
			DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
			return fmt.parse(str.trim());

		} catch (Exception ex) {
			FileLog.errorLog(ex, "将字符串转换成格式时出错，原因：" + ex.getMessage());
			return null;
		}
	}
	
	

	/**
	 * 将字符串转换成指定格式的日期.注：如不确定str格式，请使用strToDateMatchs
	 * 
	 * @param str
	 *            日期字符串.
	 * @param dateFormat
	 *            日期格式. 如果为空，默认为:yyyy-MM-dd HH:mm:ss.
	 * @return
	 */
	public static Date strToDate(final String str, String dateFormat) {
		if (str == null || str.trim().length() == 0)
			return null;
		try {
			if (dateFormat == null || dateFormat.length() == 0)
				dateFormat = "yyyy-MM-dd HH:mm:ss";
			DateFormat fmt = new SimpleDateFormat(dateFormat);
			return fmt.parse(str.trim());

		} catch (Exception ex) {
			FileLog.errorLog(ex, "将字符串(" + str + ")转换成指定格式(" + dateFormat +
					")的日期时失败！错误原因：" + ex.getMessage());
			return null;
		}
	}

	/**
	 * 将当前日期转换成yyyyMMddHHmmss的字符串. 如：20071012141350
	 * 
	 * @return
	 */
	public static String currDateToStr() {
		return dateToStr(new java.util.Date(), "yyyyMMddHHmmss");
	}
	
	/**
	 * 将当前日期转换成yyyyMMddHHmmss的字符串. 如：20071012141350
	 * 
	 * @return
	 */
	public static String currDateToStr2() {
		return dateToStr(new java.util.Date(), "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 将当前日期转换成yyyy/MM/dd的字符串. 如：2007/10/12
	 * 
	 * @return
	 */
	public static String currDateToStr3() {
		return dateToStr(new java.util.Date(), "yyyy/MM/dd");
	}

	/**
	 * 将日期转换成 日期(yyyy-MM-dd)字符串.
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String dateTodateStr(final Date date) {
		return dateToStr(date, "yyyy-MM-dd");
	}

	/**
	 * 将日期转换成 yyyy-MM-dd HH:mm 字符串.
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String dateToStr(final Date date) {
		return dateToStr(date, "yyyy-MM-dd HH:mm");
	}

	/**
	 * 将数据库查询出来的日期进行转换
	 * 
	 * @param list
	 */
	public static void getFormatDate(List<Map<String, Object>> list) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Map<String, Object> item : list) {
//			for (String key : item.keySet()) {//调整遍历方式，提升遍历效率 modify by libo
			for (Map.Entry<String, Object> entry : item.entrySet()) {
//				Object value = item.get(key);
				Object value = entry.getValue();
				if (value != null
						&& value instanceof java.sql.Timestamp)
//						&& value.getClass() == java.sql.Timestamp.class)
//					item.put(key, fm.format(value));
					item.put(entry.getKey(), fm.format(value));
			}
		}
	}

	/**
	 * 将日期转换成 yyyy-MM-dd HH:mm 日期类型.
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static Date dateToDate(final Date date) {
		return dateToDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 数据库的日期类型转换成JAVA的DATE类型
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static Date dateToDate(final Date date, String dateFormat) {
		if (date == null) {
			// log.debug("未知时间");
			return null;
			// return "未知时间";
		}
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		String time = sf.format(date);
		return Timestamp.valueOf(time);
	}

	/**
	 * 将日期转换成指定格式的字符串.
	 * 
	 * @param date
	 *            日期
	 * @param dateFormat
	 *            日期格式. 如果为空，默认为:yyyy-MM-dd HH:mm:ss.
	 * @return
	 */
	public static String dateToStr(final Date date, String dateFormat) {
		if (date == null) {
			// log.debug("未知时间");
			return "";
			// return "未知时间";
		}
		try {
			if (dateFormat == null || dateFormat.trim().length() == 0)
				dateFormat = "yyyy-MM-dd HH:mm:ss";
			if ("yyyy-MM-dd".equals(dateFormat))
				dateFormat = "yyyy-MM-dd";
			DateFormat fmt = new SimpleDateFormat(dateFormat.trim());

			return fmt.format(date);
		} catch (Exception ex) {
			 FileLog.errorLog(ex,"将日期转换成指定格式(" + dateFormat + ")的字符串时失败！错误原因：" +
					 ex.getMessage());
			 
			return "";
			// return "日期格式不匹配";
		}
	}

	/**
	 * 返回减去指定天数的日期字符串. 获取计算后的日期：指定日期dateStr前day天
	 * @param date 将运算日期.
	 * @param day 减去的天数
	 * @return 日期字符串
	 */
	public static String subtractDateToString(final Date date, final int day) {
		try {
			java.util.Date tempDate = subtractDate(date, day);
			String dateStr = dateToStr(tempDate, null);
			return dateStr;
		} catch (Exception ex) {
			FileLog.errorLog(ex, "日期格式转换时失败，原因：" + ex.getMessage());
			return "";
		}
	}

	/**
	 * 返回减去指定天数的日期.
	 * @param date 将运算日期.
	 * @param day 减去的天数
	 * @return 日期字符串
	 */
	public static Date subtractDate(final Date date, final int day) {
		try {
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(date);
			int currDay = java.util.Calendar.DAY_OF_MONTH;
			calendar.set(currDay, calendar.get(currDay) - day); // 让日期减 day天

			return calendar.getTime();
		} catch (Exception ex) {
			FileLog.errorLog(ex, "日期格式转换时失败，原因：" + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * 返回减去指定小时数的日期.
	 * 
	 * @param date
	 *            将运算日期.
	 * @param hour
	 *            减去的小时. 
	 * @return 日期字符串
	 */
	public static Date subtractTime(final Date date, final int hour) {
		try {
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(date);
			int currHour = java.util.Calendar.HOUR_OF_DAY;
			calendar.set(currHour, calendar.get(currHour) - hour); // 让日期减 day天

			return calendar.getTime();
		} catch (Exception ex) {
			FileLog.errorLog(ex, "日期格式转换时失败，原因：" + ex.getMessage());
			return null;
		}
	}

	// subtractDate

	/**
	 * 返回加上指定天数的日期.
	 * 
	 * @param date
	 *            将运算日期.
	 * @param day
	 *            加上的天数.
	 * @return 日期字符串
	 */
	public static Date plusDate(final Date date, final int day) {
		try {
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(date);
			int currDay = java.util.Calendar.DAY_OF_MONTH;

			calendar.set(currDay, calendar.get(currDay) + day); // 让日期加 day天

			return calendar.getTime();
		} catch (Exception ex) {
			FileLog.errorLog(ex, "日期格式转换时失败，原因：" + ex.getMessage());
			return null;
		}
	}

	/**
	 * 返回加上指定天数的日期字符串.
	 * 
	 * @param date
	 *            将运算日期.
	 * @param day
	 *            加上的天数.
	 * @return 日期字符串
	 */
	public static String plusDateToString(final Date date, final int day) {
		try {
			java.util.Date tempDate = plusDate(date, day);
			String dateStr = dateToStr(tempDate, null);

			return dateStr;
		} catch (Exception ex) {
			FileLog.errorLog(ex, "日期格式转换时失败，原因：" + ex.getMessage());
			return "";
		}
	}

	/**
	 * 取得指定日期date月份最大天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getMaxDayOfMonth(Date date) {
		int max = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		max = cal.get(Calendar.DAY_OF_MONTH);

		return max;
	}

	/**
	 * 计算数组的中年月日对应的天数,返回int
	 * @param overplus 格式"X年X个月X天"
	 * @param sign +/-
	 * @return
	 */
	public static int getDayForOverplus(String overplus,String sign) {
		Calendar c = getCalendarForOverplus(new Date(),overplus,sign);
		
		return getDateNumber(c);
	}

	/**
	 * 计算当前日期至此日期的天数差
	 * 
	 * @param c1
	 * @return
	 */
	public static int getDateNumber(Calendar c1) {
		long bts1, bts2;

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());

		bts1 = c1.getTimeInMillis() - cal1.getTimeInMillis();
		bts2 = bts1 / (24 * 60 * 60 * 1000); // 结果也有可能超出int,故用long bts2

		return (int) bts2;
	}

	/**
	 * 计算两个时间（startDate,endDate）差值，并以数组形式返回差值，格式为resultArray[]={年,月,日}
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static int[] getDateArray(Date startDate, Date endDate) {
		int resultArray[] = new int[3]; // 存放结果，格式为resultArray[]={年,月,日}
		int day = 0;
		int month = 0;
		int year = 0;
		boolean dayFlag = false; // 日差为负标志，true：为负
		boolean monthFlag = false; // 月差为负标志，true：为负

		try {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(startDate);
//			endDate = plusDate(endDate,1);	//加上结束时间当天
			c2.setTime(endDate);

			int startDay = c1.get(c1.DAY_OF_MONTH);
			int endDay = c2.get(c2.DAY_OF_MONTH);
			int startMonth = c1.get(c1.MONTH);
			int endMonth = c2.get(c2.MONTH);
			int startYear = c1.get(c1.YEAR);
			int endYear = c2.get(c2.YEAR);

			// 计算天数差
			int tempDay = endDay - startDay;
			if (tempDay < 0) {
				dayFlag = true;
				// day = getMaxDayOfMonth(startDate) - startDay + endDay;
				day = getMaxDayOfMonth(startDate) + tempDay;
			} else {
				day = tempDay;
			}

			// 计算月份差
			if (dayFlag)
				endMonth--;
			int tempMonth = endMonth - startMonth;
			if (tempMonth < 0) {
				monthFlag = true;
				month = 12 + tempMonth;
			} else {
				month = tempMonth;
			}

			// 计算年差
			if (monthFlag)
				endYear--;
			int tempYear = endYear - startYear;
			year = tempYear;

			// 封装结果
			resultArray[0] = year;
			resultArray[1] = month;
			resultArray[2] = day;

		} catch (Exception ex) {
			FileLog.errorLog(ex, "计算时间段时失败！错误原因：" + ex.getMessage());
		}

		return resultArray;
	}
	
	/**
     * 计算两个日期之间相差的天数（有正负之分）
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int diffdates(Date date1, Date date2) {
        int result = 0;

        GregorianCalendar gc1 = new GregorianCalendar();
        GregorianCalendar gc2 = new GregorianCalendar();

        gc1.setTime(date1);
        gc2.setTime(date2);
        result = getDays(gc1, gc2);
        
        //date1大于date2时返回负数的天数
        if (gc1.after(gc2)) {
        	result = 0-result;
        }

        return result;
    } 


    /**
     * 计算时间差
     * @param g1
     * @param g2
     * @return
     */
    public static int getDays(GregorianCalendar g1, GregorianCalendar g2) {
    	  int elapsed = 0;
    	  GregorianCalendar gc1, gc2;

    	  if (g2.after(g1)) {
    	   gc2 = (GregorianCalendar) g2.clone();
    	   gc1 = (GregorianCalendar) g1.clone();
    	  } else {
    	   gc2 = (GregorianCalendar) g1.clone();
    	   gc1 = (GregorianCalendar) g2.clone();
    	  }

    	  gc1.clear(Calendar.MILLISECOND);
    	  gc1.clear(Calendar.SECOND);
    	  gc1.clear(Calendar.MINUTE);
    	  gc1.clear(Calendar.HOUR_OF_DAY);

    	  gc2.clear(Calendar.MILLISECOND);
    	  gc2.clear(Calendar.SECOND);
    	  gc2.clear(Calendar.MINUTE);
    	  gc2.clear(Calendar.HOUR_OF_DAY);

    	  while (gc1.before(gc2)) {
    	   gc1.add(Calendar.DATE, 1);
    	   elapsed++;
    	  }
    	  return elapsed;
    	 }

    
    /**
     * 计算特定日期加上/减去数组的中年月日对应的日期        
     * @param baseDate
     * @param overplus 格式"X年X个月X天"
     * @param sign +(加上)，-(减去)
     * @return
     */
	public static Date getDateForOverplus(Date baseDate,String overplus,String sign) {
		return getCalendarForOverplus(baseDate,overplus,sign).getTime();
	}

	/**
	 * 计算特定日期加上/减去数组的中年月日对应Calendar类型  
	 * @param baseDate
	 * @param overplus
	 * @param sign
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Calendar getCalendarForOverplus(Date baseDate,String overplus,String sign){
		// 解析传入X年X个月X天字符
		Calendar c1 = Calendar.getInstance();
		c1.setTime(baseDate);
		int year = 0;				//年
		int month = 0;				//月
		int day = 0;				//天
		int indexYear = overplus.indexOf("年");
		int indexMonth1 = overplus.indexOf("个");
		int indexMonth2 = overplus.indexOf("月");
		int indexDay = overplus.indexOf("天");
		boolean flag = false;
		
		try {
			
			if (indexYear != -1) {
				year = Integer.parseInt(overplus.substring(0,indexYear));
				flag = true;
			}
			if (indexMonth1 != -1) {
				month = Integer.parseInt(overplus.substring(indexYear+1,indexMonth1));
				flag = true;
			}
			if (indexDay != -1) {
				day = Integer.parseInt(overplus.substring(indexMonth2+1,indexDay));
				flag = true;
			}

			if (!flag)
				year = Integer.valueOf(overplus);
			
			//add
			if("+".equals(sign)){
				c1.set(c1.YEAR, c1.get(c1.YEAR) + year);
				c1.set(c1.MONTH, c1.get(c1.MONTH) + month);
				c1.set(c1.DAY_OF_MONTH, c1.get(c1.DAY_OF_MONTH) + day);
			}else if("-".equals(sign)){
				c1.set(c1.YEAR, c1.get(c1.YEAR) - year);
				c1.set(c1.MONTH, c1.get(c1.MONTH) - month);
				c1.set(c1.DAY_OF_MONTH, c1.get(c1.DAY_OF_MONTH) - day);
			}else{
				FileLog.systemLog("ERROR:未计算！");
			}
				
			
		} catch (Exception ex) {
			FileLog.errorLog(ex, "计算时间段时失败！错误原因：" + ex.getMessage());
		}
		
		return c1;
	}
	/**
	 * 获取当前月的第一天
	 * @param args
	 */
	public static String getMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
        cal_1.add(Calendar.MONTH,0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return format.format(cal_1.getTime());
	}
	/**
	 * 获取上月的第一天
	 * @param 
	 */
	public static String getPreMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
        cal_1.add(Calendar.MONTH,-1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return format.format(cal_1.getTime());
	}
	/**
	 * 获取上月最后一天
	 * @return
	 */
	public static Date getPreMonthLastDate(){
		Calendar ca = Calendar.getInstance(); 
		ca.add(Calendar.MONTH,-1);
	    ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    return ca.getTime();
	}
	/**
     * 当前季度的开始日期，即2016-04-01 
     * 
     * @return
     */
    public static String getCurrentQuarterStartTime() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
        } catch (Exception e) {
        	FileLog.errorLog(e, "计算时间段时失败！错误原因：" + e.getMessage());
        }
        return  format.format(c.getTime());
    }
    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
    /**
     * 获取当前日期的上一季度开始日期
     * @return
     */
    public static String getPreQuarterStartTime(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    	int currentQuarter = getQuarterOfYear(new Date());
    	Calendar c = Calendar.getInstance();
        try {
            if (currentQuarter == 1){
            	c.add(Calendar.YEAR, -1);
                c.set(Calendar.MONTH, 9);
            }	 
             else if (currentQuarter ==2)
                 c.set(Calendar.MONTH, 0);
             else if (currentQuarter == 3)
                 c.set(Calendar.MONTH, 3);
             else if (currentQuarter == 4)
                 c.set(Calendar.MONTH, 4);
             c.set(Calendar.DATE, 1);
         } catch (Exception e) {
        	 FileLog.errorLog(e, "计算时间段时失败！错误原因：" + e.getMessage());
         }
    	return format.format(c.getTime());
    }
    /**
     * 获取最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(Integer year, Integer month) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return format.format(calendar.getTime());
    }
    /**
     * 获取上一季度最后一天
     * @param args
     */
    public static Date getPreQuarterEndTime(){
    	int currentQuarter = getQuarterOfYear(new Date());
    	Calendar c = Calendar.getInstance();
        try {
            if (currentQuarter == 1){
            	c.add(Calendar.YEAR, -1);
                c.set(Calendar.MONTH, 11);
            }	 
             else if (currentQuarter ==2){
            	c.set(Calendar.MONTH, 2); 
             }
             else if (currentQuarter == 3){
            	 c.set(Calendar.MONTH, 5); 
             }
             else if (currentQuarter == 4){
            	 c.set(Calendar.MONTH, 9);
             }
            Integer year = c.get(Calendar.YEAR);
            Integer month = c.get(Calendar.MONTH);
            c.set(year, month, 1);
            c.roll(Calendar.DATE, -1);
         } catch (Exception e) {
        	 FileLog.errorLog(e, "计算时间段时失败！错误原因：" + e.getMessage());
         }
    	return c.getTime();
    }
    /** 
     * 获取当前年第一天日期 
     * @return String 
     */  
    public static String getYearFirst(){  
        Calendar calendar = Calendar.getInstance(); 
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR); 
        calendar.clear();  
        calendar.set(Calendar.YEAR, currentYear);  
        Date currYearFirst = calendar.getTime();  
        return dateTodateStr(currYearFirst);  
    }
    /**
     * 获取当前信息的前六个月的月份信息
     * @return
     */
    public static String getPreSixMonth(){
    	SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        //获取当前时间的前6个月
        calendar.add(Calendar.MONTH,-5);
        return matter.format(calendar.getTime());
    }
    /**
     * 计算时间差
     * @param begin
     * @param end
     * @return
     */
    public static long getTimeGap(String begin,String end){
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between = 0;
        try {
            Date beginDate = dfs.parse(begin);
            Date endDate = dfs.parse(end);
            between = (endDate.getTime() - beginDate.getTime());// 得到两者的毫秒数
        } catch (Exception e) {
        	FileLog.errorLog(e, "计算时间差错误！错误原因：" + e.getMessage());
        }
        return between/1000;
    }
    /**
     * 获取当天初始时间
     * @return
     */
    public static String getTodayStartTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return format.format(todayStart.getTime());
    }
    /**
     * 获取明天初始时间
     * @return
     */
    public static String getNextDayStartTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.DATE, 1);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return format.format(todayStart.getTime());
    }
    /**
     * 获取给定天数的初始时间
     * @return
     */
    public static String getStartTime(int day){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.DATE, day);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return format.format(todayStart.getTime());
    }
    /**
     * 根据日期获取星期
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) { 
    	  String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }; 
//    	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
    	  Calendar calendar = Calendar.getInstance(); 
    	  calendar.setTime(date); 
    	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
    	  return weekDaysName[intWeek]; 
    	}  
    /**
     * 获取前一天的一个星期,返回星期一 星期二 格式
     * @return
     */
    public static List<String> getPreDayWeek(){
    	List<String> list = new ArrayList<String>();
    	Date beginDate = new Date();
    	Date firstDay = subtractDate(beginDate,7);
    	list.add(getWeekOfDate(firstDay));
    	Date secondDay = subtractDate(beginDate,6);
    	list.add(getWeekOfDate(secondDay));
    	Date threeDay = subtractDate(beginDate,5);
    	list.add(getWeekOfDate(threeDay));
    	Date fourDay = subtractDate(beginDate,4);
    	list.add(getWeekOfDate(fourDay));
    	Date fiveDay = subtractDate(beginDate,3);
    	list.add(getWeekOfDate(fiveDay));
    	Date sixtDay = subtractDate(beginDate,2);
    	list.add(getWeekOfDate(sixtDay));
    	Date sevenDay = subtractDate(beginDate,1);
    	list.add(getWeekOfDate(sevenDay));
    	
    	return list;
    }
    /**
     * 获取前一天的一个星期 ，返回yyyy-MM-dd格式
     * @return
     */
    public static List<String> getPreDayWeekDate(){
    	List<String> list = new ArrayList<String>();
    	Date beginDate = new Date();
    	Date firstDay = subtractDate(beginDate,7);
    	list.add(dateTodateStr(firstDay));
    	Date secondDay = subtractDate(beginDate,6);
    	list.add(dateTodateStr(secondDay));
    	Date threeDay = subtractDate(beginDate,5);
    	list.add(dateTodateStr(threeDay));
    	Date fourDay = subtractDate(beginDate,4);
    	list.add(dateTodateStr(fourDay));
    	Date fiveDay = subtractDate(beginDate,3);
    	list.add(dateTodateStr(fiveDay));
    	Date sixtDay = subtractDate(beginDate,2);
    	list.add(dateTodateStr(sixtDay));
    	Date sevenDay = subtractDate(beginDate,1);
    	list.add(dateTodateStr(sevenDay));
    	
    	return list;
    }
    /**
     * 获取当前年份
     * @return
     */
    public static int getCurrYear(){
    	Calendar a=Calendar.getInstance();
    	return a.get(Calendar.YEAR);
    }
    /**
     * 获取上一年份信息
     * @return
     */
    public static int getPreYear(){
    	return getCurrYear()-1;
    }
    
    /**
	 * 返回减去指定天数的日期字符串(不含时间). 获取计算后的日期：指定日期dateStr前day天
	 * @param date 将运算日期.
	 * @param day 减去的天数
	 * @return 日期字符串
	 */
	public static String subtractDateToStringNoTime(final Date date, final int day) {
		try {
			java.util.Date tempDate = subtractDate(date, day);
			String dateStr = dateToStr(tempDate, "yyyy-MM-dd");
			return dateStr;
		} catch (Exception ex) {
			FileLog.errorLog(ex, "日期格式转换时失败，原因：" + ex.getMessage());
			return "";
		}
	}
	
	/**
	 * 获取日期字符串年份：兼容日期格式列表PARSE_SUPPORT_PATTERN
	 * 
	 * @param str  输入日期
	 * @return
	 */
	public static int getDateYear(final String str) {
		if (str == null || str.trim().length() == 0)
			return 0;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(strToDateMatchs(str));
			return calendar.get(Calendar.YEAR);
		} catch (Exception ex) {
			FileLog.errorLog(ex, "将字符串转换成格式时出错，原因：" + ex.getMessage());
		}
		return 0;
	}
	
	
	/**
	 * 将字符串转换成格式为：outformat.
	 * 		日期字符串,格式兼容列表PARSE_SUPPORT_PATTERN
	 * 
	 * @param str	日期字符串
	 * @param outformat	将字符串转换成格式为：outformat
	 * @return
	 */
	public static String strToStr(final String str,DATE_TIME_FORMAT outformat) {
		if (str == null || str.trim().length() == 0)
			return "";
		try {
			return dateToStr(strToDateMatchs(str), outformat.getValue());
		} catch (Exception ex) {
			FileLog.errorLog(ex, "将字符串转换成格式时出错，原因：" + ex.getMessage());
		}
		return "";
	}

	/**
	 * 当前时间是否当月第一天
	 *
	 * @return true 是；false 否
	 */
	public static boolean isFirstDayOfCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		int i = calendar.get(Calendar.DAY_OF_MONTH);

		return i == 1;
	}
	
	

	
	/**  
	   * 字符串转换为java.util.Date<br>  
	   * 支持格式为 yyyy.MM.dd G 'at' hh:mm:ss z 如 '2002-1-1 AD at 22:10:59 PSD'<br>  
	   * yy/MM/dd HH:mm:ss 如 '2002/1/1 17:55:00'<br>  
	   * yy/MM/dd HH:mm:ss pm 如 '2002/1/1 17:55:00 pm'<br>  
	   * yy-MM-dd HH:mm:ss 如 '2002-1-1 17:55:00' <br>  
	   * yy-MM-dd HH:mm:ss am 如 '2002-1-1 17:55:00 am' <br>  
	   * @param time String 字符串<br>  
	   * @return Date 日期<br>  
	 * @throws Exception 
	   */  
	public static Date stringToDate(String time,int startWith) throws Exception{ 
		if(time==null || "".equals(time)){
			return null;
		}
		String[] format=new String[]{"yyyy-MM-dd","yyyyMMdd","yyyy/MM/dd","yyyy年MM月dd日","yyyy年MM月dd","yyyy MM dd","yyyy_MM_dd","yyyy.MM.dd","yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss"};
	    try {
	    	if(time.length()!=format[startWith].length()){
	    		throw new ParseException(time, startWith);//yyyyMMdd也能匹配20170427143342  但是解析结果是错的，所以长度一样才算匹配。
	    	}
	    	 SimpleDateFormat formatter=new SimpleDateFormat(format[startWith]);
	    	 Date d=formatter.parse(time);
	    	 FileLog.systemLog(time+" -> " + (d!=null?d.getTime():null));
	    	 return d;
		}catch ( ParseException e){
			if(startWith>=(format.length-1)){
				return null;//避免下标越界
			}
			return stringToDate(time, startWith+1);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	    
	}
	public static Date stringToDate(String time) throws Exception{
		return stringToDate(time, 0);
	}
	
}
