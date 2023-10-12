package model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Conta {

    private int agencia;
    private int numero;
    protected double saldo;
    private LocalDate dataAbertura;
    private Cliente cliente;

    public Conta(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
    }

    public Conta(int numero){
        this.numero = numero;
    }

    public boolean depositar(double valor){
        saldo += valor;
        return true;
    }

    public abstract boolean sacar(double valor);

    public boolean transferir(Conta conta, double valor){
        try {
            if(this.getSaldo() - valor < 0){
                return false;
            }

            this.setSaldo(this.getSaldo() - valor);
            conta.setSaldo(conta.getSaldo() + valor);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public int getAgencia() {
        return agencia;
    }


    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return this.numero == conta.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, saldo, dataAbertura, cliente);
    }
}
