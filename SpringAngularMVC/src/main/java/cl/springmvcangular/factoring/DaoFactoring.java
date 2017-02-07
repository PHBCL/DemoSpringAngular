package cl.springmvcangular.factoring;

import cl.springmvcangular.dao.UsuarioDAO;

public class DaoFactoring {
	
	private static UsuarioDAO usuarioDAO;
	
	public static UsuarioDAO getUsuarioDAO(){
		if(usuarioDAO == null)
			usuarioDAO= new UsuarioDAO();
		return usuarioDAO;
	}
}