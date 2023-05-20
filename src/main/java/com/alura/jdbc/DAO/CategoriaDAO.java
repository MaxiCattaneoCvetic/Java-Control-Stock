package com.alura.jdbc.DAO;

import com.alura.jdbc.Modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    final private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() {
        List<Categoria> resultado = new ArrayList<>();

        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT ID, NOMBRE FROM CATEGORIA;"
            );


            try (preparedStatement){
                final ResultSet resultSet = preparedStatement.executeQuery();

                try (resultSet){
                    while(resultSet.next()){
                       var categoria =  new Categoria(resultSet.getInt("id"),resultSet.getString("nombre"));

                       resultado.add(categoria);
                    }
                }

            }catch (SQLException e){
                throw  new RuntimeException(e);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return resultado;





    }

    public List<Categoria> listarConProductos() {


        List<Categoria> resultado = new ArrayList<>();

        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD FROM CATEGORIA C" +
                            "INNER JOIN PRODUCTO P ON C.ID = P.CATEGORIA_ID;"
            );


            try (preparedStatement){
                final ResultSet resultSet = preparedStatement.executeQuery();

                try (resultSet){
                    while(resultSet.next()){
                        var categoria =  new Categoria(resultSet.getInt("id"),resultSet.getString("nombre"));

                        resultado.add(categoria);
                    }
                }

            }catch (SQLException e){
                throw  new RuntimeException(e);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return resultado;


    }
}
