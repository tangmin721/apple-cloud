package com.cachexic.cloud.security.core.rememberme;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @Description: 自定义remember me的储存介质实现 inRedis(@ TODO)
 * @author tangmin
 * @date 2017-09-30 10:29:54
 */
public class InRedisTokenRepositoryImpl implements PersistentTokenRepository {
  private final Map<String, PersistentRememberMeToken> seriesTokens = new HashMap<String, PersistentRememberMeToken>();

  public synchronized void createNewToken(PersistentRememberMeToken token) {
    PersistentRememberMeToken current = seriesTokens.get(token.getSeries());

    if (current != null) {
      throw new DataIntegrityViolationException("Series Id '" + token.getSeries()
          + "' already exists!");
    }

    seriesTokens.put(token.getSeries(), token);
  }

  public synchronized void updateToken(String series, String tokenValue, Date lastUsed) {
    PersistentRememberMeToken token = getTokenForSeries(series);

    PersistentRememberMeToken newToken = new PersistentRememberMeToken(
        token.getUsername(), series, tokenValue, new Date());

    // Store it, overwriting the existing one.
    seriesTokens.put(series, newToken);
  }

  public synchronized PersistentRememberMeToken getTokenForSeries(String seriesId) {
    return seriesTokens.get(seriesId);
  }

  public synchronized void removeUserTokens(String username) {
    Iterator<String> series = seriesTokens.keySet().iterator();

    while (series.hasNext()) {
      String seriesId = series.next();

      PersistentRememberMeToken token = seriesTokens.get(seriesId);

      if (username.equals(token.getUsername())) {
        series.remove();
      }
    }
  }
}

