package br.com.rafagonc.tjdata.models;

import java.util.Set;

/**
 * Created by rafagonc on 03/08/17.
 */
public class ESAJPushRecipient {

    private Set<ESAJPushFilter> filters;
    private Set<ESAJRecipient> recipients;

    public ESAJPushRecipient(Set<ESAJPushFilter> filters, Set<ESAJRecipient> recipient) {
        this.filters = filters;
        this.recipients = recipient;
    }

    public Set<ESAJPushFilter> getFilters() {
        return filters;
    }

    public void setFilters(Set<ESAJPushFilter> filters) {
        this.filters = filters;
    }

    public Set<ESAJRecipient> getRecipient() {
        return recipients;
    }

    public void setRecipient(Set<ESAJRecipient> recipient) {
        this.recipients = recipient;
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
