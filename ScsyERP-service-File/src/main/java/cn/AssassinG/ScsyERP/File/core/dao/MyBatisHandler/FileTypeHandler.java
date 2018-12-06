package cn.AssassinG.ScsyERP.File.core.dao.MyBatisHandler;

import cn.AssassinG.ScsyERP.File.facade.enums.FileType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileTypeHandler extends BaseTypeHandler<FileType> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, FileType fileType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, fileType.getName());
    }

    @Override
    public FileType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        if(resultSet.wasNull())
            return null;
        else{
            return FileType.getEnum(str);
        }
    }

    @Override
    public FileType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String str = resultSet.getString(i);
        if(resultSet.wasNull())
            return null;
        else{
            return FileType.getEnum(str);
        }
    }

    @Override
    public FileType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String str = callableStatement.getString(i);
        if(callableStatement.wasNull())
            return null;
        else{
            return FileType.getEnum(str);
        }
    }
}
