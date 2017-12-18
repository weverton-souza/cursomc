
package com.weverton.cursomc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.weverton.cursomc.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private EstadoPagamento estado;
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {

	}

	public Pagamento(Integer id, EstadoPagamento estado) {

		super();
		this.id = id;
		this.estado = estado;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public EstadoPagamento getEstado() {

		return estado;
	}

	public void setEstado(EstadoPagamento estado) {

		this.estado = estado;
	}

	public Pedido getPedido() {

		return pedido;
	}

	public void setPedido(Pedido pedido) {

		this.pedido = pedido;
	}

}
