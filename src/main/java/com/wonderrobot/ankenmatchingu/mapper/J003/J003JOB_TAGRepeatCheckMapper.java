package com.wonderrobot.ankenmatchingu.mapper.J003;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.J003.J003JOB_TAGRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 案件タグ JOB_TAG キー重複チェック Mapper
 */
public interface J003JOB_TAGRepeatCheckMapper {
	public List<J003JOB_TAGRepeatCheckEntity> j003JOB_TAGRepeatCheckselectJOB_TAG(@Param("txt2")String txt2);
}