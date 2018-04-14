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
		Status tweet = twitter.updateStatus("Mmmooooooooooooo!!");
	    	System.out.println("Successfully tweeted ----> " + tweet.getText());
	    
		
		
		//API 3: Direct messaging
	    //TYLER
	    	DirectMessage dm = twitter.sendDirectMessage(twitter.getScreenName(), "What kind of magic do cows believe in? MOODOO.");
	    	System.out.println("\""+dm.getText() +"\" was sent to @" + dm.getRecipientScreenName());
	    
	    
		
		
		//API 4: Finding tweets with keywords "YouTube" and "shooting"
	  	//INDERJIT
        
        Query q = new Query("youtube"+"shooting");
        QueryResult qr = twitter.search(q);
        System.out.println("Showing results for \"YouTube\" and \"shooting\":");
        System.out.println();
        for (Status s : qr.getTweets()) {
            System.out.println("@" + s.getUser().getScreenName() + ":" + s.getText());
        }
		
		
		//API 5: Getting followers
		//INDERJIT
        
        IDs id = twitter.getFollowersIDs(twitter.getScreenName(), -1);
        long[] idslist = id.getIDs();
        System.out.println(twitter.getScreenName()+" is followed by:");
        System.out.println();
        int x= 1;
        for (long i : idslist) {
            twitter4j.User user = twitter.showUser(i);
            System.out.println( x +". "+ user.getScreenName()+" follows you!");
            x++;
        }
        System.out.println();



		
		// API 6: Getting Followers of followers
      for (long y : idslist) {
          twitter4j.User user = twitter.showUser(y);
          // idofFoF = id of follower of follower
          IDs idofFoF = twitter.getFollowersIDs(user.getScreenName(), -1);
          System.out.println(user.getScreenName()+" is followed by:");
          long[] idofFoFList = idofFoF.getIDs();
          int z=1;
          for (long a : idofFoFList) {
              System.out.println(z + ": " + twitter.showUser(a).getScreenName());
              z++;
          }

      }
        
		
		//API 7: Getting the locations that Twitter has trending topic information for
		ResponseList<Location> location;
      location = twitter.getAvailableTrends();
      System.out.println("Twitter has trending information for the following cities:");
      int count =1;
      
		for (Location l : location) {
            // woeid = where on earth identifier by Yahoo!
        	// is given by l.getWoeid()
            System.out.println(count +". "+ l.getName() + " in "+ l.getCountryName());
            count++;      
        }

		
		
	//API 8
	//RYAN
		
	File updatedPic = new File("C:\\Users\\Steve\\Desktop\\Code\\img.png");
        twitter.updateProfileImage(updatedPic);
        System.out.println("Profile picture updated!");

        //API 9
        //RYAN
        
        ResponseList<Status> tt = twitter.getUserTimeline(twitter.getScreenName());
        for(Status b: tt) {
                //Displaying the tweets 
            System.out.println(twitter.getScreenName() +" posted "+b.getText()+" on "+b.getCreatedAt()+ ". It was retweeted "+b.getRetweetCount()+" times.");

        }
		

        
	    
	    
	}
}
