package com.wonderrobot.ankenmatchingu.mapper.C001;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchByNameResponseEntity;

/**
 * Search 用
 * コミュニケーション  Mapper
 */
public interface C001PageSearchMapper {

	/*
	 * call sql
	 */
	public List<C001PageSearchResponseEntity> queryC001PageSearch(@Param("id") String id, @Param("job_id") String job_id, @Param("people_id") String people_id, @Param("remark") String remark, @Param("status") String status);

	/*
	 * call sql
	 */
	public void deleteC001PageSearch(@Param("id") String id);

}
