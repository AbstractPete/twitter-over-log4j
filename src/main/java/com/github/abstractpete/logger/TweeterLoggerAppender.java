package com.github.abstractpete.logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Created by bcmds on 03.10.2015.
 */
public class TweeterLoggerAppender extends AppenderSkeleton {
    private static final Logger LOGGER = Logger.getLogger(TweeterLoggerAppender.class);
    @Override
    protected void append(LoggingEvent loggingEvent) {
        if (loggingEvent.getLevel().equals(Level.ERROR)){
            try {
                Twitter twitter = TwitterFactory.getSingleton();
                twitter.updateStatus(loggingEvent.getMessage().toString());
            } catch (TwitterException e) {
                LOGGER.warn(e.getMessage());
            }

        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
