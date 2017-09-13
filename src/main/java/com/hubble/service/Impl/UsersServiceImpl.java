package com.hubble.service.Impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hubble.dao.UsersDao;
import com.hubble.entiy.User;
import com.hubble.service.IUsersService;

@Service("usersService")
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersDao userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public void deleteByUsersId(String userId) {
		userDao.delete(userId);
	}

	public User update(User user) {
		return userDao.save(user);
	}

	public User findByUserId(String userId) {
		return userDao.findOne(userId);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public User findByUsersId(String userId) {
		return null;
	}

	/**
	 * 处理激活
	 * 
	 * @throws ParseException
	 */
	public void processActivate(String email, String validateCode) {
		try {
			// 数据访问层，通过email获取用户信息
			User user = findByEmail(email);
			// 验证用户是否存在
			if (user != null) {
				// 验证用户激活状态
				if (user.getStatus() == 0) {
					/// 没激活
					Date currentTime = new Date();// 获取当前时间
					// 验证链接是否过期
					currentTime.before(user.getRegisterTime());
					if (currentTime.before(user.getLastActivateTime())) {
						// 验证激活码是否正确
						if (validateCode.equals(user.getValidateCode())) {
							// 激活成功， 并更新用户的激活状态，为已激活
							System.out.println("==sq===" + user.getStatus());
							user.setStatus(1);// 把状态改为激活
							System.out.println("==sh===" + user.getStatus());
							userDao.save(user);
						} else {
							System.out.println("激活码不正确");
						}
					} else {
						System.out.println("激活码已过期！");
					}
				} else {
					System.out.println("邮箱已激活，请登录！");
				}
			} else {
				System.out.println("该邮箱未注册（邮箱地址不存在）！");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("ServiceException : " + e);
		}
	}

}
