package com.alura.jdbc.controller;

import com.alura.jdbc.DAO.CategoriaDAO;
import com.alura.jdbc.Modelo.Categoria;
import com.alura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;

    public CategoriaController(){
        var factory =  new ConnectionFactory();
        this.categoriaDAO = new CategoriaDAO(factory.recuperaConexion());

    }
	public List<Categoria> listar() {
		return  categoriaDAO.listar();

	}

   public List<Categoria> cargaReporte() {
        return this.categoriaDAO.listarConProductos();

    }

}
