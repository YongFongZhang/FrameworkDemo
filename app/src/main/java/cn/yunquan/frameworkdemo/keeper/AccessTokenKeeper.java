package cn.yunquan.frameworkdemo.keeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;

import cn.yunquan.frameworkdemo.YQApplication;
import cn.yunquan.frameworkdemo.enties.AccessTokenResponse;
import cn.yunquan.frameworkdemo.utils.Base64;

public class AccessTokenKeeper {

	private static final String KEY_CLIENT_ID = "client_id";
	private static final String KEY_CLIENT_SECRET = "client_secret";

	private static final String KEY_ACCESS_TOKEN = "access_token";
	private static final String KEY_TOKEN_TYPE = "token_type";
	private static final String KEY_EXPIRES_IN = "expires_in";
	private static final String KEY_REFRESH_TOKEN = "refresh_token";

	private static final AccessTokenKeeper keeper = new AccessTokenKeeper();

	public static AccessTokenKeeper getInstance() {
		return keeper;
	}

	private final SharedPreferences pref;

	private AccessTokenKeeper() {
		pref = YQApplication.getInstance().getSharedPreferences("access-token", Context.MODE_PRIVATE);
	}


	public void writeAccessToken(String token) {
		Editor editor = pref.edit();
		editor.putString(KEY_ACCESS_TOKEN, token);
		editor.commit();
	}

	public String readAccessToken() {
		return pref.getString(KEY_ACCESS_TOKEN, null);
	}

	public void writeTokenType(String tokenType) {
		Editor editor = pref.edit();
		editor.putString(KEY_TOKEN_TYPE, tokenType);
		editor.commit();
	}

	public String readTokenType() {
		return pref.getString(KEY_TOKEN_TYPE, null);
	}


	public void writeClientId(String clientId) {
		Editor editor = pref.edit();
		editor.putString(KEY_CLIENT_ID, clientId);
		editor.commit();
	}

	public String readClientId() {
		return pref.getString(KEY_CLIENT_ID, "");
	}

	public void writeClientSecret(String secret) {
		Editor editor = pref.edit();
		editor.putString(KEY_CLIENT_SECRET, secret);
		editor.commit();
	}

	public String readClientSecret() {
		return pref.getString(KEY_CLIENT_SECRET, "");
	}

	public void writeRefreshToken(String refreshToken) {
		Editor editor = pref.edit();
		editor.putString(KEY_REFRESH_TOKEN, refreshToken);
		editor.commit();
	}

	public String readRefreshToken() {
		return pref.getString(KEY_REFRESH_TOKEN, null);
	}

	public String getAuthorization() {
		try {
			return String.format( "Basic %s", new String(Base64.encode(String.format("%s:%s", readClientId(), readClientSecret()).getBytes("US-ASCII"))));
//			return String.format("Basic %s", String.format("%s:%s", readClientId(), readClientSecret()));
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return null;
	}

	public synchronized void clear() {

		Editor editor = pref.edit();
		editor.clear();
		editor.commit();
	}

	public void saveAccessToken(AccessTokenResponse accessTokenResponse) {
		Editor editor = pref.edit();
		editor.putString(KEY_ACCESS_TOKEN, accessTokenResponse.getAccess_token());
		editor.putLong(KEY_EXPIRES_IN, System.currentTimeMillis() + accessTokenResponse.getExpires_in() * 1000);
		editor.putString(KEY_REFRESH_TOKEN, accessTokenResponse.getAccess_token());
		editor.putString(KEY_TOKEN_TYPE, accessTokenResponse.getToken_type());
		editor.commit();
	}

	public boolean isSessionValid() {
		String accessToken = pref.getString(KEY_ACCESS_TOKEN, null);
		long expiresTime = pref.getLong(KEY_EXPIRES_IN, 0L);

		return (!TextUtils.isEmpty(accessToken)) && (expiresTime != 0L)
				&& (System.currentTimeMillis() < expiresTime);
	}

}
