package com.whgb.mapper;

import com.whgb.model.AcDAccount;
import com.whgb.model.AcDAccountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AcDAccountMapper {
    long countByExample(AcDAccountExample example);

    int deleteByExample(AcDAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(AcDAccount record);

    int insertSelective(AcDAccount record);

    List<AcDAccount> selectByExample(AcDAccountExample example);

    AcDAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AcDAccount record, @Param("example") AcDAccountExample example);

    int updateByExample(@Param("record") AcDAccount record, @Param("example") AcDAccountExample example);

    int updateByPrimaryKeySelective(AcDAccount record);

    int updateByPrimaryKey(AcDAccount record);
}