package de.uniba.myREST.service;

import de.uniba.myREST.engine.FacebookEngine;
import de.uniba.myREST.response.FavoritePageResponse;
import de.uniba.myREST.response.UserPostResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * Demonstrates fetching data from the Facebook Account of a user as JSON Objects using RESTful methods.
 * @author Created by chandan on 03.09.16.
 */

@Path("/facebookData")
public class FacebookService {

    /*
     * Declaring the Java Util Logger Object for enabling logging in the FacebookService class
     */
    private static Logger loggerFacebookService = Logger.getLogger(FacebookService.class.getName());

    /*
     * Declaring an object of the FacebookEngine class.
     */
    FacebookEngine newEngine = new FacebookEngine();

    /**
     * Provides a brief information of Facebook Facebook
     * @return Response
     */
    @GET
    @Path("/accountInfo")
    @Produces(APPLICATION_JSON)
    public Response getFacebookAccountInfo(){

        loggerFacebookService.info("Class FacebookService/Method getFacebookAccountInfo: Start Logging");
        try {
            loggerFacebookService.info("Class FacebookService/Method getFacebookAccountInfo: Done Logging");
            return Response.ok(newEngine.getFacebookAccountInfo(), MediaType.APPLICATION_JSON).build();

        }catch (InternalServerErrorException iSE){
            loggerFacebookService.log(Level.SEVERE,"Internal Server Error occurred");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("We have encountered an Internal Server Error").build();
        }

    }

    /**
     * Provides a list of all pages likes by the user in Facebook
     * @return Response
     */
    @GET
    @Path("/favoritePages")
    @Produces(APPLICATION_JSON)
    public Response getFacebookUsersFavoritePages(){

        loggerFacebookService.info("Class FacebookService/Method getFacebookUsersFavoritePages: Start Logging");
        try {
            GenericEntity<List<FavoritePageResponse>> response
                    = new GenericEntity<List<FavoritePageResponse>>(newEngine.getUsersFevoritePages()) {
            };

            loggerFacebookService.info("Class FacebookService/Method getFacebookUsersFavoritePages: Done Logging");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        } catch (InternalServerErrorException iSE){
            loggerFacebookService.log(Level.SEVERE,"Internal Server Error occurred");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("We have encountered an Internal Server Error").build();
        }
    }

    /**
     * Provides a specified no of Facebook posts made by the user
     * @param numberOfPosts
     * @return Response
     */
    @GET
    @Path("/userPosts")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getFacebookPosts(@QueryParam("numberOfPosts") int numberOfPosts){

        loggerFacebookService.info("Class FacebookService/Method getFacebookPosts: Start Logging");
        //TODO Implement validation for the numberOfPosts variable.
        try {
            GenericEntity<List<UserPostResponse>> response
                    = new GenericEntity<List<UserPostResponse>>(newEngine.getUserPosts(numberOfPosts)) {
            };

            loggerFacebookService.info("Class FacebookService/Method getFacebookPosts: Done Logging");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        } catch (InternalServerErrorException iSE){
            loggerFacebookService.log(Level.SEVERE,"Internal Server Error occurred");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("We have encountered an Internal Server Error").build();
        }


    }


}
