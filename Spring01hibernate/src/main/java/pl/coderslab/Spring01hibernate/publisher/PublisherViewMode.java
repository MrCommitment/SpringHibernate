package pl.coderslab.Spring01hibernate.publisher;

public class PublisherViewMode {

    private String mode;
    private long objectId;
    private String searchMode = "all";
    private String nipSearch;
    private String regonSearch;

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

    public String getNipSearch() {
        return nipSearch;
    }

    public void setNipSearch(String nipSearch) {
        this.nipSearch = nipSearch;
    }

    public String getRegonSearch() {
        return regonSearch;
    }

    public void setRegonSearch(String regonSearch) {
        this.regonSearch = regonSearch;
    }
}
