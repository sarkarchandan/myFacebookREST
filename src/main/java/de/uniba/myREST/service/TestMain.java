package de.uniba.myREST.service;


import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.*;
import de.uniba.myREST.engine.FacebookEngine;
import de.uniba.myREST.response.AccountInfoResponse;
import de.uniba.myREST.response.FavoritePageResponse;
import de.uniba.myREST.response.UserPostResponse;

import java.util.LinkedList;
import java.util.List;

/**
 * Temporary class created for testing
 * Created by chandan on 03.09.16.
 */
public class TestMain {

    private static String accessToken = "EAAXYmkoMJt0BACVZCZAPAcGfIFtpYFVoqTYlm73GcfPOZC96O2ZBxupBZBNn8dPKsxnsCmxenHTH03pvAkDcIobR1vjLt81TZAqUuanXFTYqQK1NHmciRvqfNpbvOw6zbZBpLQ6BoTu5wNz4qZCXdp0XtEmetav26RUZD";


    public static void main(String[] args) {




        FacebookClient fbClientObject = new DefaultFacebookClient(accessToken, Version.LATEST);

        //This local variable is going to contain the User posts and return them as a list of Objects.
        List<UserPostResponse> postsResponse = new LinkedList<>();

        Connection<User> myFriends = fbClientObject.fetchConnection("me/friends", User.class);



        System.out.println(myFriends.getTotalCount());




    }



}
