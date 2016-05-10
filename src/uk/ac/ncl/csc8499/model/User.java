package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/8.
 */
@TableBind(tableName = TableName.user)
public class User extends Model<User>{
    public static final User dao = new User();

    public Page<User> query(Map<String, Object> filter){
        int page = filter.get("page")==null?ConstantParas.page:Integer.parseInt(filter.get("page").toString());
        int size = filter.get("size")==null?ConstantParas.size:Integer.parseInt(filter.get("size").toString());
        int type = filter.get("type")==null?ConstantParas.usertype_null:Integer.parseInt(filter.get("type").toString());

        String select = "select * ";
        String where = "from "+TableName.user+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("keyword")!=null && !filter.get("keyword").toString().equals("")){
            String keyword = filter.get("keyword").toString();
            where += " and ( name like '%"+keyword+"%' or username like '%"+keyword+"%' or email like '%"+keyword+"%' ) ";
        }

        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        if (type!=ConstantParas.usertype_null){
            where += " and type="+type;
        }

        String order = " order by "+ (filter.get("orderby")==null?" type asc, created desc":filter.get("orderby").toString());
        System.out.println(select+where+order);
        return User.dao.paginate(page, size, select, where + order);
    }

    public User login(String username,String password){
        List<User> users =  User.dao.find("select * from " + TableName.user + " where username= '" + username + "' and password= '" + password+"' and isDeleted = "+ConstantParas.isDeleted_false+" ");
        return users.size()>0?users.get(0):null;
    }

    public User getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = "from "+TableName.user+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }
        if (filter.get("username")!=null && !filter.get("username").toString().equals("")){
            where += " and username = '"+ filter.get("username").toString()+"' ";
        }
        if (filter.get("name")!=null && !filter.get("name").toString().equals("")){
            where += " and name = '"+filter.get("name").toString()+"' ";
        }
        if (filter.get("password")!=null && !filter.get("password").toString().equals("")){
            where += " and password = '"+filter.get("password").toString()+"' ";
        }
        if (filter.get("email")!=null && !filter.get("email").toString().equals("")){
            where += " and email = '"+filter.get("email").toString()+"' ";
        }
        if (!where.equals("from "+TableName.user+" where 1=1")){
            return User.dao.find(select + where).size()>0?User.dao.find(select + where).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(User user) {
        Map<String, Object> filter = new HashMap<>();
        filter.put("username", user.get("username"));
        if (getBy(filter) != null) {
            return false;
        } else {
            long timestamp = System.currentTimeMillis();
            user.set("created",timestamp);
            user.set("modified",timestamp);
            user.set("isDeleted",ConstantParas.isDeleted_false);
            return user.save();
        }
    }

    public boolean update(User user){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", user.get("id"));
        if (getBy(filter) != null) {
            user.set("modified",System.currentTimeMillis());
            return user.update();
        } else {
            return false;
        }
    }

    public boolean delete(User user){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", user.get("id"));
        if (getBy(filter) != null) {
            user.set("isDeleted",ConstantParas.isDeleted_true);
            user.set("modified",System.currentTimeMillis());
            return user.update();
        } else {
            return false;
        }
    }
}
