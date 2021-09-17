package tech.pdai.springboot.api.version.config.version;

import lombok.Getter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    // 1.2.3
    private static final String VERSION_PREFIX_PATTERN = "^\\d\\.\\d\\.\\d$";

    // 初始版本
    private static final String DEFAULT_VERSION = "0.0.1";

    @Getter
    private final String apiVersion;

    public ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 最新定义将生效，也就是说，方法定义覆盖了类定义。
     */
    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.apiVersion);
    }

    /**
     * 版本匹配规则
     *
     * <p>从最大版本号开始校验
     *
     * @param request
     * @return
     */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        String version = request.getHeader("version");
        if (StringUtils.isEmpty(version)) {
            version = request.getParameter("version");
        }
        version = Optional.ofNullable(version).orElse(DEFAULT_VERSION);
        if (version.matches(VERSION_PREFIX_PATTERN)) {
            if (compareVersion(version, this.apiVersion) >= 0) {// 请求版本号大于等于当前版本，请求版本生效
                return this;
            }
        }
        // 匹配不到，走默认请求。如无默认请求路径，则抛异常404
        return null;
    }

    /**
     * 当超过一个配置版本号时，最大版本号生效
     */
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        return compareVersion(other.getApiVersion(), this.apiVersion);
    }

    /**
     * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new RuntimeException("compareVersion error:illegal params.");
        }
        String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }
}

