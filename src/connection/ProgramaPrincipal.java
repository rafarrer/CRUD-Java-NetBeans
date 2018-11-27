package connection;


import connection.GerenciadorBD;
import java.sql.SQLException;
import view.CadastroAluno;
import view.Home;

public class ProgramaPrincipal {
    public static void main(String[] args) throws SQLException {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}
