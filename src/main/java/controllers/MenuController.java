package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Menu;

import services.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController extends AbstractController{
	
	//Services --------------------------------------
	@Autowired
	private MenuService menuService;
	
	//Constructor ----------------------------------
	public MenuController(){
		super();
	}
	
	// List ----------------------------------------
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result;
		Collection<Menu> menus;
		menus = menuService.findAll();
		result = new ModelAndView("menu/list");
		result.addObject("menus", menus);
		return result;
	}
}
