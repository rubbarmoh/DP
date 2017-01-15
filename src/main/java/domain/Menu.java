package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Menu extends DomainEntity{

	// Constructor --------------------------------------------
	public Menu() {
		super();
	}
	
	// Attributes -------------------------------------------
	private String random;
	
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp="^(\\d{3})[-]([a-zA-Z]{4})")
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	
	// Relationships -------------------------------------------
	private User user;
	private Collection<TipoPlato> tipoPlatos;
	
	@Valid
	@ManyToOne(optional=false)
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	
	@Valid
	@OneToMany(mappedBy="menu")
	public Collection<TipoPlato> getTipoPlatos(){
		return tipoPlatos;
	}
	public void setTipoPlatos(Collection<TipoPlato> tipoPlatos){
		this.tipoPlatos=tipoPlatos;
	}
	
	

}
