package sgf;

public interface Rh {
    void adicionarFuncionario(String nome, Funcionario.Cargo cargo);
    void demitirFuncionario(Funcionario funcionario);
    void atualizarFuncionario(Funcionario funcionario, String nome, Funcionario.Cargo cargo);
    void detalhesFuncionario(Funcionario funcionario);
    void listarFuncionarios();
    void listarFuncionarios(boolean estaDemitido);
    boolean funcionarioExiste(int id);
}
