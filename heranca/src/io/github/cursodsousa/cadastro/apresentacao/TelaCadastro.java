package io.github.cursodsousa.cadastro.apresentacao;

import io.github.cursodsousa.cadastro.dominio.Cliente;
import io.github.cursodsousa.cadastro.dominio.TipoSexo;
import io.github.cursodsousa.cadastro.utilitario.ConversorIconeParaByteArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.UUID;

public class TelaCadastro extends JFrame {

    private static final int HEIGHT_PADRAO = 20;

    private Cliente cliente;

    private JLabel labelNome;
    private JTextField campoNome;

    private JLabel labelSexo;
    private JComboBox<TipoSexo> campoSexo;

    private JLabel labelFoto;

    private JButton botaoSalvar;

    public TelaCadastro() {
        this.construirTela();
        this.cliente = new Cliente();
    }

    private void construirTela(){

        setSize(500, 500);
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        this.adicionarCampos();
        this.adicionarBotoes();
        this.adicionarComponentesFoto();
    }

    private void adicionarComponentesFoto() {
        URL caminhoFoto = getClass().getResource("/io/github/cursodsousa/cadastro/apresentacao/img.png");
        ImageIcon imagemFoto = new ImageIcon(caminhoFoto);
        Image imagemRedimensionada = imagemFoto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon imagemFotoRedimensionada = new ImageIcon(imagemRedimensionada);

        labelFoto = new JLabel();
        labelFoto.setIcon(imagemFotoRedimensionada);
        labelFoto.setBounds(240, 0, 200, 200);
        labelFoto.addMouseListener(clicarNaFotoListener());

        getContentPane().add(labelFoto);
    }

    public MouseAdapter clicarNaFotoListener(){
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser pegadorArquivo = new JFileChooser();

                int opcao = pegadorArquivo.showOpenDialog(TelaCadastro.this);

                if(opcao == JFileChooser.APPROVE_OPTION){
                    File arquivoSelecionado = pegadorArquivo.getSelectedFile();
                    String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

                    ImageIcon imageIcon = new ImageIcon(caminhoArquivo);
                    labelFoto.setIcon(imageIcon);
                }
            }
        };
    }

    private void adicionarBotoes() {
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(20, 120, 100, HEIGHT_PADRAO);
        botaoSalvar.addActionListener(botaoSalvarListener());

        getContentPane().add(botaoSalvar);
    }

    private ActionListener botaoSalvarListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UUID codigo = UUID.randomUUID();
                String nome = campoNome.getText();
                TipoSexo sexo = (TipoSexo) campoSexo.getSelectedItem();
                byte[] bytesFoto = ConversorIconeParaByteArray.iconToByteArray(labelFoto.getIcon());

                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                cliente.setSexo(sexo);
                cliente.setFoto(bytesFoto);


                JOptionPane.showMessageDialog(null, cliente);
            }
        };
    }


    private void adicionarCampos(){
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(20,20,200,HEIGHT_PADRAO);
        getContentPane().add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(20, 40, 200,HEIGHT_PADRAO);
        getContentPane().add(campoNome);

        labelSexo = new JLabel("Sexo");
        labelSexo.setBounds(20, 60, 200, HEIGHT_PADRAO);
        getContentPane().add(labelSexo);

        TipoSexo[] listaTipoSexo = { null, TipoSexo.M, TipoSexo.F, TipoSexo.O };
        campoSexo = new JComboBox<>(listaTipoSexo);
        campoSexo.setBounds(20, 80, 200, HEIGHT_PADRAO);
        getContentPane().add(campoSexo);
    }
}
