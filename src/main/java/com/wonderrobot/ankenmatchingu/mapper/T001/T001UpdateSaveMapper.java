package com.wonderrobot.ankenmatchingu.mapper.T001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * タグ管理 スマート保存-更新 Mapper
 */
public interface T001UpdateSaveMapper {
	public int t001UpdateSaveData(@Param("id")String id, @Param("tag_name")String tag_name, @Param("tag_type")String tag_type, @Param("remark")String remark, @Param("tag_code")String tag_code, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}