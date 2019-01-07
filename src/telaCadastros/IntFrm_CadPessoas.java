/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaCadastros;

import buscaCEP.BuscaCEP;
import buscaCEP.CEP;
import buscaCNPJ.BuscaCNPJ;
import buscaCNPJ.Empresa;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import tabelas.CadMunic;
import tabelas.Pessoas;
import tabelas.dao.MunicipiosDAO;
import tabelas.dao.PessoasDAO;
import telaPesquisas.jDial_PesquisaMunicipio;
import telaPesquisas.jDial_PesquisaPessoas;

/**
 *
 * @author ferna
 */
public class IntFrm_CadPessoas extends javax.swing.JInternalFrame {

    private JDialog p;
    private final int PESSOAS = 1;
    private final int MUNICIPIOS = 2;
    private final int MUNICIPIOS_ID = 3;
    private final int MUNICIPIOS_NOME = 4;
    private final int PESSOAS_ID = 5;
    private final int INCLUIR = 1;
    private final int ALTERAR = 2;
    private final int EXCLUIR = 3;
    public static Pessoas pessoa;
    private CadMunic cidade;
    private String var_uf;
    private String var_nome_mun;
    private PessoasDAO pessoasDAO;

    /**
     * Creates new form IntFrm_CadPessoas
     *
     * @param cn
     */
    public IntFrm_CadPessoas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtId = new tools.JNumberField();
        jLabel2 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTxtIE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtOrgEmiss = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtCEP = new tools.JNumberField();
        jTxtEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jTxtComplemento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTxtIdMunicipio = new tools.JNumberField();
        jTxtNomeMunicipio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTxtCPF = new tools.JNumberField();
        jFtxtData = new javax.swing.JFormattedTextField(tools.MascaraTextField.dataBR());
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jMenuItem1.setText("Copiar");
        jMenuItem1.setEnabled(false);
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Colar");
        jMenuItem2.setEnabled(false);
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Excluir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setClosable(true);
        setResizable(true);
        setTitle("Cadastro de Pessoas");

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jLabel1.setText("Código");

        jTxtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtIdFocusLost(evt);
            }
        });

        jLabel2.setText("Nome");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Identidade / Inscr. Est.");

        jLabel5.setText("Data Emissão");

        jLabel6.setText("Órgão Emissor");

        jLabel7.setText("CEP");

        jTxtCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCEPFocusLost(evt);
            }
        });
        jTxtCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtCEPKeyReleased(evt);
            }
        });

        jLabel8.setText("Endereço");

        jLabel9.setText("Bairro");

        jLabel11.setText("Complemento");

        jLabel12.setText("Município");

        jTxtIdMunicipio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtIdMunicipioFocusLost(evt);
            }
        });
        jTxtIdMunicipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtIdMunicipioKeyTyped(evt);
            }
        });

        jTxtNomeMunicipio.setEnabled(false);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF/CNPJ");

        jTxtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCPFFocusLost(evt);
            }
        });

        jFtxtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFtxtDataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtCPF)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel12)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtNomeMunicipio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFtxtData))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtOrgEmiss, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtBairro)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jTxtOrgEmiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFtxtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jTxtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jTxtNomeMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton3.setText("Gravar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        incluiPesquisa(PESSOAS);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        incluiPesquisa(MUNICIPIOS);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tools.ClearFields.ClearFields(this.jPanel1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTxtCEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCEPKeyReleased
        jTxtEndereco.setText("");
        jTxtBairro.setText("");
        jTxtComplemento.setText("");
        jTxtIdMunicipio.setText("");
        jTxtNomeMunicipio.setText("");
    }//GEN-LAST:event_jTxtCEPKeyReleased

    private void jTxtCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCEPFocusLost
        /**
         * PESQUISA APENAS SE NÃO HOUVEREM DADOS DIGITADOS.
         */
        if (jTxtEndereco.getText().equals("")) {
            try {
                CEP search = new BuscaCEP().obtemPorNumeroCEP(jTxtCEP.getText());
                jTxtEndereco.setText(search.getLogradouro());
                jTxtBairro.setText(search.getBairro());

                var_uf = null;
                var_nome_mun = null;

                var_uf = search.getUf();
                var_nome_mun = search.getLocalidade();

                jTxtNomeMunicipio.setText(var_nome_mun + " - " + var_uf);

                incluiPesquisa(MUNICIPIOS_NOME);
            } catch (Exception e) {
                tools.DefaultMsg.errorMsg(e.getMessage());
            }
        }
    }//GEN-LAST:event_jTxtCEPFocusLost

    private void jTxtCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCPFFocusLost
        if ("".equals(jTxtId.getText())) {

            pessoasDAO = new PessoasDAO();
            incluiPesquisa(pessoasDAO.getPessoas(jTxtCPF.getText()));

        }

        if (jTxtCPF.getText().length() == 14) {
            int x = JOptionPane.showConfirmDialog(this, "Deseja consultar este CNPJ na Receita Federal?", "Consulta de CNPJ", JOptionPane.YES_NO_OPTION);
            if (x == 0) {

                try {
                    BuscaCNPJ cnpj = new BuscaCNPJ();

                    Empresa empresa = cnpj.buscaEmpresa(jTxtCPF.getText());

                    jTxtNome.setText(empresa.getNome());
                    jTxtCEP.setText(empresa.getCep().replace(".", "").replace("-", ""));

                    jTxtEndereco.setText(empresa.getLogradouro() + " " + empresa.getNumero());

                    jTxtBairro.setText(empresa.getBairro());
                    jTxtComplemento.setText(empresa.getComplemento());

                    var_nome_mun = null;
                    var_uf = null;

                    var_uf = empresa.getUf();
                    var_nome_mun = empresa.getMunicipio();

                    jTxtNomeMunicipio.setText(var_nome_mun + " - " + var_uf);

                    incluiPesquisa(MUNICIPIOS_NOME);

                } catch (Exception e) {
                    tools.DefaultMsg.errorMsg("Não foi possível realizar a consulta do CNPJ.\n" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jTxtCPFFocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jFtxtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtDataKeyReleased
        if (KeyEvent.VK_DELETE == evt.getKeyCode()) {
            jFtxtData.setValue(null);
        }
    }//GEN-LAST:event_jFtxtDataKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTxtId.getText().equals("")) {
            gravaDados(INCLUIR);
        } else {
            gravaDados(ALTERAR);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        gravaDados(EXCLUIR);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jTxtIdMunicipioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtIdMunicipioFocusLost
        incluiPesquisa(MUNICIPIOS_ID);
    }//GEN-LAST:event_jTxtIdMunicipioFocusLost

    private void jTxtIdMunicipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtIdMunicipioKeyTyped
        jTxtNomeMunicipio.setText("");
    }//GEN-LAST:event_jTxtIdMunicipioKeyTyped

    private void jTxtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtIdFocusLost
        incluiPesquisa(PESSOAS_ID);
    }//GEN-LAST:event_jTxtIdFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFormattedTextField jFtxtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCEP;
    private javax.swing.JTextField jTxtCPF;
    private javax.swing.JTextField jTxtComplemento;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtIE;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtIdMunicipio;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNomeMunicipio;
    private javax.swing.JTextField jTxtOrgEmiss;
    // End of variables declaration//GEN-END:variables

    public void recebeMunicipio(CadMunic m) {
        this.cidade = m;
    }

    public void recebePessoa(Pessoas p) {
        this.pessoa = p;
    }

    private void incluiPesquisa(int pesquisa) {

        switch (pesquisa) {

            case PESSOAS_ID:

                pessoa = null;
                if (!"".equals(jTxtId.getText())) {
                    PessoasDAO p_id = new PessoasDAO();
                    pessoa = p_id.getPessoas(Integer.parseInt(jTxtId.getText()));
                }

                tools.ClearFields.ClearFields(jPanel1);

                incluiPesquisa(pessoa);

                break;
            case PESSOAS:
                /**
                 * LIMPA MEMÓRIA PARA PESQUISAR.
                 */
                pessoa = null;

                p = new jDial_PesquisaPessoas(this, true);
                p.setVisible(true);

                System.out.println("Pessoa recebida: " + pessoa);

                incluiPesquisa(pessoa);

                break;

            case MUNICIPIOS:
                /**
                 * LIMPA MEMÓRIA PARA PESQUISAR.
                 */
                cidade = null;

                p = new jDial_PesquisaMunicipio(this, true);
                p.setVisible(true);

                incluiPesquisa(cidade);

                break;

            case MUNICIPIOS_ID:

                if (jTxtNomeMunicipio.getText().equals("")
                        && !jTxtIdMunicipio.getText().equals("")) {

                    MunicipiosDAO mdao = new MunicipiosDAO();

                    cidade = mdao.getMunicipio(Integer.parseInt(jTxtIdMunicipio.getText()));

                    incluiPesquisa(cidade);

                }

                break;

            case MUNICIPIOS_NOME:

                if (!jTxtNomeMunicipio.getText().equals("")
                        && jTxtIdMunicipio.getText().equals("")) {
                    MunicipiosDAO mdao = new MunicipiosDAO();
                    cidade = mdao.getMunicipio(var_nome_mun, var_uf);

                    jTxtIdMunicipio.setText(cidade.getId() + "");

                }
                break;
        }

    }

    private void gravaDados(int action) {
        try {

            if (action > INCLUIR && jTxtId.getText().equals("")) {
                throw new SQLException("Informe um cadastro para continuar.");
            }

            pessoa = new Pessoas();
            cidade = new CadMunic();
            try {
                pessoa.setId(Integer.parseInt(jTxtId.getText().replace(".", "")));
            } catch (Exception e) {
                pessoa.setId(0);
            }
            pessoa.setNome(jTxtNome.getText());
            pessoa.setCpf(jTxtCPF.getText().replace(".", ""));
            pessoa.setIdentidade(jTxtIE.getText());
            pessoa.setOrgaoEmissor(jTxtOrgEmiss.getText());
            pessoa.setBairro(jTxtBairro.getText());
            try {
                pessoa.setDataEmissao(tools.ManipulaData.parseBrToDate(jFtxtData.getText()));
            } catch (Exception e) {
                pessoa.setDataEmissao(null);
            }

            pessoa.setCep(jTxtCEP.getText().replace(".", ""));
            pessoa.setEndereco(jTxtEndereco.getText());
            pessoa.setComplemento(jTxtComplemento.getText());
            try {
                cidade.setId(Integer.parseInt(jTxtIdMunicipio.getText().replace(".", "")));
            } catch (Exception e) {
                cidade.setId(0);
            }
            pessoa.setCidade(cidade);

            pessoasDAO = new PessoasDAO();

            switch (action) {
                case INCLUIR:
                    pessoasDAO.create(pessoa);
                    jTxtId.setText(pessoa.getId() + "");
                    break;
                case ALTERAR:
                    pessoasDAO.update(pessoa);
                    break;

                case EXCLUIR:
                    pessoasDAO.deleteById(pessoa);
                    break;
            }

            pessoasDAO.c.commit();

            tools.DefaultMsg.saveDataSuccessfull();
            tools.ClearFields.ClearFields(jPanel1);

        } catch (Exception e) {
            conn.ConexaoMySQL.finalizarTransacao(false);
            tools.DefaultMsg.errorMsg(e.getMessage());
        }
    }

    private void incluiPesquisa(Pessoas pessoa) {

        try {

            if (pessoa.getId() == null) {
                throw new UnsupportedOperationException();
            }

            jTxtId.setText(pessoa.getId() + "");
            jTxtNome.setText(pessoa.getNome());
            jTxtCPF.setText(pessoa.getCpf());
            jTxtIE.setText(pessoa.getIdentidade());
            jFtxtData.setValue(tools.ManipulaData.dateBRstr(pessoa.getDataEmissao()));
            jTxtOrgEmiss.setText(pessoa.getOrgaoEmissor());
            jTxtCEP.setText(pessoa.getCep());
            jTxtEndereco.setText(pessoa.getEndereco());
            jTxtBairro.setText(pessoa.getBairro());
            jTxtComplemento.setText(pessoa.getComplemento());
            jTxtIdMunicipio.setText(pessoa.getCidade().getId() + "");
            jTxtNomeMunicipio.setText(pessoa.getCidade().getNome()
                    + " - " + pessoa.getCidade().getUf());
        } catch (Exception e) {
            //tools.DefaultMsg.errorMsg("Sem dados para incluir!");
        }

    }

    private void incluiPesquisa(CadMunic cidade) {
        try {
            jTxtIdMunicipio.setText(cidade.getId() + "");
            jTxtNomeMunicipio.setText(cidade.getNome() + " - " + cidade.getUf());
        } catch (Exception e) {
            //tools.DefaultMsg.errorMsg("Sem dados para incluir!");
        }
    }
}