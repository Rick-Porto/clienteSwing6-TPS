package adapters.input.ui.cadastrocliente;

import services.application.cliente.CadastroClientePort;
import services.application.relatorio.ClienteFormatacao;

import javax.swing.*;

import model.Cliente;

import java.awt.*;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class ListaClientesView extends JPanel {

    private final JEditorPane pnListaClientes;

    public ListaClientesView() {

        setLayout(new BorderLayout());

        pnListaClientes = new JEditorPane();
        pnListaClientes.setContentType("text/html");

        add(new JScrollPane(pnListaClientes), BorderLayout.CENTER);
    }

    public void apresentarDados(List<Cliente> clientes) {
        var builder = new StringBuilder();

        builder.append(
                "<html><body><table border='1'><tr><th>CPF</th><th>Nome</th><th>Data de Nascimento</th><th>Endereço</th><th>Telefone</th></tr>");

        for (Cliente cliente : clientes) {
           
            // HTML
            builder.append("<tr>");
            builder.append("<td>").append(ClienteFormatacao.cpf(cliente)).append("</td>");
            builder.append("<td>").append(cliente.getNome()).append("</td>");
            builder.append("<td>").append(ClienteFormatacao.dataNascimento(cliente)).append("</td>");
            builder.append("<td>").append(ClienteFormatacao.enderecoHtml(cliente)).append("</td>");
            builder.append("<td>").append(ClienteFormatacao.telefone(cliente)).append("</td>");
            builder.append("</tr>");
        }

        builder.append("</table></body></html>");

        pnListaClientes.setText(builder.toString());
    }
}
