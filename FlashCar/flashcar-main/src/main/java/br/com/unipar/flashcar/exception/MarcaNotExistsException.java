package br.com.unipar.flashcar.exception;

public class MarcaNotExistsException extends Exception{

    public MarcaNotExistsException() {
        super("Marca não existente. Verifique!");
    }
    
}
