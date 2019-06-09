package pl.coderslab.Spring01hibernate.author;

public class AuthorViewMode {
    private String mode;
    private long objectId;
    private String searchMode = "all";
    public String emailSearch;
    public String peselSearch;
    public String lastNameSearch;

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

    public String getEmailSearch() {
        return emailSearch;
    }

    public void setEmailSearch(String emailSearch) {
        this.emailSearch = emailSearch;
    }

    public String getPeselSearch() {
        return peselSearch;
    }

    public void setPeselSearch(String peselSearch) {
        this.peselSearch = peselSearch;
    }

    public String getLastNameSearch() {
        return lastNameSearch;
    }

    public void setLastNameSearch(String lastNameSearch) {
        this.lastNameSearch = lastNameSearch;
    }
}
