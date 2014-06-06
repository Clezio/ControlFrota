package br.com.abcdario.controlfrota.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public final class DateUtil {

	private DateUtil() {

	}

	/**
	 * Método responsável por recuperar a data atual a partir do servidor de banco de dados
	 * 
	 * @return a data atual a partir do servidor de banco de dados
	 * @throws InfraestruturaException
	 * @see br.sigaweb.infraestrutura.utilitarios.DateUtil#dataAtualSemHora
	 */
	public static Calendar dataAtual() throws Exception {
		return Calendar.getInstance();
	}

	/**
	 * Método que retorna a data atual sem hora, minuto, segundo e milissegundo. Por exemplo: 29/09/2011 00:00:00.000
	 * 
	 * @return a data atual com hora, minuto, segundo e milissegundo zerados.
	 * @throws Exception
	 * @throws InfraestruturaException
	 * @see br.sigaweb.infraestrutura.utilitarios.DateUtil#dataAtual
	 */
	public static Calendar dataAtualSemHora() throws Exception {
		Calendar dataAtualSemHora = dataAtual();
		dataAtualSemHora.set(Calendar.HOUR, 0);
		dataAtualSemHora.set(Calendar.MINUTE, 0);
		dataAtualSemHora.set(Calendar.SECOND, 0);
		dataAtualSemHora.set(Calendar.MILLISECOND, 0);
		dataAtualSemHora.set(Calendar.AM_PM, Calendar.AM);
		return dataAtualSemHora;
	}

	/***
	 * Método utilizado para comparar horas
	 * 
	 * @param calendar1
	 *            um calendar representando uma hora qualquer
	 * @param calendar2
	 *            outro calendar representando uma hora qualquer
	 * @return um inteiro positivo caso o primeiro calendar seja maior que o segundo, negativo se o primeiro for menor que o
	 *         segundo e igual zero caso sejam iguais.
	 */
	public static int compareHour(Calendar calendar1, Calendar calendar2) {
		int hora1 = calendar1.get(Calendar.HOUR_OF_DAY);
		int hora2 = calendar2.get(Calendar.HOUR_OF_DAY);

		if (hora1 != hora2)
			return hora1 - hora2;

		int minuto1 = calendar1.get(Calendar.MINUTE);
		int minuto2 = calendar2.get(Calendar.MINUTE);

		if (minuto1 != minuto2)
			return minuto1 - minuto2;

		int segundo1 = calendar1.get(Calendar.SECOND);
		int segundo2 = calendar2.get(Calendar.SECOND);

		return segundo1 - segundo2;
	}

	/**
	 * Método que calcula a diferença entre datas
	 * 
	 * @param dt1
	 *            data inicial
	 * @param dt2
	 *            data final
	 * @param unit
	 *            unidade de tempo na qual se deseja o resultado
	 * @return diferença entre as datas levando em consideração
	 */
	public static long diff(Calendar dt1, Calendar dt2, TimeUnit unit) {
		return unit.convert(dt2.getTimeInMillis() - dt1.getTimeInMillis(), TimeUnit.MILLISECONDS);
	}

	/**
	 * Método para obter o ano-semestre atual. Ex: 05/2009 (Maio de 2009) para 20091 07/2009 (Julho de 2009) para 20092
	 * 
	 * @return um inteiro representando o ano semestre
	 */
	public static int getAnoSemestre() {
		int semestre = 0;
		int mes = Calendar.getInstance().get(Calendar.MONTH);
		int year = Calendar.getInstance().get(Calendar.YEAR);

		if (mes <= Calendar.JUNE) {
			semestre = 1;
		} else {
			semestre = 2;
		}

		return year * 10 + semestre;
	}

	/**
	 * Método para retornar o mês e ano referência no formato AAAAMM. Onde A representa os digitos correspondentes ao ano e MM o
	 * mês.
	 * 
	 * @param mesReferencia
	 * @param anoReferencia
	 * @return o ano referência no formato AAAAMM
	 * 
	 * @see br.sigaweb.infraestrutura.utilitarios.DateUtil#getMesAnoReferencia(Calendar Data)
	 */
	public static int getMesAnoReferencia(int mesReferencia, int anoReferencia) {
		if (mesReferencia < 1 || mesReferencia > 12)
			throw new IllegalArgumentException("O mês informado deve estar entre 1 e 12");
		if (anoReferencia < 1900)
			throw new IllegalArgumentException("O ano informado deve maior que 1990");
		return anoReferencia * 100 + mesReferencia;
	}

	/**
	 * Método para retornar o mês e ano referência no formato AAAAMM a partir de uma data específica. Onde A representa os digitos
	 * correspondentes ao ano e MM o mês.
	 * 
	 * @param data
	 * @return o ano referência no formato AAAAMM
	 * 
	 * @see br.sigaweb.infraestrutura.utilitarios.DateUtil#getMesAnoReferencia(int mes, int ano)
	 */
	public static int getMesAnoReferencia(Calendar data) {
		return data.get(Calendar.YEAR) * 100 + data.get(Calendar.MONTH);
	}

	/***
	 * Método utilizado para verificar se uma data está entre as datas passadas como parâmetro.
	 * 
	 * @param data
	 *            data a ser comparada
	 * @param dataInicial
	 *            menor data do intervalo
	 * @param dataFinal
	 *            maior data do intervalo
	 * @return Um boolean representando o resultado da comparação. Se for true a data passada como parâmetro está dentro do
	 *         intervalo aberto especificado.
	 * @see DateUtil#isBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal)
	 * @see DateUtil#isIBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 * @see DateUtil#isIBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 */
	public static boolean isBetween(Calendar data, Calendar dataInicial, Calendar dataFinal) {
		return data.compareTo(dataInicial) > 0 && data.compareTo(dataFinal) < 0;
	}

	/***
	 * Método utilizado para verificar se um hora está entre as datas passadas como parâmetro.
	 * 
	 * @param hora
	 *            um calendar representando uma hora qualquer a ser comparada
	 * @param horaInicial
	 *            menor hora do intervalo
	 * @param horaFinal
	 *            maior hora do intervalo
	 * @return Um boolean representando o resultado da comparação. Se for true a hora passada como parâmetro está dentro do
	 *         intervalo aberto especificado.
	 * @see DateUtil#isBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 * @see DateUtil#isIBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 * @see DateUtil#isIBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal)
	 */
	public static boolean isBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal) {
		return compareHour(hora, horaInicial) > 0 && compareHour(hora, horaFinal) < 0;
	}

	/***
	 * Método utilizado para verificar se uma data está entre as datas passadas como parâmetro podendo ser igual as mesmas.
	 * 
	 * @param data
	 *            data a ser comparada
	 * @param dataInicial
	 *            menor data do intervalo
	 * @param dataFinal
	 *            maior data do intervalo
	 * @return Um boolean representando o resultado da comparação. Se for true a data passada como parâmetro está dentro do
	 *         intervalo fechado especificado.
	 * @see DateUtil#isBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 * @see DateUtil#isBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal)
	 * @see DateUtil#isIBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal)
	 */
	public static boolean isIBetween(Calendar data, Calendar dataInicial, Calendar dataFinal) {
		return data.compareTo(dataInicial) >= 0 && data.compareTo(dataFinal) <= 0;
	}

	/***
	 * Método utilizado para verificar se um hora está entre as datas passadas como parâmetro podendo ser igual as mesmas.
	 * 
	 * @param hora
	 *            um calendar representando uma hora qualquer a ser comparada
	 * @param horaInicial
	 *            menor hora do intervalo
	 * @param horaFinal
	 *            maior hora do intervalo
	 * @return Um boolean representando o resultado da comparação. Se for true a hora passada como parâmetro está dentro do
	 *         intervalo fechado especificado.
	 * @see DateUtil#isBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 * @see DateUtil#isBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal)
	 * @see DateUtil#isIBetween(Calendar data, Calendar dataInicial, Calendar dataFinal)
	 */
	public static boolean isIBetweenHour(Calendar hora, Calendar horaInicial, Calendar horaFinal) {
		return compareHour(hora, horaInicial) >= 0 && compareHour(hora, horaFinal) <= 0;
	}

	/**
	 * Método utilizado para converter uma String em um Calendar
	 * 
	 * @param data
	 *            uma String representando uma data no formato informado
	 * @param formato
	 *            um formato de data qualquer
	 * @return um objeto Calendar criado a partir da data e formato informados
	 * @throws InfraestruturaException
	 *             caso ocorra uma exceção de ParseException, ou seja, a data no formato informado não possa ser convertida em
	 *             Calendar
	 */
	public static Calendar toCalendar(String data, String formato) throws Exception {
		Calendar cal = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			cal = Calendar.getInstance();
			cal.setTime(sdf.parse(data));
		} catch (ParseException e) {
			throw new Exception(e.getMessage(), e.getCause());
		}

		return cal;
	}
}
