package board.pjt.back.dto.statusMessage;

import java.util.Objects;

public class StatusMessageGetListResponseDto {
    private int status_message_id;
    private String content;
    private String created_by;

    public StatusMessageGetListResponseDto() {
    }

    public StatusMessageGetListResponseDto(int status_message_id, String content, String created_by) {
        this.status_message_id = status_message_id;
        this.content = content;
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusMessageGetListResponseDto that = (StatusMessageGetListResponseDto) o;
        return status_message_id == that.status_message_id && Objects.equals(content, that.content) && Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status_message_id, content, created_by);
    }

    @Override
    public String toString() {
        return "StatusMessageGetListResponseDto{" +
                "status_message_id=" + status_message_id +
                ", content='" + content + '\'' +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public int getStatus_message_id() {
        return status_message_id;
    }

    public void setStatus_message_id(int status_message_id) {
        this.status_message_id = status_message_id;
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
