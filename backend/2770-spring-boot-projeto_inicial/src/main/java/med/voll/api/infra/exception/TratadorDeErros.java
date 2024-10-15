package med.voll.api.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarError404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarError400(MethodArgumentNotValidException ex) {
		
		var error = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(error.stream().map(DadosErroValidacao::new).toList());
	}
	
	private record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
