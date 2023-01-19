package com.shinhancard.izmydata.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class InitConfig {

    @Value("${openapi.url}")
    String url;

    @Value("${openapi.key.encoding}")
    String encodingKey;

    @Value("${openapi.key.decoding}")
    String decdoingKey;

    public URI makeOpenApiUri(String apiUri, int page, int perPage) {
        String uriStr = url + apiUri + "?page=" + page + "&perPage=" + perPage + "&serviceKey="
                + encodingKey;
        URI uri = null;
        try {
            uri = new URI(uriStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;

    }
}
