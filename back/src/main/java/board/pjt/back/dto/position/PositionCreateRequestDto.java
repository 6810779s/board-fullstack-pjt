package board.pjt.back.dto.position;

import java.util.List;
import java.util.Objects;

public class PositionCreateRequestDto {
    private String created_by;
    private List<PositionNameListDto> position_list;

    public PositionCreateRequestDto() {
    }

    public PositionCreateRequestDto(String created_by, List<PositionNameListDto> position_list) {
        this.created_by = created_by;
        this.position_list = position_list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionCreateRequestDto that = (PositionCreateRequestDto) o;
        return Objects.equals(created_by, that.created_by) && Objects.equals(position_list, that.position_list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created_by, position_list);
    }

    @Override
    public String toString() {
        return "PositionCreateRequestDto{" +
                "created_by='" + created_by + '\'' +
                ", position_list=" + position_list +
                '}';
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public List<PositionNameListDto> getPosition_list() {
        return position_list;
    }

    public void setPosition_list(List<PositionNameListDto> position_list) {
        this.position_list = position_list;
    }
}
