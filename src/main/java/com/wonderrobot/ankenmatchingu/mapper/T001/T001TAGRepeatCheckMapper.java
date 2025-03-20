package com.wonderrobot.ankenmatchingu.mapper.T001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.T001.T001TAGRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * タグ管理 TAG キー重複チェック Mapper
 */
public interface T001TAGRepeatCheckMapper {
	public List<T001TAGRepeatCheckEntity> t001TAGRepeatCheckselectTAG(@Param("txt2")String txt2);
}