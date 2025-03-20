package com.wonderrobot.ankenmatchingu.mapper.C002;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchByNameResponseEntity;

/**
 * Search 用
 * コミュニケーション記録  Mapper
 */
public interface C002PageSearchMapper {

	/*
	 * call sql
	 */
	public List<C002PageSearchResponseEntity> queryC002PageSearch(@Param("email_content") String email_content, @Param("email_receiver") String email_receiver, @Param("email_sender") String email_sender, @Param("email_send_time") String email_send_time, @Param("email_title") String email_title);

	/*
	 * call sql
	 */
	public void deleteC002PageSearch(@Param("id") String id);

}
