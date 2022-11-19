package br.com.unipar.flashcar;

import br.com.unipar.flashcar.exception.DescricaoInvalidaException;
import br.com.unipar.flashcar.exception.DescricaoInvalidaModeloException;
import br.com.unipar.flashcar.exception.MarcaInvalidaException;
import br.com.unipar.flashcar.exception.MarcaNotExistsException;
import br.com.unipar.flashcar.exception.NomeInvalidoException;
import br.com.unipar.flashcar.model.Cor;
import br.com.unipar.flashcar.model.Marca;
import br.com.unipar.flashcar.model.Modelo;
import br.com.unipar.flashcar.service.CorService;
import br.com.unipar.flashcar.service.MarcaService;
import br.com.unipar.flashcar.service.ModeloService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Flashcar {

    public static void main(String[] args) {

        try {

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>CORES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            Cor azul = new Cor();
            azul.setDescricao("roxo");

            Cor vermelho = new Cor();
            vermelho.setDescricao("Vermelho");

            CorService corService = new CorService();
            corService.insert(azul);
            corService.insert(vermelho);

            ArrayList<Cor> listaCores = corService.findAll();
            System.out.println(listaCores.toString());

            vermelho.setId(2);
            vermelho.setDescricao("vermelho");
            corService.delete(vermelho);

            listaCores = corService.findAll();
            System.out.println(listaCores.toString());

            azul.setId(1);
            azul.setDescricao("roxooooooooooooooooooo");
            corService.update(azul);

            listaCores = corService.findAll();
            System.out.println(listaCores.toString());

            azul = corService.findById(1);
            System.out.println(azul.toString());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MARCA<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

            Marca ford = new Marca();
            ford.setNome("Ford");

            Marca chevrolet = new Marca();
            chevrolet.setNome("Ford");

            MarcaService marcaService = new MarcaService();
            marcaService.insert(ford);
            marcaService.insert(chevrolet);

            ArrayList<Marca> listaMarca = marcaService.findAll();
            System.out.println(listaMarca.toString());

            chevrolet.setId(2);
            chevrolet.setNome("Chevrolet");
            marcaService.delete(chevrolet);

            listaMarca = marcaService.findAll();
            System.out.println(listaMarca.toString());

            ford.setId(1);
            ford.setNome("Forddddddddddd");
            marcaService.update(ford);

            listaMarca = marcaService.findAll();
            System.out.println(listaMarca.toString());

            ford = marcaService.findById(1);
            System.out.println(azul.toString());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MODELO<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

            Modelo fusion = new Modelo();
            fusion.setIdMarca(1);
            fusion.setDescricao("Ford Fusion");

            ModeloService modeloService = new ModeloService();
            modeloService.insert(fusion);

            ArrayList<Modelo> listaModelo = modeloService.findAll();
            System.out.println(listaModelo.toString());

            fusion.setId(1);
            fusion.setDescricao("Forddddddddddd fusion");
            modeloService.update(fusion);

            fusion = modeloService.findById(1);
            System.out.println(fusion.toString());

        } catch (DescricaoInvalidaException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NomeInvalidoException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (DescricaoInvalidaModeloException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MarcaNotExistsException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MarcaInvalidaException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}
