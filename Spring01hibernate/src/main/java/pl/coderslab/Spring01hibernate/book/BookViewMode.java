package pl.coderslab.Spring01hibernate.book;

import pl.coderslab.Spring01hibernate.Category;
import pl.coderslab.Spring01hibernate.publisher.Publisher;

public class BookViewMode {

    private String mode;
    private long objectId;
    private String searchMode = "all";
    private Category categorySearch;
    private String titleSearch;
    private Publisher publisherSearch;
    private int resetRating;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public String getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
    }

    public Category getCategorySearch() {
        return categorySearch;
    }

    public void setCategorySearch(Category categorySearch) {
        this.categorySearch = categorySearch;
    }

    public String getTitleSearch() {
        return titleSearch;
    }

    public void setTitleSearch(String titleSearch) {
        this.titleSearch = titleSearch;
    }

    public Publisher getPublisherSearch() {
        return publisherSearch;
    }

    public void setPublisherSearch(Publisher publisherSearch) {
        this.publisherSearch = publisherSearch;
    }

    public int getResetRating() {
        return resetRating;
    }

    public void setResetRating(int resetRating) {
        this.resetRating = resetRating;
    }
}
