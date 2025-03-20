package com.wonderrobot.ankenmatchingu.mapper.S001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 共通設定管理 スマート保存-更新 Mapper
 */
public interface S001Update1GridSaveMapper {
	public int s001Update1GridSaveData(@Param("config_code")String config_code, @Param("description")String description, @Param("value")String value, @Param("id")String id, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}