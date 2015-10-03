package com.github.abstractpete;

import org.apache.log4j.Logger;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * Created by bcmds on 03.10.2015.
 */
public class TwitterPostTest {
        private static final Logger  LOGGER = Logger.getLogger(TwitterPostTest.class);
    @Test
    public void testTweet() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        Status message = twitter.updateStatus("Ok,it's a test message from Twitter4j("+Math.random()+"):\uD83D\uDCA9");
        LOGGER.info(message.getText());
    }

    @Test
    public void testNewTweeterLogger() throws Exception {
        LOGGER.error("#ERROR Cute error,Dude");
    }
}
