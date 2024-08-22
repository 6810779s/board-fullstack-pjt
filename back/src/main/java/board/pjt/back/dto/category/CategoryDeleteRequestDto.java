package board.pjt.back.dto.category;

public class CategoryDeleteRequestDto {
    private Integer category_di;

    public CategoryDeleteRequestDto() {
    }

    public CategoryDeleteRequestDto(Integer category_di) {
        this.category_di = category_di;
    }

    public Integer getCategory_di() {
        return category_di;
    }

    public void setCategory_di(Integer category_di) {
        this.category_di = category_di;
    }
}
