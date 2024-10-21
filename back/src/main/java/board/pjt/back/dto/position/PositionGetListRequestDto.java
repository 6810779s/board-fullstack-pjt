package board.pjt.back.dto.position;

import java.util.Objects;

public class PositionGetListRequestDto {
    private String created_by;

    public PositionGetListRequestDto() {
    }

    public PositionGetListRequestDto(String created_by) {
        this.created_by = created_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionGetListRequestDto that = (PositionGetListRequestDto) o;
        return Objects.equals(created_by, that.created_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created_by);
    }

    @Override
    public String toString() {
        return "PositionGetListRequestDto{" +
                "created_by='" + created_by + '\'' +
                '}';
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
