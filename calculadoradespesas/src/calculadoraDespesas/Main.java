package calculadoraDespesas;


import java.io.IOException;
import java.util.Scanner;


public class Main {	

	    public static void main(String[] args) {
	        GerenciadorDespesa gerenciador = new GerenciadorDespesa();
	        Relatorio relatorio = new Relatorio(gerenciador);
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Bem-vindo à Calculadora de Despesas!");
	        System.out.print("Informe a sua receita mensal: ");
	        gerenciador.definirReceitaMensal(scanner.nextDouble());
	        scanner.nextLine();

	        while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Adicionar despesa");
	            System.out.println("2. Exibir relatório no console");
	            System.out.println("3. Exportar relatório para arquivo");
	            System.out.println("4. Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            if (opcao == 1) {
	                System.out.print("Categoria: ");
	                String categoria = scanner.nextLine();
	                System.out.print("Descrição: ");
	                String descricao = scanner.nextLine();
	                System.out.print("Valor: ");
	                double valor = scanner.nextDouble();
	                scanner.nextLine();
	                gerenciador.adicionarDespesa(new Despesa(categoria, descricao, valor));
	                System.out.println("Despesa adicionada!");
	            } else if (opcao == 2) {
	                relatorio.gerarRelatorioConsole();
	            } else if (opcao == 3) {
	                System.out.print("Caminho do arquivo para salvar o relatório: ");
	                String filePath = scanner.nextLine();
	                try {
	                    relatorio.exportarRelatorioArquivo(filePath);
	                    System.out.println("Relatório exportado com sucesso!");
	                } catch (IOException e) {
	                    System.out.println("Erro ao salvar o relatório: " + e.getMessage());
	                }
	            } else if (opcao == 4) {
	                System.out.println("Saindo... Até logo!");
	                break;
	            } else {
	                System.out.println("Opção inválida!");
	            }
	        }
	        scanner.close();
	    }
	}


