package de.uniba.myREST.response;

/**
 * Define FavoritePageResponse as a custom datatype
 * @author Created by chandan on 03.09.16.
 */
public class FavoritePageResponse {

    private String favoritePageName;
    private String favoritePageAbout;
    private String favoritePageId;
    private String favoritePageURI;

    public FavoritePageResponse() {
    }

    /**
     * Constructor for class FavoritePageResponse
     * @param favoritePageName
     * @param favoritePageAbout
     * @param favoritePageId
     * @param favoritePageURI
     */
    public FavoritePageResponse(String favoritePageName, String favoritePageAbout, String favoritePageId, String favoritePageURI) {
        this.favoritePageName = favoritePageName;
        this.favoritePageAbout = favoritePageAbout;
        this.favoritePageId = favoritePageId;
        this.favoritePageURI = favoritePageURI;
    }

    /*
     * Getter and Setter methods for instance variables
     */
    public String getFavoritePageName() {
        return favoritePageName;
    }

    public void setFavoritePageName(String favoritePageName) {
        this.favoritePageName = favoritePageName;
    }

    public String getFavoritePageAbout() {
        return favoritePageAbout;
    }

    public void setFavoritePageAbout(String favoritePageAbout) {
        this.favoritePageAbout = favoritePageAbout;
    }

    public String getFavoritePageId() {
        return favoritePageId;
    }

    public void setFavoritePageId(String favoritePageId) {
        this.favoritePageId = favoritePageId;
    }

    public String getFavoritePageURI() {
        return favoritePageURI;
    }

    public void setFavoritePageURI(String favoritePageURI) {
        this.favoritePageURI = favoritePageURI;
    }
}
