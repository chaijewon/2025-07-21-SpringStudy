package com.sist.chat;
import com.sun.jna.NativeLibrary;
import org.json.JSONArray;
import org.json.JSONObject;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ItsCctvPlayer {

    // ❗ ITS OpenAPI 발급받은 키 넣기
    private static final String API_KEY = "8cc24a9744ae41148fed6bbc7975d37f";

    // CCTV 목록 가져오기
    public static JSONArray getCctvList() throws Exception {

        String api =
                "https://openapi.its.go.kr:9443/cctvInfo" +
                        "?apiKey=" + API_KEY +
                        "&type=ex" +
                        "&cctvType=2" +
                        "&minX=126.7&maxX=127.2" +     // 서울 인근 예시
                        "&minY=37.4&maxY=37.7" +
                        "&getType=json";

        URL url = new URL(api);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);

        br.close();

        JSONObject json = new JSONObject(sb.toString());
        return json.getJSONObject("response").getJSONArray("data");
    }

    // VLCJ로 스트림 재생
    public static void playStream(String url) {

        // VLC 설치경로 등록 필요
        NativeLibrary.addSearchPath("libvlc", "C:\\Program Files\\VideoLAN\\VLC");
        System.setProperty("jna.library.path", "C:\\Program Files\\VideoLAN\\VLC");

        MediaPlayerFactory factory = new MediaPlayerFactory();
        EmbeddedMediaPlayer player = factory.mediaPlayers().newEmbeddedMediaPlayer();

        System.out.println("▶ CCTV 재생 시작 : " + url);
        player.media().play(url);

        // 60초 동안 재생
        try { Thread.sleep(60000); } catch (Exception ignored) {}

        player.controls().stop();
        System.out.println("■ 재생 종료");
    }

    public static void main(String[] args) {

        try {
            JSONArray list = getCctvList();

            for (int i = 0; i < list.length(); i++) {
                JSONObject c = list.getJSONObject(i);

                String name = c.getString("cctvname");
                String url = c.getString("cctvurl");

                System.out.println("CCTV: " + name);
                System.out.println("URL: " + url);

                // 일부 CCTV는 null 또는 빈 스트림일 수 있음
                if (url != null && url.startsWith("http")) {
                    playStream(url);
                    break;  // 첫 번째 재생 후 종료
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
