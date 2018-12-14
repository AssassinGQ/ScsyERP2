package cn.AssassinG.ScsyERP.common.core.dao.MyBatisTypeHandler;

import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

public class LongHashSetTypeHandler extends BaseTypeHandler<HashSet<Long>> {

    private String Set2String(HashSet<Long> hashSet){
        try{
            Iterator<Long> iterator = hashSet.iterator();
            JSONArray jsonArray = new JSONArray();
            while(iterator.hasNext()){
                jsonArray.add(iterator.next());
            }
            return jsonArray.toJSONString();
        }catch(Exception e){
            return "";
        }
    }

    private HashSet<Long> String2Set(String string){
        try{
            JSONArray jsonArray = JSONArray.parseArray(string);
            HashSet<Long> hashSet = new HashSet<Long>();
            for(int i = 0; i < jsonArray.size(); i++){
                hashSet.add((Long) jsonArray.get(i));
            }
            return hashSet;
        }catch(Exception e){
            return new HashSet<Long>();
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, HashSet<Long> ts, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, Set2String(ts));
    }

    @Override
    public HashSet<Long> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        if(resultSet.wasNull()){
            return null;
        }else{
            return String2Set(str);
        }
    }

    @Override
    public HashSet<Long> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String str = resultSet.getString(i);
        if(resultSet.wasNull()){
            return null;
        }else{
            return String2Set(str);
        }
    }

    @Override
    public HashSet<Long> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String str = callableStatement.getString(i);
        if(callableStatement.wasNull()){
            return null;
        }else{
            return String2Set(str);
        }
    }
}
