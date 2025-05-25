package org.serratec.backend.exercicioPaginacaoDTO.util;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeConverter;

public class NomeAutorConversor implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String nomeAutor) { //proteger depois
		return nomeAutor.toUpperCase();
	}

	@Override
	public String convertToEntityAttribute(String nomeAutor) {//proteger depois
		String[] partes = nomeAutor.split(" ");
		List<String> palavras = new ArrayList<>();
		for (int i = 0; i < partes.length; i++) {
			String primeiraLetra =	partes[i].substring(0,1).toUpperCase();
			String restoPalavra = partes[i].substring(1, partes[i].length()).toLowerCase();
			String palavraFinal = primeiraLetra + restoPalavra;
			palavras.add(palavraFinal);
		}
	
		return String.join(" ", palavras);
	}
}
