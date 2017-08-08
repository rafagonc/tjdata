package br.com.rafagonc.tjdata.models;

import java.util.Set;

/**
 * Created by rafagonc on 03/08/17.
 */
public class ESAJPushRecipient {

    private Set<ESAJPushFilter> filters;
    private Set<ESAJRecipient> recipient;

    public ESAJPushRecipient(Set<ESAJPushFilter> filters, Set<ESAJRecipient> recipient) {
        this.filters = filters;
        this.recipient = recipient;
    }

    public Set<ESAJPushFilter> getFilters() {
        return filters;
    }

    public void setFilters(Set<ESAJPushFilter> filters) {
        this.filters = filters;
    }

    public Set<ESAJRecipient> getRecipient() {
        return recipient;
    }

    public void setRecipient(Set<ESAJRecipient> recipient) {
        this.recipient = recipient;
    }

    public Boolean accept(String q) {
        for (ESAJPushFilter filter : filters) {
            if (filter.matches(q)) {
                return true;
            }
        }
        return false;
    }
}
