package com.shinhancard.izmydata.common.util;

import java.net.URI;
import java.net.URISyntaxException;

import com.shinhancard.izmydata.common.config.InitConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
public class ApiUtil {

    @Value("${openapi.url}")
    static String url;

    @Value("${openapi.key.encoding}")
    static String encodingKey;

    @Value("${openapi.key.decoding}")
    static String decdoingKey;

    static public URI makeOpenApiUri(String apiUri) {
        String uriStr = url + apiUri + "?page=1" + "&perPage=100" + "&serviceKey="
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
