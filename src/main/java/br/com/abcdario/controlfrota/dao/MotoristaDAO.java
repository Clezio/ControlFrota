package br.com.abcdario.controlfrota.dao;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Motorista;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;

public interface MotoristaDAO extends GenericDAO<Motorista, Integer> {

	Motorista recuperarCpf(Long cpf);

	Motorista recuperar(Long cnh);

	Motorista recuperar(PessoaFisica pessoaFisica);

	List<Motorista> recuperar(String nome);

}
