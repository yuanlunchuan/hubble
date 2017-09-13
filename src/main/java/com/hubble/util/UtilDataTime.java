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
	 * ʱ���ʽ����
	 */
	public static final String fullPattern2 = "yyyyMMddHHmmssSSS";
	
	//�ַ���ת���ڣ���ʽ�����б�
	public static final String[] PARSE_SUPPORT_PATTERN = {
			DATE_TIME_FORMAT.YYYYMMDD.getValue(),
			DATE_TIME_FORMAT.YYYYMMDDHHMMSS.getValue(),
			DATE_TIME_FORMAT.YYYYMMDD_NONE_SEPARATOR.getValue(),
			DATE_TIME_FORMAT.YYYYMMDDHHMMSS_NONE_SEPARATOR.getValue(),
			DATE_TIME_FORMAT.YYYYMMDD_LEFT_DIAGONAL_SEPARATOR.getValue(),
			DATE_TIME_FORMAT.YYYYMMDDHHMMSS_LEFT_DIAGONAL_SEPARATOR.getValue()};
	
	public enum DATE_TIME_FORMAT{
		YYYY("yyyy"),
		YYYYMM("yyyy-MM"),											//�̺�ָܷ�
		YYYYMMDD("yyyy-MM-dd"),
		YYYYMMDDHH("yyyy-MM-dd HH"),
		YYYYMMDDHHMM("yyyy-MM-dd HH:mm"),
		YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),						
		YYYYMMDDHHMMSSSSS("yyyy-MM-dd HH:mm:ss SSS"),
		YYYYMMDD_NONE_SEPARATOR("yyyyMMdd"),						//�޷ָ�
		YYYYMMDDHHMMSS_NONE_SEPARATOR("yyyyMMddHHmmss"),
		YYYYMMDDHHMMSSSSS_NONE_SEPARATOR("yyyyMMddHHmmssSSS"),
		YYYYMM_LEFT_DIAGONAL_SEPARATOR("yyyy/MM"),					//��б�߷ָ�
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
	 * ˽�й��췽��
	 */
	private UtilDataTime(){		
	}
	
	/**
	 * ��ȡָ����ʽ�����ָ���
	 * @param format ���ڸ�ʽ
	 * @return �����ָ���
	 */
	public static String getformatdate(String format)
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sp = new SimpleDateFormat(format);
		return sp.format(calendar.getTime());
	}
	
	/**
	 * ���ַ���ת���ɸ�ʽΪ��yyyy-MM-dd����.ע���粻ȷ��str��ʽ����ʹ��strToDateMatchs
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
			FileLog.errorLog(ex, "���ַ���ת���ɸ�ʽʱ����ԭ��" + ex.getMessage());
			return null;
		}
	}
	/**
	 * ���ַ���ת������.���ݸ�ʽ�б�PARSE_SUPPORT_PATTERN
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
			FileLog.errorLog(ex, "���ַ���ת���ɸ�ʽʱ����ԭ��" + ex.getMessage());
			return null;
		}
	}
	/**
	 * ���ַ���ת���ɸ�ʽΪ��yyyy-MM-dd����.ע���粻ȷ��str��ʽ����ʹ��strToDateMatchs
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
			FileLog.errorLog(ex, "���ַ���ת���ɸ�ʽʱ����ԭ��" + ex.getMessage());
			return null;
		}
	}
	
	

	/**
	 * ���ַ���ת����ָ����ʽ������.ע���粻ȷ��str��ʽ����ʹ��strToDateMatchs
	 * 
	 * @param str
	 *            �����ַ���.
	 * @param dateFormat
	 *            ���ڸ�ʽ. ���Ϊ�գ�Ĭ��Ϊ:yyyy-MM-dd HH:mm:ss.
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
			FileLog.errorLog(ex, "���ַ���(" + str + ")ת����ָ����ʽ(" + dateFormat +
					")������ʱʧ�ܣ�����ԭ��" + ex.getMessage());
			return null;
		}
	}

	/**
	 * ����ǰ����ת����yyyyMMddHHmmss���ַ���. �磺20071012141350
	 * 
	 * @return
	 */
	public static String currDateToStr() {
		return dateToStr(new java.util.Date(), "yyyyMMddHHmmss");
	}
	
	/**
	 * ����ǰ����ת����yyyyMMddHHmmss���ַ���. �磺20071012141350
	 * 
	 * @return
	 */
	public static String currDateToStr2() {
		return dateToStr(new java.util.Date(), "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * ����ǰ����ת����yyyy/MM/dd���ַ���. �磺2007/10/12
	 * 
	 * @return
	 */
	public static String currDateToStr3() {
		return dateToStr(new java.util.Date(), "yyyy/MM/dd");
	}

	/**
	 * ������ת���� ����(yyyy-MM-dd)�ַ���.
	 * 
	 * @param date
	 *            ����
	 * @return
	 */
	public static String dateTodateStr(final Date date) {
		return dateToStr(date, "yyyy-MM-dd");
	}

	/**
	 * ������ת���� yyyy-MM-dd HH:mm �ַ���.
	 * 
	 * @param date
	 *            ����
	 * @return
	 */
	public static String dateToStr(final Date date) {
		return dateToStr(date, "yyyy-MM-dd HH:mm");
	}

	/**
	 * �����ݿ��ѯ���������ڽ���ת��
	 * 
	 * @param list
	 */
	public static void getFormatDate(List<Map<String, Object>> list) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Map<String, Object> item : list) {
//			for (String key : item.keySet()) {//����������ʽ����������Ч�� modify by libo
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
	 * ������ת���� yyyy-MM-dd HH:mm ��������.
	 * 
	 * @param date
	 *            ����
	 * @return
	 */
	public static Date dateToDate(final Date date) {
		return dateToDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ���ݿ����������ת����JAVA��DATE����
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static Date dateToDate(final Date date, String dateFormat) {
		if (date == null) {
			// log.debug("δ֪ʱ��");
			return null;
			// return "δ֪ʱ��";
		}
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		String time = sf.format(date);
		return Timestamp.valueOf(time);
	}

	/**
	 * ������ת����ָ����ʽ���ַ���.
	 * 
	 * @param date
	 *            ����
	 * @param dateFormat
	 *            ���ڸ�ʽ. ���Ϊ�գ�Ĭ��Ϊ:yyyy-MM-dd HH:mm:ss.
	 * @return
	 */
	public static String dateToStr(final Date date, String dateFormat) {
		if (date == null) {
			// log.debug("δ֪ʱ��");
			return "";
			// return "δ֪ʱ��";
		}
		try {
			if (dateFormat == null || dateFormat.trim().length() == 0)
				dateFormat = "yyyy-MM-dd HH:mm:ss";
			if ("yyyy-MM-dd".equals(dateFormat))
				dateFormat = "yyyy-MM-dd";
			DateFormat fmt = new SimpleDateFormat(dateFormat.trim());

			return fmt.format(date);
		} catch (Exception ex) {
			 FileLog.errorLog(ex,"������ת����ָ����ʽ(" + dateFormat + ")���ַ���ʱʧ�ܣ�����ԭ��" +
					 ex.getMessage());
			 
			return "";
			// return "���ڸ�ʽ��ƥ��";
		}
	}

	/**
	 * ���ؼ�ȥָ�������������ַ���. ��ȡ���������ڣ�ָ������dateStrǰday��
	 * @param date ����������.
	 * @param day ��ȥ������
	 * @return �����ַ���
	 */
	public static String subtractDateToString(final Date date, final int day) {
		try {
			java.util.Date tempDate = subtractDate(date, day);
			String dateStr = dateToStr(tempDate, null);
			return dateStr;
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ڸ�ʽת��ʱʧ�ܣ�ԭ��" + ex.getMessage());
			return "";
		}
	}

	/**
	 * ���ؼ�ȥָ������������.
	 * @param date ����������.
	 * @param day ��ȥ������
	 * @return �����ַ���
	 */
	public static Date subtractDate(final Date date, final int day) {
		try {
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(date);
			int currDay = java.util.Calendar.DAY_OF_MONTH;
			calendar.set(currDay, calendar.get(currDay) - day); // �����ڼ� day��

			return calendar.getTime();
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ڸ�ʽת��ʱʧ�ܣ�ԭ��" + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * ���ؼ�ȥָ��Сʱ��������.
	 * 
	 * @param date
	 *            ����������.
	 * @param hour
	 *            ��ȥ��Сʱ. 
	 * @return �����ַ���
	 */
	public static Date subtractTime(final Date date, final int hour) {
		try {
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(date);
			int currHour = java.util.Calendar.HOUR_OF_DAY;
			calendar.set(currHour, calendar.get(currHour) - hour); // �����ڼ� day��

			return calendar.getTime();
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ڸ�ʽת��ʱʧ�ܣ�ԭ��" + ex.getMessage());
			return null;
		}
	}

	// subtractDate

	/**
	 * ���ؼ���ָ������������.
	 * 
	 * @param date
	 *            ����������.
	 * @param day
	 *            ���ϵ�����.
	 * @return �����ַ���
	 */
	public static Date plusDate(final Date date, final int day) {
		try {
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(date);
			int currDay = java.util.Calendar.DAY_OF_MONTH;

			calendar.set(currDay, calendar.get(currDay) + day); // �����ڼ� day��

			return calendar.getTime();
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ڸ�ʽת��ʱʧ�ܣ�ԭ��" + ex.getMessage());
			return null;
		}
	}

	/**
	 * ���ؼ���ָ�������������ַ���.
	 * 
	 * @param date
	 *            ����������.
	 * @param day
	 *            ���ϵ�����.
	 * @return �����ַ���
	 */
	public static String plusDateToString(final Date date, final int day) {
		try {
			java.util.Date tempDate = plusDate(date, day);
			String dateStr = dateToStr(tempDate, null);

			return dateStr;
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ڸ�ʽת��ʱʧ�ܣ�ԭ��" + ex.getMessage());
			return "";
		}
	}

	/**
	 * ȡ��ָ������date�·��������
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
	 * ����������������ն�Ӧ������,����int
	 * @param overplus ��ʽ"X��X����X��"
	 * @param sign +/-
	 * @return
	 */
	public static int getDayForOverplus(String overplus,String sign) {
		Calendar c = getCalendarForOverplus(new Date(),overplus,sign);
		
		return getDateNumber(c);
	}

	/**
	 * ���㵱ǰ�����������ڵ�������
	 * 
	 * @param c1
	 * @return
	 */
	public static int getDateNumber(Calendar c1) {
		long bts1, bts2;

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());

		bts1 = c1.getTimeInMillis() - cal1.getTimeInMillis();
		bts2 = bts1 / (24 * 60 * 60 * 1000); // ���Ҳ�п��ܳ���int,����long bts2

		return (int) bts2;
	}

	/**
	 * ��������ʱ�䣨startDate,endDate����ֵ������������ʽ���ز�ֵ����ʽΪresultArray[]={��,��,��}
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static int[] getDateArray(Date startDate, Date endDate) {
		int resultArray[] = new int[3]; // ��Ž������ʽΪresultArray[]={��,��,��}
		int day = 0;
		int month = 0;
		int year = 0;
		boolean dayFlag = false; // �ղ�Ϊ����־��true��Ϊ��
		boolean monthFlag = false; // �²�Ϊ����־��true��Ϊ��

		try {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(startDate);
//			endDate = plusDate(endDate,1);	//���Ͻ���ʱ�䵱��
			c2.setTime(endDate);

			int startDay = c1.get(c1.DAY_OF_MONTH);
			int endDay = c2.get(c2.DAY_OF_MONTH);
			int startMonth = c1.get(c1.MONTH);
			int endMonth = c2.get(c2.MONTH);
			int startYear = c1.get(c1.YEAR);
			int endYear = c2.get(c2.YEAR);

			// ����������
			int tempDay = endDay - startDay;
			if (tempDay < 0) {
				dayFlag = true;
				// day = getMaxDayOfMonth(startDate) - startDay + endDay;
				day = getMaxDayOfMonth(startDate) + tempDay;
			} else {
				day = tempDay;
			}

			// �����·ݲ�
			if (dayFlag)
				endMonth--;
			int tempMonth = endMonth - startMonth;
			if (tempMonth < 0) {
				monthFlag = true;
				month = 12 + tempMonth;
			} else {
				month = tempMonth;
			}

			// �������
			if (monthFlag)
				endYear--;
			int tempYear = endYear - startYear;
			year = tempYear;

			// ��װ���
			resultArray[0] = year;
			resultArray[1] = month;
			resultArray[2] = day;

		} catch (Exception ex) {
			FileLog.errorLog(ex, "����ʱ���ʱʧ�ܣ�����ԭ��" + ex.getMessage());
		}

		return resultArray;
	}
	
	/**
     * ������������֮������������������֮�֣�
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
        
        //date1����date2ʱ���ظ���������
        if (gc1.after(gc2)) {
        	result = 0-result;
        }

        return result;
    } 


    /**
     * ����ʱ���
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
     * �����ض����ڼ���/��ȥ������������ն�Ӧ������        
     * @param baseDate
     * @param overplus ��ʽ"X��X����X��"
     * @param sign +(����)��-(��ȥ)
     * @return
     */
	public static Date getDateForOverplus(Date baseDate,String overplus,String sign) {
		return getCalendarForOverplus(baseDate,overplus,sign).getTime();
	}

	/**
	 * �����ض����ڼ���/��ȥ������������ն�ӦCalendar����  
	 * @param baseDate
	 * @param overplus
	 * @param sign
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Calendar getCalendarForOverplus(Date baseDate,String overplus,String sign){
		// ��������X��X����X���ַ�
		Calendar c1 = Calendar.getInstance();
		c1.setTime(baseDate);
		int year = 0;				//��
		int month = 0;				//��
		int day = 0;				//��
		int indexYear = overplus.indexOf("��");
		int indexMonth1 = overplus.indexOf("��");
		int indexMonth2 = overplus.indexOf("��");
		int indexDay = overplus.indexOf("��");
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
				FileLog.systemLog("ERROR:δ���㣡");
			}
				
			
		} catch (Exception ex) {
			FileLog.errorLog(ex, "����ʱ���ʱʧ�ܣ�����ԭ��" + ex.getMessage());
		}
		
		return c1;
	}
	/**
	 * ��ȡ��ǰ�µĵ�һ��
	 * @param args
	 */
	public static String getMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar   cal_1=Calendar.getInstance();//��ȡ��ǰ���� 
        cal_1.add(Calendar.MONTH,0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ�� 
        return format.format(cal_1.getTime());
	}
	/**
	 * ��ȡ���µĵ�һ��
	 * @param 
	 */
	public static String getPreMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar   cal_1=Calendar.getInstance();//��ȡ��ǰ���� 
        cal_1.add(Calendar.MONTH,-1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ�� 
        return format.format(cal_1.getTime());
	}
	/**
	 * ��ȡ�������һ��
	 * @return
	 */
	public static Date getPreMonthLastDate(){
		Calendar ca = Calendar.getInstance(); 
		ca.add(Calendar.MONTH,-1);
	    ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    return ca.getTime();
	}
	/**
     * ��ǰ���ȵĿ�ʼ���ڣ���2016-04-01 
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
        	FileLog.errorLog(e, "����ʱ���ʱʧ�ܣ�����ԭ��" + e.getMessage());
        }
        return  format.format(c.getTime());
    }
    /**
     * ����ָ�����ڵļ���
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
     * ��ȡ��ǰ���ڵ���һ���ȿ�ʼ����
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
        	 FileLog.errorLog(e, "����ʱ���ʱʧ�ܣ�����ԭ��" + e.getMessage());
         }
    	return format.format(c.getTime());
    }
    /**
     * ��ȡ���һ��
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
     * ��ȡ��һ�������һ��
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
        	 FileLog.errorLog(e, "����ʱ���ʱʧ�ܣ�����ԭ��" + e.getMessage());
         }
    	return c.getTime();
    }
    /** 
     * ��ȡ��ǰ���һ������ 
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
     * ��ȡ��ǰ��Ϣ��ǰ�����µ��·���Ϣ
     * @return
     */
    public static String getPreSixMonth(){
    	SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        //��ȡ��ǰʱ���ǰ6����
        calendar.add(Calendar.MONTH,-5);
        return matter.format(calendar.getTime());
    }
    /**
     * ����ʱ���
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
            between = (endDate.getTime() - beginDate.getTime());// �õ����ߵĺ�����
        } catch (Exception e) {
        	FileLog.errorLog(e, "����ʱ�����󣡴���ԭ��" + e.getMessage());
        }
        return between/1000;
    }
    /**
     * ��ȡ�����ʼʱ��
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
     * ��ȡ�����ʼʱ��
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
     * ��ȡ���������ĳ�ʼʱ��
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
     * �������ڻ�ȡ����
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) { 
    	  String[] weekDaysName = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" }; 
//    	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
    	  Calendar calendar = Calendar.getInstance(); 
    	  calendar.setTime(date); 
    	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
    	  return weekDaysName[intWeek]; 
    	}  
    /**
     * ��ȡǰһ���һ������,��������һ ���ڶ� ��ʽ
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
     * ��ȡǰһ���һ������ ������yyyy-MM-dd��ʽ
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
     * ��ȡ��ǰ���
     * @return
     */
    public static int getCurrYear(){
    	Calendar a=Calendar.getInstance();
    	return a.get(Calendar.YEAR);
    }
    /**
     * ��ȡ��һ�����Ϣ
     * @return
     */
    public static int getPreYear(){
    	return getCurrYear()-1;
    }
    
    /**
	 * ���ؼ�ȥָ�������������ַ���(����ʱ��). ��ȡ���������ڣ�ָ������dateStrǰday��
	 * @param date ����������.
	 * @param day ��ȥ������
	 * @return �����ַ���
	 */
	public static String subtractDateToStringNoTime(final Date date, final int day) {
		try {
			java.util.Date tempDate = subtractDate(date, day);
			String dateStr = dateToStr(tempDate, "yyyy-MM-dd");
			return dateStr;
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ڸ�ʽת��ʱʧ�ܣ�ԭ��" + ex.getMessage());
			return "";
		}
	}
	
	/**
	 * ��ȡ�����ַ�����ݣ��������ڸ�ʽ�б�PARSE_SUPPORT_PATTERN
	 * 
	 * @param str  ��������
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
			FileLog.errorLog(ex, "���ַ���ת���ɸ�ʽʱ����ԭ��" + ex.getMessage());
		}
		return 0;
	}
	
	
	/**
	 * ���ַ���ת���ɸ�ʽΪ��outformat.
	 * 		�����ַ���,��ʽ�����б�PARSE_SUPPORT_PATTERN
	 * 
	 * @param str	�����ַ���
	 * @param outformat	���ַ���ת���ɸ�ʽΪ��outformat
	 * @return
	 */
	public static String strToStr(final String str,DATE_TIME_FORMAT outformat) {
		if (str == null || str.trim().length() == 0)
			return "";
		try {
			return dateToStr(strToDateMatchs(str), outformat.getValue());
		} catch (Exception ex) {
			FileLog.errorLog(ex, "���ַ���ת���ɸ�ʽʱ����ԭ��" + ex.getMessage());
		}
		return "";
	}

	/**
	 * ��ǰʱ���Ƿ��µ�һ��
	 *
	 * @return true �ǣ�false ��
	 */
	public static boolean isFirstDayOfCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		int i = calendar.get(Calendar.DAY_OF_MONTH);

		return i == 1;
	}
	
	

	
	/**  
	   * �ַ���ת��Ϊjava.util.Date<br>  
	   * ֧�ָ�ʽΪ yyyy.MM.dd G 'at' hh:mm:ss z �� '2002-1-1 AD at 22:10:59 PSD'<br>  
	   * yy/MM/dd HH:mm:ss �� '2002/1/1 17:55:00'<br>  
	   * yy/MM/dd HH:mm:ss pm �� '2002/1/1 17:55:00 pm'<br>  
	   * yy-MM-dd HH:mm:ss �� '2002-1-1 17:55:00' <br>  
	   * yy-MM-dd HH:mm:ss am �� '2002-1-1 17:55:00 am' <br>  
	   * @param time String �ַ���<br>  
	   * @return Date ����<br>  
	 * @throws Exception 
	   */  
	public static Date stringToDate(String time,int startWith) throws Exception{ 
		if(time==null || "".equals(time)){
			return null;
		}
		String[] format=new String[]{"yyyy-MM-dd","yyyyMMdd","yyyy/MM/dd","yyyy��MM��dd��","yyyy��MM��dd","yyyy MM dd","yyyy_MM_dd","yyyy.MM.dd","yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss"};
	    try {
	    	if(time.length()!=format[startWith].length()){
	    		throw new ParseException(time, startWith);//yyyyMMddҲ��ƥ��20170427143342  ���ǽ�������Ǵ�ģ����Գ���һ������ƥ�䡣
	    	}
	    	 SimpleDateFormat formatter=new SimpleDateFormat(format[startWith]);
	    	 Date d=formatter.parse(time);
	    	 FileLog.systemLog(time+" -> " + (d!=null?d.getTime():null));
	    	 return d;
		}catch ( ParseException e){
			if(startWith>=(format.length-1)){
				return null;//�����±�Խ��
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
