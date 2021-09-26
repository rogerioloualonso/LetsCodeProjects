import br.com.letscode.java.classes.Conta;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{

    private BigDecimal saldo;

    public ContaCorrente(int numConta, int numAgencia, BigDecimal valor) {
        super(numConta, numAgencia);
        this.saldo = valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "saldo=" + saldo +
                '}';
    }

}