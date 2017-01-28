package cl.springmvcangular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.springmvcangular.bo.Usuario;
import cl.springmvcangular.dao.UsuarioDAO;

@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario(name);
		dao.ingresarUsuario(usuario);
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
