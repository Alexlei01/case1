package com.wonderrobot.ankenmatchingu.mapper.J001;
// SpringMapperClassCodeCreator.java


import org.apache.ibatis.annotations.Param;

/**
 * 案件明細 スマート保存-登録 Mapper
 */
public interface J001InsertSaveMapper {
	public int j001InsertSaveData(@Param("id")String id, @Param("project")String project, @Param("outline")String outline, @Param("project_machine")String project_machine, @Param("description")String description, @Param("recruitment")String recruitment, @Param("project_cycle")String project_cycle, @Param("work_address")String work_address, @Param("skill_required")String skill_required, @Param("budget")String budget, @Param("remark")String remark, @Param("email_sender")String email_sender, @Param("email_title")String email_title, @Param("email_content")String email_content, @Param("email_send_time")String email_send_time, @Param("FIRST_REG_ID")String FIRST_REG_ID, @Param("FIRST_REG_DTM")String FIRST_REG_DTM, @Param("LAST_UPDATE_ID")String LAST_UPDATE_ID, @Param("LAST_UPDATE_DTM")String LAST_UPDATE_DTM);
}