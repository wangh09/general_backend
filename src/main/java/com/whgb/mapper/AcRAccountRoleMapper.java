package com.whgb.mapper;

import com.whgb.model.AcRAccountRole;
import com.whgb.model.AcRAccountRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AcRAccountRoleMapper {
    long countByExample(AcRAccountRoleExample example);

    int deleteByExample(AcRAccountRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(AcRAccountRole record);

    int insertSelective(AcRAccountRole record);

    List<AcRAccountRole> selectByExample(AcRAccountRoleExample example);

    AcRAccountRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AcRAccountRole record, @Param("example") AcRAccountRoleExample example);

    int updateByExample(@Param("record") AcRAccountRole record, @Param("example") AcRAccountRoleExample example);

    int updateByPrimaryKeySelective(AcRAccountRole record);

    int updateByPrimaryKey(AcRAccountRole record);
}