package sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/20.
 */


public class Service {

    private DatabaseHelper databaseHelper;

    public Service(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    //增
    public void addData(Topic topic) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();// 创建或者打开一个可写数据库
        // 插入数据
        db.execSQL("INSERT INTO topic(title,price,old_price,describe,contact_name,tellPhone) " +
                "VALUES(?,?,?,?,?,?)", new Object[]
                {
                        topic.getTitle(),topic.getPrice(),topic.getOld_price(),
                        topic.getDescribe(),topic.getContact_name(),topic.getTellPhone()
                });
    }


    public List<Topic> getData(int offset,int count){
        ArrayList<Topic> topicList = new ArrayList<Topic>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // offset开始索引
        // count 记录条数
        Cursor cursor = db.rawQuery("select * from topic order by id desc limit ?,?", new String[]
                {
                        String.valueOf(offset), String.valueOf(count)
                });
        while (cursor.moveToNext()) {
            Topic topic = new Topic();
            topic.setId(cursor.getInt(cursor.getColumnIndex("id")));
            topic.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            topic.setPrice(cursor.getString(cursor.getColumnIndex("price")));
            topic.setOld_price(cursor.getString(cursor.getColumnIndex("old_price")));
            topic.setDescribe(cursor.getString(cursor.getColumnIndex("describe")));
            topic.setContact_name(cursor.getString(cursor.getColumnIndex("contact_name")));
            topic.setTellPhone(cursor.getString(cursor.getColumnIndex("tellPhone")));
            topicList.add(topic);
        }
        cursor.close();
        return topicList;
    }

    public List<Topic> getScrollData(int offset, int count) {
        ArrayList<Topic> topicList = new ArrayList<Topic>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // offset开始索引
        // count 记录条数
        Cursor cursor = db.rawQuery("select id,title,price,old_price,describe,contact_name,tellPhone from topic limit ?,?", new String[]
                {
                        String.valueOf(offset), String.valueOf(count)
                });
        while (cursor.moveToNext()) {
            Topic topic = new Topic();
            topic.setId(cursor.getInt(cursor.getColumnIndex("id")));
            topic.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            topic.setPrice(cursor.getString(cursor.getColumnIndex("price")));
            topic.setOld_price(cursor.getString(cursor.getColumnIndex("old_price")));
            topic.setDescribe(cursor.getString(cursor.getColumnIndex("describe")));
            topic.setContact_name(cursor.getString(cursor.getColumnIndex("contact_name")));
            topic.setTellPhone(cursor.getString(cursor.getColumnIndex("tellPhone")));
            topicList.add(topic);
        }
        cursor.close();
        return topicList;
    }

    //删
    public void deleteData(Integer id) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();// 创建或者打开一个可写数据库
        db.execSQL("delete from topic where id=?", new Object[]
                {
                        id
                });
    }

    //改
    public void updateData(Topic topic) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL("update topic set whosend=?,title=?,price=? where id = ?", new Object[]
                {

                });
    }

}