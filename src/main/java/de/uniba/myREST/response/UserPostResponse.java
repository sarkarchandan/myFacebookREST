package de.uniba.myREST.response;

/**
 * Define UserPostResponse as a custom datatype
 * @author Created by chandan on 03.09.16.
 */
public class UserPostResponse {

    private String postID;
    private String postStory;

    private String postCreatedTime;

    public UserPostResponse() {
    }


    /**
     * Constructor for class UserPostResponse
     * @param postID
     * @param postStory
     * @param postCreatedTime
     */
    public UserPostResponse(String postID, String postStory, String postCreatedTime) {
        this.postID = postID;
        this.postStory = postStory;
        this.postCreatedTime = postCreatedTime;
    }

    /*
     * Getter and Setter methods for instance variables
     */
    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPostStory() {
        return postStory;
    }

    public void setPostStory(String postStory) {
        this.postStory = postStory;
    }

    public String getPostCreatedTime() {
        return postCreatedTime;
    }

    public void setPostCreatedTime(String postCreatedTime) {
        this.postCreatedTime = postCreatedTime;
    }
}
