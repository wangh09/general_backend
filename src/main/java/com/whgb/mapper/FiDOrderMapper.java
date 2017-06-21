package com.whgb.mapper;

import com.whgb.model.FiDOrder;
import com.whgb.model.FiDOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FiDOrderMapper {
    long countByExample(FiDOrderExample example);

    int deleteByExample(FiDOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(FiDOrder record);

    int insertSelective(FiDOrder record);

    List<FiDOrder> selectByExample(FiDOrderExample example);

    FiDOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FiDOrder record, @Param("example") FiDOrderExample example);

    int updateByExample(@Param("record") FiDOrder record, @Param("example") FiDOrderExample example);

    int updateByPrimaryKeySelective(FiDOrder record);

    int updateByPrimaryKey(FiDOrder record);
}