package board.pjt.back.common.response;

import board.pjt.back.common.codes.ErrorCode;

import java.time.LocalDateTime;

public class ErrorResponse {
    private final String status;
    private final String message;
    private final LocalDateTime timestamp;
    private final int divisionCode;
    private String reason;

    public ErrorResponse(final ErrorCode code) {
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.divisionCode = code.getDivisionCode();
        this.timestamp = LocalDateTime.now();

    }

    public ErrorResponse(final ErrorCode code, final String reason) {
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.divisionCode = code.getDivisionCode();
        this.timestamp = LocalDateTime.now();
        this.reason = reason;
    }

    public static ErrorResponse of(final ErrorCode code) {
        return new ErrorResponse(code);
    }

    public static ErrorResponse of(final ErrorCode code, final String reason) {
        return new ErrorResponse(code, reason);
    }

    public String getStatus() {
        return status;
    }


    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getDivisionCode() {
        return divisionCode;
    }
}
