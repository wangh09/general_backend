package com.whgb.mapper;

import com.whgb.model.RcDResourceDictionary;
import com.whgb.model.RcDResourceDictionaryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RcDResourceDictionaryMapper {
    long countByExample(RcDResourceDictionaryExample example);

    int deleteByExample(RcDResourceDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RcDResourceDictionary record);

    int insertSelective(RcDResourceDictionary record);

    List<RcDResourceDictionary> selectByExample(RcDResourceDictionaryExample example);

    RcDResourceDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RcDResourceDictionary record, @Param("example") RcDResourceDictionaryExample example);

    int updateByExample(@Param("record") RcDResourceDictionary record, @Param("example") RcDResourceDictionaryExample example);

    int updateByPrimaryKeySelective(RcDResourceDictionary record);

    int updateByPrimaryKey(RcDResourceDictionary record);
}