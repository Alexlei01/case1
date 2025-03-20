package com.wonderrobot.ankenmatchingu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wonderrobot.ankenmatchingu.entity.GetMaxNumValueEntity;

public interface GetMaxNumValueMapper {

	public List<GetMaxNumValueEntity> getSysRecfldAutoRecordFieldAuto(@Param("RECORD_ID") String RECORD_ID,@Param("FIELD_ID") String FIELD_ID);
	
	public void insertRecordFieldAutoIntoSysRecfldAuto(@Param("BUSINESS_UNIT") String BUSINESS_UNIT, @Param("RECORD_ID") String RECORD_ID, @Param("FIELD_ID") String FIELD_ID, @Param("FIRST_REG_DTM") String FIRST_REG_DTM, @Param("FIRST_REG_ID") String FIRST_REG_ID, @Param("LAST_UPDATE_DTM") String LAST_UPDATE_DTM, @Param("LAST_UPDATE_ID") String LAST_UPDATE_ID);
	
	public void uptRecordFieldAutoToSysRecfldAuto(@Param("NUM_VAR") String NUM_VAR, @Param("LAST_UPDATE_DTM") String LAST_UPDATE_DTM, @Param("LAST_UPDATE_ID") String LAST_UPDATE_ID, @Param("RECORD_ID") String RECORD_ID, @Param("FIELD_ID") String FIELD_ID);
	
	public List<String> getLastNumFronUserTableContent(@Param("FIELD_ID") String FIELD_ID, @Param("RECORD_ID") String RECORD_ID, @Param("FIELD_IDS") String FIELD_IDS, @Param("headStr") String headStr);
}

