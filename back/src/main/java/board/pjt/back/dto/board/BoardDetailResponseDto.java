package board.pjt.back.dto.board;

import board.pjt.back.dto.category.CategorySelectResponseDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class BoardDetailResponseDto {
    private int board_id;
    private String title;
    private String content;
    private CategorySelectResponseDto category;
    private int rating;
    private String main_image_path;
    private BoardDetailResponseDto prevBoard;
    private BoardDetailResponseDto nextBoard;
    private String created_by;
    private LocalDateTime created_at;

    public BoardDetailResponseDto() {
    }

    public BoardDetailResponseDto(int board_id, String title, String content, CategorySelectResponseDto category, int rating, String main_image_path, BoardDetailResponseDto prevBoard, BoardDetailResponseDto nextBoard, String created_by, LocalDateTime created_at) {
        this.board_id = board_id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.rating = rating;
        this.main_image_path = main_image_path;
        this.prevBoard = prevBoard;
        this.nextBoard = nextBoard;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "BoardDetailResponseDto{" +
                "board_id=" + board_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", main_image_path='" + main_image_path + '\'' +
                ", prevBoard=" + prevBoard +
                ", nextBoard=" + nextBoard +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDetailResponseDto that = (BoardDetailResponseDto) o;
        return board_id == that.board_id && rating == that.rating && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(category, that.category) && Objects.equals(main_image_path, that.main_image_path) && Objects.equals(prevBoard, that.prevBoard) && Objects.equals(nextBoard, that.nextBoard) && Objects.equals(created_by, that.created_by) && Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_id, title, content, category, rating, main_image_path, prevBoard, nextBoard, created_by, created_at);
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
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

    public CategorySelectResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategorySelectResponseDto category) {
        this.category = category;
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

    public BoardDetailResponseDto getPrevBoard() {
        return prevBoard;
    }

    public void setPrevBoard(BoardDetailResponseDto prevBoard) {
        this.prevBoard = prevBoard;
    }

    public BoardDetailResponseDto getNextBoard() {
        return nextBoard;
    }

    public void setNextBoard(BoardDetailResponseDto nextBoard) {
        this.nextBoard = nextBoard;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
