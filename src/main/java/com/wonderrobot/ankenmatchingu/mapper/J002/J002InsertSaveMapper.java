package com.wonderrobot.ankenmatchingu.mapper.J002;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 案件マッチング スマート保存-登録 Mapper
 */
public interface J002InsertSaveMapper {
	public int j002InsertSaveData(@Param("id")String id, @Param("job_id")String job_id, @Param("job_name")String job_name, @Param("people_id")String people_id, @Param("people_name")String people_name, @Param("match_percent")String match_percent, @Param("match_code")String match_code, @Param("FIRST_REG_ID")String FIRST_REG_ID, @Param("FIRST_REG_DTM")String FIRST_REG_DTM, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM);
}