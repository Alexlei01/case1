package com.wonderrobot.ankenmatchingu.mapper.S001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 共通設定管理 スマート保存-登録 Mapper
 */
public interface S001Insert1GridSaveMapper {
	public int s001Insert1GridSaveData(@Param("config_code")String config_code, @Param("description")String description, @Param("value")String value, @Param("id")String id, @Param("FIRST_REG_ID")String FIRST_REG_ID, @Param("FIRST_REG_DTM")String FIRST_REG_DTM, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM);
}