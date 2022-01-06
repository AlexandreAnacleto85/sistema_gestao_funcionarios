package sgf;

import java.util.ArrayList;

public class Empresa implements Rh{
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    @Override
    public void adicionarFuncionario(String nome, Funcionario.Cargo cargo) {
        this.funcionarios.add(new Funcionario(nome, cargo));
    }

    @Override
    public void demitirFuncionario(Funcionario funcionario) {
        funcionario.setEstaDemitido(true);
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario, String nome, Funcionario.Cargo cargo) {
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
    }

    @Override
    public void detalhesFuncionario(Funcionario funcionario) {
        System.out.println(
                funcionario.getDetalhes()
        );
    }

    @Override
    public void listarFuncionarios() {
        for (Funcionario funcionario : this.funcionarios)
            System.out.println(funcionario);
    }

    @Override
    public void listarFuncionarios(boolean estaDemitido) {
        for (Funcionario funcionario : this.funcionarios)
            if (funcionario.isEstaDemitido() == estaDemitido)
                System.out.println(funcionario);
    }

    @Override
    public boolean funcionarioExiste(int id) {
        try {
            this.funcionarios.get(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Funcionario getFuncionario(int id){
        return this.funcionarios.get(id);
    }
}
