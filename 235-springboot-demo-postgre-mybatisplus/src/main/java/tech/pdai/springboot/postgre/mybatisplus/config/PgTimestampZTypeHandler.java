package tech.pdai.springboot.postgre.mybatisplus.config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGTimestamp;


@MappedTypes({LocalDateTime.class})
@MappedJdbcTypes({JdbcType.OTHER})
public class PgTimestampZTypeHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        Timestamp p = null;
        if (parameter!=null) {
            if (parameter instanceof LocalDateTime) {
                p = Timestamp.valueOf((LocalDateTime) parameter);
            }
            ps.setObject(i, p);
        }
    }

    /**
     * Gets the nullable result.
     *
     * @param rs         the rs
     * @param columnName Colunm name, when configuration <code>useColumnLabel</code> is <code>false</code>
     * @return the nullable result
     * @throws SQLException the SQL exception
     */
    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toFill(rs.getObject(columnName));
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toFill(rs.getObject(columnIndex));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toFill(cs.getObject(columnIndex));
    }

    private Object toFill(Object v) {
        if (v!=null) {
            if (v instanceof PGTimestamp) {
                PGTimestamp p = (PGTimestamp) v;
                return p.toLocalDateTime();
            } else if (v instanceof Timestamp) {
                return ((Timestamp) v).toLocalDateTime();
            }
        }
        return v;
    }
}