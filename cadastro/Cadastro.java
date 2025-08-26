package cadastro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private static final String ARQUIVO = "pessoas.json";
    private List<Pessoa> pessoas;

    public Cadastro() {
        pessoas = carregar();
    }

    public void adicionar(Pessoa pessoa) {
        pessoas.add(pessoa);
        salvar();
    }

    public void listar() {
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }

    private void salvar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            writer.write("[\n");
            for (int i = 0; i < pessoas.size(); i++) {
                writer.write("  " + pessoas.get(i).toJson());
                if (i < pessoas.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Pessoa> carregar() {
        List<Pessoa> lista = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                sb.append(linha);
            }
            String conteudo = sb.toString().trim();

            if (conteudo.startsWith("[") && conteudo.endsWith("]")) {
                conteudo = conteudo.substring(1, conteudo.length() - 1); // remove []
                if (!conteudo.isEmpty()) {
                    String[] objetos = conteudo.split("},");
                    for (String obj : objetos) {
                        if (!obj.endsWith("}")) obj += "}";
                        lista.add(Pessoa.fromJson(obj));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
