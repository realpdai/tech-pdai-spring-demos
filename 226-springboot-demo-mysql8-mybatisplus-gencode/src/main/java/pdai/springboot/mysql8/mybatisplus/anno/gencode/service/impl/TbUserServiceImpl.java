package pdai.springboot.mysql8.mybatisplus.anno.gencode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pdai.springboot.mysql8.mybatisplus.anno.gencode.entity.TbUser;
import pdai.springboot.mysql8.mybatisplus.anno.gencode.mapper.TbUserMapper;
import pdai.springboot.mysql8.mybatisplus.anno.gencode.service.ITbUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pdai
 * @since 2022-03-29
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
