package br.com.abcdario.controlfrota.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class FormatadorUtil {

	public static final int TAMANHO_CPF = 11;
	public static final int TAMANHO_CNPJ = 14;
	private static Locale pt_BR = new Locale("pt", "BR");

	private FormatadorUtil() {

	}

	/**
	 * Método utilizado para formatar CNPJ's. Este método basicamente coloca um CNPJ no formato 00.000.000/0000-00
	 * 
	 * @param cnpj
	 *            um CNPJ contendo somente digitos
	 * @return um CNPJ no formato 00.000.000/0000-00
	 */
	public static String formatarCNPJ(String cnpj) {
		if (cnpj == null || cnpj.isEmpty())
			return "";
		cnpj = StringUtil.inserirCaracteres('0', cnpj, TAMANHO_CNPJ, true);
		cnpj = String.format("%s.%s.%s/%s-%s", cnpj.substring(0, 2), cnpj.substring(2, 5), cnpj.substring(5, 8),
				cnpj.substring(8, 12), cnpj.substring(12));
		return cnpj;
	}

	/**
	 * Método utilizado para formatar CPF's. Este método basicamente coloca um CPF no formato 000.000.000-00
	 * 
	 * @param cpf
	 *            um CPF contendo somente digitos
	 * @return um CPF no formato 000.000.000-00
	 */
	public static String formatarCPF(String cpf) {
		if (cpf == null || cpf.isEmpty())
			return "";
		cpf = StringUtil.inserirCaracteres('0', cpf, TAMANHO_CPF, true);
		cpf = String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
		return cpf;
	}

	/**
	 * Método utilizado para colocar um cnpj no formato DD.DDD.DDD/DDDD-DD, onde D é um dígito de 0 a 9
	 * 
	 * @param cnpj
	 *            um número representando o cnpj a ser formatado
	 * @return um cnpj no formato DD.DDD.DDD/DDDD-DD
	 */
	public static String formatarCNPJ(long cnpj) {
		String str = StringUtil.inserirZerosAEsquerda(cnpj, 14);
		return String.format("%s.%s.%s/%s-%s", str.substring(0, 2), str.substring(2, 5), str.substring(5, 8),
				str.substring(8, 12), str.substring(12, 14));
	}

	/**
	 * Método utilizado para colocar um cpf no formato DDD.DDD.DDD-DD, onde D é um dígito de 0 a 9
	 * 
	 * @param cpf
	 *            um número representando o cpf a ser formatado
	 * @return um cpf no formato DDD.DDD.DDD-DD
	 */
	public static String formatarCPF(long cpf) {
		String str = StringUtil.inserirZerosAEsquerda(cpf, 11);
		return String.format("%s.%s.%s-%s", str.substring(0, 3), str.substring(3, 6), str.substring(6, 9), str.substring(9));
	}

	/***
	 * Método para retornar uma string que representa uma data no formato dd/mm/yyyy
	 * 
	 * @param data
	 *            Data de entrada que será convertida para o formato padrão
	 * @return uma data no formato dd/mm/yyyy
	 */
	public static String formatarData(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}

	/***
	 * Método para retornar uma string que representa uma data no formato dd/mm/yyyy
	 * 
	 * @param data
	 *            Data de entrada que será convertida para o formato padrão
	 * @return uma data no formato dd/mm/yyyy
	 */
	public static String formatarData(Calendar data) {
		return formatarData(data.getTime());
	}

	/**
	 * Método responsável por formatar uma data de acordo com o formato informado
	 * 
	 * @param data
	 *            uma data qualquer a ser formatada
	 * @param formato
	 *            um formato válido
	 * @return a data formatada de acordo com o formato informado
	 */
	public static String formatarData(Date data, String formato) {
		SimpleDateFormat dataFormat = new SimpleDateFormat(formato);
		String dataFormatada = dataFormat.format(data);
		return dataFormatada;
	}

	/**
	 * Método responsável por formatar uma data de acordo com o formato informado
	 * 
	 * @param data
	 *            uma data qualquer a ser formatada
	 * @param formato
	 *            um formato válido
	 * @return a data formatada de acordo com o formato informado
	 */
	public static String formatarData(Calendar data, String formato) {
		return formatarData(data.getTime(), formato);
	}

	/***
	 * Método para retornar uma string que representa uma data no formato dd/mm/yyyy hh:mm
	 * 
	 * @param data
	 *            Data de entrada que será convertida para o formato padrão
	 * @return uma data no formato dd/mm/yyyy HH:mm
	 */
	public static String formatarDataHora(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}

	/***
	 * Método para retornar uma string que representa uma data no formato dd/mm/yyyy hh:mm
	 * 
	 * @param data
	 *            Data de entrada que será convertida para o formato padrão
	 * @return uma data no formato dd/mm/yyyy HH:mm
	 */
	public static String formatarDataHora(Calendar data) {
		return formatarDataHora(data.getTime());
	}

	/***
	 * Método para retornar uma string que representa uma hora no formato hh:mm
	 * 
	 * @param data
	 *            Data de entrada que será convertida para o formato padrão
	 * @return uma hora no formato HH:mm
	 */
	public static String formatarHora(Date data) {
		return new SimpleDateFormat("HH:mm").format(data);
	}

	/***
	 * Método para retornar uma string que representa uma hora no formato hh:mm
	 * 
	 * @param data
	 *            Data de entrada que será convertida para o formato padrão
	 * @return uma hora no formato HH:mm
	 */
	public static String formatarHora(Calendar data) {
		return formatarHora(data.getTime());
	}

	/**
	 * Método utilizado para formatar números em ponto flutuante. Este método basicamente coloca o número passado no formato:
	 * [0],00
	 * 
	 * @param numero
	 *            o número a ser formatado
	 * @return uma string no formato: [0],00
	 */
	public static String formatarNumero(Double numero) {

		DecimalFormat format = new DecimalFormat("##0.00", new DecimalFormatSymbols(pt_BR));

		return format.format(numero);
	}

	public static Double formatarNumero(String valor) throws Exception {
		if (valor == null || valor.isEmpty()) {
			return 0D;
		}

		try {
			return NumberFormat.getInstance().parse(valor).doubleValue();
		} catch (ParseException e) {
			throw new Exception(e.getMessage(), e.getCause());
		}
	}

	/**
	 * Método utilizado para formatar números em ponto flutuante. Este método basicamente coloca o número passado no formato:
	 * [0].000,00
	 * 
	 * @param numero
	 *            o número a ser formatado
	 * @return uma string no formato: [0].000,00
	 */
	public static String formatarNumeroMoeda(Double numero) {
		return new DecimalFormat("#,##0.00", new DecimalFormatSymbols(pt_BR)).format(numero);
	}

	/**
	 * Método utilizado para formatar números em ponto flutuante. Este método basicamente coloca o número passado no formato: R$
	 * [0].000,00
	 * 
	 * @param numero
	 *            o número a ser formatado
	 * @return uma string no formato: R$ [0].000,00
	 */
	public static String formatarNumeroMoedaReal(Double numero) {
		return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(numero);
	}

}
