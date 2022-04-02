package tech.pdai.springboot.mysql8.mybatisplus.tenant.controller;


import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.query.RoleQueryBean;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.entity.response.ResponseResult;
import tech.pdai.springboot.mysql8.mybatisplus.tenant.service.IRoleService;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * @return role list
     */
    @ApiOperation("Query Role List")
    @GetMapping("list")
    public ResponseResult<List<Role>> list(RoleQueryBean roleQueryBean) {
        return ResponseResult.success(roleService.findList(roleQueryBean));
    }
}
