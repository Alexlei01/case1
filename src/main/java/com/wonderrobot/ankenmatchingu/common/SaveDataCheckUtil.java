package com.wonderrobot.ankenmatchingu.common;
// SaveDataCheckUtilBuild.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.wonderfulfly.core.util.RegexpUtil;
import com.wonderfulfly.core.util.StringUtil;
public class SaveDataCheckUtil {
	private static String getCheckItemStr (String item) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("項目「")
			.append(StringUtil.changeNullToBlank(item))
			.append("」：");
		return sBuffer.toString();
	}
	
	public static String getNoSaveItemErr () throws Exception {
		return "全ての項目が非DB保存項目になっています。";
	}
	
	public static String getPriKeyNotDefinitionErr (String fieldID) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(getCheckItemStr(fieldID))
			.append("対象テーブルのキー項目が画面に定義されていません。").append("\n");
		return sBuffer.toString();
	}
	
	public static String getKeyRepeatErr (String tableID) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("「").append(tableID)
			.append("」").append("該当するデータが既に存在します。").append("\n");
		return sBuffer.toString();
	}

	public static String getKeyNullCheckErr (String value, String itemName) throws Exception{
		StringBuffer sBuffer = new StringBuffer();
		if (StringUtil.isNullOrBlank(value)) {
			sBuffer.append(getCheckItemStr(itemName))
				.append("キー項目に空白が設定されています。").append("\n");
		}
		
		return sBuffer.toString();
	}
	
	public static String getMustNullCheckErr (String value, String itemName) throws Exception{
		StringBuffer sBuffer = new StringBuffer();
		if (StringUtil.isNullOrBlank(value)) {
			sBuffer.append(getCheckItemStr(itemName))
				.append("必須項目に入力していません。").append("\n");
		}
		
		return sBuffer.toString();
	}
	
	public static String getNotNullCheckErr (String value, String itemName) throws Exception{
		StringBuffer sBuffer = new StringBuffer();
		if (StringUtil.isNullOrBlank(value)) {
			sBuffer.append(getCheckItemStr(itemName))
				.append("非空項目に入力していません。").append("\n");
		}
		
		return sBuffer.toString();
	}
	
	public static String getMaxLengthCheckErr (String value, int intMaxLen, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (intMaxLen != 0 && StringUtil.changeNullToBlank(value).length() > intMaxLen) {
			sBuffer.append(getCheckItemStr(itemName)) 
				.append("該当項目の長さを超えて入力されています。")
				.append("入力値:(")
				.append(StringUtil.changeNullToBlank(value))
				.append(") 最大長さ:(").append(intMaxLen).append(")").append("\n");
		}
		return sBuffer.toString();
	}
	
	public static String getMinLengthCheckErr (String value, int intMinLen, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (intMinLen !=0 && StringUtil.changeNullToBlank(value).length() < intMinLen ) {
			sBuffer.append(getCheckItemStr(itemName))
			.append("最小長さより短い値が入力されています。").append("\n");
		}
		return sBuffer.toString();
	}
	
	public static String getRegexCheckErr (String value, String regex, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (!StringUtil.isNullOrBlank(value) && !StringUtil.isNullOrBlank(regex)) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			if (!m.matches()){
				sBuffer.append(getCheckItemStr(itemName)) 
					.append("入力の内容が正しくありません。").append("\n");
			}
		}
		
		return sBuffer.toString();
	}
	
	public static String getDateCheckErr (String value, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (!StringUtil.isNullOrBlank(value) && !RegexpUtil.checkDate(value)){
			sBuffer.append(getCheckItemStr(itemName)) 
					.append("入力された日付が正しくありません。[yyyy/mm/dd]の形式で入力してください。").append("\n");
		}
		
		return sBuffer.toString();
	}
	
	public static String getTimeCheckErr (String value, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (!StringUtil.isNullOrBlank(value) && !RegexpUtil.checkTime(value)){
			sBuffer.append(getCheckItemStr(itemName)) 
					.append("入力された時刻が正しくありません。[hh:mm:ss]の形式で入力してください。").append("\n");
		}
		return sBuffer.toString();
	}
	
	public static String getDateTimeCheckErr (String value, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (!StringUtil.isNullOrBlank(value) && !RegexpUtil.checkDateTime(value)){
			sBuffer.append(getCheckItemStr(itemName)) 
					.append("入力された日時が正しくありません。[yyyy/mm/dd hh:mm:ss]の形式で入力してください。").append("\n");
		}
		return sBuffer.toString();
	}
	
	public static String getIntCheckErr (String value, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (!StringUtil.isNullOrBlank(value) && !RegexpUtil.isInteger(value)){
			sBuffer.append(getCheckItemStr(itemName)) 
					.append("整数以外の文字が入っています。※0123456789の数字のみ入力可能です。").append("\n");
		}
		return sBuffer.toString();
	}
	
	public static String getDoubleCheckErr (String value, String itemName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (!StringUtil.isNullOrBlank(value) && !RegexpUtil.checkDouble(value)){
			sBuffer.append(getCheckItemStr(itemName)) 
					.append("数字以外の文字が入っています。").append("\n");
		}
		return sBuffer.toString();
	}
	
	public static void addMsg (String msg, StringBuffer sBuffer) throws Exception {
		if (!StringUtil.isNullOrBlank(msg) && sBuffer != null ) {
			sBuffer.append(msg);
		}
	}
}
