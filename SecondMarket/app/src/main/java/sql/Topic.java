package sql;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/20.
 */
public class Topic implements Serializable {

    private Integer id;
    private String title;//标题
    private String price;//价格
    private String old_price;//原价
    private String describe;//描述
    private String contact_name;//联系人
    private String tellPhone;//联系电话

    public String getOld_price() {
        return old_price;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }









}
