package board.pjt.back.dto.category;

public class CategoryCreateRequestDto {
    private String name;
    private String created_by;

    public CategoryCreateRequestDto() {
    }

    public CategoryCreateRequestDto(String name, String created_by) {
        this.name = name;
        this.created_by = created_by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
