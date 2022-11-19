package br.com.unipar.flashcar.exception;

public class NomeInvalidoException extends Exception {

    public NomeInvalidoException() {
        super("Nome vazio ou inválido. Verifique!");
    }

}
