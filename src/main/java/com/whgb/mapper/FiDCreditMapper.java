package com.whgb.mapper;

import com.whgb.model.FiDCredit;
import com.whgb.model.FiDCreditExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FiDCreditMapper {
    long countByExample(FiDCreditExample example);

    int deleteByExample(FiDCreditExample example);

    int deleteByPrimaryKey(String id);

    int insert(FiDCredit record);

    int insertSelective(FiDCredit record);

    List<FiDCredit> selectByExample(FiDCreditExample example);

    FiDCredit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FiDCredit record, @Param("example") FiDCreditExample example);

    int updateByExample(@Param("record") FiDCredit record, @Param("example") FiDCreditExample example);

    int updateByPrimaryKeySelective(FiDCredit record);

    int updateByPrimaryKey(FiDCredit record);
}