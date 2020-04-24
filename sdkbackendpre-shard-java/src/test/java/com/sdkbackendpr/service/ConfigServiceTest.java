package com.sdkbackendpr.service;

import com.sdkbackendpr.entity.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * Created by huanglijun on 2020/4/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ConfigServiceTest {

    @Resource
    ConfigService configService;

    @Test
    public void insert() {

        Long configId = 1L;

        for (int i = 1; i <= 10; i++) {
            Config config = new Config();
            config.setConfigId(i);
            config.setParaName("name"+i);
            config.setParaValue("value"+i);
            config.setParaDesc("desc"+i);
            configId++;
            configService.insert(config);
        }
        System.out.println(" &&&&&& ");
    }


    @Test
    public void update() {
    }

    @Test
    public void geConfigById() {
    }
}