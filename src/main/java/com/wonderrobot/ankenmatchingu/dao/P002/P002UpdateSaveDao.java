package com.wonderrobot.ankenmatchingu.dao.P002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.P002.P002UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class P002UpdateSaveDao {
	@Autowired
	private P002UpdateSaveMapper P002UpdateSaveMapper;

   
	/**
	 * P002UpdateSaveData
	 */
	public int p002UpdateSaveData (String id, String name, String sex, String age, String address, String price, String company_current, String certificate, String introduction, String entry_time, String interview_time, String skills, String remark, String contact, String contact_mail, String contact_company, String contact_phone, String contact_address, String email_sender, String email_send_time, String email_title, String email_content, String email_attachment, String nationality, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = P002UpdateSaveMapper.p002UpdateSaveData(id,name,sex,age,address,price,company_current,certificate,introduction,entry_time,interview_time,skills,remark,contact,contact_mail,contact_company,contact_phone,contact_address,email_sender,email_send_time,email_title,email_content,email_attachment,nationality,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}