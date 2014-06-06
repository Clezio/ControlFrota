package br.com.abcdario.controlfrota.util;

/**
 * Classe utilitária para realizar a validação CPF, CNPJ, etc.
 * 
 */
public class ValidacaoUtil {

	/**
	 * Método para verificar se um cnpj é válido ou não
	 * 
	 * @param cnpj
	 *            um númmero representando um cnpj qualquer
	 * @return TRUE se o cnpj for válido caso contrário, FALSE.
	 */
	public static boolean validarCNPJ(long cnpj) {
		if (cnpj <= 00000000000000L || cnpj == 11111111111111L || cnpj == 22222222222222L || cnpj == 33333333333333L
				|| cnpj == 44444444444444L || cnpj == 55555555555555L || cnpj == 66666666666666L || cnpj == 77777777777777L
				|| cnpj == 88888888888888L || cnpj >= 99999999999999L)
			return false;

		int primeiroDigitoVerificador = (int) (cnpj % 100) / 10;
		int segundoDigitoVerificador = (int) (cnpj % 10);

		/* Ignorando os dígitos verificadores */
		long cnpjAux = cnpj / 100;

		/* Calculando o primeiro dígito verificador */
		int primeiroDigitoVerificadorCalculado = 0;

		int fatorMultiplicativo = 2;

		for (int i = 1; i <= 12; i++) {
			if (i == 9)
				fatorMultiplicativo = 2;

			primeiroDigitoVerificadorCalculado += cnpjAux % 10 * fatorMultiplicativo;
			fatorMultiplicativo++;
			cnpjAux /= 10;
		}

		primeiroDigitoVerificadorCalculado %= 11;

		if (primeiroDigitoVerificadorCalculado < 2)
			primeiroDigitoVerificadorCalculado = 0;
		else
			primeiroDigitoVerificadorCalculado = 11 - primeiroDigitoVerificadorCalculado;

		/*
		 * Se o primeiro dígito verificador calculado for diferente do obtido no ínicio do cálculo então o cnpj é inválido
		 */
		if (primeiroDigitoVerificador != primeiroDigitoVerificadorCalculado)
			return false;

		/* Levando em consideração o primeiro dígito verificador */
		cnpjAux = cnpj / 10;

		/* Calculando o segundo dígito verificador */
		int segundoDigitoVerificadorCalculado = 0;

		fatorMultiplicativo = 2;

		for (int i = 1; i <= 13; i++) {
			if (i == 9)
				fatorMultiplicativo = 2;

			segundoDigitoVerificadorCalculado += cnpjAux % 10 * fatorMultiplicativo;
			fatorMultiplicativo++;
			cnpjAux /= 10;
		}

		segundoDigitoVerificadorCalculado %= 11;

		if (segundoDigitoVerificadorCalculado < 2)
			segundoDigitoVerificadorCalculado = 0;
		else
			segundoDigitoVerificadorCalculado = 11 - segundoDigitoVerificadorCalculado;

		/*
		 * Se o segundo dígito verificador for igual ao calculado então o cnpj é válido, pois neste ponto já testamos o primeiro
		 * dígito verificador
		 */
		return segundoDigitoVerificador == segundoDigitoVerificadorCalculado;
	}

	public static boolean validarCNPJ(String cnpj) {
		cnpj = StringUtil.retirarCaracteresNaoNumericos(cnpj);

		if (cnpj.length() != FormatadorUtil.TAMANHO_CNPJ)
			return false;

		return validarCNPJ(Long.parseLong(cnpj));
	}

	/**
	 * Método para verificar se um cpf é válido ou não
	 * 
	 * @param cpf
	 *            um número representando um cpf qualquer
	 * @return TRUE se o cpf for válido caso contrário, FALSE .
	 */
	public static boolean validarCPF(long cpf) {
		if (cpf <= 00000000000L || cpf == 11111111111L || cpf == 22222222222L || cpf == 33333333333L || cpf == 44444444444L
				|| cpf == 55555555555L || cpf == 66666666666L || cpf == 77777777777L || cpf == 88888888888L
				|| cpf >= 99999999999L)
			return false;

		int primeiroDigitoVerificador = (int) (cpf % 100) / 10;
		int segundoDigitoVerificador = (int) (cpf % 10);

		/* Ignorando os dígitos verificadores */
		long cpfAux = cpf / 100;

		/* Calculando o primeiro dígito verificador */
		int primeiroDigitoVerificadorCalculado = 0;

		for (int fatorMultiplicativo = 2; fatorMultiplicativo <= 10; fatorMultiplicativo++) {
			primeiroDigitoVerificadorCalculado += cpfAux % 10 * fatorMultiplicativo;
			cpfAux /= 10;
		}

		primeiroDigitoVerificadorCalculado %= 11;

		if (primeiroDigitoVerificadorCalculado < 2)
			primeiroDigitoVerificadorCalculado = 0;
		else
			primeiroDigitoVerificadorCalculado = 11 - primeiroDigitoVerificadorCalculado;

		/*
		 * Se o primeiro dígito verificador calculado for diferente do obtido no ínicio do cálculo então o cpf é inválido
		 */
		if (primeiroDigitoVerificador != primeiroDigitoVerificadorCalculado)
			return false;

		/* Levando em consideração o primeiro dígito verificador */
		cpfAux = cpf / 10;

		/* Calculando o segundo dígito verificador */
		int segundoDigitoVerificadorCalculado = 0;

		for (int fatorMultiplicativo = 2; fatorMultiplicativo <= 11; fatorMultiplicativo++) {
			segundoDigitoVerificadorCalculado += cpfAux % 10 * fatorMultiplicativo;
			cpfAux /= 10;
		}

		segundoDigitoVerificadorCalculado %= 11;

		if (segundoDigitoVerificadorCalculado < 2)
			segundoDigitoVerificadorCalculado = 0;
		else
			segundoDigitoVerificadorCalculado = 11 - segundoDigitoVerificadorCalculado;

		/*
		 * Se o segundo dígito verificador for igual ao calculado então o cpf é válido, pois neste ponto já testamos o primeiro
		 * dígito verificador
		 */
		return segundoDigitoVerificador == segundoDigitoVerificadorCalculado;
	}

	/**
	 * Método para verificar se um cpf é válido ou não
	 * 
	 * @param cpf
	 *            um número representando um cpf qualquer
	 * @return TRUE se o cpf for válido caso contrário, FALSE .
	 */
	public static boolean validarCPF(String cpf) {
		cpf = StringUtil.retirarCaracteresNaoNumericos(cpf);

		if (cpf.length() != FormatadorUtil.TAMANHO_CPF)
			return false;

		return validarCPF(Long.parseLong(cpf));
	}
}