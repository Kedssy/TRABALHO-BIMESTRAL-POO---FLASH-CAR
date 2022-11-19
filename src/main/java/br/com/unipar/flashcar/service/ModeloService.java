package br.com.unipar.flashcar.service;

import br.com.unipar.flashcar.database.repository.ModeloRepository;
import br.com.unipar.flashcar.exception.DescricaoInvalidaModeloException;
import br.com.unipar.flashcar.exception.MarcaInvalidaException;
import br.com.unipar.flashcar.exception.MarcaNotExistsException;
import br.com.unipar.flashcar.exception.NomeInvalidoException;
import br.com.unipar.flashcar.model.Marca;
import br.com.unipar.flashcar.model.Modelo;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloService {

    private void validaModelo(Modelo modelo) throws DescricaoInvalidaModeloException,
            MarcaNotExistsException,
            MarcaInvalidaException,
            NomeInvalidoException {

        String idMarca = valueOf(modelo.getIdMarca());
        Marca marca = new Marca();

        if (modelo.getDescricao() == null) {
            throw new DescricaoInvalidaModeloException();
        }

        if (modelo.getDescricao().trim().length() == 0) {
            throw new DescricaoInvalidaModeloException();
        }

        if (modelo.getDescricao().trim().length() > 60) {
            throw new DescricaoInvalidaModeloException();
        }

        if (idMarca == null) {
            throw new MarcaInvalidaException();
        }

        if (idMarca != null) {
            try {
                MarcaService marcaService = new MarcaService();
                marca = marcaService.findById(modelo.getIdMarca());

                if (marca.getNome() == null) {
                    throw new MarcaNotExistsException();
                }

            } catch (SQLException ex) {
                ex.getMessage();
            }
        }

    }

    public void insert(Modelo modelo) throws SQLException,
            DescricaoInvalidaModeloException,
            MarcaNotExistsException,
            MarcaInvalidaException,
            NomeInvalidoException {
        validaModelo(modelo);

        ModeloRepository modeloRepository = new ModeloRepository();
        modeloRepository.insert(modelo);
    }

    public ArrayList<Modelo> findAll() throws SQLException {
        ModeloRepository modeloRepository = new ModeloRepository();
        return modeloRepository.findAll();
    }

    public void delete(Modelo modelo) throws SQLException {
        ModeloRepository modeloRepository = new ModeloRepository();
        modeloRepository.delete(modelo);
    }

    public void update(Modelo modelo) throws SQLException,
            DescricaoInvalidaModeloException,
            MarcaNotExistsException,
            MarcaInvalidaException,
            NomeInvalidoException {
        validaModelo(modelo);

        ModeloRepository modeloRepository = new ModeloRepository();
        modeloRepository.update(modelo);
    }

    public Modelo findById(int id) throws NomeInvalidoException, SQLException {
        ModeloRepository modeloRepository = new ModeloRepository();
        return modeloRepository.findById(id);
    }

}
