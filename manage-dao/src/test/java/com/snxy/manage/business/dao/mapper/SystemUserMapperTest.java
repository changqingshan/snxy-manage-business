package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 24398 on 2018/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SystemUserMapperTest {


    @Resource
    SystemUserMapper systemUserMapper;

    @Test
    public void mapperTest(){
      SystemUser systemUser =   systemUserMapper.selectByPrimaryKey(11L);

      log.info("systemUser ;  [{}]",systemUser);
    }



}
