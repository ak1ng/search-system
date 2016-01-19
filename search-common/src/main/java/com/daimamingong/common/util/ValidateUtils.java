package com.daimamingong.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {
	
	/**
	 * 匹配中文字符
	 */
	public static final String REGEX_CHINESE = "^[u4e00-u9fa5]$";
	
	/**
	 * 匹配URL
	 */
	public static final String REGEX_URL = "[a-zA-z]+://[^\\s]*";
	
	/**
	 * 匹配国内电话
	 * 格式:[区号{4}]-号码-[分机号{6}]
	 */
	public static final String REGEX_TELEPHONE = "(0\\d{2,3}-)?\\d{7,8}(-\\d{1,6})?";
	
	/**
	 * 匹配国内手机
	 * 格式:[086]手机号码
	 */
	public static final String REGEX_PHONE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
	
	/**
	 * 匹配QQ
	 */
	public static final String REGEX_QQ = "[1-9][0-9]{4,}";
	
	/**
	 * 匹配中国邮编
	 */
	public static final String REGEX_POSTCODE = "[1-9]\\d{5}(?!\\d)";
	
	/**
	 * 匹配18位身份证号码
	 */
	public static final String REGEX_ID_CARD_18 = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";
	
	/**
	 * 匹配生日(年-月-日)
	 */
	public static final String REGEX_BIRTHDAY = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))";
	
	/**
	 * 匹配正整数
	 */
	public static final String REGEX_POSITIVE_INTEGER = "^[1-9]\\d*$";
	
	/**
	 * 匹配负整数
	 */
	public static final String REGEX_NEGATIVE_INTEGER = "^-[1-9]\\d*$";

	/**
	 * 匹配负整数
	 */
	public static final String REGEX_IP_ADDRESS = "^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$";
	
	/**
	 * 匹配邮箱
	 */
	public static final String REGEX_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

	/**
	 * 校验是否匹配
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean isMatches(String str,String regex) {
		if (null == str)
			return false;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(ValidateUtils.isMatches(null,ValidateUtils.REGEX_IP_ADDRESS));
	}
}
