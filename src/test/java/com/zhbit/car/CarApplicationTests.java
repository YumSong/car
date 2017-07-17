package com.zhbit.car;

import com.zhbit.car.service.user.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}


	@Test
	public void test2() throws Exception {
		// 保存对象
		User user1 = new User();
		user1.setUserName("超人");
		user1.setAge(20);
		redisTemplate.opsForValue().set(user1.getUserName(), user1);
		User user2 = new User();
		user2.setUserName("蝙蝠侠");
		user2.setAge(30);
		redisTemplate.opsForValue().set(user2.getUserName(), user2);
		User user3 = new User();
		user3.setUserName("蜘蛛侠");
		user3.setAge(40);
		redisTemplate.opsForValue().set(user3.getUserName(), user3);

        Assert.assertEquals(20, ((User)redisTemplate.opsForValue().get("超人")).getAge().longValue());
        Assert.assertEquals(30, ((User)redisTemplate.opsForValue().get("蝙蝠侠")).getAge().longValue());
        Assert.assertEquals(40, ((User)redisTemplate.opsForValue().get("蜘蛛侠")).getAge().longValue());
    }
}
