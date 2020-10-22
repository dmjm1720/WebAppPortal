package mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private Connection cn;
    private Connection cnprov;

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

    //SAE
    public void Conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-557O6CE\\SQLEXPRESS;databaseName=SAE70Empre01", "sa", "dmsistemas");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.37\\SQLEXPRESS;databaseName=SAE70Empre01", "sa", "Aspel**2013");
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
            //cnprov = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-557O6CE\\SQLEXPRESS;databaseName=PortalProvNac", "sa", "dmsistemas");
            cnprov = DriverManager.getConnection("jdbc:sqlserver://WIN-2M3H0PDH8W8;databaseName=PortalProvNac", "sa", "duch3!\"#2020");
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

}
