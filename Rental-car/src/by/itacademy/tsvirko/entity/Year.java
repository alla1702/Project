package by.itacademy.tsvirko.entity;

import lombok.Getter;

@Getter
public enum Year {

    YEAR2000("2000"),
    YEAR2001("2001"),
    YEAR2002("2002"),
    YEAR2003("2003"),
    YEAR2004("2004"),
    YEAR2005("2005"),
    YEAR2006("2006"),
    YEAR2007("2007"),
    YEAR2008("2008"),
    YEAR2009("2009"),
    YEAR2010("2010"),
    YEAR2011("2011"),
    YEAR2012("2012"),
    YEAR2013("2013"),
    YEAR2014("2014"),
    YEAR2015("2015"),
    YEAR2016("2016"),
    YEAR2017("2017"),
    YEAR2018("2018"),
    YEAR2019("2019");

    private String value;

    Year(String value) {
        this.value = value;
    }
}