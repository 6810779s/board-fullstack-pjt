package board.pjt.back.dto.category;

public class CategorySelectRequestDto {
    private long category_id;

    public CategorySelectRequestDto() {
    }

    public CategorySelectRequestDto(long category_id) {
        this.category_id = category_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
