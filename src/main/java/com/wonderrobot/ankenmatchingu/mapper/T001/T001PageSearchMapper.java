package com.wonderrobot.ankenmatchingu.mapper.T001;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchByNameResponseEntity;

/**
 * Search 用
 * タグ管理  Mapper
 */
public interface T001PageSearchMapper {

	/*
	 * call sql
	 */
	public List<T001PageSearchResponseEntity> queryT001PageSearch(@Param("id") String id, @Param("remark") String remark, @Param("tag_code") String tag_code, @Param("tag_name") String tag_name, @Param("tag_type") String tag_type);

	/*
	 * call sql
	 */
	public void deleteT001PageSearch(@Param("id") String id);

}
