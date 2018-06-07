package ua.nure.skrypnyk.practice7.controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.skrypnyk.practice7.constants.Constants;
import ua.nure.skrypnyk.practice7.constants.XML;
import ua.nure.skrypnyk.practice7.entity.OldCard;
import ua.nure.skrypnyk.practice7.entity.OldCards;
import ua.nure.skrypnyk.practice7.entity.Type;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOMController {
    private String xmlFileName;
    private OldCards oldCards;

    public DOMController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public OldCards getOldCards() {
        return oldCards;
    }

    public void parse(boolean validate) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        if (validate) {
            documentBuilderFactory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            documentBuilderFactory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        documentBuilder.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                throw e;
            }
        });

        Document document = documentBuilder.parse(xmlFileName);
        Element root = document.getDocumentElement();

        NodeList oldCardsNodes = root.getElementsByTagName(XML.OLDCARD.value());

        oldCards = new OldCards();

        for (int i = 0; i < oldCardsNodes.getLength(); i++) {
            oldCards.getOldCards().add(getOldCard((Element) oldCardsNodes.item(i)));
        }
    }

    private OldCard getOldCard(Element element) {
        OldCard oldCard = new OldCard();
        oldCard.setTheme(getContentOfTag(element, XML.THEME.value()));
        oldCard.setType(getType((Element) element.getElementsByTagName(XML.TYPE.value()).item(0)));
        oldCard.setCountry(getContentOfTag(element, XML.COUNTRY.value()));
        oldCard.setYear(getContentOfTag(element, XML.YEAR.value()));
        oldCard.setAuthor(getContentOfTag(element, XML.AUTHOR.value()));
        oldCard.setValuable(getContentOfTag(element, XML.VALUABLE.value()));

        return oldCard;
    }

    private Type getType(Element element) {
        Type type = new Type();
        type.setTypeOfCard(getContentOfTag(element, XML.TYPEOFCARD.value()));
        type.setPosted(Boolean.valueOf(getContentOfTag(element, XML.ISPOSTED.value())));
        return type;
    }

    private String getContentOfTag(Element element, String tag) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() == 0)
            return null;
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }


    public static Document getDocument(OldCards oldCards) throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement(XML.OLDCARDS.value());
        document.appendChild(root);

        Element element = null;
        for (OldCard oldCard : oldCards.getOldCards()) {
            Element oldCardElement = document.createElement(XML.OLDCARD.value());

            element = document.createElement(XML.THEME.value());
            element.setTextContent(oldCard.getTheme());
            oldCardElement.appendChild(element);

            element = document.createElement(XML.COUNTRY.value());
            element.setTextContent(oldCard.getCountry());
            oldCardElement.appendChild(element);

            element = document.createElement(XML.YEAR.value());
            element.setTextContent(oldCard.getYear());
            oldCardElement.appendChild(element);

            element = document.createElement(XML.AUTHOR.value());
            element.setTextContent(oldCard.getAuthor());
            oldCardElement.appendChild(element);

            element = document.createElement(XML.VALUABLE.value());
            element.setTextContent(oldCard.getValuable());
            oldCardElement.appendChild(element);

            appendType(document, oldCardElement, oldCard);
        }

        return document;
    }

    private static void appendType(Document document, Element oldCardElement, OldCard oldCard) {
        Element typeElement = document.createElement(XML.TYPE.value());

        Element element = null;
        element = document.createElement(XML.TYPEOFCARD.value());
        element.setTextContent(oldCard.getType().getTypeOfCard().toString());
        typeElement.appendChild(element);

        element = document.createElement(XML.ISPOSTED.value());
        element.setTextContent(Boolean.toString(oldCard.getType().isPosted()));
        typeElement.appendChild(element);

        oldCardElement.appendChild(typeElement);
    }


    public static void saveToXML(OldCards oldCards, String xmlFileName) throws ParserConfigurationException, TransformerException {
        saveToXML(getDocument(oldCards), xmlFileName);
    }


    public static void saveToXML(Document document, String xmlFileName) throws TransformerException {
        StreamResult result = new StreamResult(new File(xmlFileName));

        TransformerFactory tf = TransformerFactory.newInstance();
        javax.xml.transform.Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        t.transform(new DOMSource(document), result);
    }


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DOMController domController = new DOMController(Constants.VALID_XML_FILE);
        domController.parse(true);
        System.out.println("=============================");
        System.out.println(domController.getOldCards());
        System.out.println("=============================");

        domController = new DOMController(Constants.INVALID_XML_FILE);

        try {
            domController.parse(true);
        } catch (SAXException e) {
            System.err.println("====================================");
            System.err.println("Validation is failed:\n" + e.getMessage());
            System.err.println("Try to print oldCards object: " + domController.getOldCards());
            System.err.println("====================================");
        }

        domController.parse(false);
        System.out.println("=============================");
        System.out.println(domController.getOldCards());
        System.out.println("=============================");

        DOMController.saveToXML(domController.getOldCards(), Constants.INVALID_XML_FILE + ".dom-result.xml");
    }
}
