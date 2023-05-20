package com.alura.jdbc.pruebas;

import com.alura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaPoolConex {
    public static void main(String[] args) throws SQLException {
        //simulamos multimples conex

        ConnectionFactory connectionFactory = new ConnectionFactory();

        for(int i = 0; i < 50; i++){
            Connection con =  connectionFactory.recuperaConexion();
            System.out.println("Abriendo la conexion de numero " + i );
        }




    }
}
