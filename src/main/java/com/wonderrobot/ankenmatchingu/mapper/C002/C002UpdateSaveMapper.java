package com.wonderrobot.ankenmatchingu.mapper.C002;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * コミュニケーション記録 スマート保存-更新 Mapper
 */
public interface C002UpdateSaveMapper {
	public int c002UpdateSaveData(@Param("id")String id, @Param("record_type")String record_type, @Param("email_receiver")String email_receiver, @Param("email_title")String email_title, @Param("email_content")String email_content, @Param("email_sender")String email_sender, @Param("email_send_time")String email_send_time, @Param("match_id")String match_id, @Param("c_id")String c_id, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}