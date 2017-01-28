package cl.springmvcangular.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="usuarioService")
public class UsuarioRestController {
	
	@RequestMapping(value="Saludar", method= RequestMethod.GET)
	public String Saludar(){
		return "Hola desde Rest Service";
	}
	

}
