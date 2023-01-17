package com.felipe.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.felipe.streams.model.Produto;
import com.felipe.streams.model.Produto.Status;

public class ExemploAnyMatch {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto("Água 2L", Status.ATIVO, new BigDecimal(9.9)));
		produtos.add(new Produto("Picanha 1kg", Status.ATIVO, new BigDecimal(109.5)));
		produtos.add(new Produto("Carvão", Status.INATIVO, new BigDecimal(34.2)));
		produtos.add(new Produto("Cerveja 600ml", Status.ATIVO, new BigDecimal(8.4)));
		produtos.add(new Produto("Cupim 2kg", Status.ATIVO, new BigDecimal(92)));
		
//		boolean temPicanha = false;
//		
//		for (Produto produto : produtos) {
//			if ("Picanha 1kg".equals(produto.getNome())) {
//				temPicanha = true;
//				break;
//			}
//		}
		
		boolean temPicanha = produtos.stream()
				.anyMatch(p -> "Picanha 1kg".equals(p.getNome())); // Retorna true se qualquer elemento da strem corresponder ao predicate, se encontrou e já satisfez a condição ele não percorre toda a coleção.
		
		System.out.println(temPicanha);
	}

}
