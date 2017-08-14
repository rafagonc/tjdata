package br.com.rafagonc.tjdata.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rafagonc on 13/08/17.
 */
public class ESAJForo {

    private String nome;
    private String local;

    public ESAJForo(String nome, String local) {
        this.nome = nome;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public static Set<ESAJForo> foros() throws Exception {
        Gson gson = new Gson();
        String content = new Scanner(new ClassPathResource("foro.json").getFile()).useDelimiter("\\Z").next();
        Type listType = new TypeToken<Set<ESAJForo>>(){}.getType();
        Set<ESAJForo> foros = gson.fromJson(content, (Type) listType);
        return foros;
    }

}
