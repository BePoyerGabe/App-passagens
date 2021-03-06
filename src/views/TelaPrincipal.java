/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.AssentoDAO;
import dao.OnibusDAO;
import dao.ViagemDAO;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.Viagem;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Assento;
import models.Cliente;
import models.Onibus;
/**
 *
 * @author bernardo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    Cliente cLogado = new Cliente();
    
    public TelaPrincipal() {
        initComponents();
    }
    
    public TelaPrincipal(Cliente c) {
        
        initComponents();
        cbDestino.setEnabled(false);
        btComprar.setEnabled(false);
        cbAssento.setEnabled(false);
        jTViagem.setEnabled(false);
        cLogado = c;
        
        lbTeste.setText(c.getNome());
        ViagemDAO vDao = new ViagemDAO();        
        ArrayList<String> origens = vDao.listaOrigem();
        
        
        ArrayList<String> filtrado = vDao.filtroViagem(origens);
        cbOrigem.addItem("========");
        
        for (String v : filtrado) {
            cbOrigem.addItem(v);
        }

        
        DefaultTableModel modelo = (DefaultTableModel) jTViagem.getModel();
        jTViagem.setRowSorter(new TableRowSorter(modelo));
                
        
    }
    
    public void preencherTabela(List<Viagem> viagens) {
        DefaultTableModel modelo = (DefaultTableModel) jTViagem.getModel();
        
        for(Viagem v : viagens) {
            
            modelo.addRow(new Object[] {
                v.getOnibus().getId(),
                v.getOnibus().getCompanhia(),
                v.getPreco(),
                v.getHoraPartida(),
                v.getDia()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbTeste = new javax.swing.JLabel();
        jpPai = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbOrigem = new javax.swing.JComboBox<>();
        cbDestino = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btAllPas = new javax.swing.JButton();
        jpPaiTabela = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTViagem = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbAssento = new javax.swing.JComboBox<>();
        btComprar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProg = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();
        miLogoff = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("I-Bus Início");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        lbTeste.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        lbTeste.setText("jLabel1");

        jpPai.setLayout(new java.awt.CardLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reserve sua passagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Castellar", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Origem:");

        cbOrigem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrigemItemStateChanged(evt);
            }
        });

        cbDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDestinoItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Destino:");

        btAllPas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons 1/book.png"))); // NOI18N
        btAllPas.setText("Ver suas passgens");
        btAllPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllPasActionPerformed(evt);
            }
        });

        jpPaiTabela.setLayout(new java.awt.CardLayout());

        jTViagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Companhia", "Preço (R$)", "Hora de partida", "Dia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTViagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTViagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTViagem);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Selecione um dos assentos:");

        cbAssento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbAssento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAssentoItemStateChanged(evt);
            }
        });

        btComprar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons 1/basket_add.png"))); // NOI18N
        btComprar.setText("Reservar");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAssento, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btComprar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComprar)
                    .addComponent(jLabel5)
                    .addComponent(cbAssento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jpPaiTabela.add(jPanel4, "card2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(btAllPas))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpPaiTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAllPas))
                .addGap(18, 18, 18)
                .addComponent(jpPaiTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpPai.add(jPanel3, "cardPrinc");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sobre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Castellar", 0, 18))); // NOI18N

        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textArea1.setEditable(false);
        textArea1.setFont(new java.awt.Font("Noto Mono", 0, 12)); // NOI18N
        textArea1.setText("\tEsse projeto foi desenvolvido ao longo da disciplina de Laboratório de \nProgramação Orientada a Objetos do curso de Sistemas de Informação da \nUniversidade  do Estado do Mato Grosso e ministrada pelo prof. Ms. Benevid \nFelix.\n\n\tO objetivo era desenvolver um sistema em Java com interface e banco \nde dados para compra de passagens de ônibus utilizando os conceitos de \nPOO aprendidos durante o semestre.\n\n\tO usuário cadastrado ao logar na página principal deve selecionar a \norigem da viagem, esta é carregada pelo banco assim que a página é carregada.\nQuando seleciona a  origem, é feito uma busca no banco para todas as viagens\ncom aquela origem, carregando o combobox de destino com todas as possíveis\nviagens. No momento que selecionar o destino, aparecerá na JTable todas as\nopções contendo suas informações que vieram do banco. O usuário seleciona \numa delas e o combobox dos assentos é desabilitado com todos assentos\ndisponíveis. Ao clicar em comprar aquele assento é reservado.\n\nDev: Bernardo P. G.");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Link github do projeto -");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("https://github.com/BePoyerGabe/App-passagens");

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons 1/arrow_left.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        jpPai.add(jPanel1, "cardSobre");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Usuário logado:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("I-Bus - Seu sistema de passagens");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTeste)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbTeste))
                .addGap(39, 39, 39)
                .addComponent(jpPai, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuProg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons 1/cog.png"))); // NOI18N
        menuProg.setText("Opções");
        menuProg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProgActionPerformed(evt);
            }
        });

        miSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons 1/help.png"))); // NOI18N
        miSobre.setText("Sobre");
        miSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSobreActionPerformed(evt);
            }
        });
        menuProg.add(miSobre);

        miLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons 1/user_delete.png"))); // NOI18N
        miLogoff.setText("Logoff");
        miLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoffActionPerformed(evt);
            }
        });
        menuProg.add(miLogoff);

        jMenuBar1.add(menuProg);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuProgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProgActionPerformed

        
    }//GEN-LAST:event_menuProgActionPerformed

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout) jpPai.getLayout();
        c1.show(jpPai, "cardSobre");
    }//GEN-LAST:event_miSobreActionPerformed

    
    private void miLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoffActionPerformed
        // TODO add your handling code here:
        dispose();
        TelaLogin tl = new TelaLogin();
        tl.setVisible(true);
    }//GEN-LAST:event_miLogoffActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout) jpPai.getLayout();
        c1.show(jpPai, "cardPrinc");
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void btAllPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllPasActionPerformed
        // TODO add your handling code here:
        TelaListaPassagens tlp = new TelaListaPassagens(cLogado);
        tlp.setVisible(true);
    }//GEN-LAST:event_btAllPasActionPerformed

    
    
    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        // TODO add your handling code here:
        AssentoDAO aDao = new AssentoDAO();
        Assento a = new Assento();
        Onibus b = new Onibus();
        
        a.setNumero((Integer) cbAssento.getSelectedItem());
        a.setCliente(cLogado);
        System.out.println(cLogado.getNome() + " "+ cLogado.getId());
        
        b.setId((Integer) jTViagem.getValueAt(jTViagem.getSelectedRow(), 0));
        b.setCompanhia(jTViagem.getValueAt(jTViagem.getSelectedRow(), 2).toString());
        a.setOnibus(b);
        
        
        
        boolean res = aDao.fazerResenva(a);
        
        if(res) {
            JOptionPane.showMessageDialog(null, "Passagem reservada!!");
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }//GEN-LAST:event_btComprarActionPerformed

    private void cbOrigemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrigemItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == evt.SELECTED){
            cbDestino.setEnabled(true);
            cbDestino.removeAllItems();
            ViagemDAO vDao = new ViagemDAO();
            //System.out.println(evt.getItem());
            
            if(evt.getItem() != "=========") {
                List<String> destinos = vDao.buscaDestino(evt.getItem().toString());

                
                cbDestino.addItem("=========");
        
                for (String resultado : destinos) {
                   cbDestino.addItem(resultado);
                    /*if(resultado != null) {
                        cbDestino.addItem(resultado);
                   }*/
            
                }
            }
        }
    }//GEN-LAST:event_cbOrigemItemStateChanged

    private void cbDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDestinoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == evt.SELECTED){
            jTViagem.setEnabled(true);
            ViagemDAO vDao = new ViagemDAO();
            //System.out.println(evt.getItem());
            
            if(evt.getItem() != "=========") {
                List<Viagem> destinos = vDao.listarViagens(cbOrigem.getSelectedItem().toString(), evt.getItem().toString());
                
                System.out.println(destinos.size());
                
                //PREENCHE JTABLE AQUI
                DefaultTableModel tm = (DefaultTableModel) jTViagem.getModel();
                tm.setRowCount(0);
                
                preencherTabela(destinos);
                
            }
        }
    }//GEN-LAST:event_cbDestinoItemStateChanged

    private void jTViagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTViagemMouseClicked
        if(jTViagem.getSelectedRow() != -1) {
            cbAssento.setEnabled(true);
            cbAssento.removeAllItems();
            OnibusDAO onibusDao = new OnibusDAO();
        
            Assento[] lugares =  onibusDao.assentosLivres(jTViagem.getValueAt(jTViagem.getSelectedRow(), 1).toString());
            System.out.println(Arrays.toString(lugares));
        
            for(int i=0; i < 20; i++) {
            
                if(lugares[i] == null) {
                
                    Assento a = new Assento();
                    a.setNumero(i);
                    cbAssento.addItem(a.getNumero());
                    ///cbAssento.addItem(i+1);
                } else {
                    System.out.println("tem valor");
                }
            }
        }
    }//GEN-LAST:event_jTViagemMouseClicked

    private void cbAssentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssentoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == evt.SELECTED){
            btComprar.setEnabled(true);
            
        }
    }//GEN-LAST:event_cbAssentoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAllPas;
    private javax.swing.JButton btComprar;
    private javax.swing.JComboBox<Object> cbAssento;
    private javax.swing.JComboBox<Object> cbDestino;
    private javax.swing.JComboBox<String> cbOrigem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTViagem;
    private javax.swing.JPanel jpPai;
    private javax.swing.JPanel jpPaiTabela;
    private javax.swing.JLabel lbTeste;
    private javax.swing.JMenu menuProg;
    private javax.swing.JMenuItem miLogoff;
    private javax.swing.JMenuItem miSobre;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
