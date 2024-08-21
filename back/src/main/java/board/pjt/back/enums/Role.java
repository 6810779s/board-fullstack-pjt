package board.pjt.back.enums;

public enum Role {
    ROLE_ADMIN("관리자"),
    ROLE_USER("일반 사용자");
    private final String description;

    // 생성자
    Role(String description) {
        this.description = description;
    }

    // Getter
    public String getDescription() {
        return description;
    }
}
