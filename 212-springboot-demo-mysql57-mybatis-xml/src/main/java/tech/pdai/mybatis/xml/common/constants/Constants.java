package tech.pdai.mybatis.xml.common.constants;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants {

    /**
     * 登录名称是否唯一的返回结果码
     */
    public final static String USER_NAME_UNIQUE = "0";
    public final static String USER_NAME_NOT_UNIQUE = "1";

    /**
     * 手机号码是否唯一的返回结果
     */
    public final static String USER_PHONE_UNIQUE = "0";
    public final static String USER_PHONE_NOT_UNIQUE = "1";

    /**
     * e-mail 是否唯一的返回结果
     */
    public final static String USER_EMAIL_UNIQUE = "0";
    public final static String USER_EMAIL_NOT_UNIQUE = "1";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

}
