package FirstTwitterApp;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.File;
import java.util.List;

public class TwitterApp {
	
	public static void main (String[] args) throws TwitterException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		//took out keys for security reasons		
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("")
				.setOAuthConsumerSecret("")
				.setOAuthAccessToken("")
				.setOAuthAccessTokenSecret("");
				
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();
		
		//API 1: Getting all the tweets on the timeline
		//SHIVANGI
		List<Status> statuses = twitter.getHomeTimeline();
		for(Status status: statuses){
			System.out.println(status.getUser().getName()+" tweeted "+status.getText());
		}
		
		
		//API 2: Posting a tweet
		//TYLER
		
	    
		
		
		//API 3: Direct messaging
	    //TYLER
	    
	    
	    
		
		
		//API 4: Finding tweets with keywords "YouTube" and "shooting"
	  	//INDERJIT
		
		
		//API 5: Getting followers
		//INDERJIT



		
		//API 6: Getting Followers of followers
	    //LANCE
        


		
		
		//API 7: Getting the locations that Twitter has trending topic information for
	    //LANCE

		
		
		//API 8: changing profile pic
	    //RYAN

        
        
	    //API 9: Displaying the tweets on the timeline
	    //RYAN
		

        
	    
	    
	}
}
