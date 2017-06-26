package br.com.rafagonc.tjdata.models.models;

/**
 * Created by rafagonc on 18/06/17.
 */
public enum ESAJTribunal {

        SP("https://esaj.tjsp.jus.br"),
        AL("http://www2.tjal.jus.br");

        public String endpoint;

        ESAJTribunal(String endpoint) {
            this.endpoint = endpoint;
        }
}
