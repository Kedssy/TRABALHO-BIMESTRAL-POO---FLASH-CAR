package br.com.unipar.flashcar.exception;

public class MarcaInvalidaException extends Exception{
    
    public MarcaInvalidaException() {
        super("Código da marca esta vazio ou invalido. Verifique");
    }
    
}
