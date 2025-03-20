package com.wonderrobot.ankenmatchingu.mapper.J002;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.J002.J002JOB_MATCHEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * JOB_MATCH Mapper
 */
public interface J002JOB_MATCHMapper {
	public List<J002JOB_MATCHEntity> j002InitDepthZero(@Param("txt2")String txt2);
	public List<J002JOB_MATCHEntity> j002SearchInitDepthZero(@Param("txt2")String txt2);
}