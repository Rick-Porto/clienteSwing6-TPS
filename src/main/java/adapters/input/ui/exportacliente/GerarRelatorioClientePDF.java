package adapters.input.ui.exportacliente;

import com.itextpdf.text.*;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Cliente;
import services.application.relatorio.ClienteFormatacao;
import services.application.relatorio.GeraRelatorioClientePort;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GerarRelatorioClientePDF implements GeraRelatorioClientePort {

    @Override
    public void gerar(List<Cliente> clientes) throws Exception {

        Document document = new Document(PageSize.A4.rotate());
        File dir = new File("./relatorios");

        if (!dir.exists()) {
            dir.mkdirs(); // cria a pasta (e subpastas, se necessário)
        }

        File file = new File(dir, "clientes.pdf");

        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        var title = new Paragraph(
                "Relatório de Clientes",
                FontFactory.getFont(FontFactory.HELVETICA, 20));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(new float[] { 15, 25, 15, 30, 15 });
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);

        addHeader(table);
        addRows(table, clientes);

        document.add(table);
        document.close();

        Desktop.getDesktop().open(file);
    }

    private void addHeader(PdfPTable table) {
        List.of("CPF", "Nome", "Data de nascimento", "Endereço", "Telefone")
                .forEach(h -> {
                    PdfPCell cell = new PdfPCell(new Phrase(h));
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                });
    }

    private void addRows(PdfPTable table, List<Cliente> clientes) {
        var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Cliente c : clientes) {
            table.addCell(ClienteFormatacao.cpf(c));
            table.addCell(c.getNome());
            table.addCell(c.getDataNasc().format(dtf));
            table.addCell(ClienteFormatacao.endereco(c));
            table.addCell(ClienteFormatacao.telefone(c));
        }
    }
}
