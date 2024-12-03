package board.pjt.back.dto.projectParticipant;

import board.pjt.back.dto.projectStack.ProjectStackInfo;

import java.util.List;
import java.util.Objects;

public class ProjectParticipantGetMyProjectResponseDto {
    private String title;
    private String content;
    private List<ProjectStackInfo> stackInfoList;

    public ProjectParticipantGetMyProjectResponseDto() {
    }

    public ProjectParticipantGetMyProjectResponseDto(String title, String content, List<ProjectStackInfo> stackInfoList) {
        this.title = title;
        this.content = content;
        this.stackInfoList = stackInfoList;
    }

    @Override
    public String toString() {
        return "BoardGetMyProjectResponseDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", stackInfoList=" + stackInfoList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectParticipantGetMyProjectResponseDto that = (ProjectParticipantGetMyProjectResponseDto) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(stackInfoList, that.stackInfoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, stackInfoList);
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

    public List<ProjectStackInfo> getStackInfoList() {
        return stackInfoList;
    }

    public void setStackInfoList(List<ProjectStackInfo> stackInfoList) {
        this.stackInfoList = stackInfoList;
    }
}
