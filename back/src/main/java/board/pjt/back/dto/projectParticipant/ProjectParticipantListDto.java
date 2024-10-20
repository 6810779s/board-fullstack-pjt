package board.pjt.back.dto.projectParticipant;

import java.util.Objects;

public class ProjectParticipantListDto {
    private String participant;

    public ProjectParticipantListDto() {
    }

    public ProjectParticipantListDto(String participant) {
        this.participant = participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectParticipantListDto that = (ProjectParticipantListDto) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant);
    }

    @Override
    public String toString() {
        return "ProjectParticipantListDto{" +
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
