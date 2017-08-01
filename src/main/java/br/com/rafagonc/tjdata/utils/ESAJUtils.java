package br.com.rafagonc.tjdata.utils;

import org.jsoup.nodes.Element;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rafagonc on 15/06/17.
 */
public class ESAJUtils {

    public static void deleteFolderContent(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolderContent(f);
                } else {
                    f.delete();
                }
            }
        }
    }

    public static String between(String str, String a, String b) {
        return between(str,a,false,b,false);
    }

    public static String between(String str, String a, Boolean regexA, String b, Boolean regexB) {
        int indexA = 0;
        if (regexA) {
            Pattern pattern = Pattern.compile(a);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                indexA = str.indexOf(matcher.group()) + matcher.group().length();
            }
        } else {
            indexA = str.indexOf(a) + a.length();
            if (!str.contains(a)) {
                return "";
            }
        }

        String excludeBehind = str.substring(indexA);

        int indexB = indexA;

        if (regexB) {
            Pattern pattern = Pattern.compile(b);
            Matcher matcher = pattern.matcher(excludeBehind);
            if (matcher.find()) {
                indexB = excludeBehind.indexOf(matcher.group());
            }
        } else {
            indexB = excludeBehind.indexOf(b);
            if (indexB == -1) {
                return "";
            }
        }

        String result = excludeBehind.substring(0,indexB);
        return result;
    }

    public static String removeHTMLTags(String str) {
        return removeNewLine(str.replaceAll("\\<[^>]*>",""));
    }

    public static String removeNewLine(String str) {
        return str.replace("\n","").replace("\t","").replace("\r","");
    }

    public static String normalize(String str) {
        return removeNewLine(removeHTMLTags(str.replaceAll("^\\s*", "")).replaceAll("\\s*$", "")).replaceAll("\\s+"," ");
    }

    public static String getTextoFromDado(String dado, Element table, int... args) {
        try {
            Element tr =  table.child(0).getElementsContainingText(dado).get(3).parents().get(1);
            Element child = tr;
            for (int i: args) {
                child = child.child(i);
            }
            return ESAJUtils.normalize(child.text().replace(dado,"").replace(":",""));
        } catch (Exception e) {

        }
        return null;
    }

    public static String getTextoWithIndex(Element table, int... args) {
        try {
            Element child = table;
            for (int i: args) {
                child = child.child(i);
            }
            return ESAJUtils.normalize(child.text());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDDMMYYYYDateString(final String str, final TimeZone tz)
            throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(tz);
        return sdf.parse(str);
    }

    public static Date BR_parseDDMMYYYYDateString(final String str)
            throws ParseException {
        return parseDDMMYYYYDateString(str,TimeZone.getTimeZone("America/Sao_Paulo"));
    }


}
