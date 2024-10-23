package board.pjt.back.enums.friendRequest;

public enum Status {
    PENDING("요청중: 친구 요청이 발송된 상태이며, 상대방이 아직 응답하지 않은 상태."),
    ACCEPTED("수락: 상대방이 친구 요청을 수락한 상태."),
    REJECTED("거절: 상대방이 친구 요청을 거절한 상태."),
    CANCELED("요청 취소: 사용자가 친구 요청을 취소한 상태."),
    BLOCKED("차단: 특정 사용자가 다른 사용자를 차단하여 친구 요청을 받을 수 없는 상태.");
    private final String description;
    Status(String description) {
        this.description = description;
    }

}
