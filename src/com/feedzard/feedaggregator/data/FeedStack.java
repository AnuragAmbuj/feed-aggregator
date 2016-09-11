package com.feedzard.feedaggregator.data;

import com.feedzard.feedaggregator.models.Feed;
import com.feedzard.logging.Log;

import java.util.Stack;
import java.util.logging.Level;

/**
 * Created by aambuj on 10-09-2016.
 */
public class FeedStack extends Stack<Feed> {

    private static final int MAX_CAPACITY = 100;

    Feed feed[] = new Feed[MAX_CAPACITY];
    int topOfStack = -1;

    public FeedStack() {
        super();
    }

    @Override
    public Feed push(Feed item) {
        if(topOfStack < MAX_CAPACITY)
            feed[++topOfStack]= new Feed(item);
        else
            Log.writeLine(Level.WARNING,"Top of stack reached, cannot push Feeds any further");
        return item;
    }

    @Override
    public synchronized Feed pop() {
            return feed[topOfStack--];
    }

    @Override
    public synchronized Feed peek() {

            return feed[topOfStack-1];

    }

    @Override
    public boolean empty() {
        if(topOfStack < 0)
            return true;
        else
            return false;
    }

    @Override
    public synchronized int search(Object o) {
        return super.search(o);
    }
}
