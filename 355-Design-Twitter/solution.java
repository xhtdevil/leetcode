// public class Twitter {
//     private HashMap<Integer, List<Integer>> follower;           //list of follower, those IDs who follow a certain ID
//     private HashMap<Integer, List<Integer>> postTwitter;        //twitters a certain ID will show in getNewsFeed
//     private HashMap<Integer, List<Integer>> selfTwitter;        //twitters a certain ID posted
//     /** Initialize your data structure here. */
//     public Twitter() {
//         followee = new HashMap<Integer, List<Integer>>();
//         postTwitter = new HashMap<Integer, List<Integer>>();
//         selfTwitter = new HashMap<Integer, List<Integer>>();
//     }
    
//     /** Compose a new tweet. */
//     public void postTweet(int userId, int tweetId) {
//         if(!postTwitter.containsKey(userId)){
//             postTwitter.put(userId, new ArrayList<Integer>);
//         }
//         postTwitter.get(userId).add(tweetId);
//          if(!selfTwitter.containsKey(userId)){
//             selfTwitter.put(userId, new ArrayList<Integer>);
//         }
//         selfTwitter.get(userId).add(tweetId);
//         for(int i : follower.get(userId)){
//             if(!postTwitter.containsKey(i)){
//                 postTwitter.put(i, new ArrayList<Integer>);
//             }
//             postTwitter.get(i).add(tweetId);
//         }
//     }
    
//     /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
//     public List<Integer> getNewsFeed(int userId) {
        
//     }
    
//     /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
//     public void follow(int followerId, int followeeId) {
//         if(follower.containsKey(followeeId)){
//             follower.put(followeeId, new ArrayList<Integer>);
//         }
//         follower.get(followeeId).add(follower);
//         if(!postTwitter.containsKey(followerId)){
//             postTwitter.put(followerId, new ArrayList<Integer>);
//         }
//         postTwitter.get(follower).addAll(selfTwitter.get(followeeId));
//     }
    
//     /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
//     public void unfollow(int followerId, int followeeId) {
        
//     }
// }
public class Twitter {
    private static int timeStamp = 0;
    
    // easy to find if user exist
    private Map<Integer, User> userMap;
    
    // Tweet link to next Tweet so that we can save a lot of time
    // when we execute getNewsFeed(userId)
    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next=null;
        }
    }
    
    
    // OO design so User can follow, unfollow and post itself
    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;
        
        public User(int id){
            this.id=id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }
        
        public void follow(int id){
            followed.add(id);
        }
        
        public void unfollow(int id){
            followed.remove(id);
        }
        
        
        // everytime user post a new tweet, add it to the head of tweet list.
        public void post(int id){
            Tweet t = new Tweet(id);
            t.next=tweet_head;
            tweet_head=t;
        }
    }
    
    
    

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
            
    }
    

    
    // Best part of this.
    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with 
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this 
    // heap before we get the 10 most recent tweet.
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userMap.containsKey(userId))   return res;
        
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
        for(int user: users){
            Tweet t = userMap.get(user).tweet_head;
            // very imporant! If we add null to the head we are screwed.
            if(t!=null){
                q.add(t);
            }
        }
        int n=0;
        while(!q.isEmpty() && n<10){
          Tweet t = q.poll();
          res.add(t.id);
          n++;
          if(t.next!=null)
            q.add(t.next);
        }
        
        return res;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */