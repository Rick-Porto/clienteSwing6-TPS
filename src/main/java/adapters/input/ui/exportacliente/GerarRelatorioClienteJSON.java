package adapters.input.ui.exportacliente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Cliente;
import services.application.relatorio.GeraRelatorioClientePort;
import util.LocalDateAdapter;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

public class GerarRelatorioClienteJSON implements GeraRelatorioClientePort {

    @Override
    public void gerar(List<Cliente> clientes) throws Exception {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        String json = gson.toJson(clientes);

        File dir = new File("./relatorios");

        if (!dir.exists()) {
            dir.mkdirs(); // cria a pasta (e subpastas, se necessário)
        }

        File file = new File(dir, "clientes.json");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(json);
        }

        if (file.exists()) {
            Desktop.getDesktop().open(file);
        }
    }
}
