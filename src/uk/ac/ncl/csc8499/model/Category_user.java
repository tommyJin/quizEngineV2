package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/7/20.
 */
@TableBind(tableName = TableName.category_user)
public class Category_user extends Model<Category_user> {
    public static final Category_user dao = new Category_user();

    public List<Category_user> query(Map<String, Object> filter){
        String select = "select * ";
        String where = " from "+TableName.category_user+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("user_id")!=null && !filter.get("user_id").toString().equals("")){
            Integer user_id = Integer.valueOf(filter.get("user_id").toString());
            where += " and user_id= "+user_id+" ";
        }

        if (filter.get("category_id")!=null && !filter.get("category_id").toString().equals("")){
            Integer category_id = Integer.valueOf(filter.get("category_id").toString());
            where += " and category_id= "+category_id+" ";
        }

        String order = " order by "+ (filter.get("orderby")==null?"  created desc":filter.get("orderby").toString());
        return Category_user.dao.find(select + where + order);
    }

    public Category_user getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = " from "+TableName.category_user+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("user_id")!=null){
            where += " and user_id = "+Integer.parseInt(filter.get("user_id").toString());
        }
        if (filter.get("category_id")!=null && !filter.get("category_id").toString().equals("")){
            where += " and category_id = "+Integer.parseInt(filter.get("category_id").toString())+" ";
        }
        if (!where.equals(" from "+TableName.category_user+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ")){
            List<Category_user> cus = Category_user.dao.find(select+where);
            return cus.size()>0?cus.get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(Category_user cu){
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",cu.get("user_id"));
        filter.put("category_id",cu.get("category_id"));
        Category_user cuser = getBy(filter);
        if (cuser==null){
            long time = System.currentTimeMillis();
            cu.set("created",time);
            cu.set("modified",time);
            cu.set("isDeleted",0);
            return cu.save();
        }else {
            if (cuser.get("isDeleted").toString().equals("1")){
                cuser.set("isDeleted",0);
                return Category_user.dao.update(cuser);
            }else {
                return true;
            }
        }
    }

    //maybe no need here
    public boolean update(Category_user cu){
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",cu.get("user_id"));
        filter.put("category_id",cu.get("category_id"));
        Category_user cuser = getBy(filter);
        if (cuser != null && cuser.get("isDeleted").toString().equals("0")){
            cu.set("modified",System.currentTimeMillis());
            return cu.update();
        }else {
            return false;
        }
    }

    public boolean delete(Category_user cu){
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",cu.get("user_id"));
        filter.put("category_id",cu.get("category_id"));
        Category_user cuser = getBy(filter);
        if (cuser != null && cuser.get("isDeleted").toString().equals("0")){
            cu.set("isDeleted",1);
            cu.set("modified",System.currentTimeMillis());
            return cu.update();
        }else {
            return false;
        }
    }

}
