package fr.doranco.tpjsf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nom;
	private String prenom;
	private String genre;
	private Date dateNaissance;
	private String email;
	private String niveauDeService;
	private String phone;
	private String fonctionActuelle;
	private String disponibilite;
	private String langage;
	private List<Address> addresses;
	private String password;

	public User() {
		this.addresses = new ArrayList<Address>();
	}

	public User( String nom, String prenom, String genre, String email, Date dateNaissance, String niveauDeService,
			String phone, String fonctionActuelle, String disponibilite, String langage, String password) {
		this.prenom = prenom;
		this.nom = nom;
		this.genre = genre;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.niveauDeService = niveauDeService;
		this.phone = phone;
		this.fonctionActuelle = fonctionActuelle;
		this.disponibilite = disponibilite;
		this.langage = langage;
		this.password = password;
		this.addresses = new ArrayList<Address>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
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

	public void setLangage(String langage) {
		this.langage = langage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return addresses;
	}
}
