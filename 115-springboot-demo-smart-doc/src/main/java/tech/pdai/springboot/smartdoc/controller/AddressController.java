package tech.pdai.springboot.smartdoc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.smartdoc.entity.ResponseResult;
import tech.pdai.springboot.smartdoc.entity.param.AddressParam;

/**
 * Address API.
 *
 * @author pdai
 * @since 1.1
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    /**
     * Add a new address.
     *
     * @param addressParam param
     * @return address
     */
    @PostMapping("add")
    public ResponseResult<String> add(AddressParam addressParam) {
        return ResponseResult.success("success");
    }

}
