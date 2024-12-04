package board.pjt.back.dto.board;


import board.pjt.back.enums.board.ProjectFilterSearchType;

import java.util.Objects;

public class BoardMainRequestDto {
    private ProjectFilterSearchType searchType;
    private String keyword;

    public BoardMainRequestDto() {
    }

    public BoardMainRequestDto(ProjectFilterSearchType searchType, String keyword) {
        this.searchType = searchType;
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "BoardMainRequestDto{" +
                "searchType=" + searchType +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardMainRequestDto that = (BoardMainRequestDto) o;
        return searchType == that.searchType && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchType, keyword);
    }

    public ProjectFilterSearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(ProjectFilterSearchType searchType) {
        this.searchType = searchType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
