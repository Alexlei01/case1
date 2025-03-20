package com.wonderrobot.ankenmatchingu.common;
// PropertiestUtilBuild.java
import java.util.Properties;
import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import org.springframework.util.ResourceUtils;
@Component
public class SpringPropertiesUtil {
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private ConfigEntity ConfigEntity;
	private static SpringPropertiesUtil InitStaticConstant;
	@PostConstruct
	private void init() {
		InitStaticConstant = this;
	}
	public static String getSystemProperties(String propertiesID) {
		return InitStaticConstant.springSystemProperties.getProperty(propertiesID);
	}
	public static String getLog4j_path() {
		return InitStaticConstant.ConfigEntity.getLog4j_path();
	}
	public static String getSifglog_path() {
		return InitStaticConstant.ConfigEntity.getSifglog_path();
	}
	public static String getExport_file_path() {
		return InitStaticConstant.ConfigEntity.getExport_file_path();
	}
	public static String getPrint_file_path() {
		return InitStaticConstant.ConfigEntity.getPrint_file_path();
	}
	public static String getPrint_template_file_path() {
		return InitStaticConstant.ConfigEntity.getPrint_template_file_path();
	}
	public static String getUpload_file_path() {
		return InitStaticConstant.ConfigEntity.getUpload_file_path();
	}
	public static String getUser_tableid() {
		return InitStaticConstant.ConfigEntity.getUser_tableid();
	}
	public static String getUser_table_userid_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_userid_fieldid();
	}
	public static String getUser_table_password_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_password_fieldid();
	}
	public static String getUser_table_user_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_user_fieldid();
	}
	public static String getUser_table_eff_status_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_eff_status_fieldid();
	}
	public static String getUser_table_group_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_group_fieldid();
	}
	public static String getBUSINESS_ERROR_LOG_SUFFIX() {
		return InitStaticConstant.ConfigEntity.getBUSINESS_ERROR_LOG_SUFFIX();
	}
	public static String getInout_businessunit() {
		return InitStaticConstant.ConfigEntity.getInout_businessunit();
	}
	public static String getInout_environflg() {
		return InitStaticConstant.ConfigEntity.getInout_environflg();
	}
	public static String getInout_langid() {
		return InitStaticConstant.ConfigEntity.getInout_langid();
	}
	public static String getPdf_font_path() {
		return InitStaticConstant.ConfigEntity.getPdf_font_path();
	}
	public static String getPdf_font_name() {
		return InitStaticConstant.ConfigEntity.getPdf_font_name();
	}
	public static String getUser_table_usernm1_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_usernm1_fieldid();
	}
	public static String getUser_table_usernm2_fieldid() {
		return InitStaticConstant.ConfigEntity.getUser_table_usernm2_fieldid();
	}
}
