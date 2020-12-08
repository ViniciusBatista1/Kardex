package controller;

import view.Tela;

/**
 * @author Ricardo Drudi
 */
public class Principal {
    
    public static void main(String[] args) {
/*        Connection con = ConnectionFactory.getConnection();
        System.out.println("Conectado!");
        ConnectionFactory.closeConnection(con);
        System.out.println("Desconectado!");
*/
        new Tela().setVisible(true);
    }

}
