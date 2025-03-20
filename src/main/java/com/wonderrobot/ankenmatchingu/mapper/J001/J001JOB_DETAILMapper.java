package com.wonderrobot.ankenmatchingu.mapper.J001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.J001.J001JOB_DETAILEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * JOB_DETAIL Mapper
 */
public interface J001JOB_DETAILMapper {
	public List<J001JOB_DETAILEntity> j001InitDepthZero(@Param("txt2")String txt2);
	public List<J001JOB_DETAILEntity> j001SearchInitDepthZero(@Param("txt2")String txt2);
}