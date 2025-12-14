package services.application.relatorio;

import model.Cliente;

import java.time.format.DateTimeFormatter;

public class ClienteFormatacao {
    private static final DateTimeFormatter DATA_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /*
     * =====================
     * CPF
     * =====================
     */
    public static String cpf(Cliente c) {
        long num = c.getCpf().numero();
        String s = String.format("%011d", num);

        return s.substring(0, 3) + "." +
                s.substring(3, 6) + "." +
                s.substring(6, 9) + "-" +
                s.substring(9, 11);
    }

    /*
     * =====================
     * Data
     * =====================
     */
    public static String dataNascimento(Cliente c) {
        return c.getDataNasc().format(DATA_FMT);
    }

    /*
     * =====================
     * Endereço (texto)
     * =====================
     */
    public static String endereco(Cliente c) {
        var e = c.getEndereco();

        String cep = String.format("%08d", e.getCEP());
        cep = cep.substring(0, 5) + "-" + cep.substring(5);

        return e.getLogradouro() + ", " + e.getNumero() +
                (e.getComplemento() != null && !e.getComplemento().isBlank()
                        ? " - " + e.getComplemento()
                        : "")
                +
                "\n" + e.getBairro() + " - " + e.getCidade() +
                "\n" + cep + " - " + e.getUf().getSigla();
    }

    /*
     * =====================
     * Endereço (HTML)
     * =====================
     */
    public static String enderecoHtml(Cliente c) {
        return endereco(c).replace("\n", "<br>");
    }

    /*
     * =====================
     * Telefone
     * =====================
     */
    public static String telefone(Cliente c) {
        var t = c.getTelefone();

        String num = String.format("%09d", t.getNumero());

        return "(" + t.getDdd() + ") " +
                num.substring(0, 5) + "-" +
                num.substring(5);
    }
}
