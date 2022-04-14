package tech.pdai.springboot.postgre.mybatisplus.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.postgre.mybatisplus.dao.IRoleDao;
import tech.pdai.springboot.postgre.mybatisplus.entity.Role;
import tech.pdai.springboot.postgre.mybatisplus.entity.query.RoleQueryBean;
import tech.pdai.springboot.postgre.mybatisplus.service.IRoleService;

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
