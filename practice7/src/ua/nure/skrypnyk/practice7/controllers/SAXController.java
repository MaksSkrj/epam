package ua.nure.skrypnyk.practice7.controllers;


import java.io.IOException;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.skrypnyk.practice7.constants.Constants;
import ua.nure.skrypnyk.practice7.constants.XML;
import ua.nure.skrypnyk.practice7.entity.OldCard;
import ua.nure.skrypnyk.practice7.entity.OldCards;
import ua.nure.skrypnyk.practice7.entity.Type;

import javax.xml.parsers.*;


public class SAXController extends DefaultHandler {
    private String xmlFileName;
    private OldCards oldCards;
    private OldCard oldCard;
    private Type type;


    private String currentElement;

    public SAXController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }


    public void parse(boolean validate) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);

        if (validate) {
            factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlFileName, this);
    }


    public OldCards getOldCards() {
        return oldCards;
    }

    public void error(SAXParseException e) throws SAXException {
        throw e;
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = localName;

        XML xmlElement = XML.getXMLObject(currentElement);
        switch (xmlElement) {
            case OLDCARDS:
                oldCards = new OldCards();
                break;
            case OLDCARD:
                oldCard = new OldCard();
                break;
            case TYPE:
                type = new Type();
                break;
        }
    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
        XML xmlElement = XML.getXMLObject(localName);

        switch (xmlElement) {
            case OLDCARD:
                oldCards.getOldCards().add(oldCard);
                break;
            case TYPE:
                oldCard.setType(type);
                break;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);

        if (text.trim().isEmpty())
            return;

        XML xmlElement = XML.getXMLObject(currentElement);
        switch (xmlElement) {
            case THEME:
                oldCard.setTheme(text);
                break;
            case COUNTRY:
                oldCard.setCountry(text);
                break;
            case YEAR:
                oldCard.setYear(text);
                break;
            case AUTHOR:
                oldCard.setAuthor(text);
                break;
            case VALUABLE:
                oldCard.setValuable(text);
                break;
            case TYPEOFCARD:
                type.setTypeOfCard(text);
                break;
            case ISPOSTED:
                type.setPosted(Boolean.valueOf(text));
                break;
        }
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXController saxController = new SAXController(Constants.VALID_XML_FILE);
        saxController.parse(true);
        OldCards oldCards = saxController.getOldCards();
        System.out.println("==================================");
        System.out.print(oldCards);
        System.out.println("==================================");
        saxController = new SAXController(Constants.INVALID_XML_FILE);
        try {
            saxController.parse(true);
        }
        catch (Exception e) {
            System.err.println("====================================");
            System.err.println("Validation is failed:\n" + e.getMessage());
            System.err.println("Try to print OldCards object: " + saxController.getOldCards());
            System.err.println("====================================");
        }
        saxController.parse(false);
        System.out.println("====================================");
        System.out.print(saxController.getOldCards());
        System.out.println("====================================");
    }
}
