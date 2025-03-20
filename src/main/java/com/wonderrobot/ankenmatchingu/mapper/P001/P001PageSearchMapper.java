package com.wonderrobot.ankenmatchingu.mapper.P001;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchByNameResponseEntity;

/**
 * Search 用
 * 技術者タグ  Mapper
 */
public interface P001PageSearchMapper {

	/*
	 * call sql
	 */
	public List<P001PageSearchResponseEntity> queryP001PageSearch(@Param("detail_id") String detail_id, @Param("email_send_time") String email_send_time, @Param("id") String id, @Param("number_end") String number_end, @Param("number_start") String number_start, @Param("tag_code") String tag_code, @Param("tag_id") String tag_id, @Param("tag_type") String tag_type, @Param("value") String value);

	/*
	 * call sql
	 */
	public void deleteP001PageSearch(@Param("id") String id);

}
