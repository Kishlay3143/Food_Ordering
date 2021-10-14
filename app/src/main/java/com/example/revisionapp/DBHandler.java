package com.example.revisionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorSpace;

import androidx.annotation.Nullable;

import com.example.revisionapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper{

    final static String DBNAME="mydatabase.db";
    final static int DBVERSION=2;

    public DBHandler(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement,"+
                        "name text,"+
                        "phone text,"+
                        "price int,"+
                        "quantity int,"+
                        "image int,"+
                        "description text,"+
                        "foodName text )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP table if exists orders");
            onCreate(db);
    }

    // Method to insert order
    public boolean insertOrder(String name,String phone,int price,int quantity,int image,String desc,String foodName){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();

        /*Actually these indexes are the columns of the Tables of the database*
        id=0
        name=1
        phone=2
        price=3
        quantity=4
        image=5
        description=6
        foodName=7
        */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("quantity",quantity);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodName",foodName);

        long id=database.insert("orders",null,values);
        if (id<=0){
            return false;
        }else {
            return true;
        }
    }

    // Method to show the inserted orders
    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodName,image,price from orders",null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrdersModel model=new OrdersModel();
                model.setOrderNo(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setOrderPrice2(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    // Method to send the id the items to identify the items uniquely
    public Cursor getOrderById(int id){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from orders where id=" +id,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }

        return cursor;
    }

    // Method to update the order
    public boolean updateOrder(String name,String phone,int price,int quantity,int image,String desc,String foodName,int id){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();

        /*Actually these indexes are the columns of the Tables of the database*
        id=0
        name=1
        phone=2
        price=3
        quantity=4
        image=5
        description=6
        foodName=7
        */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("quantity",quantity);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodName",foodName);

        long row=database.update("orders",values,"id="+ id,null);
        if (row<=0){
            return false;
        }else {
            return true;
        }
    }

    // Method to delete the order
    public int deleteOrder(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }


}
