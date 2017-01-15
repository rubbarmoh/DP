package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;



@Entity
@Access(AccessType.PROPERTY)
public class TipoPlato extends DomainEntity{
	
	// Constructors ---------------------------------------
	public TipoPlato(){
		super();
	}
	
	//Attributes ------------------------------------------
	private String tipoPlato;
	
	@NotBlank
	public String getTipoPlato() {
		return tipoPlato;
	}
	public void setTipoPlato(String tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	
	// Relationships -------------------------------------
	private Menu menu;
	private Recipe recipe;
	
	@Valid
	@ManyToOne(optional=false)
	public Menu getMenu(){
		return menu;
	}
	public void setMenu(Menu menu){
		this.menu=menu;
	}
	
	@Valid
	@ManyToOne(optional=false)
	public Recipe getRecipe(){
		return recipe;
	}
	public void setRecipe(Recipe recipe){
		this.recipe = recipe;
	}
	
	
}
