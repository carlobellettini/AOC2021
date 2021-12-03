package Day00;

import java.net.*;
import java.net.http.HttpClient;
import java.time.Duration;

public class WebClient {
  public static HttpClient getClient() {
    CookieHandler.setDefault(new CookieManager());

    HttpCookie sessionCookie = new HttpCookie("session", SessionSecrets.key);
    sessionCookie.setPath("/");..
    sessionCookie.setVersion(0);

    try {
      ((CookieManager) CookieHandler.getDefault()).getCookieStore().add(new URI("https://adventofcode.com"), sessionCookie);
    } catch (URISyntaxException e) {
      throw new IllegalStateException(e);
    }

    return HttpClient.newBuilder()
        .cookieHandler(CookieHandler.getDefault())
        .connectTimeout(Duration.ofSeconds(10))
        .build();
  }
}
