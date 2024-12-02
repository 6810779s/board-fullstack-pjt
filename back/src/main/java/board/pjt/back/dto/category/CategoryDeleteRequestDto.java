package board.pjt.back.dto.category;

public class CategoryDeleteRequestDto {
    private long category_id;

    public CategoryDeleteRequestDto() {
    }

    public CategoryDeleteRequestDto(long category_id) {
        this.category_id = category_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
