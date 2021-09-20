package tech.pdai.springboot.api.version.config.version;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    /**
     * support v1.1.1, v1.1, v1; three levels .
     */
    private static final Pattern VERSION_PREFIX_PATTERN_1 = Pattern.compile("/v\\d\\.\\d\\.\\d/");
    private static final Pattern VERSION_PREFIX_PATTERN_2 = Pattern.compile("/v\\d\\.\\d/");
    private static final Pattern VERSION_PREFIX_PATTERN_3 = Pattern.compile("/v\\d/");
    private static final List<Pattern> VERSION_LIST = Collections.unmodifiableList(
            Arrays.asList(VERSION_PREFIX_PATTERN_1, VERSION_PREFIX_PATTERN_2, VERSION_PREFIX_PATTERN_3)
    );

    @Getter
    private final String apiVersion;

    public ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * method priority is higher then class.
     *
     * @param other other
     * @return ApiVersionCondition
     */
    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.apiVersion);
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        for (int vIndex = 0; vIndex < VERSION_LIST.size(); vIndex++) {
            Matcher m = VERSION_LIST.get(vIndex).matcher(request.getRequestURI());
            if (m.find()) {
                String version = m.group(0).replace("/v", "").replace("/", "");
                if (vIndex == 1) {
                    version = version + ".0";
                } else if (vIndex == 2) {
                    version = version + ".0.0";
                }
                if (compareVersion(version, this.apiVersion) >= 0) {
                    log.info("version={}, apiVersion={}", version, this.apiVersion);
                    return this;
                }
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        return compareVersion(other.getApiVersion(), this.apiVersion);
    }

    private int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new RuntimeException("compareVersion error:illegal params.");
        }
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {
            ++idx;
        }
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }
}

