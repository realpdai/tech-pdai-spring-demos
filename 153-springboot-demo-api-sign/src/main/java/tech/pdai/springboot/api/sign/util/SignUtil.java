package tech.pdai.springboot.api.sign.util;

import java.util.Arrays;
import java.util.Map;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.util.CollectionUtils;

public class SignUtil {

    private static final String DEFAULT_SECRET = "1qaz@WSX#$%&";

    public static String sign(String body, Map<String, String[]> params, String[] paths) {
        StringBuilder sb = new StringBuilder();
        if (CharSequenceUtil.isNotBlank(body)) {
            sb.append(body).append('#');
        }

        if (!CollectionUtils.isEmpty(params)) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(paramEntry -> {
                        String paramValue = String.join(",", Arrays.stream(paramEntry.getValue()).sorted().toArray(String[]::new));
                        sb.append(paramEntry.getKey()).append("=").append(paramValue).append('#');
                    });
        }

        if (ArrayUtil.isNotEmpty(paths)) {
            String pathValues = String.join(",", Arrays.stream(paths).sorted().toArray(String[]::new));
            sb.append(pathValues);
        }
        return SecureUtil.sha256(String.join("#", DEFAULT_SECRET, sb.toString()));
    }

}
