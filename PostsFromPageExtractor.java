import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

/*

A simple Facebook4J client which
illustrates how to access group feeds / posts / comments.
@param args
@throws FacebookException
*/
public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("087731084587", "akutai");
// Get an access token from:
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAg945Phx30BAG5MtZA3aClT7yXTWMTriC7LfMqvSw0UYwZBc0fYrX7iEq4wwj2WTFrxnEu2P4Med9u635kcY1b3s426yzTyEXYEpuQZABwHfXAGIb3ZBMtwZBrcoQHOWXWdUYGPRpjWk9ao4AxVliUQZBgWY7rZC6furEt7ZAerGwTYmHq1raJZBIeHvyNAhf9iem4va8oZCqAgZDZD";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

 ResponseList< Post > feeds = facebook.getFeed("2451616434935051",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }
}
