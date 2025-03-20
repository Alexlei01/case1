package com.wonderrobot.ankenmatchingu.mapper.C001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * コミュニケーション スマート保存-更新 Mapper
 */
public interface C001UpdateSaveMapper {
	public int c001UpdateSaveData(@Param("id")String id, @Param("job_id")String job_id, @Param("people_id")String people_id, @Param("remark")String remark, @Param("status")String status, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}