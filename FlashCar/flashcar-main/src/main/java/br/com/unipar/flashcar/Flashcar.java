package br.com.unipar.flashcar;

import br.com.unipar.flashcar.exception.DescricaoInvalidaException;
import br.com.unipar.flashcar.model.Cor;
import br.com.unipar.flashcar.service.CorService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Flashcar {

    public static void main(String[] args) {

        try {

            Cor azul = new Cor();
            azul.setDescricao("Azul");

            CorService corService = new CorService();
            corService.insert(azul);

            ArrayList<Cor> listaCores = corService.findAll();
            System.out.println(listaCores.toString());

            Cor vermelho = new Cor();
            vermelho.setId(2);
            vermelho.setDescricao("Vermelho");
            corService.delete(vermelho);

            listaCores = corService.findAll();
            System.out.println(listaCores.toString());

            azul.setId(3);
            azul.setDescricao("Roxo");
            corService.update(azul);

            listaCores = corService.findAll();
            System.out.println(listaCores.toString());

            azul = corService.findById(3);
            System.out.println(azul.toString());

        } catch (DescricaoInvalidaException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}
