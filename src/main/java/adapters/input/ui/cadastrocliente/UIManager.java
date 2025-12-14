package adapters.input.ui.cadastrocliente;

import services.application.cep.CEPPort;
import services.application.cliente.CadastroClientePort;
import services.application.uf.UFPort;

public class UIManager {

    public static void run(CadastroClientePort cadastroService, CEPPort cepService, UFPort ufService) {
        new MainWindow(cadastroService, cepService, ufService);
    }
}
