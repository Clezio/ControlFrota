package br.com.abcdario.controlfrota.controle;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Estado;

public interface EstadoControle {

	Estado recuperar(Integer codigo);

	List<Estado> recuperar();

}
