package poly.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class KakaoService {

	public String getAccessToken(String authorize_code) throws Exception {
		System.out.println(this.getClass().getName() + ".getAccessToken start!");

		String access_token = "";
		String refresh_token = "";
		String reqUrl = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=928bbb3f0e2b7934f85c85beaa13b7ea");
			sb.append("&redirect_uri=http://52.79.54.76:8080/kakaologin.do");
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode: " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("responseBody: " + result);

			JsonParser jsonParser = new JsonParser();
			JsonElement element = jsonParser.parse(result);

			access_token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();

			System.out.println("access_token: " + access_token);
			System.out.println("refresh_token: " + refresh_token);

			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(this.getClass().getName() + ".getAccessToken end!");
		return access_token;
	}

	// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언함
	public HashMap<String, Object> getUserInfo(String access_token, HttpSession session) throws Exception {
		HashMap<String, Object> userInfo = new HashMap<>();
		String reqUrl = "https://kapi.kakao.com/v2/user/me";

		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode: " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println("responseBody: " + result);

//            JSONParser jsonParser = new JsonParser();
//            JSONElement element = jsonParser.parse(result);

			JSONObject element = new JSONObject(result);
			JSONObject properties = element.getJSONObject("properties");
			JSONObject kakao_account = element.getJSONObject("kakao_account");

			if (properties.getString("nickname") != null) {
				String nickname = properties.getString("nickname");
				userInfo.put("nickname", nickname);
			}
			// ------------------------------------------------------
			if (kakao_account.getString("email") != null) {
				String email = kakao_account.getString("email");
				userInfo.put("email", email);
			}
			// ------------------------------------------------------
			if (kakao_account.getString("age_range") != null) {
				String age_range = kakao_account.getString("age_range");
				userInfo.put("age_range", age_range);
			}
			// ------------------------------------------------------
			if (kakao_account.getString("birthday") != null) {
				String birthday = kakao_account.getString("birthday");
				userInfo.put("birthday", birthday);
			}
			// ------------------------------------------------------
			if (kakao_account.getString("gender") != null) {
				String gender = kakao_account.getString("gender");
				userInfo.put("gender", gender);
			}
			// ------------------------------------------------------
			if (properties.getString("profile_image") != null) {
				String profile_image = properties.getString("profile_image");
				userInfo.put("profile_image", profile_image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}

}