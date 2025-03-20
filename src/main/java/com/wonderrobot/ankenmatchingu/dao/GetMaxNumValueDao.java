package com.wonderrobot.ankenmatchingu.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.GetMaxNumValueEntity;
import com.wonderrobot.ankenmatchingu.mapper.GetMaxNumValueMapper;

@Repository
public class GetMaxNumValueDao {
@Autowired
private GetMaxNumValueMapper GetMaxNumValueMapper;

	public List<GetMaxNumValueEntity> getSysRecfldAutoRecordFieldAuto(String RECORD_ID, String FIELD_ID) throws Exception {
		List<GetMaxNumValueEntity> returnVal = GetMaxNumValueMapper.getSysRecfldAutoRecordFieldAuto(RECORD_ID, FIELD_ID);
		return returnVal;
	}
	
	public void insertRecordFieldAutoIntoSysRecfldAuto(String BUSINESS_UNIT, String RECORD_ID, String FIELD_ID,String FIRST_REG_DTM, String FIRST_REG_ID, String LAST_UPDATE_DTM, String LAST_UPDATE_ID) throws Exception {
		GetMaxNumValueMapper.insertRecordFieldAutoIntoSysRecfldAuto(BUSINESS_UNIT, RECORD_ID, FIELD_ID, FIRST_REG_DTM, FIRST_REG_ID, LAST_UPDATE_DTM, LAST_UPDATE_ID);
	}
	
	public void uptRecordFieldAutoToSysRecfldAuto(String NUM_VAR, String LAST_UPDATE_DTM, String LAST_UPDATE_ID, String RECORD_ID, String FIELD_ID) throws Exception {
		GetMaxNumValueMapper.uptRecordFieldAutoToSysRecfldAuto(NUM_VAR, LAST_UPDATE_DTM, LAST_UPDATE_ID, RECORD_ID, FIELD_ID);
	}
	
	public List<String> getLastNumFronUserTableContent(String FIELD_ID, String RECORD_ID, String FIELD_IDS, String headStr) throws Exception {
		List<String> returnVal = GetMaxNumValueMapper.getLastNumFronUserTableContent(FIELD_ID, RECORD_ID, FIELD_IDS, headStr);
		return returnVal;
	}
}

