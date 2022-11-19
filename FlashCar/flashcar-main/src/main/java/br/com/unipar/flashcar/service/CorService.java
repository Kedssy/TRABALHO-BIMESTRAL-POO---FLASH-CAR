package br.com.unipar.flashcar.service;

import br.com.unipar.flashcar.database.repository.CorRepository;
import br.com.unipar.flashcar.exception.DescricaoInvalidaException;
import br.com.unipar.flashcar.model.Cor;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorService {

    private void valida(Cor cor) throws DescricaoInvalidaException {

        if (cor.getDescricao() == null) {
            throw new DescricaoInvalidaException();
        }

        if (cor.getDescricao().trim().length() == 0) {
            throw new DescricaoInvalidaException();
        }

        if (cor.getDescricao().trim().length() > 60) {
            throw new DescricaoInvalidaException();
        }

    }

    public void insert(Cor cor) throws DescricaoInvalidaException,
            SQLException {

        valida(cor);

        CorRepository corRepository = new CorRepository();
        corRepository.insert(cor);

    }

    public ArrayList<Cor> findAll() throws SQLException {
        CorRepository corRepository = new CorRepository();
        return corRepository.findAll();
    }

    public void delete(Cor cor) throws SQLException {
        CorRepository corRepository = new CorRepository();
        corRepository.delete(cor);
    }

    public void update(Cor cor) throws SQLException, DescricaoInvalidaException {
        valida(cor);

        CorRepository corRepository = new CorRepository();
        corRepository.update(cor);
    }

    public Cor findById(int id) throws SQLException {
        CorRepository corRepository = new CorRepository();
        return corRepository.findById(id);
    }

}
