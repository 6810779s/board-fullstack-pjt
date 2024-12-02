package board.pjt.back.entity;

import java.util.Date;
import java.util.Objects;

public class BoardEntity {
    private long board_id;
    private String title;
    private String content;
    private long category_id;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;

    public BoardEntity() {
    }

    public BoardEntity(String title, String content, long category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(board_id, title, content, category_id, created_at, created_by, updated_at, updated_by);
    }

    @Override
    public String toString() {
        return "Board{" +
                "board_id=" + board_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                '}';
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
