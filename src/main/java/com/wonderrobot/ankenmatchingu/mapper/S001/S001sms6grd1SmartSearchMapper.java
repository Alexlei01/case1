package com.wonderrobot.ankenmatchingu.mapper.S001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.S001.S001sms6grd1SmartSearchEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * スマート検索用
 * 共通設定管理 検索 配置表 スマート検索 Mapper
 */
public interface S001sms6grd1SmartSearchMapper {
	public List<S001sms6grd1SmartSearchEntity> s001sms6grd1SmartSearch(@Param("configCode1")String configCode1, @Param("value1")String value1, @Param("desc1")String desc1, @Param("description1")String description1);
}