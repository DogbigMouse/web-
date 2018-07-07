package com.myjsp.utils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

public class stringutils {
	
	/**
	 * 根据字符串数组和链接符生成字符串
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
	 * 根据后缀名生成文件名
	 * @param ext 扩展名
	 * @return 文件名
	 */
	public static String geneFileNameByExtName(String ext){
		//获取当前时间
		Date date = new Date();
		//获取当前时间的毫秒数（距离1970-01-01）
		long time = date.getTime();
		
		//生成随机数
		Random rd = new Random();
		int num = rd.nextInt(100000);
		
		DecimalFormat format = new DecimalFormat("00000");
		return time+format.format(num)+"."+ext;
	}
	/**
	 * 随机生成订单编号
	 * @return
	 */
	public static String geneOrderId(){
		//获取当前时间
		Date date = new Date();
		//获取当前时间的毫秒数（距离1970-01-01）
		long time = date.getTime();
		
		//生成随机数
		Random rd = new Random();
		int num = rd.nextInt(100000);
		
		DecimalFormat format = new DecimalFormat("00000");
		return time+format.format(num);
	}
	
	/**
	 * 把字符串分割成一个数组
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
