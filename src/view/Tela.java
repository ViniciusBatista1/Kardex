package view;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Entrada;
import model.Fornecedor;
import model.Produto;
import model.Saida;

/**
 *
 * @author Ricardo Drudi
 * @website engedata.com
 */
public class Tela extends javax.swing.JFrame {


    String painel;

    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sistema de Controle de Estoque");
        mostraPainel("Clientes");
        limpaTelaCliente();
    }
    
    private void mostraPainel(String pn) {
        CardLayout cl = (CardLayout) (pnCentral.getLayout());
        cl.show(pnCentral, pn);
        painel = pn;
        pnBotoes.setVisible(!pn.equals("Kardex"));
    }

    private void limpaTelaCliente() {
        tfCliNome.setText("");
        tfCliCPF.setText("");
        tfCliCelular.setText("");
        tfCliEmail.setText("");
        tfCliNome.requestFocus();
    }
    
    private void limpaTelaFornecedor() {
        tfForCnpj.setText("");
        tfForNome.setText("");
        tfForTel.setText("");
        tfForEmail.setText("");
        tfForNome.requestFocus();
    }
    
    private void limpaTelaProduto() {
        tfProDesc.setText("");
        tfProQtde.setText("");
        tfProCusto.setText("");
        
    }
    
    private void gravaCliente() {
        String nome = tfCliNome.getText();
        String cpf = tfCliCPF.getText();
        String celular = tfCliCelular.getText();
        String email = tfCliEmail.getText();
        Cliente c = new Cliente(cpf, nome, celular, email);
        int id = c.gravar();
        JOptionPane.showMessageDialog(null,"O ID do Cliente é: " + id);
        limpaTelaCliente();        
    }
    
    private void gravaFornecedor() {
        String nome = tfForNome.getText();
        String cnpj = tfForCnpj.getText();
        String telefone = tfForTel.getText();
        String email = tfForEmail.getText();
        Fornecedor c = new Fornecedor(cnpj, nome, telefone, email);
        int id = c.gravar();
        JOptionPane.showMessageDialog(null,"O ID do Fornecedor é: " + id);
        limpaTelaFornecedor();
    }
    
    private void gravaProduto() {
        String descricao = tfProDesc.getText();
        int qtde = Integer.parseInt(tfProQtde.getText());
        double custo = Double.parseDouble(tfProCusto.getText());
        Produto c = new Produto(descricao, qtde, custo);
        int id = c.gravar();
        JOptionPane.showMessageDialog(null,"O ID do Produto é: " + id);
        limpaTelaProduto();
    }
    
    private void listaCliente() {
        new TLista(Cliente.getTableModel()).setVisible(true);
    }
    
    private void listaFornecedor() {
        new TLista(Fornecedor.getTableModel()).setVisible(true);
    }
    
    private void listaProduto() {
        new TLista(Produto.getTableModel()).setVisible(true);
       
    }
    private void montaTabelaSaidas() {
        tbKardex.setModel(Saida.getTableModel());
    }
    
    private void montaTabelaEntrada() {
        tbKardex.setModel(Entrada.getTableModel());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        btProdutos = new javax.swing.JButton();
        btClientes = new javax.swing.JButton();
        btFornecedores = new javax.swing.JButton();
        btEntradas = new javax.swing.JButton();
        btSaidas = new javax.swing.JButton();
        pnBotoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btListar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        pnCentral = new javax.swing.JPanel();
        pnClientes = new javax.swing.JPanel();
        lbClientes = new javax.swing.JLabel();
        lbCliNome = new javax.swing.JLabel();
        lbCliCPF = new javax.swing.JLabel();
        lbCliCelular = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCliNome = new javax.swing.JTextField();
        tfCliCPF = new javax.swing.JTextField();
        tfCliCelular = new javax.swing.JTextField();
        tfCliEmail = new javax.swing.JTextField();
        pnProdutos = new javax.swing.JPanel();
        lbProdutos = new javax.swing.JLabel();
        lbProNome = new javax.swing.JLabel();
        lbProDesc = new javax.swing.JLabel();
        lbProCusto = new javax.swing.JLabel();
        tfProQtde = new javax.swing.JTextField();
        tfProCusto = new javax.swing.JTextField();
        tfProDesc = new javax.swing.JTextField();
        pnFornecedores = new javax.swing.JPanel();
        lbFornecedores = new javax.swing.JLabel();
        lbCNPJ = new javax.swing.JLabel();
        lbCliNome2 = new javax.swing.JLabel();
        lbCliNome3 = new javax.swing.JLabel();
        lbCliNome4 = new javax.swing.JLabel();
        tfForNome = new javax.swing.JTextField();
        tfForTel = new javax.swing.JTextField();
        tfForEmail = new javax.swing.JTextField();
        tfForCnpj = new javax.swing.JTextField();
        pnKardex = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btNovaSaida = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKardex = new javax.swing.JTable();
        btNovaEntrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTitulo.setBackground(new java.awt.Color(37, 164, 212));
        pnTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTitulo.setMinimumSize(new java.awt.Dimension(760, 80));
        pnTitulo.setPreferredSize(new java.awt.Dimension(744, 80));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoJPG.jpg"))); // NOI18N
        pnTitulo.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbTitulo.setFont(new java.awt.Font("OCR A Extended", 1, 60)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Kardex");
        pnTitulo.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 630, 60));

        getContentPane().add(pnTitulo, java.awt.BorderLayout.NORTH);

        pnMenu.setBackground(new java.awt.Color(3, 30, 82));
        pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnMenu.setLayout(new javax.swing.BoxLayout(pnMenu, javax.swing.BoxLayout.PAGE_AXIS));

        btProdutos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btProdutos.setText("Produtos");
        btProdutos.setBorderPainted(false);
        btProdutos.setContentAreaFilled(false);
        btProdutos.setMaximumSize(new java.awt.Dimension(143, 38));
        btProdutos.setMinimumSize(new java.awt.Dimension(145, 45));
        btProdutos.setPreferredSize(new java.awt.Dimension(145, 45));
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });
        pnMenu.add(btProdutos);

        btClientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btClientes.setForeground(new java.awt.Color(255, 255, 255));
        btClientes.setText("Clientes");
        btClientes.setBorderPainted(false);
        btClientes.setContentAreaFilled(false);
        btClientes.setMaximumSize(new java.awt.Dimension(143, 38));
        btClientes.setMinimumSize(new java.awt.Dimension(145, 45));
        btClientes.setPreferredSize(new java.awt.Dimension(145, 45));
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });
        pnMenu.add(btClientes);

        btFornecedores.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btFornecedores.setForeground(new java.awt.Color(255, 255, 255));
        btFornecedores.setText("Fornecedores");
        btFornecedores.setBorderPainted(false);
        btFornecedores.setContentAreaFilled(false);
        btFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFornecedoresActionPerformed(evt);
            }
        });
        pnMenu.add(btFornecedores);

        btEntradas.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEntradas.setForeground(new java.awt.Color(255, 255, 255));
        btEntradas.setText("Entradas");
        btEntradas.setBorderPainted(false);
        btEntradas.setContentAreaFilled(false);
        btEntradas.setMaximumSize(new java.awt.Dimension(143, 38));
        btEntradas.setMinimumSize(new java.awt.Dimension(145, 45));
        btEntradas.setPreferredSize(new java.awt.Dimension(145, 45));
        btEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntradasActionPerformed(evt);
            }
        });
        pnMenu.add(btEntradas);

        btSaidas.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btSaidas.setForeground(new java.awt.Color(255, 255, 255));
        btSaidas.setText("Saídas");
        btSaidas.setBorderPainted(false);
        btSaidas.setContentAreaFilled(false);
        btSaidas.setMaximumSize(new java.awt.Dimension(143, 38));
        btSaidas.setMinimumSize(new java.awt.Dimension(145, 45));
        btSaidas.setPreferredSize(new java.awt.Dimension(145, 45));
        btSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidasActionPerformed(evt);
            }
        });
        pnMenu.add(btSaidas);

        getContentPane().add(pnMenu, java.awt.BorderLayout.WEST);

        pnBotoes.setBackground(new java.awt.Color(0, 0, 0));
        pnBotoes.setMinimumSize(new java.awt.Dimension(614, 35));
        pnBotoes.setPreferredSize(new java.awt.Dimension(614, 35));
        pnBotoes.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        pnBotoes.add(jLabel1);
        pnBotoes.add(jLabel2);
        pnBotoes.add(jLabel5);

        btListar.setBackground(new java.awt.Color(1, 165, 247));
        btListar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btListar.setForeground(new java.awt.Color(255, 255, 255));
        btListar.setText("Listar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });
        pnBotoes.add(btListar);

        btLimpar.setBackground(new java.awt.Color(1, 165, 247));
        btLimpar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        pnBotoes.add(btLimpar);

        btSalvar.setBackground(new java.awt.Color(1, 165, 247));
        btSalvar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        pnBotoes.add(btSalvar);

        getContentPane().add(pnBotoes, java.awt.BorderLayout.SOUTH);

        pnCentral.setBackground(new java.awt.Color(102, 255, 51));
        pnCentral.setLayout(new java.awt.CardLayout());

        pnClientes.setBackground(new java.awt.Color(244, 247, 249));

        lbClientes.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        lbClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClientes.setText("Clientes");

        lbCliNome.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCliNome.setText("Nome:");

        lbCliCPF.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCliCPF.setText("CPF:");

        lbCliCelular.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCliCelular.setText("Celular:");

        jLabel4.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        jLabel4.setText("E-mail:");

        tfCliNome.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        tfCliCPF.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        tfCliCelular.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        tfCliEmail.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnClientesLayout = new javax.swing.GroupLayout(pnClientes);
        pnClientes.setLayout(pnClientesLayout);
        pnClientesLayout.setHorizontalGroup(
            pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClientesLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbCliCelular)
                        .addComponent(lbCliCPF)
                        .addComponent(lbCliNome))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCliCelular)
                    .addComponent(tfCliCPF)
                    .addComponent(tfCliNome)
                    .addComponent(tfCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
            .addComponent(lbClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnClientesLayout.setVerticalGroup(
            pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClientesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbClientes)
                .addGap(47, 47, 47)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCliNome))
                .addGap(18, 18, 18)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCliCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCliCPF))
                .addGap(16, 16, 16)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCliCelular)
                    .addComponent(tfCliCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pnCentral.add(pnClientes, "Clientes");

        lbProdutos.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        lbProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProdutos.setText("Produtos");

        lbProNome.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbProNome.setText("Descrição:");

        lbProDesc.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbProDesc.setText("Quantidade:");

        lbProCusto.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbProCusto.setText("Custo médio:");

        tfProQtde.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        tfProCusto.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        tfProDesc.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnProdutosLayout = new javax.swing.GroupLayout(pnProdutos);
        pnProdutos.setLayout(pnProdutosLayout);
        pnProdutosLayout.setHorizontalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbProNome)
                    .addComponent(lbProDesc)
                    .addComponent(lbProCusto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfProCusto, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(tfProQtde))
                .addGap(95, 95, 95))
            .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnProdutosLayout.createSequentialGroup()
                    .addGap(188, 188, 188)
                    .addComponent(tfProDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(97, Short.MAX_VALUE)))
        );
        pnProdutosLayout.setVerticalGroup(
            pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbProdutos)
                .addGap(54, 54, 54)
                .addComponent(lbProNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnProdutosLayout.createSequentialGroup()
                        .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfProQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbProDesc))
                        .addGap(56, 56, 56))
                    .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfProCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbProCusto)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(pnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnProdutosLayout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(tfProDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(230, Short.MAX_VALUE)))
        );

        pnCentral.add(pnProdutos, "Produtos");

        lbFornecedores.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        lbFornecedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFornecedores.setText("Fornecedores");

        lbCNPJ.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCNPJ.setText("CNPJ:");

        lbCliNome2.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCliNome2.setText("Nome:");

        lbCliNome3.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCliNome3.setText("Email:");

        lbCliNome4.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
        lbCliNome4.setText("Telefone:");

        tfForCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfForCnpjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFornecedoresLayout = new javax.swing.GroupLayout(pnFornecedores);
        pnFornecedores.setLayout(pnFornecedoresLayout);
        pnFornecedoresLayout.setHorizontalGroup(
            pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFornecedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addGroup(pnFornecedoresLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCliNome3)
                    .addComponent(lbCliNome4)
                    .addComponent(lbCliNome2)
                    .addComponent(lbCNPJ))
                .addGap(18, 18, 18)
                .addGroup(pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfForCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfForTel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfForEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfForNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFornecedoresLayout.setVerticalGroup(
            pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFornecedoresLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbFornecedores)
                .addGap(49, 49, 49)
                .addGroup(pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCliNome2)
                    .addComponent(tfForNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCNPJ)
                    .addComponent(tfForCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfForTel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCliNome4))
                .addGap(31, 31, 31)
                .addGroup(pnFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfForEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCliNome3))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnCentral.add(pnFornecedores, "Fornecedores");

        pnKardex.setBackground(new java.awt.Color(244, 247, 249));
        pnKardex.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Dosis", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Entrada/Saída");
        pnKardex.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        btNovaSaida.setText("Nova Saída");
        btNovaSaida.setBorderPainted(false);
        btNovaSaida.setContentAreaFilled(false);
        btNovaSaida.setMaximumSize(new java.awt.Dimension(73, 20));
        btNovaSaida.setMinimumSize(new java.awt.Dimension(73, 20));
        btNovaSaida.setPreferredSize(new java.awt.Dimension(73, 20));
        btNovaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaSaidaActionPerformed(evt);
            }
        });

        tbKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbKardex);

        btNovaEntrada.setText("Nova Entrada");
        btNovaEntrada.setBorderPainted(false);
        btNovaEntrada.setContentAreaFilled(false);
        btNovaEntrada.setMaximumSize(new java.awt.Dimension(73, 20));
        btNovaEntrada.setMinimumSize(new java.awt.Dimension(73, 20));
        btNovaEntrada.setPreferredSize(new java.awt.Dimension(73, 20));
        btNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btNovaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pnKardex.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnCentral.add(pnKardex, "Kardex");

        getContentPane().add(pnCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        mostraPainel("Produtos");
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        mostraPainel("Clientes");
    }//GEN-LAST:event_btClientesActionPerformed

    private void btFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFornecedoresActionPerformed
        mostraPainel("Fornecedores");
    }//GEN-LAST:event_btFornecedoresActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (painel.equals("Clientes")) gravaCliente();
        else if (painel.equals("Fornecedores")) gravaFornecedor();
        else if (painel.equals("Produtos")) gravaProduto();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        if (painel.equals("Clientes")) limpaTelaCliente();
        else if (painel.equals("Fornecedores")) limpaTelaFornecedor();
        else if (painel.equals("Produtos")) limpaTelaProduto();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        if (painel.equals("Clientes")) listaCliente();
        else if (painel.equals("Fornecedores")) listaFornecedor();
        else if (painel.equals("Produtos")) listaProduto();
    }//GEN-LAST:event_btListarActionPerformed

    private void btNovaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaSaidaActionPerformed
        new TelaSaida().setVisible(true);
    }//GEN-LAST:event_btNovaSaidaActionPerformed

    private void btSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidasActionPerformed
        montaTabelaSaidas();
        mostraPainel("Kardex");
    }//GEN-LAST:event_btSaidasActionPerformed

    private void tfForCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfForCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfForCnpjActionPerformed

    private void btEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntradasActionPerformed
        montaTabelaEntrada();
        mostraPainel("Kardex");
    }//GEN-LAST:event_btEntradasActionPerformed

    private void btNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaEntradaActionPerformed
      new TelaEntrada().setVisible(true);
    }//GEN-LAST:event_btNovaEntradaActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btEntradas;
    private javax.swing.JButton btFornecedores;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btNovaEntrada;
    private javax.swing.JButton btNovaSaida;
    private javax.swing.JButton btProdutos;
    private javax.swing.JButton btSaidas;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCNPJ;
    private javax.swing.JLabel lbCliCPF;
    private javax.swing.JLabel lbCliCelular;
    private javax.swing.JLabel lbCliNome;
    private javax.swing.JLabel lbCliNome2;
    private javax.swing.JLabel lbCliNome3;
    private javax.swing.JLabel lbCliNome4;
    private javax.swing.JLabel lbClientes;
    private javax.swing.JLabel lbFornecedores;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbProCusto;
    private javax.swing.JLabel lbProDesc;
    private javax.swing.JLabel lbProNome;
    private javax.swing.JLabel lbProdutos;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnCentral;
    private javax.swing.JPanel pnClientes;
    private javax.swing.JPanel pnFornecedores;
    private javax.swing.JPanel pnKardex;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnProdutos;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTable tbKardex;
    private javax.swing.JTextField tfCliCPF;
    private javax.swing.JTextField tfCliCelular;
    private javax.swing.JTextField tfCliEmail;
    private javax.swing.JTextField tfCliNome;
    private javax.swing.JTextField tfForCnpj;
    private javax.swing.JTextField tfForEmail;
    private javax.swing.JTextField tfForNome;
    private javax.swing.JTextField tfForTel;
    private javax.swing.JTextField tfProCusto;
    private javax.swing.JTextField tfProDesc;
    private javax.swing.JTextField tfProQtde;
    // End of variables declaration//GEN-END:variables

}
