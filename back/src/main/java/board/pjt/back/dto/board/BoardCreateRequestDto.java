package board.pjt.back.dto.board;

import java.util.Objects;

public class BoardCreateRequestDto {
    private String title;
    private String content;
    private int rating;
    private String main_image_path;
    private int category_id;

    public BoardCreateRequestDto() {
    }

    public BoardCreateRequestDto(String title, String content, int rating, String main_image_path, int category_id) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.main_image_path = main_image_path;
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "BoardCreateRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", main_image_path='" + main_image_path + '\'' +
                ", category_id=" + category_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCreateRequestDto that = (BoardCreateRequestDto) o;
        return rating == that.rating && category_id == that.category_id && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(main_image_path, that.main_image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, rating, main_image_path, category_id);
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMain_image_path() {
        return main_image_path;
    }

    public void setMain_image_path(String main_image_path) {
        this.main_image_path = main_image_path;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
