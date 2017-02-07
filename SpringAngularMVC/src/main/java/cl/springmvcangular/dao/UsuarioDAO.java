package cl.springmvcangular.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import cl.springmvcangular.bo.Usuario;
import cl.springmvcangular.dto.UsuarioDTO;
import cl.springmvcangular.factoring.HibernateFactoring;

public class UsuarioDAO {
	
	public Usuario validarUsuario(UsuarioDTO usuarioReq){
		Session session =  HibernateFactoring.getSessionFactory().openSession();
		try{
		Query query = session.createQuery("from Usuario where nombre=:nombre and contrasena=:contrasena ");
		query.setString("nombre", usuarioReq.getUsuario());
		query.setString("contrasena", usuarioReq.getContrasena());
		return (Usuario)query.list().get(0);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
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
	
	public void eliminarUsuario(Usuario usuario){
		Session session =  HibernateFactoring.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			session.getTransaction().rollback();
			System.out.println(ex.getMessage());
		}
	}
	
	
	public ArrayList<Usuario> obtenerUsuario(){
		Session session =  HibernateFactoring.getSessionFactory().openSession();
		try{
			Query query = session.createQuery("from Usuario");
			return (ArrayList<Usuario>)query.list();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	

	public Usuario obtenerUsuarioById(int codigo){
		Session session =  HibernateFactoring.getSessionFactory().openSession();
		try{
			Query query = session.createQuery("from Usuario where id = :id");
			query.setInteger("id", codigo);
			return (Usuario)query.list().get(0);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
