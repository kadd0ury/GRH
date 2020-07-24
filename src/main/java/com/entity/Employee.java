package com.entity;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;






@Entity
@Table(name = "employees")
public class Employee{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	
	@NotEmpty(message = "le Prénom ne doit pas être vide")
	@Column(name = "first_name")
    private String firstName;
	
	
	@NotEmpty(message = "le Nom ne doit pas être vide")
    @Column(name = "last_name")
    private String lastName;
	
	@Email(message="Veuillez entrer un email valide")
	@NotEmpty(message = "Email ne doit pas être vide")
    @Column(name = "email")
    private String email;
	
	
	@Pattern(regexp ="(^(0)(6|7|5)[0-9]{8}$)", message = "Votre numéro de téléphone doit respecter les formats du Téléphone marrocain ")
	@Size(max=10,min=10,message="votre numéro de téléphone doit contenir 10 chiffres")
	@NotEmpty(message = "le Téléphone ne doit pas être vide")
    @Column(name = "numTele")
    private String tele;
	
	

	@NotEmpty(message = "Veuillez saisir votre adresse ")
    @Column(name = "adresse")
    private String adresse;
	
	@NotEmpty(message = "Veuillez saisir votre salaire ")
    @Column(name = "salaire")
    private String salaire;
	
	
	
	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	@NotEmpty(message = "Veuillez choisir votre grade ")
	@Column(name = "grade")
	private String grade ;
	

	@Column(name = "manager")
	private String manager="-" ;
	
	
	@Column(name = "sup")
	private String sup="-" ;
	
	
	@ManyToOne
	private Dept dept;
	
	
	@ManyToOne
	private Renum reum;
	
	public Renum getReum() {
		return reum;
	}

	public void setReum(Renum reum) {
		this.reum = reum;
	}

	public int getMyRenum() {
		return myRenum;
	}

	public void setMyRenum(int myRenum) {
		this.myRenum = myRenum;
	}

	@Transient
	private int myDept;
	
	@Transient
	private int myRenum;
	

	
	
	public int getMyDept() {
		return myDept;
	}

	public void setMyDept(int myDept) {
		this.myDept = myDept;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getSup() {
		return sup;
	}

	public void setSup(String sup) {
		this.sup = sup;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}



	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

    
    
    

    
    
    public Employee() {

    }
    
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
