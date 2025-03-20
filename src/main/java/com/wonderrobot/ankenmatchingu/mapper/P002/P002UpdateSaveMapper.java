package com.wonderrobot.ankenmatchingu.mapper.P002;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 技術者明細 スマート保存-更新 Mapper
 */
public interface P002UpdateSaveMapper {
	public int p002UpdateSaveData(@Param("id")String id, @Param("name")String name, @Param("sex")String sex, @Param("age")String age, @Param("address")String address, @Param("price")String price, @Param("company_current")String company_current, @Param("certificate")String certificate, @Param("introduction")String introduction, @Param("entry_time")String entry_time, @Param("interview_time")String interview_time, @Param("skills")String skills, @Param("remark")String remark, @Param("contact")String contact, @Param("contact_mail")String contact_mail, @Param("contact_company")String contact_company, @Param("contact_phone")String contact_phone, @Param("contact_address")String contact_address, @Param("email_sender")String email_sender, @Param("email_send_time")String email_send_time, @Param("email_title")String email_title, @Param("email_content")String email_content, @Param("email_attachment")String email_attachment, @Param("nationality")String nationality, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}