package board.pjt.back.dto.category;

public class CategorySelectResponseDto {
    private Integer category_id;
    private String name;

    public CategorySelectResponseDto() {
    }

    public CategorySelectResponseDto(Integer category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
