package com.codegnan.dao;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import model.User;
public class UserDao {
private Map<String,User> userStorage=new ConcurrentHashMap<>();
public void save(User user) {
	userStorage.put(user.getUsername(), user);
}
public User findByUsername(String username) {
	return userStorage.get(username);
}
}
