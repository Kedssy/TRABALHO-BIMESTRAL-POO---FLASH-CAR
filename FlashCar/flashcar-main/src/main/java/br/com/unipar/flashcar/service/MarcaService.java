package br.com.unipar.flashcar.service;

import br.com.unipar.flashcar.database.repository.MarcaRepository;
import br.com.unipar.flashcar.exception.NomeInvalidoException;
import br.com.unipar.flashcar.model.Marca;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarcaService {

    private void validaMarca (Marca marca) throws NomeInvalidoException {
        if (marca.getNome() == null) {
            throw new NomeInvalidoException();
        }
        
        if (marca.getNome().trim().length() == 0) {
            throw new NomeInvalidoException();
        }
        
        if (marca.getNome().trim().length() > 60) {
            throw new NomeInvalidoException();
        }
    }
    
    public void insert(Marca marca) throws NomeInvalidoException, SQLException{
        validaMarca(marca);
        
        MarcaRepository marcaRepository = new MarcaRepository();
        marcaRepository.insert(marca);
    }
    
    public ArrayList<Marca> findAll() throws SQLException{
        MarcaRepository marcaRepository = new MarcaRepository();
        return marcaRepository.findAll();
    }
    
    public void delete(Marca marca) throws SQLException{
        MarcaRepository marcaRepository = new MarcaRepository();
        marcaRepository.delete(marca);
    }
    
    public void update(Marca marca) throws NomeInvalidoException, SQLException{
        validaMarca(marca);
        
        MarcaRepository marcaRepository = new MarcaRepository();
        marcaRepository.update(marca);
    }
    
    public Marca findById(int id) throws NomeInvalidoException, SQLException {
        MarcaRepository marcaRepository = new MarcaRepository();
        return marcaRepository.findById(id);
    }
    
}
