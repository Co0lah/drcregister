package fr.doranco.tpjsf2.dao;

import java.util.List;

import fr.doranco.tpjsf.entity.User;

public interface IUserDao {
	
			User getUserById(Integer id) throws Exception;
			User getUserByEmail(String email) throws Exception;
			List<User> getUsers() throws Exception;
			Integer addUser(User user) throws Exception;
			void  UpdateUser(User user) throws Exception;
			void DeleteUser(User user) throws Exception;
}
