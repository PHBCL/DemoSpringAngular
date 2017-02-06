package cl.springmvcangular.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.gson.Gson;

import cl.springmvcangular.bo.Usuario;
import cl.springmvcangular.dao.UsuarioDAO;
import cl.springmvcangular.dto.UsuarioDTO;

@RestController
@RequestMapping(value="usuarioService")
public class UsuarioRestController {
	
	@RequestMapping(value="Saludar", method= RequestMethod.GET)
	public ResponseEntity<String> Saludar(){
		System.out.println("En el servicio");
		Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson("Funciono"),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="RegistrarUsuario", method= RequestMethod.POST)
	public ResponseEntity<String> RegistrarUsuario(@RequestBody UsuarioDTO usuario){
		Gson gson = new Gson();
		Usuario n_Usuario = new Usuario(usuario.getNombre());
		UsuarioDAO dao = new UsuarioDAO();
		dao.ingresarUsuario(n_Usuario);	
		
		
		
		
		
	}
	

	@RequestMapping(value="listaUsuario", method= RequestMethod.GET)
	public ResponseEntity<String> listaUsuario(){
		Gson gson = new Gson();
		UsuarioDAO dao = new UsuarioDAO();
		return new ResponseEntity<String>(gson.toJson(dao.obtenerUsuario()),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="eliminarUsuario", method= RequestMethod.POST)
	public ResponseEntity<String> EliminarUsuario(@RequestBody UsuarioDTO usuario){
		Gson gson = new Gson();
		Usuario n_Usuario = new Usuario(usuario.getNombre());
		UsuarioDAO dao = new UsuarioDAO();
		dao.eliminarUsuario(dao.obtenerUsuarioById(usuario.getId()));
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
