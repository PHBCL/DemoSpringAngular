package cl.springmvcangular.controller;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cl.springmvcangular.bo.Usuario;
import cl.springmvcangular.dao.UsuarioDAO;
import cl.springmvcangular.dto.UsuarioDTO;
import cl.springmvcangular.factoring.DaoFactoring;
import cl.springmvcangular.jwtValidator.classes.GeneradorToken;

@RestController
@RequestMapping(value="usuarioService")
public class UsuarioRestController {
	
	@Autowired
	GeneradorToken generadorToken;
	
	
	@RequestMapping(value="Saludar", method= RequestMethod.GET)
	public ResponseEntity<String> Saludar(){
		System.out.println("En el servicio");
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson("Funciono"),HttpStatus.OK);
	}
	
	@RequestMapping(value="validarUsuario", method= RequestMethod.POST)
	public ResponseEntity<String> ValidarUsuario(@RequestBody UsuarioDTO usuarioReq){
		Gson gson = new Gson();
		Usuario usuario = DaoFactoring.getUsuarioDAO().validarUsuario(usuarioReq);	
		if(usuario != null){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR_OF_DAY, 8);
			return new ResponseEntity<String>(gson.toJson(generadorToken.generarToken(String.valueOf(usuario.getId()),
																					  "", 
																					  "", 
														  							  cal.getTimeInMillis())),
											  HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@RequestMapping(value="registrarUsuario", method= RequestMethod.POST)
	public ResponseEntity<String> RegistrarUsuario(@RequestBody UsuarioDTO usuario){
		Gson gson = new Gson();
		Usuario n_Usuario = new Usuario(usuario.getUsuario(),usuario.getContrasena());
		DaoFactoring.getUsuarioDAO().ingresarUsuario(n_Usuario);	
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 8);
		return new ResponseEntity<String>(gson.toJson(generadorToken.generarToken(String.valueOf(usuario.getId()),
																				  "", 
																				  "", 
													  							  cal.getTimeInMillis())),
										  HttpStatus.OK);
	}


	
	
	@RequestMapping(value="listaUsuario", method= RequestMethod.GET)
	public ResponseEntity<String> listaUsuario(){
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson(DaoFactoring.getUsuarioDAO().obtenerUsuario()),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="eliminarUsuario", method= RequestMethod.POST)
	public ResponseEntity<String> EliminarUsuario(@RequestBody UsuarioDTO usuario){
		DaoFactoring.getUsuarioDAO().eliminarUsuario(DaoFactoring.getUsuarioDAO().obtenerUsuarioById(usuario.getId()));
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
