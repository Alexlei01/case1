package com.wonderrobot.ankenmatchingu.mapper.J002;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.J002.J002JOB_MATCHRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 案件マッチング JOB_MATCH キー重複チェック Mapper
 */
public interface J002JOB_MATCHRepeatCheckMapper {
	public List<J002JOB_MATCHRepeatCheckEntity> j002JOB_MATCHRepeatCheckselectJOB_MATCH(@Param("txt2")String txt2);
}