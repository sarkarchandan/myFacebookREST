package de.uniba.myREST.service;


import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.Likes;
import com.restfb.types.Page;
import com.restfb.types.User;
import de.uniba.myREST.engine.FacebookEngine;
import de.uniba.myREST.response.AccountInfoResponse;
import de.uniba.myREST.response.FavoritePageResponse;

import java.util.List;

/**
 * Created by chandan on 03.09.16.
 */
public class TestMain {

    public static void main (String[] args) {

        FacebookEngine newEngine = new FacebookEngine();

        AccountInfoResponse newResponse = newEngine.getFacebookAccountInfo();
        //System.out.println(newResponse.getUserID());
        //System.out.println(newResponse.getUserName());

        List<FavoritePageResponse> favoriteResponse = newEngine.getUsersFevoritePages();
        for (FavoritePageResponse eachResponse: favoriteResponse){
            System.out.println(eachResponse.getFavoritePageName());
            System.out.println(eachResponse.getFavoritePageAbout());
            System.out.println(eachResponse.getFavoritePageId());
            System.out.println(eachResponse.getFavoritePageURI());
        }

    }

}
