package com.whgb.mapper;

import com.whgb.model.FiDWallet;
import com.whgb.model.FiDWalletExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FiDWalletMapper {
    long countByExample(FiDWalletExample example);

    int deleteByExample(FiDWalletExample example);

    int deleteByPrimaryKey(String id);

    int insert(FiDWallet record);

    int insertSelective(FiDWallet record);

    List<FiDWallet> selectByExample(FiDWalletExample example);

    FiDWallet selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FiDWallet record, @Param("example") FiDWalletExample example);

    int updateByExample(@Param("record") FiDWallet record, @Param("example") FiDWalletExample example);

    int updateByPrimaryKeySelective(FiDWallet record);

    int updateByPrimaryKey(FiDWallet record);
}