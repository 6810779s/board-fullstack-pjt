package board.pjt.back.dto.statusMessage;

import java.util.Objects;

public class StatusMessageCreateRequestDto {
    private String content;
    private String created_by;

    public StatusMessageCreateRequestDto() {
    }

    public StatusMessageCreateRequestDto(String content, String created_by) {
        this.content = content;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusMessageCreateRequestDto that = (StatusMessageCreateRequestDto) o;
        return Objects.equals(content, that.content) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, created_by);
    }

    @Override
    public String toString() {
        return "StatusMessageCreateRequestDto{" +
                "content='" + content + '\'' +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
