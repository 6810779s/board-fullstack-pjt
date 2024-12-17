package board.pjt.back.dto.common;

import board.pjt.back.enums.board.ProjectFilterSearchType;

public class PaginationRequestDto {
    private int page;
    private int pageSize;
    private ProjectFilterSearchType searchType;
    private String keyword;

    public PaginationRequestDto() {
    }

    public PaginationRequestDto(int page, int pageSize, ProjectFilterSearchType searchType, String keyword) {
        this.page = page;
        this.pageSize = pageSize;
        this.searchType = searchType;
        this.keyword = keyword;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
