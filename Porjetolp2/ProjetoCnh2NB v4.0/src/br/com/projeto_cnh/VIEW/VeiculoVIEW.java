/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_cnh.VIEW;

import br.com.projeto_cnh.CTR.VeiculoCTR;
import br.com.projeto_cnh.DTO.VeiculoDTO;
import br.com.projeto_cnh.CTR.InstrutorCTR;
import br.com.projeto_cnh.DTO.InstrutorDTO;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 * @author Henrique Hyonemoto
 * @author Marina Nakashima
 */
public class VeiculoVIEW extends javax.swing.JInternalFrame {

    VeiculoCTR veiculoCTR = new VeiculoCTR();
    VeiculoDTO veiculoDTO = new VeiculoDTO();

    InstrutorDTO instrutorDTO = new InstrutorDTO();
    InstrutorCTR instrutorCTR = new InstrutorCTR();

    int gravar_alterar;
    ResultSet rs;
    DefaultTableModel modeloJtlInstrutor;
    DefaultTableModel modeloJtlVeiculo;
    DefaultTableModel modeloJtlInstrutorAprovado;

    /**
     * Creates new form VeiculoVIEW
     */
    public VeiculoVIEW() {
        initComponents();

        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);

        modeloJtlInstrutor = (DefaultTableModel) this.jtl_instrutor.getModel();
        modeloJtlVeiculo = (DefaultTableModel) this.jtl_veiculo.getModel();
        modeloJtlInstrutorAprovado = (DefaultTableModel) this.jtl_instrutor_aprovado.getModel();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void gravar() {
        try {
            veiculoDTO.setModelo(this.inputModelo.getText());
            veiculoDTO.setPlaca(this.inputPlaca.getText());
            veiculoDTO.setTipo(this.inputTipo.getSelectedItem().toString());

            JOptionPane.showMessageDialog(null, this.veiculoCTR.inserirVeiculo(veiculoDTO));

            for (int i = 0; modeloJtlInstrutorAprovado.getRowCount() > i; i++) {
                instrutorDTO.setId_instrutor(Integer.parseInt(String.valueOf(
                        this.jtl_instrutor_aprovado.getValueAt(i, 0)
                )));
                veiculoCTR.inserirInstrutorVeiculo(veiculoDTO, instrutorDTO);
            }
        } catch (Exception err) {
            System.out.println("Erro VeiculoVIEW.gravar(): " + err.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao gravar");
        }
    }
    
    private void alterar() {
        try {
            int idsInstrutores[] = new int[this.jtl_instrutor_aprovado.getRowCount()];
            for (int i = 0; i < this.jtl_instrutor_aprovado.getRowCount(); i++) {
                idsInstrutores[i] = Integer.parseInt(String.valueOf(this.jtl_instrutor_aprovado.getValueAt(i, 0)));
            }
            JOptionPane.showMessageDialog(null, this.veiculoCTR.alteraInstrutorVeiculo(veiculoDTO, idsInstrutores));
        } catch (Exception err) {
            System.out.println("Erro VeiculoVIEW.preencheCamposVeiculo(): " + err.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        }
    }

    private void excluir() {
        try {
            this.veiculoDTO.setPlaca(String.valueOf(
                    this.jtl_veiculo.getValueAt(this.jtl_veiculo.getSelectedRow(), 0)
            ));
            JOptionPane.showMessageDialog(null, this.veiculoCTR.excluirVeiculo(veiculoDTO));
        } catch (Exception err) {
            System.out.println("Erro VeiculoVIEW.excluir(): " + err.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }
    }

    private void consultarVeiculo() {
        try {
            this.modeloJtlVeiculo.setNumRows(0);
            this.veiculoDTO.setPlaca(this.inputPesquisaVeiculo.getText());
            if (this.inputPesquisaVeiculo.getText() == null || this.inputPesquisaVeiculo.getText() == "") {
                rs = this.veiculoCTR.consultarVeiculo(veiculoDTO, 1);
            } else {
                rs = this.veiculoCTR.consultarVeiculo(veiculoDTO, 2);
            }

            while (rs.next()) {
                this.modeloJtlVeiculo.addRow(new Object[]{
                    rs.getString("placa"),
                    rs.getString("modelo"),
                    rs.getString("tipo")
                });
            }
        } catch (Exception err) {
            System.out.println("Erro VeiculoVIEW.consultarVeiculo(): " + err.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        } finally {
            this.veiculoCTR.CloseDB();
        }
    }

    private void consultarInstrutor() {
        try {
            this.modeloJtlInstrutor.setNumRows(0);
            this.instrutorDTO.setNomeInstrutor(this.inputPesquisaInstrutor.getText());

            if (this.inputPesquisaInstrutor.getText() == null || this.inputPesquisaInstrutor.getText() == "") {
                rs = this.instrutorCTR.consultarInstrutor(instrutorDTO, 3);
            } else {
                rs = this.instrutorCTR.consultarInstrutor(instrutorDTO, 1);
            }

            while (rs.next()) {
                this.modeloJtlInstrutor.addRow(new Object[]{
                    rs.getString("id_instrutor"),
                    rs.getString("nomeinstrutor"),});
            }

        } catch (Exception err) {
            System.out.println("Erro VeiculoVIEW.consultarInstrutor(): " + err.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        } finally {
            this.instrutorCTR.CloseDB();
        }
    }

    private void preencheCamposVeiculo(String placa) {
        try {
            ResultSet rs2;
            ResultSet rsInstrutor;
            this.veiculoDTO.setPlaca(placa);

            rs = this.veiculoCTR.consultarVeiculo(veiculoDTO, 2);

            while (rs.next()) {
                this.inputPlaca.setText(rs.getString("placa"));
                this.inputModelo.setText(rs.getString("modelo"));
                this.inputTipo.setSelectedItem(rs.getString("tipo"));
            }

            rs2 = this.veiculoCTR.consultarVeiculo(veiculoDTO, 3);

            while (rs2.next()) {
                this.instrutorDTO.setId_instrutor(Integer.parseInt(
                        rs2.getString("id_instrutor")
                ));
                rsInstrutor = this.instrutorCTR.consultarInstrutor(instrutorDTO, 2);

                while (rsInstrutor.next()) {
                    this.modeloJtlInstrutorAprovado.addRow(new Object[]{
                        rsInstrutor.getInt("id_instrutor"),
                        rsInstrutor.getString("nomeinstrutor")
                    });
                }
            }

        } catch (Exception err) {
            System.out.println("Erro VeiculoVIEW.preencheCamposVeiculo(): " + err.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        } finally {
            this.veiculoCTR.CloseDB();
        }
    }

    private void liberaCampos(boolean a) {
        this.inputPlaca.setEnabled(a);
        this.inputModelo.setEnabled(a);
        this.inputTipo.setEnabled(a);
    }

    private void limpaCampos() {
        inputPlaca.setText(null);
        inputModelo.setText(null);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) { //checar erro
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
        this.btn_pesquisar_instrutor.setEnabled(b);
    }

    private void adicionaInstrutorSelecionado(int id_instrutor, String nomeinstrutor) {
        try {
            this.modeloJtlInstrutorAprovado.addRow(new Object[]{id_instrutor, nomeinstrutor,});

        } catch (Exception err) {
            System.out.println("Erro ao adicionar instrutor: " + err.getMessage());
        }
    }

    private void removeInstrutorSelecionado(int linha_selecionada) {
        try {
            if (linha_selecionada >= 0) {
                this.modeloJtlInstrutorAprovado.removeRow(linha_selecionada);
            }
        } catch (Exception err) {
            System.out.println("Erro ao remover instrutor " + err.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputPesquisaVeiculo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtl_veiculo = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btn_pesquisa_veiculo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_instrutor = new javax.swing.JTable();
        inputPesquisaInstrutor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_pesquisar_instrutor = new javax.swing.JButton();
        vincular_instrutor = new javax.swing.JButton();
        desvincular_instrutor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_instrutor_aprovado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        inputModelo = new javax.swing.JTextField();
        inputTipo = new javax.swing.JComboBox<>();
        inputPlaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Consulta Veículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jtl_veiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtl_veiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Tipo", "Modelo"
            }
        ));
        jtl_veiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_veiculoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtl_veiculo);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel6.setText("Placa:");

        btn_pesquisa_veiculo.setText("Pesquisar");
        btn_pesquisa_veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_veiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPesquisaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pesquisa_veiculo))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pesquisa_veiculo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(inputPesquisaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vincular Instrutor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jtl_instrutor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtl_instrutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jtl_instrutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_instrutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_instrutor);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel5.setText("Nome:");

        btn_pesquisar_instrutor.setText("Pesquisar");
        btn_pesquisar_instrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisar_instrutorActionPerformed(evt);
            }
        });

        vincular_instrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/prod_add.png"))); // NOI18N
        vincular_instrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vincular_instrutorActionPerformed(evt);
            }
        });

        desvincular_instrutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/prod_rem.png"))); // NOI18N
        desvincular_instrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desvincular_instrutorActionPerformed(evt);
            }
        });

        jtl_instrutor_aprovado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtl_instrutor_aprovado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jtl_instrutor_aprovado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_instrutor_aprovadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_instrutor_aprovado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vincular_instrutor)
                            .addComponent(desvincular_instrutor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPesquisaInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_pesquisar_instrutor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPesquisaInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisar_instrutor)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(vincular_instrutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(desvincular_instrutor))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel1.setText("Cadastro de Veículo");

        inputTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        inputTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carro", "Moto", "Caminhão", "Ônibus", "Carreta", "Van" }));

        inputPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlacaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel4.setText("Tipo:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel3.setText("Modelo:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jLabel2.setText("Placa:");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_cnh/VIEW/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlacaActionPerformed

    }//GEN-LAST:event_inputPlacaActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        this.modeloJtlInstrutor.setNumRows(0);
        this.modeloJtlVeiculo.setNumRows(0);
        this.modeloJtlInstrutorAprovado.setNumRows(0);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (this.modeloJtlInstrutorAprovado.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Deve ter pelo menos um instrutor selecionado para prosseguir");
        } else {
            if (gravar_alterar == 1) {
                this.gravar();
            } else if (gravar_alterar == 2) {
                this.alterar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar");
            }
            limpaCampos();
            liberaCampos(false);
            liberaBotoes(true, false, false, false, true);
            this.modeloJtlInstrutor.setNumRows(0);
            this.modeloJtlVeiculo.setNumRows(0);
            this.modeloJtlInstrutorAprovado.setNumRows(0);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        this.modeloJtlInstrutor.setNumRows(0);
        this.modeloJtlVeiculo.setNumRows(0);
        this.modeloJtlInstrutorAprovado.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        this.modeloJtlInstrutor.setNumRows(0);
        this.modeloJtlVeiculo.setNumRows(0);
        this.modeloJtlInstrutorAprovado.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void btn_pesquisa_veiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_veiculoActionPerformed
        this.consultarVeiculo();
    }//GEN-LAST:event_btn_pesquisa_veiculoActionPerformed

    private void btn_pesquisar_instrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisar_instrutorActionPerformed
        this.consultarInstrutor();
    }//GEN-LAST:event_btn_pesquisar_instrutorActionPerformed

    private void jtl_instrutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_instrutorMouseClicked

    }//GEN-LAST:event_jtl_instrutorMouseClicked

    private void jtl_veiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_veiculoMouseClicked
        this.modeloJtlInstrutorAprovado.setNumRows(0);
        preencheCamposVeiculo(String.valueOf(this.jtl_veiculo.getValueAt(
                this.jtl_veiculo.getSelectedRow(), 0)));
        liberaBotoes(false, true, true, true, true);
        gravar_alterar = 2;
    }//GEN-LAST:event_jtl_veiculoMouseClicked

    private void jtl_instrutor_aprovadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_instrutor_aprovadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtl_instrutor_aprovadoMouseClicked

    private void vincular_instrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vincular_instrutorActionPerformed
        if (this.jtl_instrutor.getSelectedRow() >= 0) {
            this.adicionaInstrutorSelecionado(Integer.parseInt(String.valueOf(this.jtl_instrutor.getValueAt(
                    this.jtl_instrutor.getSelectedRow(), 0))),
                    String.valueOf(this.jtl_instrutor.getValueAt(this.jtl_instrutor.getSelectedRow(), 1)));
        } else {
            JOptionPane.showMessageDialog(null, "Não existem linhas");
        }
    }//GEN-LAST:event_vincular_instrutorActionPerformed

    private void desvincular_instrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desvincular_instrutorActionPerformed
        this.removeInstrutorSelecionado(this.jtl_instrutor_aprovado.getSelectedRow());
    }//GEN-LAST:event_desvincular_instrutorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btn_pesquisa_veiculo;
    private javax.swing.JButton btn_pesquisar_instrutor;
    private javax.swing.JButton desvincular_instrutor;
    private javax.swing.JTextField inputModelo;
    private javax.swing.JTextField inputPesquisaInstrutor;
    private javax.swing.JTextField inputPesquisaVeiculo;
    private javax.swing.JTextField inputPlaca;
    private javax.swing.JComboBox<String> inputTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtl_instrutor;
    private javax.swing.JTable jtl_instrutor_aprovado;
    private javax.swing.JTable jtl_veiculo;
    private javax.swing.JButton vincular_instrutor;
    // End of variables declaration//GEN-END:variables
}
