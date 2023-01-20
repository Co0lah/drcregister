package fr.doranco.tpjsf2.metier;

import java.util.List;

import fr.doranco.tpjsf.entity.User;

public interface IUserMetier {

	User getUserById(Integer id) throws Exception;
	List<User> getUsers() throws Exception;
	User addUser(User user ) throws Exception;
	void updateUser(User user) throws Exception;
	void deleteUser(User user) throws Exception;
	User LogIn(String email, String password ) throws Exception;
}
