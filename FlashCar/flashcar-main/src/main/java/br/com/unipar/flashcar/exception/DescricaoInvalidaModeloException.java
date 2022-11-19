package br.com.unipar.flashcar.exception;

public class DescricaoInvalidaModeloException extends Exception{
    public DescricaoInvalidaModeloException() {
        super("Descrição vazia ou inválida. Verifique!");
    }
}
