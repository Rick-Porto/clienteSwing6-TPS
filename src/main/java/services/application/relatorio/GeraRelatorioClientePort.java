package services.application.relatorio;

import model.Cliente;
import java.util.List;

public interface GeraRelatorioClientePort {
    void gerar(List<Cliente> clientes) throws Exception;
}