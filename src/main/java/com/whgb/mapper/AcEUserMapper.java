package com.whgb.mapper;

import com.whgb.model.AcEUser;
import com.whgb.model.AcEUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AcEUserMapper {
    long countByExample(AcEUserExample example);

    int deleteByExample(AcEUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(AcEUser record);

    int insertSelective(AcEUser record);

    List<AcEUser> selectByExample(AcEUserExample example);

    AcEUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AcEUser record, @Param("example") AcEUserExample example);

    int updateByExample(@Param("record") AcEUser record, @Param("example") AcEUserExample example);

    int updateByPrimaryKeySelective(AcEUser record);

    int updateByPrimaryKey(AcEUser record);
}