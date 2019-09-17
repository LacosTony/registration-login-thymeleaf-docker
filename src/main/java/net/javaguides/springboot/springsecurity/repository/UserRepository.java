package net.javaguides.springboot.springsecurity.repository;

import net.javaguides.springboot.springsecurity.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Repository
public class UserRepository  {

	private List<User> users = newArrayList();


	public User findByEmail(String email) {
		return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
	}

	public User save(User user) {

		if(findByEmail(user.getEmail()) == null) {
			users.add(user);
		}else {
			users.remove(user);
			users.add(user);
		}

		return findByEmail(user.getEmail());
	}
}
