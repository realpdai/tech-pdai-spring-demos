package tech.pdai.springboot.validation.i18n.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * This class is for xxxx.
 *
 * @author pdai
 */
@Data
@Builder
public class ExceptionData {

    @Singular
    private final List<Object> errors;

}
