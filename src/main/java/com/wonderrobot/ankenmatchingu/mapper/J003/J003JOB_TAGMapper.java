package com.wonderrobot.ankenmatchingu.mapper.J003;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.J003.J003JOB_TAGEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * JOB_TAG Mapper
 */
public interface J003JOB_TAGMapper {
	public List<J003JOB_TAGEntity> j003InitDepthZero(@Param("txt2")String txt2);
	public List<J003JOB_TAGEntity> j003SearchInitDepthZero(@Param("txt2")String txt2);
}