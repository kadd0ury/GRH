package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name ="renumeration")
public class Renum {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	
	@NotEmpty(message = "le Nom ne doit pas être vide")
	@Column(name = "nom")
    private String nom;
	
	
	@NotEmpty(message = "Veuillez entrer la description de la rénumération")
	@Column(name = "description")
    private String description;
	
	
	@NotEmpty(message = "Veuillez entrer le code  de la rénumération")
	@Column(name = "code")
    private String code;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "renum_id")
	private List<Employee> Employees;
	

	
	
	

	

	
	
    
	
	
	
	
	
	
	
	

}
