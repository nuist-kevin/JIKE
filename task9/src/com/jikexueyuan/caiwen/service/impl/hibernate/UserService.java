package com.jikexueyuan.caiwen.service.impl.hibernate;

import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.repositry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

//@Service
public class UserService {

/*//	@Autowired
//	private UserDao userDao;

	@Autowired
	private UserRepository userReposotory;
//	@Transactional
	public User save(User user) {
		return userReposotory.save(user);
	}

//	@Transactional
//	public void edit(User user) {
//		userReposotory.update(user);
//	}
//	@Transactional
	public void delete(Integer id) {
		userReposotory.delete(id);
	}
//	@Transactional
	public User get(Integer id) {
		return userReposotory.findOne(id);
	}
//	@Transactional
	public List<User> getAll() {
		return userReposotory.findAll();
	}
//	@Transactional
	public Page<User> findBypage(int page, int size) {
		return userReposotory.findAll(new PageRequest(page, size));
	}


//	@Transactional
	public Long getTotalCount() {
		return userReposotory.count();
	}


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
//		System.out.println(userService.get(1).getUsername());
//		System.out.println(userService.getTotalCount());
//		Iterator<User> iterator = userService.findBypage(1, 5).iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next().getUsername());
//		}


		System.out.println(userService.getUserByUsername("chenhu").getRealName());
		System.out.println(userService.getUserByRealName("陈虎").getRealName());

	}*/
}
