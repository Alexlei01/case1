package com.wonderrobot.ankenmatchingu.mapper.C001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * コミュニケーション スマート保存-登録 Mapper
 */
public interface C001InsertSaveMapper {
	public int c001InsertSaveData(@Param("id")String id, @Param("job_id")String job_id, @Param("people_id")String people_id, @Param("remark")String remark, @Param("status")String status, @Param("FIRST_REG_ID")String FIRST_REG_ID, @Param("FIRST_REG_DTM")String FIRST_REG_DTM, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM);
}