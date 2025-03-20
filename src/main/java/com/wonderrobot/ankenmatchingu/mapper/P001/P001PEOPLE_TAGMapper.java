package com.wonderrobot.ankenmatchingu.mapper.P001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.P001.P001PEOPLE_TAGEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * PEOPLE_TAG Mapper
 */
public interface P001PEOPLE_TAGMapper {
	public List<P001PEOPLE_TAGEntity> p001InitDepthZero(@Param("txt2")String txt2);
	public List<P001PEOPLE_TAGEntity> p001SearchInitDepthZero(@Param("txt2")String txt2);
}