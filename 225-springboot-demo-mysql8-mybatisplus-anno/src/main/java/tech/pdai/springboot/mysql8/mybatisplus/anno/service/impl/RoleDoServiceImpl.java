package tech.pdai.springboot.mysql8.mybatisplus.anno.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.mysql8.mybatisplus.anno.dao.IRoleDao;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.Role;
import tech.pdai.springboot.mysql8.mybatisplus.anno.entity.query.RoleQueryBean;
import tech.pdai.springboot.mysql8.mybatisplus.anno.service.IRoleService;

import java.util.List;

@Service
public class RoleDoServiceImpl extends ServiceImpl<IRoleDao, Role> implements IRoleService {

    @Override
    public List<Role> findList(RoleQueryBean roleQueryBean) {
        return lambdaQuery().like(StringUtils.isNotEmpty(roleQueryBean.getName()), Role::getName, roleQueryBean.getName())
                .like(StringUtils.isNotEmpty(roleQueryBean.getDescription()), Role::getDescription, roleQueryBean.getDescription())
                .like(StringUtils.isNotEmpty(roleQueryBean.getRoleKey()), Role::getRoleKey, roleQueryBean.getRoleKey())
                .list();
    }
}
