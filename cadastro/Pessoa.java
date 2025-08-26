package cadastro;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;

    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }


    public String toJson() {
        return String.format("{\"nome\":\"%s\",\"idade\":%d}",
                nome, idade);
    }

    public static Pessoa fromJson(String json) {
        json = json.trim().replace("{", "");

        String[] campos = json.split(",");
        String nome = "";
        int idade = 0;

        for (String campo : campos) {
            String[] chaveValor = campo.split(":");
            String chave = chaveValor[0].replace("\"", "").trim();
            String valor = chaveValor[1].replace("\"", "").trim();

            
    @Override
    public String toString() {
        return nome + " (" + idade + " anos) ";
    }
}
