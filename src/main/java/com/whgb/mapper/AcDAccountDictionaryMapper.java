package com.whgb.mapper;

import com.whgb.model.AcDAccountDictionary;
import com.whgb.model.AcDAccountDictionaryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AcDAccountDictionaryMapper {
    long countByExample(AcDAccountDictionaryExample example);

    int deleteByExample(AcDAccountDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcDAccountDictionary record);

    int insertSelective(AcDAccountDictionary record);

    List<AcDAccountDictionary> selectByExample(AcDAccountDictionaryExample example);

    AcDAccountDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcDAccountDictionary record, @Param("example") AcDAccountDictionaryExample example);

    int updateByExample(@Param("record") AcDAccountDictionary record, @Param("example") AcDAccountDictionaryExample example);

    int updateByPrimaryKeySelective(AcDAccountDictionary record);

    int updateByPrimaryKey(AcDAccountDictionary record);
}