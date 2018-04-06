package io.seyon.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.seyon.domain.SeyonResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class.getName());
	private HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;

	@Autowired
	ExceptionMapping mapping;

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<SeyonResponse> exceptionHandler(Throwable ex) {

		Class<? extends Throwable> clazz = ex.getClass();

		Integer customErrorCode = null != mapping.getErrorCodeMapping().get(clazz)
				? Integer.parseInt(mapping.getErrorCodeMapping().get(clazz))
				: 503;
		String customMessage = mapping.getErrorMessageMapping().get(clazz);

		SeyonResponse exceptionMessage = new SeyonResponse();

		exceptionMessage.setCode(customErrorCode);
		status = HttpStatus.valueOf(customErrorCode);

		if (null != customMessage) {
			exceptionMessage.setMessage(customMessage);

		} else {
			String msg = ex.getLocalizedMessage();
			exceptionMessage.setMessage(msg);
		}
		log.debug("Error Response Sent back {}",exceptionMessage);
		log.error("Exception Details {}",ex);
		return new ResponseEntity<SeyonResponse>(exceptionMessage, status);
	}
}