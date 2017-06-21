package com.whgb.mapper;

import com.whgb.model.RcDApi;
import com.whgb.model.RcDApiExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RcDApiMapper {
    long countByExample(RcDApiExample example);

    int deleteByExample(RcDApiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RcDApi record);

    int insertSelective(RcDApi record);

    List<RcDApi> selectByExample(RcDApiExample example);

    RcDApi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RcDApi record, @Param("example") RcDApiExample example);

    int updateByExample(@Param("record") RcDApi record, @Param("example") RcDApiExample example);

    int updateByPrimaryKeySelective(RcDApi record);

    int updateByPrimaryKey(RcDApi record);
}