package br.com.abcdario.controlfrota.controle;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Motorista;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;

public interface MotoristaControle {

	void salvarOuAtualizar(Motorista instrutor);

	void excluir(Motorista instrutor);

	Motorista recuperar(Integer codigo);

	List<Motorista> recuperar();

	Motorista recuperar(Long cnh);

	Motorista recuperarCpf(Long cpf);

	Motorista recuperar(PessoaFisica pessoaFisica);

	List<Motorista> recuperar(String nome);

}
