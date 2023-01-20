package fr.doranco.tpjsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf.entity.Address;
import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf2.metier.IUserMetier;
import fr.doranco.tpjsf2.metier.UserMetier;
import fr.doranco.tpjsf2.utils.Dates;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "nom", value = "Gassa")
	private String nom;
	@ManagedProperty(name = "prenom", value = "Coolah")
	private String prenom;
	@ManagedProperty(name = "genre", value = "homme")
	private String genre;
	@ManagedProperty(name = "dateNaissance", value = "12/07/2000")
	private String dateNaissance;
	@ManagedProperty(name = "email", value = "Coolah@doranco.fr")
	private String email;
	@ManagedProperty(name = "niveauDeService", value = "premium")
	private String niveauDeService;
	@ManagedProperty(name = "password", value = "azertyui")
	private String password;
	@ManagedProperty(name = "passwordConfirm", value = "azertyui")
	private String passwordConfirm;
	@ManagedProperty(name = "numero", value = "10")
	private String numero;
	@ManagedProperty(name = "rue", value = "rue de Eclipse")
	private String rue;
	@ManagedProperty(name = "codePostal", value = "33000")
	private String codePostal;
	@ManagedProperty(name = "ville", value = "Bordeaux")
	private String ville;
	@ManagedProperty(name = "phone", value = "0612345678")
	private String phone;
	private String fonctionActuelle;
	private String disponibilite;
	@ManagedProperty(name = "disponibilite", value = "oui")
	private String langage;

	private Set<Address> addressesTemp;
	private IUserMetier userMetier = new UserMetier();

	private static String messageSuccess;
	private static String messageError;

	static {
		messageError = "";
		messageSuccess = "";
	}

	public UserBean() {
		this.addressesTemp = new HashSet<Address>();
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		try {
			users = userMetier.getUsers();
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la récupération de tous les utilisateurs !\n";
			e.printStackTrace();
		}
		return users;
	}

	public String addUser() {
		messageError = "";
		messageSuccess = "";
		if (!this.password.equals(passwordConfirm)) {
			this.messageError = "Les mots de passe ne concordent pas. Réessayez !";
			return "";
		}

		try {
			User user = new User( this.nom, this.prenom, this.genre, this.email, Dates.stringToDate(this.dateNaissance),
					this.niveauDeService, this.phone, this.fonctionActuelle, this.disponibilite, this.langage,
					this.password);
			for (Address addresse : addressesTemp) {
				user.getAddresses().add(addresse);
			}

			User addedUser = userMetier.addUser(user);

			this.nom = "";
			this.prenom = "";
			this.genre = "";
			this.email = "";
			this.dateNaissance = "";
			this.niveauDeService = "";
			this.phone = "";
			this.fonctionActuelle = "";
			this.disponibilite = "";
			this.langage = "";

			addressesTemp.clear();
			this.messageSuccess = "Utilisateur créé avec success ! id = " + addedUser.getId();
			this.messageError = "";

		} catch (Exception e) {
			this.messageSuccess = "";
			this.messageError = "Erreur lors de la creation de l'utilisateur !\n";
			e.printStackTrace();
		}
		return "";
	}

	public String addAdresse() {
		messageError = "";
		messageSuccess = "";
		try {
			Address address = new Address(this.numero, this.rue, this.codePostal, this.ville);
			this.addressesTemp.add(address);
			this.numero = "";
			this.rue = "";
			this.codePostal = "";
			this.ville = "";

			this.messageSuccess = "Adresse ajoutée avec success !";
			this.messageError = "";
			return "";

		} catch (Exception e) {
			this.messageSuccess = "";
			this.messageError = "Erreur lors de l'ajout de l'adresse !\n" + e.getMessage();
		}
		return "";
	}

	public List<String> getAllAddresses() {
		List<String> addressesSavedListStr = new ArrayList<String>();
		for (Address addrs : addressesTemp) {
			StringBuilder addressesSavedList = new StringBuilder();
			addressesSavedList.append(addrs.getNumero()).append(" ").append(addrs.getRue()).append(" ")
					.append(addrs.getCodePostal()).append(" ").append(addrs.getVille());
			addressesSavedListStr.add(addressesSavedList.toString());
		}
		return addressesSavedListStr;
	}

	public String getListAddressesInscrit(User user) {
		StringBuilder addressesSavedList = new StringBuilder();
		for (Address addrs : user.getAddresses()) {
			addressesSavedList.append(addrs.getNumero()).append(" ").append(addrs.getRue()).append(" ")
					.append(addrs.getCodePostal()).append(" ").append(addrs.getVille());
		}
		return addressesSavedList.toString();
	}

	public String deleteUser(User user) {
		messageError = "";
		messageSuccess = "";
		return "";
	}

	public String reset() {
		this.nom = "";
		this.prenom = "";
		this.genre = "";
		this.email = "";
		this.niveauDeService = "";
		this.dateNaissance = "";
		this.phone = "";
		this.fonctionActuelle = "";
		this.disponibilite = "";

		return "";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNiveauDeService() {
		return niveauDeService;
	}

	public void setNiveauDeService(String niveauDeService) {
		this.niveauDeService = niveauDeService;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFonctionActuelle() {
		return fonctionActuelle;
	}

	public void setFonctionActuelle(String fonctionActuelle) {
		this.fonctionActuelle = fonctionActuelle;
	}

	public String getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getLangage() {
		return langage;
	}

	public void setLangagesFavoris(String langage) {
		this.langage = langage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		UserBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		UserBean.messageError = messageError;
	}
}
