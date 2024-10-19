package me.cadastro.Controller;

import me.cadastro.Exceptions.PriceException;
import me.cadastro.Exceptions.ProductNameEmptyException;
import me.cadastro.Exceptions.ProductNullPointerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ObjLongConsumer;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNullPointerException.class)
	public ResponseEntity<Object> capturaErroNull(){
		Map<String, Object> body = new HashMap<String, Object>();

		body.put("message", "verifique os campos do produto");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	@ExceptionHandler(PriceException.class)
	public ResponseEntity<Object> Preco(){
		Map<String, Object> body = new HashMap<String, Object>();

		body.put("message", "verifique o preço do produto");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(ProductNameEmptyException.class)
	public ResponseEntity<Object> capturaErroNameEmpty(){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", "Nome do produto não pode ser vazio.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
}
