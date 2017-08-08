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

    private String text;
    private Strategy strategy = Strategy.CONTAINS;

    public ESAJPushFilter(String q) {
        this.text = q;
        this.strategy = Strategy.CONTAINS;
    }

    public ESAJPushFilter(String q, Strategy strategy) {
        this.text= q;
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
        Pattern pattern = Pattern.compile(text);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();

    }

    private Boolean containsStrategy(String text) {
        return text.contains(text);
    }

}
