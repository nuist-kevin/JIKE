package com.jikexueyuan.caiwen.service.impl.jpa;

import com.jikexueyuan.caiwen.command.UserCommand;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.repositry.UserRepository;
import com.jikexueyuan.caiwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userReposotory;

	public User save(User user) {
		return userReposotory.save(user);
	}

	public User getByUsername(String username) {
        return userReposotory.findOne(username);
	}

	public List<User> findAll() {
	    return userReposotory.findAll();
    }

    public void delete(String username) {
        userReposotory.delete(username);
    }

    public boolean validateUser(UserCommand userCommand) {
        User user = getByUsername(userCommand.getUsername());
        if (user == null) {
            return false;
        } else {
            return user.getPassword().equals(userCommand.getPassword());
        }
    }

    public boolean isAuthorised(User user) {
        return user.getAuthority() > 0;
    }

    public boolean isAdmin(User user) {
        return user.getAuthority() == 1;
    }
}
