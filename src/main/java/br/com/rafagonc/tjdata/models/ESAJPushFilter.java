package br.com.rafagonc.tjdata.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rafagonc on 03/08/17.
 */
public class ESAJPushFilter {

    enum Strategy {
        CONTAINS,
        REGEX
    }

    private String q;
    private Strategy strategy;

    public ESAJPushFilter(String q, Strategy strategy) {
        this.q = q;
        this.strategy = strategy;
    }

    public static ESAJPushFilter regex(String regex) {
        return new ESAJPushFilter(regex, Strategy.REGEX);
    }

    public static ESAJPushFilter contains(String contains) {
        return new ESAJPushFilter(contains, Strategy.CONTAINS);
    }

    public Boolean matches(String matches) {
        if (this.strategy == Strategy.REGEX) {
            return regexStrategy(matches);
        } else {
            return containsStrategy(matches);
        }
    }

    private Boolean regexStrategy(String text) {
        Pattern pattern = Pattern.compile(q);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();

    }

    private Boolean containsStrategy(String text) {
        return text.contains(q);
    }

}
