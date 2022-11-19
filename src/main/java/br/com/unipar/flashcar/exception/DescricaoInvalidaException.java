package br.com.unipar.flashcar.exception;

public class DescricaoInvalidaException extends Exception {

    public DescricaoInvalidaException() {
        super("Descrição Vazia ou invalida. Verifique!");
    }
    
}
