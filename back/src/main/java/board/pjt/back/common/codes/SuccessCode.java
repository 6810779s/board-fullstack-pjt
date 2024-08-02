package board.pjt.back.common.codes;

public enum SuccessCode {

    /**
     * ******************************* Success CodeList ***************************************
     */
    // 조회 성공 코드 (HTTP Response: 200 OK)
    SELECT_SUCCESS("SUCCESS", 200, "SELECT SUCCESS"),
    // 삭제 성공 코드 (HTTP Response: 200 OK)
    DELETE_SUCCESS("SUCCESS", 200, "DELETE SUCCESS"),
    // 삽입 성공 코드 (HTTP Response: 201 Created)
    INSERT_SUCCESS("SUCCESS", 201, "INSERT SUCCESS"),
    // 수정 성공 코드 (HTTP Response: 201 Created)
    UPDATE_SUCCESS("SUCCESS", 204, "UPDATE SUCCESS"),

    ; // End

    /**
     * ******************************* Success Code Constructor ***************************************
     */
    // 성공 코드의 '코드 상태'를 반환한다.
    private final String status;

    // 성공 코드의 '코드 값'을 반환한다.
    private final int divisionCode;

    // 성공 코드의 '코드 메시지'를 반환한다.s
    private final String message;

    SuccessCode() {
        this.status = "SUCCESS";
        this.divisionCode = 200;
        this.message = null;
    }

    // 생성자 구성
    SuccessCode(final String status, final int divisionCode, final String message) {
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
