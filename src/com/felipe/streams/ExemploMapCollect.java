package com.felipe.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.felipe.streams.model.Categoria;
import com.felipe.streams.model.Produto;
import com.felipe.streams.model.Produto.Status;

public class ExemploMapCollect {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		
		Categoria categoriaBebidas = new Categoria("Bebidas");
		Categoria categoriaCarnes = new Categoria("Carnes");
		Categoria categoriaOutros = new Categoria("Outros");
		
		produtos.add(new Produto("Água 2L", Status.ATIVO, new BigDecimal(9.9), categoriaBebidas));
		produtos.add(new Produto("Picanha 1kg", Status.ATIVO, new BigDecimal(109.5), categoriaCarnes));
		produtos.add(new Produto("Carvão", Status.INATIVO, new BigDecimal(34.2), categoriaOutros));
		produtos.add(new Produto("Cerveja 600ml", Status.ATIVO, new BigDecimal(8.4), categoriaBebidas));
		produtos.add(new Produto("Cupim 2kg", Status.ATIVO, new BigDecimal(92), categoriaCarnes));
		
//		List<Categoria> categorias = new ArrayList<>();
//		
//		for (Produto produto : produtos) {
//			if (Status.ATIVO.equals(produto.getStatus())) {
//				Categoria categoria = produto.getCategoria();
//				
//				if (!categorias.contains(categoria)) {
//					categorias.add(categoria);
//				}
//			}
//		}
		
		List<Categoria> categorias = produtos.stream()
				.filter(p -> Status.ATIVO.equals(p.getStatus()))
				.map(Produto::getCategoria)
				.distinct() // retorna uma stream apenas com elementos distintos
				.collect(Collectors.toList());
		
		System.out.println(categorias);
	}

}
