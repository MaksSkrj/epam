package ua.nure.skrypnyk.practice7.util;

import ua.nure.skrypnyk.practice7.entity.OldCard;

import java.util.Comparator;

public class Sorter {
    public static final Comparator<OldCard> SORT_BY_COUNTRY = (Comparator.comparing(OldCard::getCountry));

    public static final Comparator<OldCard> SORT_BY_YEAR = (Comparator.comparing(OldCard::getYear));

    public static final Comparator<OldCard> SORT_BY_AUTHOR = (Comparator.comparing(OldCard::getAuthor));

}
