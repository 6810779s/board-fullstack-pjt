package board.pjt.back.enums.board;

public enum ProjectFilterSearchType {
    ALL("전체"),
    TITLE("제목"),
    CONTENT("내용"),
    PROJECT_NAME("프로젝트명"),
    SKILL("기술");
    private final String description;
    ProjectFilterSearchType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
