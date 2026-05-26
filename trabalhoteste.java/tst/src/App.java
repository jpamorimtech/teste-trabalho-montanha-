import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // LISTAS DOS QUARTOS
        ArrayList<Integer> numerosQuartos = new ArrayList<Integer>();
        ArrayList<Integer> capacidadeQuartos = new ArrayList<Integer>();

        // LISTAS DOS MORADORES
        ArrayList<String> nomes = new ArrayList<String>();
        ArrayList<String> cpfs = new ArrayList<String>();
        ArrayList<String> cursos = new ArrayList<String>();
        ArrayList<Integer> quartosMoradores = new ArrayList<Integer>();
        ArrayList<String> funcoes = new ArrayList<String>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n====================================");
            System.out.println(" SISTEMA DE REPÚBLICA ESTUDANTIL ");
            System.out.println("====================================");
            System.out.println("1 - Cadastrar quarto");
            System.out.println("2 - Listar quartos");
            System.out.println("3 - Cadastrar morador");
            System.out.println("4 - Listar moradores");
            System.out.println("5 - Remover morador");
            System.out.println("6 - Ver ocupação dos quartos");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            // CADASTRAR QUARTO
            if (opcao == 1) {

                System.out.print("\nNúmero do quarto: ");
                int numeroQuarto = scanner.nextInt();

                boolean quartoExiste = false;

                for (int i = 0; i < numerosQuartos.size(); i++) {

                    if (numerosQuartos.get(i) == numeroQuarto) {
                        quartoExiste = true;
                    }
                }

                if (quartoExiste == true) {

                    System.out.println("\nQuarto já cadastrado.");

                } else {

                    System.out.print("Capacidade máxima do quarto: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();

                    numerosQuartos.add(numeroQuarto);
                    capacidadeQuartos.add(capacidade);

                    System.out.println("\nQuarto cadastrado com sucesso.");
                }
            }

            // LISTAR QUARTOS
            else if (opcao == 2) {

                if (numerosQuartos.size() == 0) {

                    System.out.println("\nNenhum quarto cadastrado.");

                } else {

                    System.out.println("\n===== QUARTOS CADASTRADOS =====");

                    for (int i = 0; i < numerosQuartos.size(); i++) {

                        System.out.println(
                            "\nQuarto: " + numerosQuartos.get(i)
                        );

                        System.out.println(
                            "Capacidade: " + capacidadeQuartos.get(i) + " moradores"
                        );
                    }
                }
            }

            // CADASTRAR MORADOR
            else if (opcao == 3) {

                if (numerosQuartos.size() == 0) {

                    System.out.println("\nCadastre um quarto primeiro.");

                } else {

                    System.out.print("\nNome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    boolean cpfExiste = false;

                    for (int i = 0; i < cpfs.size(); i++) {

                        if (cpfs.get(i).equals(cpf)) {
                            cpfExiste = true;
                        }
                    }

                    if (cpfExiste == true) {

                        System.out.println("\nCPF já cadastrado.");

                    } else {

                        System.out.print("Curso: ");
                        String curso = scanner.nextLine();

                        System.out.println("\nFunções da república:");
                        System.out.println("- Presidente");
                        System.out.println("- Financeiro");
                        System.out.println("- Compras");
                        System.out.println("- Limpeza");
                        System.out.println("- Morador");

                        System.out.print("Digite a função: ");
                        String funcao = scanner.nextLine();

                        System.out.print("Número do quarto: ");
                        int quarto = scanner.nextInt();
                        scanner.nextLine();

                        boolean quartoEncontrado = false;
                        int capacidadeQuarto = 0;

                        for (int i = 0; i < numerosQuartos.size(); i++) {

                            if (numerosQuartos.get(i) == quarto) {

                                quartoEncontrado = true;
                                capacidadeQuarto = capacidadeQuartos.get(i);
                            }
                        }

                        if (quartoEncontrado == false) {

                            System.out.println("\nQuarto não encontrado.");

                        } else {

                            int ocupados = 0;

                            for (int i = 0; i < quartosMoradores.size(); i++) {

                                if (quartosMoradores.get(i) == quarto) {
                                    ocupados++;
                                }
                            }

                            if (ocupados >= capacidadeQuarto) {

                                System.out.println("\nQuarto lotado.");

                            } else {

                                nomes.add(nome);
                                cpfs.add(cpf);
                                cursos.add(curso);
                                quartosMoradores.add(quarto);
                                funcoes.add(funcao);

                                System.out.println("\nMorador cadastrado com sucesso.");
                            }
                        }
                    }
                }
            }

            // LISTAR MORADORES
            else if (opcao == 4) {

                if (nomes.size() == 0) {

                    System.out.println("\nNenhum morador cadastrado.");

                } else {

                    System.out.println("\n===== MORADORES =====");

                    for (int i = 0; i < nomes.size(); i++) {

                        System.out.println("\nMorador " + (i + 1));
                        System.out.println("Nome: " + nomes.get(i));
                        System.out.println("CPF: " + cpfs.get(i));
                        System.out.println("Curso: " + cursos.get(i));
                        System.out.println("Função: " + funcoes.get(i));
                        System.out.println("Quarto: " + quartosMoradores.get(i));
                    }
                }
            }

            // REMOVER MORADOR
            else if (opcao == 5) {

                System.out.print("\nDigite o CPF do morador: ");
                String cpfRemover = scanner.nextLine();

                boolean encontrou = false;

                for (int i = 0; i < cpfs.size(); i++) {

                    if (cpfs.get(i).equals(cpfRemover)) {

                        nomes.remove(i);
                        cpfs.remove(i);
                        cursos.remove(i);
                        quartosMoradores.remove(i);
                        funcoes.remove(i);

                        encontrou = true;

                        System.out.println("\nMorador removido com sucesso.");
                        break;
                    }
                }

                if (encontrou == false) {

                    System.out.println("\nCPF não encontrado.");
                }
            }

            // VER OCUPAÇÃO DOS QUARTOS
            else if (opcao == 6) {

                if (numerosQuartos.size() == 0) {

                    System.out.println("\nNenhum quarto cadastrado.");

                } else {

                    System.out.println("\n===== OCUPAÇÃO DOS QUARTOS =====");

                    for (int i = 0; i < numerosQuartos.size(); i++) {

                        int ocupados = 0;

                        for (int j = 0; j < quartosMoradores.size(); j++) {

                            if (quartosMoradores.get(j) == numerosQuartos.get(i)) {
                                ocupados++;
                            }
                        }

                        System.out.println(
                            "\nQuarto " + numerosQuartos.get(i)
                        );

                        System.out.println(
                            "Ocupação: " + ocupados +
                            "/" + capacidadeQuartos.get(i)
                        );

                        if (ocupados >= capacidadeQuartos.get(i)) {

                            System.out.println("Status: LOTADO");

                        } else {

                            System.out.println("Status: DISPONÍVEL");
                        }
                    }
                }
            }

            // OPÇÃO INVÁLIDA
            else if (opcao != 0) {

                System.out.println("\nOpção inválida.");
            }
        }

        System.out.println("\nSistema encerrado.");

        scanner.close();
    }
}