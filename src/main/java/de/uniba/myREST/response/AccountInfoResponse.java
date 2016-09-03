package de.uniba.myREST.response;

import java.util.List;

/**
 * Created by chandan on 03.09.16.
 */
public class AccountInfoResponse {

    private String userName;
    private String userID;
    private long numberOfFriends;

    public AccountInfoResponse() {
    }

    public AccountInfoResponse(String userName, String userID, long numberOfFriends) {
        this.userName = userName;
        this.userID = userID;
        this.numberOfFriends = numberOfFriends;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public long getNumberOfFriends() {
        return numberOfFriends;
    }

    public void setNumberOfFriends(long numberOfFriends) {
        this.numberOfFriends = numberOfFriends;
    }
}
