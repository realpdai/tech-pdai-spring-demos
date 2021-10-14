package tech.pdai.springboot.api.sign.config.sign;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.text.CharSequenceUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;
import tech.pdai.springboot.api.sign.config.exception.BusinessException;
import tech.pdai.springboot.api.sign.util.SignUtil;

/**
 * @author pdai
 */
@Aspect
@Component
public class SignAspect {

    /**
     * SIGN_HEADER.
     */
    private static final String SIGN_HEADER = "X-SIGN";

    /**
     * pointcut.
     */
    @Pointcut("execution(@tech.pdai.springboot.api.sign.config.sign.Signature * *(..))")
    private void verifySignPointCut() {
        // nothing
    }

    /**
     * verify sign.
     */
    @Before("verifySignPointCut()")
    public void verify() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String sign = request.getHeader(SIGN_HEADER);

        // must have sign in header
        if (CharSequenceUtil.isBlank(sign)) {
            throw new BusinessException("no signature in header: " + SIGN_HEADER);
        }

        // check signature
        try {
            String generatedSign = generatedSignature(request);
            if (!sign.equals(generatedSign)) {
                throw new BusinessException("invalid signature");
            }
        } catch (Throwable throwable) {
            throw new BusinessException("invalid signature");
        }
    }

    private String generatedSignature(HttpServletRequest request) throws IOException {
        // @RequestBody
        String bodyParam = null;
        if (request instanceof ContentCachingRequestWrapper) {
            bodyParam = new String(((ContentCachingRequestWrapper) request).getContentAsByteArray(), StandardCharsets.UTF_8);
        }

        // @RequestParam
        Map<String, String[]> requestParameterMap = request.getParameterMap();

        // @PathVariable
        String[] paths = null;
        ServletWebRequest webRequest = new ServletWebRequest(request, null);
        Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        if (!CollectionUtils.isEmpty(uriTemplateVars)) {
            paths = uriTemplateVars.values().toArray(new String[0]);
        }

        return SignUtil.sign(bodyParam, requestParameterMap, paths);
    }

}