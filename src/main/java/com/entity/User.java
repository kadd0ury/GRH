package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@Table(name="users")

public class User {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	

	@NotEmpty(message = "Veuillez entrer votre nom svp !")
	@Column(name = "nom")
	private String nom ;
	
	
	@Email(message="Veuillez entrer un email valide")
	@NotEmpty(message = "Email ne doit pas être vide")
    @Column(name = "email")
    private String email;
	
	
	
	
	
	@NotEmpty(message = "Veuillez entrer le role")
	@Column(name = "role")
	private String role ;
	
	@Pattern(regexp ="(^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[-+!*$@%_])([-+!*$@%_\\w]{8,15})$)", message = "Le mot de passe doit contenir au mois une lettre Maj et Min et un nombre et un caractères spécial et la taille entre 8 et 15 caractéres !")
	@Column(name = "password")
	@NotEmpty(message = "le mot de passe  ne doit pas être vide")
	private String password;
	


	
	
	

	





	
	

	
	
	
	
	
	
	
	
	

}
