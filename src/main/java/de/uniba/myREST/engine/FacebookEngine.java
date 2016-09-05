package de.uniba.myREST.engine;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;
import de.uniba.myREST.response.AccountInfoResponse;
import de.uniba.myREST.response.FavoritePageResponse;
import de.uniba.myREST.response.UserPostResponse;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Establish connection with Facebook Graph Api and fetch information from the account of the user
 * @author Created by chandan on 03.09.16.
 */
public class FacebookEngine {

    /*
     * Declaring the Java Util Logger Object for enabling logging in the FacebookEngine class
     */
    private static Logger loggerFacebookEngine = Logger.getLogger(FacebookEngine.class.getName());

    /*
     * User's Access Token should go here
     */
    private static String accessToken = "EAAXYmkoMJt0BACVZCZAPAcGfIFtpYFVoqTYlm73GcfPOZC96O2ZBxupBZBNn8dPKsxnsCmxenHTH03pvAkDcIobR1vjLt81TZAqUuanXFTYqQK1NHmciRvqfNpbvOw6zbZBpLQ6BoTu5wNz4qZCXdp0XtEmetav26RUZD";

    /*
     * Creating Facebook Client object to establish the connection with Facebook Graph Api
     */
    FacebookClient fbClientObject = new DefaultFacebookClient(accessToken,Version.LATEST);


    /**
     * Fetches account of the user from Facebook Graph Api.
     * @return AccountInfoResponse
     */
    public AccountInfoResponse getFacebookAccountInfo(){
        loggerFacebookEngine.info("Class FacebookEngine/Method getFacebookAccountInfo: Start Logging");

        AccountInfoResponse myAccountInfoResponse;

        /*
         * The defined endpoint of the Facebook Graph API for the account information of the user is "me" and
         * information for user's friends is "me/friends"
         */
        User mySelf =fbClientObject.fetchObject("me",User.class);
        Connection<User> myFriend = fbClientObject.fetchConnection("me/friends",User.class);

        myAccountInfoResponse = new AccountInfoResponse(mySelf.getName(),mySelf.getId(),myFriend.getTotalCount());

        loggerFacebookEngine.info("Class FacebookEngine/Method getFacebookAccountInfo: Done Logging");
        return myAccountInfoResponse;

    }


    /**
     * Fetches the entire List of Facebook Pages liked by the user
     * @return List<FavoritePageResponse>
     */
    public List<FavoritePageResponse> getUsersFevoritePages(){

        loggerFacebookEngine.info("Class FacebookEngine/Method getUsersFevoritePages: Start Logging");

        /*
         * This local variable is going to contain the liked pages and return them as a list of Objects.
         */
        List<FavoritePageResponse> favoriteResponse = new LinkedList<>();

        /*
         * The defined endpoint of the Facebook Graph API for the likes pages of the user is  "me/likes"
         */
        Connection<Page> favoritePage = fbClientObject.fetchConnection("me/likes",Page.class);

        for(List<Page> newPage: favoritePage){
            for(Page likedPage: newPage){

                favoriteResponse.add(new FavoritePageResponse(likedPage.getName(),likedPage.getAbout(),likedPage.getId(),"fb.com/"+likedPage.getId()));
            }
        }
        loggerFacebookEngine.info("Class FacebookEngine/Method getUsersFevoritePages: Done Logging");
        return favoriteResponse;
    }


    /**
     * Fetches the specified no of Facebook posts made by the user
     * @param numberOfPosts
     * @return List<UserPostResponse>
     */
    public List<UserPostResponse> getUserPosts(int numberOfPosts){

        loggerFacebookEngine.info("Class FacebookEngine/Method getUserPosts: Start Logging");

        /*
         * This local variable is going to contain the User posts and return them as a list of Objects.
         */
        List<UserPostResponse> postsResponse = new LinkedList<>();

        /*
         * The defined endpoint of the Facebook Graph API for the posts made by the user is  "me/feed"
         */
        Connection<Post> userPosts = fbClientObject.fetchConnection("me/feed",Post.class);

        for(List<Post> allUserPosts: userPosts){
            for(Post eachUserPost: allUserPosts){

                postsResponse.add(new UserPostResponse(
                        eachUserPost.getId(),
                        eachUserPost.getStory(),
                        eachUserPost.getCreatedTime().toString()
                        ));
                }
            }
        loggerFacebookEngine.info("Class FacebookEngine/Method getUserPosts: Done Logging");
        return postsResponse.subList(0,numberOfPosts);
    }



}

