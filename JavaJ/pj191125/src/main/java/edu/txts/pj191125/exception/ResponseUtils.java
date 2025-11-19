package edu.txts.pj191125.exception;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 13:46
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/

public class ResponseUtils {

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .status(200)
                .code(0) // success code = 0
                .message("Success")
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static ApiResponse<?> error(ErrorCode errorCode) {
        return ApiResponse.builder()
                .status(errorCode.getStatus().value())
                .code(errorCode.getCode())
                .message(errorCode.getMessage("en"))
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static ApiErrorResponse error(ErrorCode errorCode, String instance, String traceId) {
        return ApiErrorResponse.builder()
                .type("https://example.com/errors/" + errorCode.name())
                .title(errorCode.getMessage("en"))
                .detail(errorCode.getMessage("en"))
                .status(errorCode.getStatus().value())
                .code(errorCode.getCode())
                .instance(instance)
                .traceId(traceId)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
