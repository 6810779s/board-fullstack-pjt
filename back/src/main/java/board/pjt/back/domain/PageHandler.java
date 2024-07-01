package board.pjt.back.domain;

import java.util.Collections;
import java.util.List;

public class PageHandler<T> {
    private List<T> contents = Collections.emptyList();
    private int totalItems;
    private int totalPages;
    private int pageSize;
    private int page; // 0부터 시작
    private int numberOfElements;
    private boolean hasPrevious;
    private boolean hasNext;
    private boolean isFirst;
    private boolean isLast;

    public PageHandler(int totalItems, int page, int pageSize) {
        this.totalItems = totalItems;
        this.page = page;
        this.pageSize = pageSize;

        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.hasPrevious = page > 0;
        this.hasNext = page < this.totalPages - 1;

        this.isFirst = this.page == 0;
        this.isLast = this.page == this.totalPages - 1;

    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "contents=" + contents +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                ", page=" + page +
                ", numberOfElements=" + numberOfElements +
                ", hasPrevious=" + hasPrevious +
                ", hasNext=" + hasNext +
                ", isFirst=" + isFirst +
                ", isLast=" + isLast +
                '}';
    }


    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> allContents) {
        int fromIndex = this.page * this.pageSize;
        int endIndex = Math.min(fromIndex + this.pageSize, allContents.size());
        this.contents = allContents.subList(fromIndex, endIndex);
        this.numberOfElements = contents.size();
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }


}
