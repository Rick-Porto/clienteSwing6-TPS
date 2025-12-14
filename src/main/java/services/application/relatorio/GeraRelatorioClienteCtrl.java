package services.application.relatorio;

import model.Cliente;
import services.domain.persistence.ClienteRepository;
import services.domain.persistence.RepositoryPool;

import java.util.Comparator;
import java.util.List;

public class GeraRelatorioClienteCtrl {
    private final GeraRelatorioClientePort relatorioPort;

    public GeraRelatorioClienteCtrl(GeraRelatorioClientePort relatorioPort) {
        this.relatorioPort = relatorioPort;
    }

    public void executar() throws Exception {
        var repo = RepositoryPool.acquire(ClienteRepository.class);

        List<Cliente> clientes = repo.findAll();

        clientes.sort(Comparator.comparing(c -> c.getCpf().numero()));

        relatorioPort.gerar(clientes);
    }
}
