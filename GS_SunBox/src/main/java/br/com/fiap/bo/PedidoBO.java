package br.com.fiap.bo;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.exception.PedidoException;
import br.com.fiap.model.Pedido;

public class PedidoBO {

	public void validarPedido(Pedido pedido) throws PedidoException {

		if (pedido == null || pedido.getItens() == null || pedido.getItens().isEmpty()) {
			throw new PedidoException("Pedido inválido: Nenhum item no pedido.");
		}

	}

	public double calcularTotal(Pedido pedido) {

		return pedido.getItens().stream().mapToDouble(item -> item.getPreco() * item.getQuantidade()).sum();
	}
	
	public void atualizarStatus(int id, String novoStatus) throws Exception {
	    PedidoDAO dao = new PedidoDAO();
	    Pedido pedido = dao.buscarPorId(id);

	    if (pedido == null) {
	        throw new Exception("Pedido não encontrado.");
	    }

	    pedido.setStatus(novoStatus);
	    dao.atualizar(pedido);
	}

	public void excluirPedido(int id) throws Exception {
	    PedidoDAO dao = new PedidoDAO();
	    Pedido pedido = dao.buscarPorId(id);

	    if (pedido == null) {
	        throw new Exception("Pedido não encontrado.");
	    }

	    dao.excluir(id);
	}

}
