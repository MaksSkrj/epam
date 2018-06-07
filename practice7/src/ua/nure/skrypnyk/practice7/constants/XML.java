package ua.nure.skrypnyk.practice7.constants;

public enum XML {
    OLDCARDS("oldCards"), OLDCARD("oldCard"), THEME("Theme"), TYPE("Type"), TYPEOFCARD("TypeOfCard"), ISPOSTED("isPosted"),
    COUNTRY("Country"), YEAR("Year"), AUTHOR("Author"), VALUABLE("Valuable");

    private String value;

    XML(String value) {
        this.value = value;
    }

    public boolean equalsTo(String name) {
        return value.equals(name);
    }

    public String value() {
        return value;
    }

    public static XML getXMLObject(String element) {
        for (XML el : XML.values()) {
            if (el.equalsTo(element))
                return el;
        }
        return null;
    }
}
