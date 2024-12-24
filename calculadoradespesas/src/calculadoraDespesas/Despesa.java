package calculadoraDespesas;

public class Despesa {

	String categoria;
	String descricao;
	double valor;
	
	
	

	public Despesa(String categoria, String descricao, double valor) {
		this.categoria = categoria;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getValor() {
		return valor;
	}
}
