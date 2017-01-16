package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Menu;

import repositories.MenuRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class MenuService {

	// Managed repository ------------------------------------
	
	@Autowired
	private MenuRepository menuRepository;

	// Supporting services ------------------------------
	
	@Autowired
	private UserService userService;
	
	// Constructors --------------------------------------
	public MenuService() {
		super();
	}
	
	// Simple CRUD methods ------------------------------

	public Menu create(){
		Menu menu = new Menu();
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Authority au = new Authority();
		au.setAuthority("USER");
		Assert.isTrue(userAccount.getAuthorities().contains(au));
		
		Assert.notNull(menu);
		
		menu = new Menu();
		return menu;
	}
	
	public Collection<Menu> findAll(){
		Collection<Menu> result;
		
		result = menuRepository.findAll();
		return result;
	}
	
	public Menu findOne(int menuId) {
		Menu result;

		result = menuRepository.findOne(menuId);
		Assert.notNull(result);

		return result;
	} 
	
	public Menu save (Menu menu){
		Menu result;
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Authority au = new Authority();
		au.setAuthority("USER");
		Assert.isTrue(userAccount.getAuthorities().contains(au));
		
		Assert.notNull(menu);

		menu.setUser(userService.findByPrincipal());
		result = menuRepository.save(menu);
		return result;
	}
	
	public void delete(Menu menu){
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Authority au = new Authority();
		au.setAuthority("USER");
		Assert.isTrue(userAccount.getAuthorities().contains(au));
		
		Assert.notNull(menu);
		
		menuRepository.delete(menu);
	}
	
	//Other business methods ---------------------------------
	
	
}
