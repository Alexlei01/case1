package com.wonderrobot.ankenmatchingu.mapper.J003;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchByNameResponseEntity;

/**
 * Search 用
 * 案件タグ  Mapper
 */
public interface J003PageSearchMapper {

	/*
	 * call sql
	 */
	public List<J003PageSearchResponseEntity> queryJ003PageSearch(@Param("detail_id") String detail_id, @Param("email_send_time") String email_send_time, @Param("id") String id, @Param("number_end") String number_end, @Param("number_start") String number_start, @Param("tag_code") String tag_code, @Param("tag_id") String tag_id, @Param("tag_type") String tag_type, @Param("value") String value);

	/*
	 * call sql
	 */
	public void deleteJ003PageSearch(@Param("id") String id);

}
