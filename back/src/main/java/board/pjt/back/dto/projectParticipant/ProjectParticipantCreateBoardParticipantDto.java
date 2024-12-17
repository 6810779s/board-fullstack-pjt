package board.pjt.back.dto.projectParticipant;

import java.util.Objects;

public class ProjectParticipantCreateBoardParticipantDto {
    private long board_id;
    private String userEmail;

    public ProjectParticipantCreateBoardParticipantDto(long board_id, String userEmail) {
        this.board_id = board_id;
        this.userEmail = userEmail;
    }

    public ProjectParticipantCreateBoardParticipantDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectParticipantCreateBoardParticipantDto that = (ProjectParticipantCreateBoardParticipantDto) o;
        return board_id == that.board_id && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, userEmail);
    }

    @Override
    public String toString() {
        return "ProjectParticipantCreateBoardParticipant{" +
                "board_id=" + board_id +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
