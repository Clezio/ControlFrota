package br.com.abcdario.controlfrota.controle;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Estado;

public interface CidadeControle {

	Cidade recuperar(Integer codigo);

	List<Cidade> recuperar();

	List<Cidade> recuperar(Estado estado);

}
