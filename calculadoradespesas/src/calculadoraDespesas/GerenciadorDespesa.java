package calculadoraDespesas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDespesa {

	private double receitaMensal;
	private List<Despesa> despesas;
	
	 public GerenciadorDespesa() {
	        this.despesas = new ArrayList<>();
	    }

	    public void definirReceitaMensal(double receita) {
	        this.receitaMensal = receita;
	    }

	    public void adicionarDespesa(Despesa despesa) {
	        despesas.add(despesa);
	    }

	    public double calcularTotalPorCategoria(String categoria) {
	        return despesas.stream()
	                .filter(d -> d.getCategoria().equalsIgnoreCase(categoria))
	                .mapToDouble(Despesa::getValor)
	                .sum();
	    }

	    public double calcularTotalGeral() {
	        return despesas.stream().mapToDouble(Despesa::getValor).sum();
	    }

	    public double calcularSaldoRestante() {
	        return receitaMensal - calcularTotalGeral();
	    }

	    public List<Despesa> getDespesas() {
	        return despesas;
	    }

}
