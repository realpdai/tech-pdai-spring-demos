import com.baomidou.mybatisplus.generator.FastAutoGenerator;

/**
 * This class is for xxxx.
 *
 * @author pdai
 */
public class TestGenCode {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test_db?useSSL=false&autoReconnect=true&characterEncoding=utf8", "test", "bfXa4Pt2lUUScy8jakXf")
                .globalConfig(builder ->
                        builder.author("pdai") // 设置作者
                                .enableSwagger() // 开启 swagger 模式
                )
                .packageConfig(builder ->
                        builder.parent("tech.pdai.springboot.mysql8.mybatisplus.anno") // 设置父包名
                                .moduleName("gencode") // 设置父包模块名
                )
                .strategyConfig(builder ->
                        builder.addInclude("tb_user", "tb_role", "tb_user_role")
                )
                .execute();
    }
}
