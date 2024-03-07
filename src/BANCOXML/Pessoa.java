package BANCOXML;

import java.io.Serializable;

public class Pessoa implements Serializable{
    //atributos
    
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String CPF;
    
    //construtor

    public Pessoa(String nome, int idade, double peso, double altura, String CPF) {
        setNome(nome);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
        setCPF(CPF);
    }
    
    //getters 
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getCPF() {
        return CPF;
    }
    
    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if(idade > 0){
            this.idade = idade;
        }else{
            throw new RuntimeException("Idade: " + idade + " inválida.");
        }
    }

    public void setPeso(double peso) {
        if(peso > 0){
            this.peso = peso;
        }else{
            throw new RuntimeException("Peso: " + peso + " inválido.");
        }
    }

    public void setAltura(double altura) {
        if(altura > 0){
            this.altura = altura;
        }else{
            throw new RuntimeException("Altura: " + altura + " inválida.");
        }
    }

    public void setCPF(String CPF) {
        if(CPF.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")){
            this.CPF = CPF;
        }else{
            throw new RuntimeException("CPF: " + CPF + " inválido.");
        }
    }
    
    @Override
    public String toString(){
        return getNome() + " (" + getIdade() + ", " + getAltura() + ", " + getPeso() + ", " + getCPF() + ")";
    }
    
    
    
    
}

