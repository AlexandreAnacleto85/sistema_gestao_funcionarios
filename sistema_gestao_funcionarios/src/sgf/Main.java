package sgf;

import java.util.Scanner;

public class Main {
    static Scanner sc      = new Scanner(System.in);
    static Empresa empresa = new Empresa();

    static void add_Funcionario(){
        empresa.adicionarFuncionario(inputNome(), inputCargo());
    }

    static void detalharFuncionario(){
        Funcionario funcionario = inputFuncionario();
        if (funcionario != null)
            empresa.detalhesFuncionario(funcionario);
    }

    static void demitirFuncionario(){
        Funcionario funcionario = inputFuncionario();
        if (funcionario != null)
            empresa.demitirFuncionario(funcionario);
    }
    static void atualizarFuncionario(){
        Funcionario funcionario = inputFuncionario();
        if (funcionario == null) return;
        String menu = """
                ============== OPÇÕES ================                       
                1 Atualizar nome
                2 Atualizar cargo
                3 Sair
                ======================================
                Opcao:""";

        String nome             = funcionario.getNome();
        Funcionario.Cargo cargo = funcionario.getCargo();

        int opcao = 0;
        while (opcao != 3){
            System.out.print(menu);
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Nome atual: "+ nome);
                    nome = inputNome();
                    break;
                case 2:
                    System.out.println("Cargo atual: "+ cargo);
                    cargo = inputCargo();
                    break;
                case 3:
                    empresa.atualizarFuncionario(funcionario, nome, cargo);
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }

    static Funcionario inputFuncionario(){
        System.out.print("Digite o id do funcionário: ");
        int id = sc.nextInt();

        if (empresa.funcionarioExiste(id))
            return empresa.getFuncionario(id);
        else
            System.out.println("Funcionario não existe");

        return null;
    }

    static Funcionario.Cargo inputCargo(){
        String cargos = """
                ============== CARGOS ================                       
                1 - Gerente Geral
                2 - Gerente de departamento
                3 - Lider tecnico
                4 - Colaborador
                ======================================  
                Opcao:""";

        int opcao = 0;
        while (opcao > 4 || opcao < 1){
            System.out.print(cargos);
            opcao = sc.nextInt();
        }
        return switch (opcao){
            case 1 -> Funcionario.Cargo.GERENTE_GERAL;
            case 2 -> Funcionario.Cargo.GERENTE_DEPARTAMENTO;
            case 3 -> Funcionario.Cargo.LIDER_TECNICO;
            case 4 -> Funcionario.Cargo.COLABORADOR;
            default -> throw new IllegalStateException("Unexpected value: " + opcao);
        };
    }

    static String inputNome(){
        System.out.print("Digite o nome do funcionario: ");
        sc.nextLine();
        return sc.nextLine();
    }

    public static void main(String[] args) {
        String menu = """
                     ============== MENU ================                        
                    1 - Adicionar funcionário
                    2 - Detalhar funcionário
                    3 - Demitir funcionário
                    4 - Atualizar funcionário
                    5 - Listar todos os funcionários
                    6 - Listar funcionários trabalhando
                    7 - Listar funcionários demitidos
                    8 - Sair
                    =====================================  
                    Opcao:""";

        int opcao = 0;
        while (opcao != 8) {
            System.out.print(menu);
            opcao = sc.nextInt();
            switch (opcao){
                case 1: add_Funcionario();
                    break;
                case 2: detalharFuncionario();
                    break;
                case 3: demitirFuncionario();
                    break;
                case 4: atualizarFuncionario();
                    break;
                case 5: empresa.listarFuncionarios();
                    break;
                case 6: empresa.listarFuncionarios(false);
                    break;
                case 7: empresa.listarFuncionarios(true);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opcao inválida");
            }
        }
    }
}
