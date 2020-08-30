package ru.progwards.java2.lessons.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        String[] s = userArr("sr77fk02stjf06bcpdd6s5kcva");
        System.out.println(s[0]);
        System.out.println(s[1]);
    }

    public static String[] userArr(String moodleSession) throws IOException {
        URL url = new URL("http://lms.progwards.ru/moodle/user/edit.php");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setDoOutput(true);
        con.setRequestProperty("Cookie", "MoodleSession=" + moodleSession);
        con.connect();

        String id = null;
        String username = null;

        if (con.getResponseCode() == 200) {
            String idKey = "profile.php?id=";
            String unKey = "value=\"";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String strCurrentLine;
            String strPrevLine = null;
            while ((strCurrentLine = br.readLine()) != null) {
                if (strCurrentLine.contains(idKey)){
                    id = strCurrentLine.substring(strCurrentLine.indexOf(idKey) + idKey.length());
                    id = id.substring(0, id.indexOf("\""));
                }
                else if (strCurrentLine.contains(unKey) && strPrevLine.endsWith("id=\"id_email\"")){
                    username = strCurrentLine.substring(strCurrentLine.indexOf(unKey) + unKey.length());
                    username = username.substring(0, username.indexOf("\""));
                }
                if (id != null && username != null) break;
                strPrevLine = strCurrentLine;
            }
        }

        return new String[]{id, username};
    }

}
