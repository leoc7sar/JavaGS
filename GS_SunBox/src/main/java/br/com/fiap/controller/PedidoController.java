package br.com.fiap.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

import br.com.fiap.bo.PedidoBO;
import br.com.fiap.model.Pedido;
import br.com.fiap.service.PedidoService;

public class PedidoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cliente = request.getParameter("cliente");

		PedidoService pedidoService = new PedidoService();
		try {
			Pedido pedido = new Pedido(); // Assumindo que existe um construtor Pedido(String cliente)
			pedidoService.criarPedido(pedido);
			response.sendRedirect("success.jsp");
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Implementar lógica se necessário
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parse ID do pedido e novos dados do pedido
		int id = Integer.parseInt(request.getParameter("id"));
		String novoStatus = request.getParameter("status");

		// Atualizar pedido via PedidoBO
		PedidoBO bo = new PedidoBO();
		try {
			bo.atualizarStatus(id, novoStatus);
			response.setStatus(HttpServletResponse.SC_OK); // 200 OK
			response.getWriter().write("Pedido atualizado com sucesso!");
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
			response.getWriter().write("Erro ao atualizar o pedido: " + e.getMessage());
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parse ID do pedido
		int id = Integer.parseInt(request.getParameter("id"));

		// Excluir pedido via PedidoBO
		PedidoBO bo = new PedidoBO();
		try {
			bo.excluirPedido(id);
			response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204 No Content
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
			response.getWriter().write("Erro ao excluir o pedido: " + e.getMessage());
		}
	}

}
