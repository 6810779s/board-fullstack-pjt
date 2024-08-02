package board.pjt.back.common.response;

import board.pjt.back.common.codes.SuccessCode;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private final String status;
    private final int divisionCode;
    private final String message;
    private final LocalDateTime timestamp;
    private T data;

    public ApiResponse() {
        this.status = "SUCCESS";
        this.divisionCode = 200;
        this.message = "OK";
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(final SuccessCode code) {
        this.status = code.getStatus();
        this.divisionCode = code.getDivisionCode();
        this.message = code.getMessage();
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(final SuccessCode code, final T data) {
        this.status = code.getStatus();
        this.divisionCode = code.getDivisionCode();
        this.message = code.getMessage();
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public static <T> ApiResponse<T> of(final SuccessCode code) {
        return new ApiResponse<>(code);
    }

    // Static factory method with SuccessCode and data
    public static <T> ApiResponse<T> of(final SuccessCode code, final T data) {
        return new ApiResponse<>(code, data);
    }

    public String getStatus() {
        return status;
    }

    public int getDivisionCode() {
        return divisionCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }
}
