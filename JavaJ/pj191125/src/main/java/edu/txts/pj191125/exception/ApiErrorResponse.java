package edu.txts.pj191125.exception;

import lombok.Builder;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 16:00
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Builder
public class ApiErrorResponse {
	private String type;        // URI xác định nhóm lỗi
	private String title;       // ngắn gọn, message
	private String detail;      // chi tiết lỗi
	private int status;         // HTTP status
	private int code;           // errorCode
	private String instance;    // endpoint
	private String traceId;     // log trace
	private long timestamp;
}
