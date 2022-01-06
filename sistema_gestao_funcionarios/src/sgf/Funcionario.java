package sgf;

public class Funcionario {
    enum Cargo{
        COLABORADOR,
        LIDER_TECNICO,
        GERENTE_GERAL,
        GERENTE_DEPARTAMENTO;
    }
    private int        id;
    private String     nome;
    private Cargo      cargo;
    private boolean    estaDemitido;
    private static int totalFuncionarios;

    public Funcionario(String nome, Cargo cargo) {
        this.nome         = nome;
        this.cargo        = cargo;
        this.estaDemitido = false;
        this.id           = totalFuncionarios++;
    }

    public String getDetalhes() {
        return "nome='" + nome + '\'' + ", cargo=" + cargo + ", " + (estaDemitido ? "Demitido" : "Trabalhando");
    }

    @Override
    public String toString() {
        return "id=" + id + " nome='" + nome + '\'' + ", cargo=" + cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isEstaDemitido() {
        return estaDemitido;
    }

    public void setEstaDemitido(boolean estaDemitido) {
        this.estaDemitido = estaDemitido;
    }

}
