package edu.txts.pj191125.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 13:46
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<ApiErrorResponse> handleAppException(
			AppException ex, HttpServletRequest request) {

		String traceId = UUID.randomUUID().toString();

		log.error("TraceId {} - AppException: {}", traceId, ex.getMessage(), ex);

		ApiErrorResponse response = ApiErrorResponse.builder()
				.type("https://example.com/errors/" + ex.getErrorCode().name())
				.title(ex.getMessage())
				.detail(ex.getMessage())
				.status(ex.getErrorCode().getStatus().value())
				.code(ex.getErrorCode().getCode())
				.instance(request.getRequestURI())
				.traceId(traceId)
				.timestamp(System.currentTimeMillis())
				.build();

		return ResponseEntity.status(ex.getErrorCode().getStatus()).body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorResponse> handleException(Exception ex, HttpServletRequest request) {
		String traceId = UUID.randomUUID().toString();

		log.error("TraceId {} - Unexpected Exception: {}", traceId, ex.getMessage(), ex);

		ApiErrorResponse response = ApiErrorResponse.builder()
				.type("https://example.com/errors/SYSTEM_INTERNAL_ERROR")
				.title("Internal server error")
				.detail(ex.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.code(9000)
				.instance(request.getRequestURI())
				.traceId(traceId)
				.timestamp(System.currentTimeMillis())
				.build();

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}

