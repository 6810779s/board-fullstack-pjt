package board.pjt.back.dto.projectParticipant;

import java.util.Objects;

public class ProjectParticipantGetByBoardIdRequestDto {
    private int board_id;

    public ProjectParticipantGetByBoardIdRequestDto() {
    }

    public ProjectParticipantGetByBoardIdRequestDto(int board_id) {
        this.board_id = board_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectParticipantGetByBoardIdRequestDto that = (ProjectParticipantGetByBoardIdRequestDto) o;
        return board_id == that.board_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id);
    }

    @Override
    public String toString() {
        return "ProjectParticipantGetByBoardIdRequestDto{" +
                "board_id=" + board_id +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

}
