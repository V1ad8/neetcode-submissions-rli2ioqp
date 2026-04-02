class Twitter {
    boolean[][] followed;
    List<Pair<Integer, Integer>> tweets;

    public Twitter() {
        followed = new boolean[100][100];
        tweets = new ArrayList();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(0, new Pair(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList();

        for (var tweet : tweets) {
            if (userId == tweet.getValue() || followed[userId - 1][tweet.getValue() - 1]) {
                res.add(tweet.getKey());
                if (res.size() == 10) {
                    break;
                }
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followed[followerId - 1][followeeId - 1] = true;
    }
    
    public void unfollow(int followerId, int followeeId) {
        followed[followerId - 1][followeeId - 1] = false;
    }
}
