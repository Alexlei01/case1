package com.wonderrobot.ankenmatchingu.mapper.C002;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.C002.C002COMMUNICATION_RECORDEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * COMMUNICATION_RECORD Mapper
 */
public interface C002COMMUNICATION_RECORDMapper {
	public List<C002COMMUNICATION_RECORDEntity> c002InitDepthZero(@Param("txt2")String txt2);
	public List<C002COMMUNICATION_RECORDEntity> c002SearchInitDepthZero(@Param("txt2")String txt2);
}