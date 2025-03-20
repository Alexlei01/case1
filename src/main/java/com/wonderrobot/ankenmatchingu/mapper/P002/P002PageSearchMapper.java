package com.wonderrobot.ankenmatchingu.mapper.P002;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchByNameResponseEntity;

/**
 * Search 用
 * 技術者明細  Mapper
 */
public interface P002PageSearchMapper {

	/*
	 * call sql
	 */
	public List<P002PageSearchResponseEntity> queryP002PageSearch(@Param("email_send_time") String email_send_time, @Param("email_title") String email_title, @Param("id") String id);

	/*
	 * call sql
	 */
	public void deleteP002PageSearch(@Param("id") String id);

}
