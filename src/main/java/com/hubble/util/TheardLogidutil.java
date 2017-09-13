package com.hubble.util;

import java.util.Random;

public class TheardLogidutil {
	/**
	 * ���췽��
	 */
	private TheardLogidutil(){
	}
	
	/**
	 * ����ID��ʱ��yyyyMMddHHmmssSSS����3λ�����
	 * 
	 * @return
	 */
	private static String getLogid()
	{
		Random r = new Random();
		String rs = r.nextInt(1000) + "";
		int len = rs.length();
		//��������ϳ������㹻3λʱǰ��ƴװ0		
		//ֻ��1λʱ
		if(len == 1)
		{
			rs = "00" + rs;
			//ֻ����λʱ
		}
		else if(len == 2)
		{
			rs = "0" + rs;
		}
		return UtilDataTime.getformatdate(UtilDataTime.fullPattern2) + rs;
	}

	/**
	 * �����߳�ID
	 */
	public static void set()
	{
		Thread.currentThread().setName(getLogid());
	}

	/**
	 * ��ȡ��ǰ�߳�ID
	 * 
	 * @return
	 */
	public static String getId()
	{
		return "Logid=" + Thread.currentThread().getName() + " ";
	}
}
