package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Menu;
import domain.Recipe;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
public class MenuServiceTest extends AbstractTest{

	//Service under test ---------------------------------
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	
	//Tests ----------------------------------------------
	//Positive -------------------------------------------
	@Test
	public void testCreate(){
		super.authenticate("user1");
		Menu m;
		m=menuService.create();
		Assert.notNull(m);
		super.authenticate(null);
	}
	
	@Test
	public void testSave(){
		Collection<Menu> menus;
		Menu m, saved;
		super.authenticate("user1");
		m=menuService.create();
		m.setRandom("125-EDSC");
		m.setUser(userService.findByPrincipal());
		saved = menuService.save(m);
		menus = menuService.findAll();
		Assert.isTrue(menus.contains(saved));
	}
	
	@Test
	public void testFindAll(){
		Collection<Menu>menus;
		menus=menuService.findAll();
		Assert.notNull(menus);	
	}
	
	@Test
	public void testFindOne(){
		Menu m;
		m = menuService.findOne(202);
		Assert.notNull(m);
	}
	
	@Test
	public void testDelete(){
		Collection<Menu> menus;
		Menu m, saved;
		super.authenticate("user1");
		m=menuService.create();
		m.setRandom("125-EDSC");
		m.setUser(userService.findByPrincipal());
		saved = menuService.save(m);
		menuService.delete(saved);
		menus = menuService.findAll();
		Assert.isTrue(!menus.contains(saved));
	}
	
}
