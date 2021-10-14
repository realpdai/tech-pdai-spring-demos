package tech.pdai.springboot.api.sign.config.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.pdai.springboot.api.sign.config.response.ResponseResult;
import tech.pdai.springboot.api.sign.config.response.ResponseStatus;

/**
 * @author pdai
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handle business exception.
     *
     * @param businessException business exception
     * @return ResponseResult
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<BusinessException> processBusinessException(BusinessException businessException) {
        log.error(businessException.getLocalizedMessage());
        return ResponseResult.fail(null, businessException.getLocalizedMessage()==null
                ? ResponseStatus.HTTP_STATUS_500.getDescription()
                :businessException.getLocalizedMessage());
    }

    /**
     * handle other exception.
     *
     * @param exception exception
     * @return ResponseResult
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult<Exception> processException(Exception exception) {
        log.error(exception.getLocalizedMessage(), exception);
        return ResponseResult.fail(null, ResponseStatus.HTTP_STATUS_500.getDescription());
    }
}
