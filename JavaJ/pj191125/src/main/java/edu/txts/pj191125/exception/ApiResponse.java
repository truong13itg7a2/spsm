package edu.txts.pj191125.exception;

import lombok.Builder;
import lombok.Data;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 13:45
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

@Data
@Builder
public class ApiResponse<T> {
	private int status;
	private String message;
	private int code;        // errorCode (1000, 1001…)
	private T data;
	private long timestamp;
}
