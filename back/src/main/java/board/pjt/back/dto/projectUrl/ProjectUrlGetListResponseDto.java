package board.pjt.back.dto.projectUrl;

import java.util.Objects;

public class ProjectUrlGetListResponseDto {
    private String url;
    private String name;

    public ProjectUrlGetListResponseDto() {
    }

    public ProjectUrlGetListResponseDto(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectUrlGetListResponseDto that = (ProjectUrlGetListResponseDto) o;
        return Objects.equals(url, that.url) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, name);
    }

    @Override
    public String toString() {
        return "ProjectUrlGetListResponseDto{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
