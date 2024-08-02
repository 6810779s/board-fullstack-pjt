package board.pjt.back.common.codes;


/**
 * [공통 코드] API 통신에 대한 '에러 코드'를 Enum 형태로 관리를 한다.
 * Global Error CodeList : 전역으로 발생하는 에러코드를 관리한다.
 * Custom Error CodeList : 업무 페이지에서 발생하는 에러코드를 관리한다
 * Error Code Constructor : 에러코드를 직접적으로 사용하기 위한 생성자를 구성한다.
 *
 * @author lee
 */
public enum ErrorCode {
    BAD_REQUEST_ERROR("FAIL", 400, "Bad Request Exception"),

    // @RequestBody 데이터 미 존재
    REQUEST_BODY_MISSING_ERROR("FAIL", 400, "Required request body is missing"),

    // 유효하지 않은 타입
    INVALID_TYPE_VALUE("FAIL", 400, " Invalid Type Value"),

    // Request Parameter 로 데이터가 전달되지 않을 경우
    MISSING_REQUEST_PARAMETER_ERROR("FAIL", 400, "Missing Servlet RequestParameter Exception"),

    // 입력/출력 값이 유효하지 않음
    IO_ERROR("FAIL", 400, "I/O Exception"),

    // com.google.gson JSON 파싱 실패
    JSON_PARSE_ERROR("FAIL", 400, "JsonParseException"),

    // com.fasterxml.jackson.core Processing Error
    JACKSON_PROCESS_ERROR("FAIL", 400, "com.fasterxml.jackson.core Exception"),

    // 권한이 없음
    FORBIDDEN_ERROR("FAIL", 403, "Forbidden Exception"),

    // 서버로 요청한 리소스가 존재하지 않음
    NOT_FOUND_ERROR("FAIL", 404, "Not Found Exception"),

    // NULL Point Exception 발생
    NULL_POINT_ERROR("FAIL", 404, "Null Point Exception"),

    // @RequestBody 및 @RequestParam, @PathVariable 값이 유효하지 않음
    NOT_VALID_ERROR("FAIL", 404, "handle Validation Exception"),

    // @RequestBody 및 @RequestParam, @PathVariable 값이 유효하지 않음
    NOT_VALID_HEADER_ERROR("FAIL", 404, "Header에 데이터가 존재하지 않는 경우 "),

    // 서버가 처리 할 방법을 모르는 경우 발생
    INTERNAL_SERVER_ERROR("FAIL", 500, "Internal Server Error Exception"),


    ; // End

    /**
     * ******************************* Error Code Constructor ***************************************
     */
    // 에러 코드의 '코드 상태'을 반환한다.
    private final String status;
    // 에러 코드의 '코드간 구분 값'을 반환한다.
    private final int divisionCode;
    // 에러 코드의 '코드 메시지'을 반환한다.
    private final String message;

    // 생성자 구성

    ErrorCode(final String status, final int divisionCode, final String message) {
        this.status = status;
        this.divisionCode = divisionCode;
        this.message = message;
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
}
