package calculadoraDespesas;

import java.io.FileWriter;
import java.io.IOException;


public class Relatorio {
	
	    private GerenciadorDespesa gerenciador;

	    public Relatorio(GerenciadorDespesa gerenciador) {
	        this.gerenciador = gerenciador;
	    }

	    public void gerarRelatorioConsole() {
	        System.out.println("Relatório de Despesas:");
	        gerenciador.getDespesas().forEach(d -> 
	            System.out.printf("Categoria: %s | Descrição: %s | Valor: %.2f%n",
	                              d.getCategoria(), d.getDescricao(), d.getValor()));
	        System.out.printf("Total Geral: %.2f%n", gerenciador.calcularTotalGeral());
	        System.out.printf("Saldo Restante: %.2f%n", gerenciador.calcularSaldoRestante());
	    }

	    public void exportarRelatorioArquivo(String filePath) throws IOException {
	        try (FileWriter writer = new FileWriter(filePath)) {
	            writer.write("Relatório de Despesas:\n");
	            for (Despesa despesa : gerenciador.getDespesas()) {
	                writer.write(String.format("Categoria: %s | Descrição: %s | Valor: %.2f%n",
	                        despesa.getCategoria(), despesa.getDescricao(), despesa.getValor()));
	            }
	            writer.write(String.format("Total Geral: %.2f%n", gerenciador.calcularTotalGeral()));
	            writer.write(String.format("Saldo Restante: %.2f%n", gerenciador.calcularSaldoRestante()));
	        }
	    }
	}


