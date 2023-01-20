package fr.doranco.tpjsf2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf2.utils.Dates;

public class UserDao implements IUserDao{

	@Override
	public User getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() throws Exception {
		 
		Connection connection = DorancoDataSource.getInstance().getConnection();
		String requete = "SELECT * FROM user";
		PreparedStatement ps = connection.prepareStatement(requete);
		ResultSet res = ps.getResultSet();
		List<User> users = new ArrayList<User>();
		while(res.next()) {
			User user = new User();
			user.setId(res.getInt("id"));
			user.setNom(res.getString("nom"));
			user.setPrenom(res.getString("prenom"));
			user.setGenre(res.getString("genre"));
			user.setDateNaissance(Dates.dateSqlToUtil(res.getDate("dateNaissance")));
			user.setEmail(res.getString("email"));
			user.setNiveauDeService(res.getString("niveauDeService"));
			user.setPhone(res.getString("phone"));
			user.setFonctionActuelle(res.getString("fonctionActuelle"));
			user.setDisponibilite(res.getString("disponibilite"));
			user.setLangage(res.getString("langage"));
			user.setPassword(res.getString("password"));
			users.add(user);
		}
		return users;
	}

	@Override
	public Integer addUser(User user) throws Exception {
		Connection connection = DorancoDataSource.getInstance().getConnection();
		String requete = "INSERT INTO user(nom, prenom, genre, date_naissance, email, service, phone, fonction, disponibilite, langage, password)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getGenre());
		ps.setDate(4, Dates.dateUtilToSql(user.getDateNaissance()));
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getNiveauDeService());
		ps.setString(7, user.getPhone());
		ps.setString(8, user.getFonctionActuelle());
		ps.setString(9, user.getDisponibilite());
		ps.setString(10, user.getLangage());
		ps.setString(11, user.getPassword());
		
		ps.executeUpdate();
		ResultSet res = ps.getGeneratedKeys();
		int id = -1;
		if(res.next()) {
			id = res.getInt(1);
		}
		
		return id;
	}

	@Override
	public void UpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
