package board.pjt.back.domain;

import java.util.Date;
import java.util.Objects;

public class CategoryDto {
    private Integer category_id;
    private String name;
    private Date created_at;
    private String created_by;
    private Date updated_at;
    private String updated_by;

    public CategoryDto() {

    }

    public CategoryDto(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(category_id, that.category_id) && Objects.equals(name, that.name) && Objects.equals(created_at, that.created_at) && Objects.equals(created_by, that.created_by) && Objects.equals(updated_at, that.updated_at) && Objects.equals(updated_by, that.updated_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, name, created_at, created_by, updated_at, updated_by);
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                ", updated_at=" + updated_at +
                ", updated_by='" + updated_by + '\'' +
                '}';
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }


    public String getCreated_by() {
        return created_by;
    }


    public Date getUpdated_at() {
        return updated_at;
    }


    public String getUpdated_by() {
        return updated_by;
    }
    
}
