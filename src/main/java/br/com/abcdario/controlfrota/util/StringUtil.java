package br.com.abcdario.controlfrota.util;

public final class StringUtil {

	private StringUtil() {
	}

	/**
	 * Método utilizado para contar a quantidade de ocorrências de uma determinada substring em uma string
	 * 
	 * @param str
	 *            a string utilizada para contagem de ocorrências da substring
	 * @param subStr
	 *            a substring a ser contada as ocorrências em str
	 * @return a quantidade de vezes que uma substring aparece em uma string
	 */
	public static int contarOcorrencias(String str, String subStr) {
		int qtdOcorrenciasSubStr = 0;
		int index = 0;
		int sizeSubStr = subStr.length();

		while (index != -1) {
			index = str.indexOf(subStr, index);
			if (index != -1) {
				qtdOcorrenciasSubStr++;
				index += sizeSubStr;
			}
		}

		return qtdOcorrenciasSubStr;
	}

	/**
	 * Método utilizado para transformar em maiúscula a primeira letra de uma palavra e as letras restantes em minúsculas
	 * 
	 * @param palavra
	 *            uma string qualquer
	 * @return uma string onde a primeira letra da palavra é maiúscula
	 * @see br.StringUtil.infraestrutura.utilitarios.StringUtils#firstToUpperCaseAll(String palavra)
	 */
	public static String firstToUpperCase(String palavra) {
		palavra = palavra.toLowerCase();

		if (palavra.isEmpty()) {
			return "";
		}

		String first = String.valueOf(palavra.charAt(0)).toUpperCase();
		String right = palavra.substring(1);

		return first + right;
	}

	/**
	 * Método utilizado para transformar em maiúscula a primeira letra de cada palavra (substrings separadas por espaço) e as
	 * letras restantes em minúsculas na string informada
	 * 
	 * @param palavra
	 *            uma string qualquer composta por várias palavras separadas por espaço
	 * @return uma string onde a primeira letra de cada palavra é maiúscula
	 * @see br.StringUtil.infraestrutura.utilitarios.StringUtils#firstToUpperCase(String palavra)
	 */
	public static String firstToUpperCaseAll(String palavra) {
		if (palavra.length() == 0) {
			return "";
		}

		String frase = "";
		for (String s : palavra.split(" ")) {
			frase = frase + StringUtil.firstToUpperCase(s) + " ";
		}

		return frase.trim();
	}

	/**
	 * Método utilizado para inserir caracteres à esquerda ou direita de uma String
	 * 
	 * @param caractere
	 *            é o caractere utilizado para completar a palavra
	 * @param palavra
	 *            é a palavra na qual que queremos inserir caracteres
	 * @param tamanhoFinalPalavra
	 *            tamanho da palavra após a inserção de caracteres
	 * @param esquerda
	 *            TRUE se os caracteres serão inseridos a esquerda, FALSE caso eles sejam inseridos a direita
	 * @return uma string com o tamanho especificado completado com caracteres de acordo com o sentido especificado
	 */
	public static String inserirCaracteres(char caractere, String palavra, int tamanhoFinalPalavra, boolean esquerda) {
		int quantidadeCaracteresInserir = tamanhoFinalPalavra - palavra.length();
		String novaPalavra = "";

		for (int i = 1; i <= quantidadeCaracteresInserir; i++)
			novaPalavra += caractere;

		if (esquerda) {
			novaPalavra = novaPalavra + palavra;
		} else {
			novaPalavra = palavra + novaPalavra;
		}

		return novaPalavra;
	}

	public static String inserirZerosAEsquerda(long numero, int quantidadeZeros) {
		return String.format("%0" + quantidadeZeros + "d", numero);
	}

	/**
	 * Método para retirar qualquer caractere especial de uma String <br/>
	 * <br/>
	 * Exemplos de caracteres especiais:<br/>
	 * Â, À, Á, Ä, Ã é substituído por A <br/>
	 * â, ã, à, á, ä substituído por a <br/>
	 * Ç substituído por C <br/>
	 * ç substituído por c <br/>
	 * < > \ | / - ; , substituído por nada <br/>
	 * 
	 * @author Luan
	 * @param str
	 *            a String que queremos retirar os caracteres especiais
	 * @return uma String sem caracteres especiais
	 * @see StringUtil#retirarCaracteresNaoNumericos(String)
	 * @see StringUtil#retirarCaracteresNumericos(String)
	 */
	public static String retirarCaracteresEspeciais(String str) {
		String result;

		result = str.replaceAll("[ÂÀÁÄÃ]", "A");
		result = result.replaceAll("[âãàáä]", "a");
		result = result.replaceAll("[ÊÈÉË]", "E");
		result = result.replaceAll("[êèéë]", "e");
		result = result.replaceAll("[ÎÍÌÏ]", "I");
		result = result.replaceAll("[îíìï]", "i");
		result = result.replaceAll("[ÔÕÒÓÖ]", "O");
		result = result.replaceAll("[ôõòóö]", "o");
		result = result.replaceAll("[ÛÙÚÜ]", "U");
		result = result.replaceAll("[ûúùü]", "u");
		result = result.replaceAll("Ç", "C");
		result = result.replaceAll("ç", "c");
		result = result.replaceAll("[ÝŸ]", "Y");
		result = result.replaceAll("[ýÿ]", "y");
		result = result.replaceAll("ñ", "n");
		result = result.replaceAll("Ñ", "N");
		result = result.replaceAll("['<>\\|/,.:;-]", "");

		return result;
	}

	/**
	 * Método para retirar qualquer caractere não numérico de uma String
	 * 
	 * @param str
	 *            a String que queremos retirar os caracteres não numéricos
	 * @return uma String sem caracteres não númericos
	 * @see StringUtil#retirarCaracteresNumericos(String)
	 * @see StringUtil#retirarCaracteresEspeciais(String)
	 */
	public static String retirarCaracteresNaoNumericos(String str) {
		if (str == null) {
			return "";
		}
		return str.replaceAll("[^\\d]", "");
	}

	/**
	 * Método para retirar qualquer caractere numérico de uma String
	 * 
	 * @param str
	 *            a String que queremos retirar os caracteres numéricos
	 * @return uma String sem caracteres numéricos
	 * @see StringUtil#retirarCaracteresNaoNumericos(String)
	 * @see StringUtil#retirarCaracteresEspeciais(String)
	 */
	public static String retirarCaracteresNumericos(String str) {
		if (str == null) {
			return "";
		}
		return str.replaceAll("[\\d]", "");
	}

}