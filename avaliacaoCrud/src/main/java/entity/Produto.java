package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyy");
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer idProduto;
	@NotEmpty(message = "Nome do produto obrigatorio")
	@Column(length=50, unique=true)
	private String nome;
	@Min(1)	
	@Column	
	private Double preco;
	@Min(1)
	@Column	
	private Integer quantidade;	
	@NotNull(message = "coloque a data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	public Produto() {
		
	}

	public Produto(Integer idProduto, String nome, Double preco, Integer quantidade, Date dataCadastro) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade
				+ ", dataCadastro=" + SDF.format(dataCadastro) + "]";
	}

	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	

}
