package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.Produto;
import model.Entrada;

/**
 *
 * @author Ricardo Drudi
 * @website engedata.com
 */
public class TelaEntrada extends javax.swing.JFrame {
    
    private List<Produto> lProd = new ArrayList<Produto>();
    private List<Fornecedor> lFor = new ArrayList<Fornecedor>();

    /** Creates new form TelaSaida */
    public TelaEntrada() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sistema de Controle de Estoque");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        montaComboBox();
        
    }

    private void montaComboBox() {
        lProd = Produto.getLista();
        lFor = Fornecedor.getLista();
        // preenchendo combobox produtos
        cbProduto.removeAllItems();
        for (Produto i: lProd) {
            cbProduto.addItem(i.getDescricao());
        }
        // preenchendo combobox fornecedor
        cbFornecedor.removeAllItems();
        for (Fornecedor i: lFor) {
            cbFornecedor.addItem(i.getNome());
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox<>();
        cbFornecedor = new javax.swing.JComboBox<>();
        tfQtde = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        dtData = new com.toedter.calendar.JDateChooser();
        btGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTitulo.setBackground(new java.awt.Color(37, 164, 212));
        pnTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTitulo.setMinimumSize(new java.awt.Dimension(500, 80));
        pnTitulo.setPreferredSize(new java.awt.Dimension(744, 80));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoJPG.jpg"))); // NOI18N
        pnTitulo.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbTitulo.setFont(new java.awt.Font("OCR A Extended", 1, 60)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Entrada");
        pnTitulo.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 470, 60));

        getContentPane().add(pnTitulo, java.awt.BorderLayout.NORTH);

        jLabel1.setText("Data:");

        jLabel2.setText("Produto:");

        jLabel3.setText("Fornecedor:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Valor Unitário:");

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(73, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dtData, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfQtde)
                            .addComponent(tfValor, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGravar)
                        .addGap(57, 57, 57))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(dtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGravar)
                        .addGap(16, 16, 16))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Date data = dtData.getDate();
        Produto produto = lProd.get(cbProduto.getSelectedIndex());
        Fornecedor fornecedor = lFor.get(cbFornecedor.getSelectedIndex());
        int qtde = Integer.parseInt(tfQtde.getText());
        double valor = Double.parseDouble(tfValor.getText());
        new Entrada(data,produto,fornecedor,qtde,valor).gravar();
        JOptionPane.showMessageDialog(null,"Entrada Gravada com sucesso!");
    }//GEN-LAST:event_btGravarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGravar;
    private javax.swing.JComboBox<String> cbFornecedor;
    private javax.swing.JComboBox<String> cbProduto;
    private com.toedter.calendar.JDateChooser dtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTextField tfQtde;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

}
