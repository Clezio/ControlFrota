/**
 * Método utilizado para bloquear caracteres não-numéricos
 * 
 * @param event
 * @return
 * 
 * Uso:
 */
function bloqueiaCaracteresNaoNumericos(event) {
	var keyCode = 0;
	
	if (event.srcElement) // IF IE
		keyCode = event.keyCode;
	else if (event.target){ // IF Firefox
		keyCode = event.which;
		
		if(keyCode == 0)
			return true;
	}
	
	if (keyCode == 8 || (keyCode >= 48 && keyCode <= 57))
		return true;

	return false;
}

/**
 * Método utilizado para bloquear caracteres não-numéricos
 * 
 * @param event
 * @return
 * 
 * Uso:
 */
function moeda(event) {
	var keyCode = 0;
	
	if (event.srcElement) // IF IE
		keyCode = event.keyCode;
	else if (event.target){ // IF Firefox
		keyCode = event.which;
		
		if(keyCode == 0)
			return true;
	}
	
	if (keyCode == 8 || keyCode == 44 || keyCode == 46 || (keyCode >= 48 && keyCode <= 57))
		return true;

	return false;
}

/**
 * Método utilizado para permitir somente letras
 * 
 * @param event
 * @return
 * 
 * Uso:
 */
function permitirSomenteLetras(event) {
	var keyCode = 0;
	
	if (event.srcElement) // IF IE
		keyCode = event.keyCode;
	else if (event.target){ // IF Firefox
		keyCode = event.which;

		if(keyCode == 0)
			return true;
	}
	
	var BACKSPACE = 8;
	var ENTER = 13;
	var SPACE = 32;
	var DOT = 46;
	
	if(BACKSPACE || ENTER || SPACE || DOT){
		return true;
	}
	
	/* Caracteres de A a z*/
	if (keyCode >= 65 && keyCode <= 122){
		return true;
	}

	return false;
}