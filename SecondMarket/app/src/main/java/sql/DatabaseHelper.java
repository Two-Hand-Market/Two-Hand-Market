package sql;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 继承SQLiteOpenHelper
 *
 * @author Harvey
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * 数据库名称 /.db可有可无
     */
    public static final String DATABASE_NAME = "market.db";
    /**
     * 数据库版本,版本号不能为0
     */
    public static final int DATABASE_VERSION = 1;

    /**
     * 构造方法
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        // CursorFactory设置为null,使用默认值
        this(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 必须要有此构造方法
     *
     * @param context 代表应用的上下文
     * @param name    代表数据库的名称
     * @param factory 代表记录集游标工厂，是专门用来生成记录集游标，记录集游标是对查询结果进行迭代的
     * @param version 代表数据库的版本，如果以后升级软件的时候，需要更改
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // 必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }

    /**
     * 在用户第一次使用软件时，会创建数据库，而该方法在数据库初次创建时被调用，此方法中特别适合
     * 生成数据库表的结构，它只会被调用一次，它的唯一一个参数是操作数据库的工具类，这个
     * 工具类提供了对数据的添、删、改、查等方法，用这个类实现对SQL语句的执行
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE topic (id Integer PRIMARY KEY AUTOINCREMENT, title TEXT,price TEXT,old_price TEXT,describe TEXT,contact_name TEXT,tellPhone TEXT)");
        // Create Topic Table
    }

    /** q
     * version版本号发生改变时，此方法会被调用，在这个方法中比较适合实现软件更新时修改数据库表结构的工作
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
