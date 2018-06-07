package ua.nure.skrypnyk.practice7.entity;

public class OldCard {
    private String Theme;
    private Type type;
    private String country;
    private String year;
    private String author;
    private String valuable;

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getValuable() {
        return valuable;
    }

    public void setValuable(String valuable) {
        this.valuable = valuable;
    }

    @Override
    public String toString() {
        return "{" + "Theme='" + Theme + "', type=" + type +
                "', country='" + country + "', year='" + year +
                "', author='" + author + "', valuable='" + valuable + '}';
    }
}
