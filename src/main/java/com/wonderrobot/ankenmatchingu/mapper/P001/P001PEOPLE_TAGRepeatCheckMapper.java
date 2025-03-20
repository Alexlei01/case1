package com.wonderrobot.ankenmatchingu.mapper.P001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.P001.P001PEOPLE_TAGRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 技術者タグ PEOPLE_TAG キー重複チェック Mapper
 */
public interface P001PEOPLE_TAGRepeatCheckMapper {
	public List<P001PEOPLE_TAGRepeatCheckEntity> p001PEOPLE_TAGRepeatCheckselectPEOPLE_TAG(@Param("txt2")String txt2);
}