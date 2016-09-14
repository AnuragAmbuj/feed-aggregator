package com.feedzard.feedaggregator.reader;

import com.feedzard.feedaggregator.models.Feed;
import com.feedzard.feedaggregator.models.FeedMessage;
import com.feedzard.feedaggregator.parser.FeedParserSymbols;
import com.feedzard.logging.Log;
import org.jetbrains.annotations.Contract;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import static com.feedzard.feedaggregator.parser.FeedParserSymbols.*;

/**
 * Created by aambuj on 06-09-2016.
 */
public class RSSFeedReader {
    final URL feedUrl;

    private RSSFeedReader(URL feedUrl)throws MalformedURLException {
        this.feedUrl = feedUrl;
    }
    public Feed readFeed() throws XMLStreamException {
        Feed feed = null;
        try {
            boolean isFeedHeader = true;
            // Set header values intial to the empty string
            String description = "";
            String title = "";
            String link = "";
            String language = "";
            String copyright = "";
            String author = "";
            String pubdate = "";
            String guid = "";

            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = getInputStream();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName()
                            .getLocalPart();
                    switch (localPart) {
                        case FeedParserSymbols.ITEM:
                            if (isFeedHeader) {
                                isFeedHeader = false;
                                feed = new Feed(title, link, description, language,
                                        copyright, pubdate);
                            }
                            event = eventReader.nextEvent();
                            break;
                        case TITLE:
                            title = getCharacterData(event, eventReader);
                            break;
                        case DESCRIPTION:
                            description = getCharacterData(event, eventReader);
                            break;
                        case LINK:
                            link = getCharacterData(event, eventReader);
                            break;
                        case GUID:
                            guid = getCharacterData(event, eventReader);
                            break;
                        case LANGUAGE:
                            language = getCharacterData(event, eventReader);
                            break;
                        case AUTHOR:
                            author = getCharacterData(event, eventReader);
                            break;
                        case PUB_DATE:
                            pubdate = getCharacterData(event, eventReader);
                            break;
                        case COPYRIGHT:
                            copyright = getCharacterData(event, eventReader);
                            break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                        FeedMessage message = new FeedMessage();
                        message.setAuthor(author);
                        message.setDescription(description);
                        message.setFeedId(guid);
                        message.setLink(link);
                        message.setTitle(title);
                        feed.getMessages().add(message);
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private InputStream getInputStream() {
        try {
            return feedUrl.openStream();
        } catch (IOException e) {
            System.out.println("No connection/Connection Timed out");
            throw new RuntimeException(e);
        }
    }

    @Contract("null -> fail; !null -> !null")
    public static RSSFeedReader getSafeInstance(String feedUrl) throws MalformedURLException {
        if (feedUrl == null) {
            Log.writeLine(Level.SEVERE, "Malformed URL Exception");
            throw new MalformedURLException("Malformed URL ENcountered.");
        } else {
            return new RSSFeedReader(new URL(feedUrl));
        }

    }
}
