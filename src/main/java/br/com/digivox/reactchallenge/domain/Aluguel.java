package br.com.digivox.reactchallenge.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.digivox.reactchallenge.enums.AluguelStatus;

@Entity
public class Aluguel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	private Livro livro;
	
	private Date dataDeCriacao;
	
	private Date dataDeRetirada;
	
	private Date dataDeDevolucao;
	
	private Date dataPrevistaParaDevolucao;
	
	private AluguelStatus status;
	
	public Aluguel() {
		
	}

	public Aluguel(Cliente cliente, Livro livro, Date dataDeCriacao, Date dataDeRetirada, Date dataDeDevolucao) {
		super();
		this.cliente = cliente;
		this.livro = livro;
		this.dataDeCriacao = dataDeCriacao;
		this.dataDeRetirada = dataDeRetirada;
		this.dataDeDevolucao = dataDeDevolucao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivros(Livro livro) {
		this.livro = livro;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Date getDataDeRetirada() {
		return dataDeRetirada;
	}

	public void setDataDeRetirade(Date dataDeretirada) {
		this.dataDeRetirada = dataDeretirada;
	}

	public Integer getId() {
		return id;
	}

	public Date getDataDeDevolucao() {
		return dataDeDevolucao;
	}

	public void setDataDeDevolucao(Date dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}

	public AluguelStatus getStatus() {
		return status;
	}

	public void setStatus(AluguelStatus status) {
		this.status = status;
	}

	public Date getDataPrevistaParaDevolucao() {
		return dataPrevistaParaDevolucao;
	}

	public void setDataPrevistaParaDevolucao(Date dataPrevistaParaDevolucao) {
		this.dataPrevistaParaDevolucao = dataPrevistaParaDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
