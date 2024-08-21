/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ClienteController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ANTONIO MILTON
 */
public class ClienteMvc {
     private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtEmail;
    private final ClienteController clienteController;
    
   public ClienteMvc(ClienteController clienteController){
       
       this.clienteController = clienteController;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 3));

        JLabel lblId = new JLabel("Id");
        panel.add(lblId);

        txtId = new JTextField();
        panel.add(txtId);

        JLabel lblNome = new JLabel("Nome: ");
        panel.add(lblNome);

        txtNome = new JTextField();
        panel.add(txtNome);

        JLabel lblEmail = new JLabel("Email");
        panel.add(lblEmail);

        txtEmail = new JTextField();
        panel.add(txtEmail);

        JButton btInserir = new JButton("Inserir");
        btInserir.addActionListener((ActionEvent e) -> {
            clienteController.inserirCliente(Integer.parseInt(txtId.getText()), txtNome.getText(), txtEmail.getText());
        });

        panel.add(btInserir);

        JButton btUpdate = new JButton("Atualizar");
        btUpdate.addActionListener((ActionEvent e) -> {
            clienteController.atualizarCliente(Integer.parseInt(txtId.getText()), txtNome.getText(), txtEmail.getText());
        });

        panel.add(btUpdate);

        JButton btExcluir = new JButton("Excluir");
        btExcluir.addActionListener((ActionEvent e) -> {
            clienteController.excluirCliente(Integer.parseInt(txtId.getText()));
        });
        panel.add(btExcluir);

        frame.add(panel);
        frame.setVisible(true);
   }
    
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        ClienteMvc clientemvc = new ClienteMvc(clienteController);
    }
    
}
