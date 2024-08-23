package board.pjt.back.dto.common;

public class PaginationRequestDto {
    int page;
    int pageSize;

    public PaginationRequestDto() {
    }

    public PaginationRequestDto(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
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
