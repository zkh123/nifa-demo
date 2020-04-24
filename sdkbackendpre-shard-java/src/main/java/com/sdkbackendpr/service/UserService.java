package com.sdkbackendpr.service;

import com.sdkbackendpr.entity.UserInfo;
import com.sdkbackendpr.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    UserInfoMapper userInfoMapper;

    public static Long userId = 2427878l;

    public void insert() {
        for (int i = 113; i <= 100870566; i++) {

            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            userInfo.setAccount("account" + i);
            userInfo.setPassword("password" + i);
            userInfo.setUserName("name" + i);
            userId++;
            userInfoMapper.insert(userInfo);
            System.out.println(" i: " + i);
        }
    }

    public UserInfo getUserInfoByUserId(Long id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public List<UserInfo> selectByRange(Long firstId, Long lastId){
        return userInfoMapper.selectByRange(firstId, lastId);
    }

    public List<UserInfo> selectUseInfoByCriteria(Map<String, Object> params){
        return userInfoMapper.selectUseInfoByCriteria(params);
    }
}
