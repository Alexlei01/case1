package com.wonderrobot.ankenmatchingu.mapper.J002;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchByNameResponseEntity;

/**
 * Search 用
 * 案件マッチング  Mapper
 */
public interface J002PageSearchMapper {

	/*
	 * call sql
	 */
	public List<J002PageSearchResponseEntity> queryJ002PageSearch(@Param("id") String id, @Param("job_id") String job_id, @Param("job_name") String job_name, @Param("match_code") String match_code, @Param("match_percent") String match_percent, @Param("people_id") String people_id, @Param("people_name") String people_name);

	/*
	 * call sql
	 */
	public void deleteJ002PageSearch(@Param("id") String id);

}
