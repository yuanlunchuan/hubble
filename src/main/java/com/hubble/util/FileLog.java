package com.hubble.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class FileLog {
	/**
	 * ϵͳʹ�õ�loger
	 */
	private static Logger debugLogger = null;
	private static Logger errorLogger = null;
	private static Logger infoLogger  = null;
	static
	{
		loadLogger();
	}

	/**
	 * 
	 */
	public FileLog()
	{
		super();
	}

	/**
	 * װ��ϵͳʹ�õ� loger
	 * 
	 */
	static void loadLogger()
	{
		debugLogger = Logger.getLogger("debug");
		infoLogger = Logger.getLogger("");//info��������Ϊlog4j.rootLogger
		errorLogger = Logger.getLogger("error");
	}

	/**
	 * ��¼���������еĴ�����Ϣ��¼����Ӧlog4j�е�error�����log
	 * 
	 * @param msg ��Ϣ
	 */
	public static void errorLog(Object msg)
	{
		errorLogger.error(TheardLogidutil.getId() + msg);
	}

	/**
	 * ��¼���������еĴ�����쳣��Ϣ��¼����Ӧlog4j�е�error�����log
	 * 
	 * @param e Ҫ��¼���쳣��Ϣ
	 */
	public static void errorLog(Exception e)
	{
		errorLogger.error(getExceptionTrace(e));
	}

	/**
	 * ��¼���������еĴ�����쳣��Ϣ��¼����Ӧlog4j�е�error�����log
	 * 
	 * @param e Ҫ��¼���쳣��Ϣ
	 * @param msg Ҫ��¼����Ϣ
	 */
	public static void errorLog(Exception e , Object msg)
	{
		errorLogger.error(TheardLogidutil.getId() + msg + "\n" + getExceptionTrace(e));
	}

	/**
	 * ��¼���������еĵ�����Ϣ����Ӧlog4j�е�debug�����log
	 * 
	 * @param msg Ҫ��¼��Ϣ
	 */
	public static void debugLog(Object msg)
	{
		debugLogger.debug(TheardLogidutil.getId() + msg);
	}

	/**
	 * ��¼�����е��쳣��Ϣ����Ӧlog4j�е�debug�����log
	 * 
	 * @param e Ҫ��¼���쳣��Ϣ
	 */
	public static void debugLog(Exception e)
	{
		debugLogger.debug(getExceptionTrace(e));
	}

	/**
	 * ��¼�����е��쳣��Ϣ����Ӧlog4j�е�debug�����log
	 * 
	 * @param e Ҫ��¼���쳣��Ϣ
	 * @param msg Ҫ��¼����Ϣ
	 */
	public static void debugLog(Exception e , Object msg)
	{
		debugLogger.debug(TheardLogidutil.getId() + msg + "\n" + getExceptionTrace(e));
	}

	/**
	 * ϵͳ��Ϣ��־��¼����Ӧlog4j����info�����log
	 * 
	 * @param msg ��Ϣ
	 */
	public static void systemLog(Object msg)
	{
		infoLogger.info(TheardLogidutil.getId() + msg);
	}

	/**
	 * ϵͳ��Ϣ�쳣��־��¼����Ӧlog4j����info�����log
	 * 
	 * @param e Ҫ��¼���쳣��Ϣ
	 */
	public static void systemLog(Exception e)
	{
		infoLogger.info(getExceptionTrace(e));
	}

	/**
	 * ϵͳ��Ϣ�쳣��־��¼����Ӧlog4j����info�����log
	 * 
	 * @param e Ҫ��¼���쳣��Ϣ
	 * @param msg Ҫ��¼����Ϣ
	 */
	public static void systemLog(Exception e , Object msg)
	{
		infoLogger.info(TheardLogidutil.getId() + msg + "\n" + getExceptionTrace(e));
	}

	/**
	 * ����쳣��Ϣ ��� e.printStackTrace();
	 * 
	 * @param e �쳣
	 */
	public static void exOut(Exception e)
	{
		String s = getExceptionTrace(e);
		errorLogger.error(s);
	}

	/**
	 * �쳣��Ϣ���
	 * @param e �쳣
	 * @return �쳣��Ϣ
	 */
	private static String getExceptionTrace(Exception e)
	{
		String s = null;
		ByteArrayOutputStream bout = null;
		PrintWriter wrt = null;
		try {
			bout = new ByteArrayOutputStream();
			wrt = new PrintWriter(bout,true);
			e.printStackTrace(wrt);
			s = bout.toString();
			wrt.close();
			bout.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(wrt != null){
				try {
					wrt.close();	
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
			if(bout != null){
				try {
					bout.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return s;
	}

}
