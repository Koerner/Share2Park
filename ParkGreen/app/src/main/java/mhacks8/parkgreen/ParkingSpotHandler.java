package mhacks8.parkgreen;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by carsonschmidt on 10/8/16.
 */

public class ParkingSpotHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "parkingspotDB.db";
    private static final String TABLE_PARKINGSPOTS = "parking spots";

    public static final String COLUMN_SPOT_NUM = "_spot_num";
    public static final String COLUMN_SPOT_LOC = "_spot_loc";
    public static final String COLUMN_PLATE_NUM = "_plate_num";
    public static final String COLUMN_TIME_IN = "_time_in";
    public static final String COLUMN_TIME_OUT = "_time_out";

    public ParkingSpotHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PARKINGSPOTS_TABLE = "CREATE TABLE " +
                TABLE_PARKINGSPOTS + "("
                + COLUMN_SPOT_NUM + " INTEGER PRIMARY KEY," + COLUMN_SPOT_LOC
                + " TEXT," + COLUMN_PLATE_NUM + " INTEGER" + ")";
        db.execSQL(CREATE_PARKINGSPOTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARKINGSPOTS);
        onCreate(db);
    }
/*
    public void addParkingSpot(ParkingSpot spot) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_SPOT_LOC, spot.getProductName());
        values.put(COLUMN_PLATE_NUM, spot.getQuantity());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PARKINGSPOTS, null, values);
        db.close();
    }

    public ParkingSpot findParkingSpot(String productname) {
        String query = "Select * FROM " + TABLE_PARKINGSPOTS + " WHERE " + COLUMN_SPOT_LOC + " =  \"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ParkingSpot product = new ParkingSpot();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setProductName(cursor.getString(1));
            product.setQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }

    public boolean deleteProduct(String productname) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_PARKINGSPOTS + " WHERE " + COLUMN_SPOT_LOC + " =  \"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ParkingSpot spot = new ParkingSpot();

        if (cursor.moveToFirst()) {
            spot.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PARKINGSPOTS, COLUMN_SPOT_NUM + " = ?",
                    new String[] { String.valueOf(spot.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}*/