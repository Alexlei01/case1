package com.wonderrobot.ankenmatchingu.dao.J001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.J001.J001InsertSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J001InsertSaveDao {
	@Autowired
	private J001InsertSaveMapper J001InsertSaveMapper;

   
	/**
	 * J001InsertSaveData
	 */
	public int j001InsertSaveData (String id, String project, String outline, String project_machine, String description, String recruitment, String project_cycle, String work_address, String skill_required, String budget, String remark, String email_sender, String email_title, String email_content, String email_send_time, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = J001InsertSaveMapper.j001InsertSaveData(id,project,outline,project_machine,description,recruitment,project_cycle,work_address,skill_required,budget,remark,email_sender,email_title,email_content,email_send_time,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}