package board.pjt.back.dto.projectParticipant;

import java.util.List;
import java.util.Objects;

public class ProjectParticipantCreateRequestDto {
    private int board_id;
    private List<ProjectParticipantListDto> participant_list;

    public ProjectParticipantCreateRequestDto() {
    }

    public ProjectParticipantCreateRequestDto(int board_id, List<ProjectParticipantListDto> participant_list) {
        this.board_id = board_id;
        this.participant_list = participant_list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectParticipantCreateRequestDto that = (ProjectParticipantCreateRequestDto) o;
        return board_id == that.board_id && Objects.equals(participant_list, that.participant_list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, participant_list);
    }

    @Override
    public String toString() {
        return "ProjectParticipantCreateRequestDto{" +
                "board_id=" + board_id +
                ", participant_list=" + participant_list +
                '}';
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public List<ProjectParticipantListDto> getParticipant_list() {
        return participant_list;
    }

    public void setParticipant_list(List<ProjectParticipantListDto> participant_list) {
        this.participant_list = participant_list;
    }
}
