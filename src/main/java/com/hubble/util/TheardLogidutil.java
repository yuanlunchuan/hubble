package com.hubble.util;

import java.util.Random;

public class TheardLogidutil {
	/**
	 * 构造方法
	 */
	private TheardLogidutil(){
	}
	
	/**
	 * 生成ID，时间yyyyMMddHHmmssSSS加上3位随机数
	 * 
	 * @return
	 */
	private static String getLogid()
	{
		Random r = new Random();
		String rs = r.nextInt(1000) + "";
		int len = rs.length();
		//检查数据上长，不足够3位时前面拼装0		
		//只有1位时
		if(len == 1)
		{
			rs = "00" + rs;
			//只有两位时
		}
		else if(len == 2)
		{
			rs = "0" + rs;
		}
		return UtilDataTime.getformatdate(UtilDataTime.fullPattern2) + rs;
	}

	/**
	 * 设置线程ID
	 */
	public static void set()
	{
		Thread.currentThread().setName(getLogid());
	}

	/**
	 * 获取当前线程ID
	 * 
	 * @return
	 */
	public static String getId()
	{
		return "Logid=" + Thread.currentThread().getName() + " ";
	}
}
