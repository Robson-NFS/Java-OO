
public abstract class Conta {

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;

	public Conta(int agencia, int numero) {
		total++; // Conta.total++;
//		System.out.println("O Total de Contas é : " + total);
		this.numero = numero;
		this.agencia = agencia;
//		System.out.println("Estou criando uma conta " + this.numero);

	}

	public abstract void deposita(double valor);

	public boolean saca(double valor) {
		if (saldo >= valor) {
			this.saldo -= valor;
			System.out.println("Operação Realizada Com Sucesso!");
			return true;
		} else {
			System.out.println("Valor Indisponível: " + valor + " \n O Seu Saldo Atual é :" + saldo);
			return false;
		}

	}

	public boolean transfere(double valor, Conta destino) {
		if (this.saca(valor)) {
			destino.deposita(valor);
			return true;
		} else {
			return false;
		}
	}

	public double getSaldo() {
		return this.saldo;

	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Valor Inválido");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Valor Inválido");
			return;
		}
		this.agencia = agencia;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public static int getTotal() {
		return Conta.total;
	}

}