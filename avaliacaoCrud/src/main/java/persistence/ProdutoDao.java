package persistence;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Produto;

public class ProdutoDao {
	
	EntityManager manager;
	EntityTransaction transaction;
	
	static EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("avaliacao");
	
	public ProdutoDao(){
		manager = factory.createEntityManager();
	}
	
	public void create(Produto p)throws Exception{
		transaction=manager.getTransaction();
		  transaction.begin();
		    manager.persist(p);
		  transaction.commit();
	}
	
	public void update(Produto p)throws Exception{
		transaction= manager.getTransaction();
		 transaction.begin();
		   manager.merge(p);
		 transaction.commit();
		
	}
	
	public void delete(Produto p)throws Exception{
		transaction= manager.getTransaction();
		 transaction.begin();
		   manager.remove(p);
		 transaction.commit();
		
		
	}
	
	public ArrayList<Produto>findAll(){
		return (ArrayList<Produto>) manager.createQuery("select obj from Produto as obj").getResultList();
	}
	
	public Produto findByCode(Integer cod){
		return manager.find(Produto.class, cod);
		}
	
	
}
