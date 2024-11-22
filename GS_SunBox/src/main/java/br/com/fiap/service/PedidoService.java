package br.com.fiap.service;

import java.util.List;

import br.com.fiap.bo.PedidoBO;
import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.exception.PedidoException;
import br.com.fiap.model.Pedido;

public class PedidoService {

	private PedidoDAO pedidoDAO = new PedidoDAO();
	private PedidoBO pedidoBO = new PedidoBO();

	public void criarPedido(Pedido pedido) throws PedidoException {
		pedidoBO.validarPedido(pedido);
		pedidoDAO.salvar(pedido);
	}

	public Pedido buscarPedido(int id) {
		return pedidoDAO.buscarPorId(id);
	}

	public List<Pedido> listarPedidos() {
		return pedidoDAO.listarTodos();
	}

	public void atualizarPedido(Pedido pedido) throws PedidoException {
		pedidoBO.validarPedido(pedido);
		pedidoDAO.atualizar(pedido);
	}

	public void deletarPedido(int id) {
		pedidoDAO.deletar(id);
	}
}
