package com.sdkbackendpr.mapper;

import com.sdkbackendpr.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    List<UserInfo> selectByRange(@Param("firstId") Long firstId, @Param("lastId") Long lastId);

//    List<UserInfo> selectUseInfoByCriteria(Long userId, Date startTime,Date endTime);

    List<UserInfo> selectUseInfoByCriteria(Map<String, Object> params);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}
