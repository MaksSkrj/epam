package ua.nure.skrypnyk.practice7.controllers;

import ua.nure.skrypnyk.practice7.constants.Constants;
import ua.nure.skrypnyk.practice7.constants.XML;
import ua.nure.skrypnyk.practice7.entity.OldCard;
import ua.nure.skrypnyk.practice7.entity.OldCards;
import ua.nure.skrypnyk.practice7.entity.Type;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

public class STAXController {
    private String xmlFileName;
    private OldCards oldCards;
    private OldCard oldCard;
    private Type type;

    String currentElement;


    public OldCards getOldCards() {
        return oldCards;
    }

    public STAXController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        XMLEventReader reader = factory.createXMLEventReader(new StreamSource(xmlFileName));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isCharacters() && event.asCharacters().isWhiteSpace())
                continue;

            if (event.isStartElement())
                processStartElement((StartElement) event);
            else if (event.isEndElement())
                processEndElement((EndElement) event);
            else if (event.isCharacters())
                processCharacters((Characters) event);
        }
        reader.close();
    }

    private void processStartElement(StartElement element) {
        currentElement = element.getName().getLocalPart();
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

    private void processEndElement(EndElement element) {
        String elementName = element.getName().getLocalPart();
        XML xmlElement = XML.getXMLObject(elementName);

        switch (xmlElement) {
            case OLDCARD:
                oldCards.getOldCards().add(oldCard);
                break;
            case TYPE:
                oldCard.setType(type);
                break;
        }
    }

    private void processCharacters(Characters characters) {
        XML xmlElement = XML.getXMLObject(currentElement);
        String text = characters.getData();

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

    public static void main(String[] args) throws XMLStreamException {
        STAXController staxController = new STAXController(Constants.VALID_XML_FILE);
        staxController.parse();
        OldCards oldCards = staxController.getOldCards();
        System.out.println("==================================");
        System.out.print(oldCards);
        System.out.println("==================================");
    }
}
