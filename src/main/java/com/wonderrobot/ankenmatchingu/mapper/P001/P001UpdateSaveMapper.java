package com.wonderrobot.ankenmatchingu.mapper.P001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 技術者タグ スマート保存-更新 Mapper
 */
public interface P001UpdateSaveMapper {
	public int p001UpdateSaveData(@Param("id")String id, @Param("tag_type")String tag_type, @Param("tag_id")String tag_id, @Param("number_start")String number_start, @Param("number_end")String number_end, @Param("value")String value, @Param("detail_id")String detail_id, @Param("tag_code")String tag_code, @Param("email_send_time")String email_send_time, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}