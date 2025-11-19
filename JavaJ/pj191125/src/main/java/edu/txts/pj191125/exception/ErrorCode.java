package edu.txts.pj191125.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 13:44
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

@Getter
public enum ErrorCode {

	/*// 4xx
	INVALID_INPUT(1000, "Invalid input data", HttpStatus.BAD_REQUEST),
	USER_NOT_FOUND(1001, "User not found", HttpStatus.NOT_FOUND),
	EMAIL_EXISTED(1002, "Email already existed", HttpStatus.CONFLICT),

	// 5xx
	INTERNAL_SERVER_ERROR(2000, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),*/

	// ===== AUTH =====
	AUTH_INVALID_TOKEN(1000, "Invalid token", "Token không hợp lệ", HttpStatus.UNAUTHORIZED),
	AUTH_ACCESS_DENIED(1001, "Access denied", "Không có quyền truy cập", HttpStatus.FORBIDDEN),

	// ===== USER =====
	USER_NOT_FOUNDV2(2000, "User not found", "Người dùng không tồn tại", HttpStatus.NOT_FOUND),
	USER_EMAIL_EXISTED(2001, "Email already exists", "Email đã tồn tại", HttpStatus.CONFLICT),

	// ===== SYSTEM =====
	SYSTEM_INTERNAL_ERROR(9000, "Internal server error", "Lỗi hệ thống", HttpStatus.INTERNAL_SERVER_ERROR);

	private final int code;
	private final String messageEn;
	private final String messageVn;
	private final HttpStatus status;

	ErrorCode(int code, String messageEn, String messageVn, HttpStatus status) {
		this.code = code;
		this.messageEn = messageEn;
		this.messageVn = messageVn;
		this.status = status;
	}

	/*ErrorCode(int code, String messageEn, HttpStatus status) {
		this.code = code;
		this.messageEn = messageEn;
		this.status = status;
	}*/


	public String getMessage(String lang) {
		if ("vn".equalsIgnoreCase(lang)) return messageVn;
		return messageEn; // default English
	}
}
