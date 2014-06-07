package br.com.abcdario.controlfrota.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.dao.MotoristaDAO;
import br.com.abcdario.controlfrota.modelo.Motorista;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class MotoristaControleImpl implements MotoristaControle {

	private final MotoristaDAO motoristaDAO;

	@Autowired
	public MotoristaControleImpl(MotoristaDAO motoristaDAO) {
		this.motoristaDAO = motoristaDAO;
	}

	@Override
	public void salvarOuAtualizar(Motorista motorista) {
		motoristaDAO.salvarOuAtualizar(motorista);
	}

	@Override
	public void excluir(Motorista motorista) {
		motoristaDAO.excluir(motorista);
	}

	@Override
	public Motorista recuperar(Integer codigo) {
		return motoristaDAO.recuperar(codigo);
	}

	@Override
	public List<Motorista> recuperar() {
		return motoristaDAO.recuperar();
	}

	@Override
	public Motorista recuperar(Long cnh) {
		return motoristaDAO.recuperar(cnh);
	}

	@Override
	public Motorista recuperarCpf(Long cpf) {
		return motoristaDAO.recuperarCpf(cpf);
	}

	@Override
	public Motorista recuperar(PessoaFisica pessoaFisica) {
		return motoristaDAO.recuperar(pessoaFisica);
	}

	@Override
	public List<Motorista> recuperar(String nome) {
		return motoristaDAO.recuperar(nome);
	}

}
