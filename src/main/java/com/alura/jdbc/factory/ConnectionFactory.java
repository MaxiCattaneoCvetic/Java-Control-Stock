package com.alura.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//creamos la conexion mediante un pool de conexiones
//Podemos indicar la cantidad max y min de conexiones

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory() {
        //eta clase es la c3p0
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?userTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("root");

        //Seteamos el max de conexiones abiertass
        pooledDataSource.setMaxPoolSize(10);
        this.dataSource = pooledDataSource;


    }

    public Connection recuperaConexion()  {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
