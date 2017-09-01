package br.com.rafagonc.tjdata.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
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
        ClassPathResource classPathResource = new ClassPathResource("foro.json");
        byte[] bdata = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
        String data = new String(bdata, StandardCharsets.UTF_8);
        Type listType = new TypeToken<Set<ESAJForo>>(){}.getType();
        Set<ESAJForo> foros = gson.fromJson(data, (Type) listType);
        return foros;
    }

}
