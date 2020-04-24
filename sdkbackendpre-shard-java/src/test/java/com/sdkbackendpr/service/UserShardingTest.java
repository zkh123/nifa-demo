package com.sdkbackendpr.service;

import com.sdkbackendpr.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 演示取模的分库分表策略
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserShardingTest {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
    UserService userService;

	@Test
	public void insert(){
		userService.insert();
	}

	@Test
	public void select(){
		UserInfo userInfo1= userService.getUserInfoByUserId(1L);
		System.out.println("------userInfo1:"+userInfo1);

        UserInfo userInfo2= userService.getUserInfoByUserId(2L);
        System.out.println("------userInfo2:"+userInfo2);
	}

	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

	@Test
	public void selectUseInfoByCriteria() throws ParseException {
		Map<String, Object> params1 = new HashMap<>(3);
		Long userId1 = 5455L;
		params1.put("userId", userId1);
		params1.put("startTime", formatter.parse("2020-04-20 13:58:38"));
		params1.put("endTime", formatter.parse("2020-04-25 16:58:38"));

		List<UserInfo> list1 = userService.selectUseInfoByCriteria(params1);
		System.out.println(" result size: " + list1.size());   // 0


		Map<String, Object> params2 = new HashMap<>(3);
		Long userId2 = 1L;
		params2.put("userId", userId2);

		Date startTime = formatter.parse("2020-04-20 13:58:38");
		String s = dateFormatter.format(startTime.toInstant());
		params2.put("startTime", s);

		Date endTime = formatter.parse("2020-04-23 16:58:38");
		String e = dateFormatter.format(endTime.toInstant());
		params2.put("endTime", e);

		List<UserInfo> list2 = userService.selectUseInfoByCriteria(params2);
		System.out.println(" result size: " + list2.size());  // 1


		Map<String, Object> params3 = new HashMap<>(3);
		Long userId3 = 1L;
		params3.put("userId", userId3);
		params3.put("startTime", "2020-04-20 13:58:38");
		params3.put("endTime", "2020-04-23 16:58:38");

		List<UserInfo> list3 = userService.selectUseInfoByCriteria(params3);
		System.out.println(" result size: " + list3.size());  // 1
	}

}
