package board.pjt.back.dto.category;

public class CategorySelectRequestDto {
    private Integer category_id;

    public CategorySelectRequestDto() {
    }

    public CategorySelectRequestDto(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
