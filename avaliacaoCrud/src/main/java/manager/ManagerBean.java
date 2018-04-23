package manager;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Produto;
import persistence.ProdutoDao;

@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean implements Serializable{
       private static final long serialVersionUID = 1L;
       
       
      private Produto produto = new Produto();
      private ProdutoDao dao = new ProdutoDao();
      private ArrayList<Produto> lista;
       
       public ManagerBean() {
    	   produto = new Produto();
    	   dao = new ProdutoDao();
    	   lista = new ArrayList<>();
    	   
    	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDao getDao() {
		return dao;
	}

	public void setDao(ProdutoDao dao) {
		this.dao = dao;
	}

	public ArrayList<Produto> getLista() {
		lista = dao.findAll();
		return lista;
	}

	public void setLista(ArrayList<Produto> lista) {
		this.lista = lista;
	}
	
	public void listar() {	
		lista = dao.findAll();
	}
	
	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
			dao.create(produto);
			produto = new Produto();
		fc.addMessage(null, new FacesMessage("Dados Gravados..."));		
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: " + ex.getMessage()));
		}
	}
	
	
	public String excluir(Produto produto){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dao.delete(produto);
			listar();
		fc.addMessage(null, new FacesMessage("Dados Excluidos..."));			
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: " + ex.getMessage()));
		}
		return "gravar";          
	}
	
	public void alterar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
			dao.update(produto);
			listar();
		fc.addMessage(null, new FacesMessage("Dados Gravados..."));		
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error: " + ex.getMessage()));
		}
	}
       

}
