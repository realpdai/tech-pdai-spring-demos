package tech.pdai.springboot.mysql57.mybatis.xml.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import tech.pdai.springboot.mysql57.mybatis.xml.dao.IRoleDao;
import tech.pdai.springboot.mysql57.mybatis.xml.entity.Role;
import tech.pdai.springboot.mysql57.mybatis.xml.entity.query.RoleQueryBean;
import tech.pdai.springboot.mysql57.mybatis.xml.service.IRoleService;

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
