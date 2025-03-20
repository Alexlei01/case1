package com.wonderrobot.ankenmatchingu.mapper.T001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.T001.T001TAGEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * TAG Mapper
 */
public interface T001TAGMapper {
	public List<T001TAGEntity> t001InitDepthZero(@Param("txt2")String txt2);
	public List<T001TAGEntity> t001SearchInitDepthZero(@Param("txt2")String txt2);
}