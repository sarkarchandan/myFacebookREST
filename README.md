# myFacebookREST
[RestFB](http://restfb.com/) is a Facebook Graph API, open source software released under the terms of the MIT License. This API is being used in this implementation to fetch the basic account information for the user along with all liked Facebook pages and a given no of Facebook posts made by or associated  with the user. All outcomes will be serialized as JSON objects. Any web browser or REST Client e.g. Chrome Advanced REST Client could be used for it. This implementation is built in Linux environment.

## Assumption
- This implementation creates Web Application Archive (.war) file and deploys the same in [Glassfish](https://glassfish.java.net/) container which can be downloaded from the link.
- It assumes that the user has a native installation of [Gradle](https://gradle.org/) or a [Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) pattern may also be used.
- The user should have an active Facebook account ofcourse :wink:

## Installation
Clone the [GitHub Repository](https://github.com/sarkarchandan/myFacebookREST)
```sh
$ git clone  https://github.com/sarkarchandan/myFacebookREST
$ cd myFacebookREST
```
## Usage
### Create Credentials
- While being logged on to Facebook, go to [Facebook Developers Tools and Support for Graph API Explorer](https://developers.facebook.com/tools/explorer/) page.
- Click on the `Get Token` and choose `Get User Access Token` option. In the pop-up window select all the check boxes or as it may suit and follow the subsequent self-explanatory instructions to get the temporary Access Token generated. This token will be required to make a secure call to the Facebook Graph API.
- A comprehensive guide for using the Facebook Graph API Explorer along with generating the temporary access token for the applications can be found [here](https://www.youtube.com/watch?v=WteK95AppF4)
### Import
- This implementation has been built using IntelliJ Idea but any IDE of user’s choice e.g. Eclipse can be used to import the project. Execute the corresponding gradle plug in to build the project workspace before importing.
```sh
$ gradle idea
```
OR
```sh
$ gradle eclipse
```
- Enter the generated Access Token to the respective static field of the **FacebookEngine** class of the package _de.uniba.myREST.engine_
- Make sure that glassfish server container is running.
- Build the archive and deploy to the Container.
```sh
$ gradle build
$ gradle deploy
```
## Sample Execution
Open the web browser or Chrome Advanced REST Client and enter the URI with query strings such as:
- For account Information: `http://localhost:8080/facebookData/accountInfo/`
### Sample Outcome
```
{
"numberOfFriends": #No Of Friends{long}#
"userID": "###############{String}"
"userName": "Chandan Sarkar"
}
```
- For liked pages: `http://localhost:8080/facebookData/favoritePages`
```
{
"favoritePageId": "235646636483840"
"favoritePageName": "Otto-Friedrich-Universität Bamberg"
"favoritePageURI": "fb.com/235646636483840"
}
{
"favoritePageId": "1501508160177294"
"favoritePageName": "The Unlikely Partners Network"
"favoritePageURI": "fb.com/1501508160177294"
}
.
.
.
```
- For a given no of user posts: `http://localhost:8080/facebookData/userPosts?numberOfPosts=10`
```
{
"postCreatedTime": "Wed Aug 03 21:49:19 CEST 2016"
"postID": "1078227922215107_1055778701126696"
"postStory": "Chandan Sarkar shared Bright Side's video."
}-
{
"postCreatedTime": "Wed Aug 03 21:18:19 CEST 2016"
"postID": "1078227922215107_1055758731128693"
"postStory": "Chandan Sarkar shared Indiatimes's video."
}
.
.
.
```
# Known Issues
- At this point **FacebookEngine** class expects the credential to be entered directly to the class body. I am working to come up with better method for that.
- There is a way of extending the temporary access token to a longer surviving token, programmatically which is not included in this implementation at this point. I am working to include the same.
-  **numberOfPosts** field is lacking validation as of now. I am working to add validation for it.
- We have used one of the multiple Constructors available for **DefaultFacebookClient** class from the package _com.restfb_ which takes Access Token and API Version as parameters. One issue with using this particular Constructor is, irrespective of the chosen API Version, many of the attributes related to user’s Facebook account return null values. There exist few simpler version of Constructors which returns more or less all attributes but they are unfortunately deprecated. I am exploring to find a better way to sort this out with trying other available Constructors.
**I am open to any suggestions or comments.**
