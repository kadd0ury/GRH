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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name="departement")

public class Dept {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	
	
	@Size(min = 3, message = "le minimum est 3 caractères pour le nom du département")
	@NotEmpty(message = "le nom du département ne doit pas être vide")
	@Pattern(regexp ="^[a-zA-Z]+$", message = "Veuillez entrer que des lettres")
	@Column(name = "nom")
	private String nom ;
	
	@Size(min = 3, message ="le minimum est 3 caractères pour le Supérieur du département")
	@NotEmpty(message = "le Supérieur du département ne doit pas être vide")
	@Pattern(regexp ="^[a-zA-Z]+$", message = "Veuillez entrer que des lettres")
	@Column(name = "sp")
	private String sup ;
	
	@Size(min = 6,max=6, message = "le code du département est de six caractère alphanumérique")
	@NotEmpty(message = "le code du département ne doit pas être vide")
	@Column(name = "code" )
	private String code ;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private List<Employee> Employees;


	
	
	

	





	
	

	
	
	
	
	
	
	
	
	

}
