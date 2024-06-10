package japdp.damtf.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Controlador de manejo de excepciones que proporciona 
 * métodos para gestionar las excepciones genéricas de la aplicación.
 */
@RestControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleHttpMessageNotReadableException(Exception e) {
		LOGGER.info("JSON Mal formado: {}",e.getMessage());   
		return "JSON Mal formado: " + e;
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleMethodArgumentTypeMismatchException(Exception e) {
		LOGGER.info("Tipo del argumento del método erróneo: {}",e.getMessage());   
		return "Tipo del argumento del método erróneo: " + e;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception e) {
		LOGGER.info("Genérico: {}",e.getMessage());   
		return "Genérico: " + e;
	}

}
