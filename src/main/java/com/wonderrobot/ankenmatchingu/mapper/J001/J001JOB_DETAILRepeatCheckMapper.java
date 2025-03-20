package com.wonderrobot.ankenmatchingu.mapper.J001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.J001.J001JOB_DETAILRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 案件明細 JOB_DETAIL キー重複チェック Mapper
 */
public interface J001JOB_DETAILRepeatCheckMapper {
	public List<J001JOB_DETAILRepeatCheckEntity> j001JOB_DETAILRepeatCheckselectJOB_DETAIL(@Param("txt2")String txt2);
}