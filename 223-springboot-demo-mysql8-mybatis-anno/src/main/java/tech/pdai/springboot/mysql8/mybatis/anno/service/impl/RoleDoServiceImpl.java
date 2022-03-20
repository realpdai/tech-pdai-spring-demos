package tech.pdai.springboot.mysql8.mybatis.anno.service.impl;

import org.springframework.stereotype.Service;
import tech.pdai.springboot.mysql8.mybatis.anno.dao.IRoleDao;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.Role;
import tech.pdai.springboot.mysql8.mybatis.anno.entity.query.RoleQueryBean;
import tech.pdai.springboot.mysql8.mybatis.anno.service.IRoleService;

import java.util.List;

@Service
public class RoleDoServiceImpl implements IRoleService {

    /**
     * roleDao.
     */
    private final IRoleDao roleDao;

    /**
     * init.
     *
     * @param roleDao2 role dao
     */
    public RoleDoServiceImpl(final IRoleDao roleDao2) {
        this.roleDao = roleDao2;
    }

    @Override
    public List<Role> findList(RoleQueryBean roleQueryBean) {
        return roleDao.findList(roleQueryBean);
    }
}
