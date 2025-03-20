package com.wonderrobot.ankenmatchingu.dao.J001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.J001.J001UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J001UpdateSaveDao {
	@Autowired
	private J001UpdateSaveMapper J001UpdateSaveMapper;

   
	/**
	 * J001UpdateSaveData
	 */
	public int j001UpdateSaveData (String id, String project, String outline, String project_machine, String description, String recruitment, String project_cycle, String work_address, String skill_required, String budget, String remark, String email_sender, String email_title, String email_content, String email_send_time, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = J001UpdateSaveMapper.j001UpdateSaveData(id,project,outline,project_machine,description,recruitment,project_cycle,work_address,skill_required,budget,remark,email_sender,email_title,email_content,email_send_time,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}