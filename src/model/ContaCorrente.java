package model;

import java.time.LocalDate;

public class ContaCorrente extends Conta{

    private double taxaManutencao;

    public ContaCorrente(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaManutencao) {
        super(agencia, numero, saldo, dataAbertura, cliente);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public boolean sacar(double valor){
        try {
            double limite = this.getCliente().getLimiteCredito();
            if((this.getSaldo() + limite) - valor  < 0){
                return false;
            }
            else if(limite - valor >= 0){
                this.getCliente().setLimiteCredito(this.getCliente().getLimiteCredito() - valor);
                return true;
            }

            else  if((limite + this.getSaldo()) - valor >= 0){
                this.getCliente().setLimiteCredito(0);
                this.setSaldo(this.getSaldo() + limite - valor);
                return true;
            }
            return false;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor){
        try {
            if(this.sacar(valor)){
                conta.depositar(valor);
                return true;
            }
            return false;
        } catch(Exception e){
            return false;
        }
    }

    public boolean aplicarTaxa(){
        saldo -= taxaManutencao;
        return true;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}
