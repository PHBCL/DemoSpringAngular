package cl.springmvcangular.dao;

import org.hibernate.Session;

import cl.springmvcangular.bo.Usuario;
import cl.springmvcangular.factoring.HibernateFactoring;

public class UsuarioDAO {
	
	public void ingresarUsuario(Usuario usuario){
		Session session =  HibernateFactoring.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			session.getTransaction().rollback();
			System.out.println(ex.getMessage());
		}
	}
}
