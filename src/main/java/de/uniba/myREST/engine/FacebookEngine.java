package de.uniba.myREST.engine;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Page;
import com.restfb.types.User;
import de.uniba.myREST.response.AccountInfoResponse;
import de.uniba.myREST.response.FavoritePageResponse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class FacebookEngine is responsible for the establishing connection with Facebook Graph Api and fetch the desired information from our account
 * Created by chandan on 03.09.16.
 */
public class FacebookEngine {

    /**
     * Declaring the Java Util Logger Object for enabling logging in the FacebookEngine class
     */
    private static Logger loggerFacebookEngine = Logger.getLogger(FacebookEngine.class.getName());

    /**
     * We have generated the extended access token by registering an application with facebook in developer mode and using application id and application secret
     */
    private static String accessToken = "EAAXYmkoMJt0BACVZCZAPAcGfIFtpYFVoqTYlm73GcfPOZC96O2ZBxupBZBNn8dPKsxnsCmxenHTH03pvAkDcIobR1vjLt81TZAqUuanXFTYqQK1NHmciRvqfNpbvOw6zbZBpLQ6BoTu5wNz4qZCXdp0XtEmetav26RUZD";

    /**
     * Creating Facebook Client object to establish the connection with Facebook Graph Api
     */
    FacebookClient fbClientObject = new DefaultFacebookClient(accessToken,Version.LATEST);


    /**
     * Method getFacebookAccountInfo fetches my account information from Facebook Graph Api.
     * @return
     */
    public AccountInfoResponse getFacebookAccountInfo(){
        loggerFacebookEngine.info("Class FacebookEngine/Method getFacebookAccountInfo: Start Logging");

        AccountInfoResponse myAccountInfoResponse;
        User mySelf =fbClientObject.fetchObject("me",User.class);

        myAccountInfoResponse = new AccountInfoResponse(mySelf.getName(),
                mySelf.getId());

        loggerFacebookEngine.info("Class FacebookEngine/Method getFacebookAccountInfo: Done Logging");
        return myAccountInfoResponse;

    }


    public List<FavoritePageResponse> getUsersFevoritePages(){

        List<FavoritePageResponse> favoriteResponse = new LinkedList<>();


        loggerFacebookEngine.info("Class FacebookEngine/Method getUsersFevoritePages: Start Logging");
        Connection<Page> favoritePage = fbClientObject.fetchConnection("me/likes",Page.class);

        for(List<Page> newPage: favoritePage){
            for(Page likedPage: newPage){

                favoriteResponse.add(new FavoritePageResponse(likedPage.getName(),likedPage.getAbout(),likedPage.getId(),"fb.com/"+likedPage.getId()));
            }
        }
        return favoriteResponse;
    }
}
