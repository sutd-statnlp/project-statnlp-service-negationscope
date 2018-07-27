package org.statnlp.services.negationscope.util;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

public class ConstantUtil {

    public final static MediaType CONTENT_TYPE_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
}
