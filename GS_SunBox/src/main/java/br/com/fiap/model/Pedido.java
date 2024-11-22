package br.com.fiap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private List<Item> itens;

	public Pedido() {
		itens = new ArrayList<>();
		inicializarItensSunBox();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	private void inicializarItensSunBox() {
		itens.add(new Item("SunBox Pequeno", 100.0, 1));
		itens.add(new Item("SunBox Médio", 150.0, 1));
		itens.add(new Item("SunBox Grande", 200.0, 1));
	}

	public void setStatus(String novoStatus) {
		// TODO Auto-generated method stub
		
	}

	public int getClienteId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Date getDataPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
