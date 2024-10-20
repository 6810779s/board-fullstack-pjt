package board.pjt.back.dto.projectParticipant;

import java.util.Objects;

public class ProjectParticipantGetListByBoardIdResponseDto {
    private String participant;

    public ProjectParticipantGetListByBoardIdResponseDto() {
    }

    public ProjectParticipantGetListByBoardIdResponseDto(String participant) {
        this.participant = participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectParticipantGetListByBoardIdResponseDto that = (ProjectParticipantGetListByBoardIdResponseDto) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant);
    }

    @Override
    public String toString() {
        return "ProjectParticipantGetListByBoardIdResponseDto{" +
                "participant='" + participant + '\'' +
                '}';
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }
}
