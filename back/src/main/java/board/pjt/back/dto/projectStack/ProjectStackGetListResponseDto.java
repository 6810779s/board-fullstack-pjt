package board.pjt.back.dto.projectStack;

import java.util.Objects;

public class ProjectStackGetListResponseDto {
    private String name;

    public ProjectStackGetListResponseDto() {
    }

    public ProjectStackGetListResponseDto(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectStackGetListResponseDto that = (ProjectStackGetListResponseDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ProjectStackGetListResponseDto{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
