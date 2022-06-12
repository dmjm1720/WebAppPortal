package mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private Connection cn;
    private Connection cnprov;
    private Connection cnban;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public Connection getCnprov() {
        return cnprov;
    }

    public void setCnprov(Connection cnprov) {
        this.cnprov = cnprov;
    }

    public Connection getCnban() {
        return cnban;
    }

    public void setCnban(Connection cnban) {
        this.cnban = cnban;
    }

    //SAE
    public void Conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SAE80Empre01", "sa", "DevSysM4g*22");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.37\\SQLEXPRESS;databaseName=SAE80Empre01", "sa", "Aspel**2013");
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public void Cerrar() throws SQLException {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //PORTAL
    public void Conectarprov() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //cnprov = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PortalProvNac", "sa", "DevSysM4g*22");
            cnprov = DriverManager.getConnection("jdbc:sqlserver://192.168.0.11;databaseName=PortalProvNac", "sa", "S1st3m4S*Duch3");
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public void Cerrarprov() throws SQLException {
        try {
            if (cnprov != null) {
                if (cnprov.isClosed() == false) {
                    cnprov.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //BANCOS
    public void ConectarBan() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //cnban = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-557O6CE\\SQLEXPRESS;databaseName=BAN50EMPRE01", "sa", "dmsistemas");
            cnban = DriverManager.getConnection("jdbc:sqlserver://192.168.1.37\\SQLEXPRESS;databaseName=BAN50EMPRE01", "sa", "Aspel**2013");
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public void CerrarBan() throws SQLException {
        try {
            if (cnban != null) {
                if (cnban.isClosed() == false) {
                    cnban.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

}
