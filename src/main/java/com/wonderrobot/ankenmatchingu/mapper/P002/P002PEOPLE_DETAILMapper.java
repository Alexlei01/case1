package com.wonderrobot.ankenmatchingu.mapper.P002;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.P002.P002PEOPLE_DETAILEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * PEOPLE_DETAIL Mapper
 */
public interface P002PEOPLE_DETAILMapper {
	public List<P002PEOPLE_DETAILEntity> p002InitDepthZero(@Param("txt2")String txt2);
	public List<P002PEOPLE_DETAILEntity> p002SearchInitDepthZero(@Param("txt2")String txt2);
}