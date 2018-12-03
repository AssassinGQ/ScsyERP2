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

public class HashSetTypeHandler<T> extends BaseTypeHandler<HashSet<T>> {

    private String Set2String(HashSet<T> hashSet){
        try{
            Iterator<T> iterator = hashSet.iterator();
            JSONArray jsonArray = new JSONArray();
            while(iterator.hasNext()){
                jsonArray.add(iterator.next());
            }
            return jsonArray.toJSONString();
        }catch(Exception e){
            return "";
        }
    }

    private HashSet<T> String2Set(String string){
        try{
            JSONArray jsonArray = JSONArray.parseArray(string);
            HashSet<T> hashSet = new HashSet<T>();
            for(int i = 0; i < jsonArray.size(); i++){
                hashSet.add((T) jsonArray.get(i));
            }
            return hashSet;
        }catch(Exception e){
            return new HashSet<T>();
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, HashSet<T> ts, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, Set2String(ts));
    }

    @Override
    public HashSet<T> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String str = resultSet.getString(s);
        if(resultSet.wasNull()){
            return null;
        }else{
            return String2Set(str);
        }
    }

    @Override
    public HashSet<T> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String str = resultSet.getString(i);
        if(resultSet.wasNull()){
            return null;
        }else{
            return String2Set(str);
        }
    }

    @Override
    public HashSet<T> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String str = callableStatement.getString(i);
        if(callableStatement.wasNull()){
            return null;
        }else{
            return String2Set(str);
        }
    }
}
