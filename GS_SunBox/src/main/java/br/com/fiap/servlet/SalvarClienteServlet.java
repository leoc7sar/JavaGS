package br.com.fiap.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/salvarCliente")
public class SalvarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        // Lógica para salvar o cliente e a quantidade de itens SunBox
        // Exemplo: salvar no banco de dados ou processar os dados

        // Redirecionar para a página de sucesso
        response.sendRedirect("sucesso.jsp");
    }
}
