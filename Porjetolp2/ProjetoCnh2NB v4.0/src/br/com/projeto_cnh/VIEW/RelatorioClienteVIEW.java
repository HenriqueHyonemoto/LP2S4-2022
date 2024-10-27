package br.com.projeto_cnh.VIEW;

import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.projeto_cnh.DTO.ClienteDTO;
import br.com.projeto_cnh.CTR.ClienteCTR;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * @author Henrique Hyonemoto
 * @author Marina Nakashima
 */
public class RelatorioClienteVIEW extends javax.swing.JInternalFrame {

    
	ClienteDTO clienteDTO = new ClienteDTO();
    ClienteCTR clienteCTR = new ClienteCTR();

    int gravar_alterar;
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_cliente;

    public RelatorioClienteVIEW() {
        initComponents();
        modelo_jtl_consultar_cliente = (DefaultTableModel) jtl_consultar_cliente.getModel();
        preencheTabela();
        
    }

    public void setPosition() {
        Dimension d = this.getDesktopPane().getSize();

        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }


    
    
    private void preencheTabela() {
        try {
           modelo_jtl_consultar_cliente.setNumRows(0); // limpa linhas
            clienteDTO.setNome(""); // enquanto tiver linhas faça
            rs = clienteCTR.consultarCliente(clienteDTO, 1); // 1 = é a pesquisa
            while (rs.next()) {
                modelo_jtl_consultar_cliente.addRow(new Object[]{
                    rs.getString("id_cliente"),
                    rs.getString("nome"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("idade"),
                    rs.getString("tipoCnh"),
                    rs.getString("tipoCnhAtual"),
                    rs.getString("rg"),});
            }

        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_cliente = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();

        setBackground(new java.awt.Color(195, 255, 210));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setText("Relatorio dos Clientes");


        jtl_consultar_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Rua", "Número", "Bairro", "Cidade", "Estado", "Cep", "Cpf", "Telefone", "Idade", "CNH_P", "CNH_A", "Rg",
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_clienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_cliente);

        btnPesquisar.setText("Atualizar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        
        JButton btnSair = new JButton();
        btnSair.setIcon(new ImageIcon(RelatorioClienteVIEW.class.getResource("/br/com/projeto_cnh/VIEW/imagens/sair.png")));
        btnSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSair.setText("Sair");
        btnSair.setEnabled(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(299)
        					.addComponent(jLabel13))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        					.addGap(280)
        					.addComponent(btnPesquisar)))
        			.addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(12)
        			.addComponent(jLabel13)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSair)
        				.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//GEN-LAST:event_btnNovoActionPerformed

    private void jtl_consultar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_clienteMouseClicked
       /* preenchecampos(Integer.parseInt(String.valueOf(
                jtl_consultar_cliente.getValueAt(
                        jtl_consultar_cliente.getSelectedRow(), 0))));*/
       // TODO add your handling code here:
    }//GEN-LAST:event_jtl_consultar_clienteMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preencheTabela();         // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtl_consultar_cliente;
}
