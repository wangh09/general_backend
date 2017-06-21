package com.whgb.mapper;

import com.whgb.model.FiDFinanceDictionary;
import com.whgb.model.FiDFinanceDictionaryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FiDFinanceDictionaryMapper {
    long countByExample(FiDFinanceDictionaryExample example);

    int deleteByExample(FiDFinanceDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FiDFinanceDictionary record);

    int insertSelective(FiDFinanceDictionary record);

    List<FiDFinanceDictionary> selectByExample(FiDFinanceDictionaryExample example);

    FiDFinanceDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FiDFinanceDictionary record, @Param("example") FiDFinanceDictionaryExample example);

    int updateByExample(@Param("record") FiDFinanceDictionary record, @Param("example") FiDFinanceDictionaryExample example);

    int updateByPrimaryKeySelective(FiDFinanceDictionary record);

    int updateByPrimaryKey(FiDFinanceDictionary record);
}