package cm.codgnan.service;
import com.codegnan.dao.UserDao;
import com.codegnan.exception.LoginFailed;

import model.User;
public class AuthinticationService {
private UserDao userDao;

public AuthinticationService(UserDao userdao) {
	super();
	this.userDao=userdao;
}

public User authenticate(String username,String password)throws LoginFailed{
	User user=userDao.findByUsername(username);
	if(user==null||!user.passwordChacker(password)) {
		throw new LoginFailed("invalid user name or password");
	}
	return user;
}


}
