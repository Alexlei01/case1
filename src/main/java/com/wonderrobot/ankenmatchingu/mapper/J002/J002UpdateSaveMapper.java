package com.wonderrobot.ankenmatchingu.mapper.J002;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 案件マッチング スマート保存-更新 Mapper
 */
public interface J002UpdateSaveMapper {
	public int j002UpdateSaveData(@Param("id")String id, @Param("job_id")String job_id, @Param("job_name")String job_name, @Param("people_id")String people_id, @Param("people_name")String people_name, @Param("match_percent")String match_percent, @Param("match_code")String match_code, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM, @Param("id1")String id1);
}