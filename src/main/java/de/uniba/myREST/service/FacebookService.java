package de.uniba.myREST.service;

import de.uniba.myREST.engine.FacebookEngine;
import de.uniba.myREST.response.FavoritePageResponse;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * FacebookService class is at present works as a demonstration of how to fetch data from Our Facebook Account as JSON Objects using RESTful methods.
 * I have created an Application with Facebook in developer mode to implement this program.
 * Created by chandan on 03.09.16.
 */

@Path("/facebookData")
public class FacebookService {

    /**
     * Declaring the Java Util Logger Object for enabling logging in the FacebookService class
     */
    private static Logger loggerFacebookService = Logger.getLogger(FacebookService.class.getName());

    FacebookEngine newEngine = new FacebookEngine();

    /**
     * Method getFacebooAccountInfo provides a brief information of our Account Information in Facebook
     * @return
     */
    @GET
    @Path("/accountInfo")
    @Produces(APPLICATION_JSON)
    public Response getFacebookAccountInfo(){

        return Response.ok(newEngine.getFacebookAccountInfo(), MediaType.APPLICATION_JSON).build();

    }

    @GET
    @Path("/favoritePages")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getFacebookUsersFavoritePages(){

        GenericEntity<List<FavoritePageResponse>> response
                = new GenericEntity<List<FavoritePageResponse>>(newEngine.getUsersFevoritePages()) {};

        return Response.ok(response,MediaType.APPLICATION_JSON).build();
    }


}
