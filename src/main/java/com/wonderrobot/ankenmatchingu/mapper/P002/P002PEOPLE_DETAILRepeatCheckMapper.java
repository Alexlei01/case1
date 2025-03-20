package com.wonderrobot.ankenmatchingu.mapper.P002;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.P002.P002PEOPLE_DETAILRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 技術者明細 PEOPLE_DETAIL キー重複チェック Mapper
 */
public interface P002PEOPLE_DETAILRepeatCheckMapper {
	public List<P002PEOPLE_DETAILRepeatCheckEntity> p002PEOPLE_DETAILRepeatCheckselectPEOPLE_DETAIL(@Param("txt2")String txt2);
}