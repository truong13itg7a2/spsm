package edu.txts.pj191125.exception;

import lombok.Getter;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 13:44
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

@Getter
public class AppException extends RuntimeException {
	private final ErrorCode errorCode;

	public AppException(ErrorCode errorCode) {
		super(errorCode.getMessage("en")); // default
		this.errorCode = errorCode;
	}

	public AppException(ErrorCode errorCode, String lang) {
		super(errorCode.getMessage(lang));
		this.errorCode = errorCode;
	}
}
