package com.wonderrobot.ankenmatchingu.mapper.J001;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchByNameResponseEntity;

/**
 * Search 用
 * 案件明細  Mapper
 */
public interface J001PageSearchMapper {

	/*
	 * call sql
	 */
	public List<J001PageSearchResponseEntity> queryJ001PageSearch(@Param("email_sender") String email_sender, @Param("email_title") String email_title, @Param("id") String id, @Param("recruitment") String recruitment);

	/*
	 * call sql
	 */
	public void deleteJ001PageSearch(@Param("id") String id);

}
