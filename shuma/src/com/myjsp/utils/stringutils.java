package com.myjsp.utils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

public class stringutils {
	
	/**
	 * �����ַ�����������ӷ������ַ���
	 * @param strs
	 * @param jionSrtr
	 * @return
	 */
	public static String geneStrByArry(String[] strs,String jionSrtr){
		StringBuffer sbf = new StringBuffer();
		strs[0].charAt(1);
		for(String str : strs){
			sbf.append(str+jionSrtr);
		}
		sbf.deleteCharAt(sbf.length()-1);
		return sbf.toString();
	}
	/**
	 * ���ݺ�׺�������ļ���
	 * @param ext ��չ��
	 * @return �ļ���
	 */
	public static String geneFileNameByExtName(String ext){
		//��ȡ��ǰʱ��
		Date date = new Date();
		//��ȡ��ǰʱ��ĺ�����������1970-01-01��
		long time = date.getTime();
		
		//���������
		Random rd = new Random();
		int num = rd.nextInt(100000);
		
		DecimalFormat format = new DecimalFormat("00000");
		return time+format.format(num)+"."+ext;
	}
	/**
	 * ������ɶ������
	 * @return
	 */
	public static String geneOrderId(){
		//��ȡ��ǰʱ��
		Date date = new Date();
		//��ȡ��ǰʱ��ĺ�����������1970-01-01��
		long time = date.getTime();
		
		//���������
		Random rd = new Random();
		int num = rd.nextInt(100000);
		
		DecimalFormat format = new DecimalFormat("00000");
		return time+format.format(num);
	}
	
	/**
	 * ���ַ����ָ��һ������
	 * @param str
	 * @return
	 */
	public static String fenge(String imgStr,String splitStr){
		String[] array = imgStr.split(splitStr);
		String img = array[0].toString();
		return img;
		
	}
	public static String[] chai(String imgStr,String splitStr){
		String[] array = imgStr.split(splitStr);
		return array;
		
	}
}
