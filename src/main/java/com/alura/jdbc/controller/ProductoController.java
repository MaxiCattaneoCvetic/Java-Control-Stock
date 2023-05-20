package com.alura.jdbc.controller;

import com.alura.jdbc.Modelo.Categoria;
import com.alura.jdbc.Modelo.Producto;
import com.alura.jdbc.DAO.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoController {
	private ProductoDAO productoDAO;

	public ProductoController( ) {
		this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
	}

	public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
		ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
		return productoDAO.modificar(nombre, descripcion, cantidad, id);

    }

    public int eliminar(Integer id) throws SQLException {
        final Connection con = new ConnectionFactory().recuperaConexion();

		try(con) {

			final PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM  PRODUCTO WHERE ID = ?");

			try(preparedStatement){
			preparedStatement.setInt(1, id);
			preparedStatement.execute();


			int updateCount = preparedStatement.getUpdateCount();
			return updateCount; //esto nos devuelve un int, nos devuelve cuantas filas fueron modificadas luego de ejecutar el comando
		}}

    }

    public List<Producto> listar() {
         return productoDAO.listar();

    }

    public void guardar(Producto producto, Integer categoriaID){
		producto.setCategoriaId(categoriaID);
		productoDAO.guardar(producto);

    }

	public List<Producto> listar(Categoria categoria){
		return productoDAO.listar(categoria.getId());


	}


}
