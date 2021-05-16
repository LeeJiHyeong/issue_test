import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Book {

    public final String clientId = "P21GiHfZFJ95PZGKZ0K0";
    public final String clientSecret = "zFAuLrI1ei";

    public static void main(String[] args) throws IOException {
        String clientId = "P21GiHfZFJ95PZGKZ0K0";
        String clientSecret = "zFAuLrI1ei";
        String text = URLEncoder.encode("헬스", "UTF-8");
        String apiUrl = "https://openapi.naver.com/v1/search/book?query=" + text;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            BufferedReader br;

            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
