package fr.doranco.tpjsf2.metier;

import java.util.List;

import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf2.dao.IUserDao;
import fr.doranco.tpjsf2.dao.UserDao;

public class UserMetier implements IUserMetier {

	private IUserDao userDao = new UserDao();

	@Override
	public User getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public User addUser(User user) throws Exception {
		user.setNom(user.getNom().toUpperCase());
		user.setPrenom(user.getPrenom().substring(0, 1).toUpperCase()
				.concat(user.getPrenom().substring(1, user.getPrenom().length()).toLowerCase()));
		Integer idUser = userDao.addUser(user);
		user.setId(idUser);
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User LogIn(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
