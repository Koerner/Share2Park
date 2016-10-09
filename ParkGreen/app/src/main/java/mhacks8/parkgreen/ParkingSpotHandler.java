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
    public static final String COLUMN_SPOT_LOC_LAT = "_spot_loc_lat";
    public static final String COLUMN_SPOT_LOC_LONG = "_spot_loc_long";
    public static final String COLUMN_PLATE_NUM = "_plate_num";
    public static final String COLUMN_TIME_START = "_time_start";
    public static final String COLUMN_TIME_END = "_time_end";

    public ParkingSpotHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PARKINGSPOTS_TABLE = "CREATE TABLE " +
                TABLE_PARKINGSPOTS + "("
                + COLUMN_SPOT_NUM + " INTEGER PRIMARY KEY," + COLUMN_SPOT_LOC_LAT
                + " TEXT," + COLUMN_PLATE_NUM + " INTEGER" + ")";
        db.execSQL(CREATE_PARKINGSPOTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARKINGSPOTS);
        onCreate(db);
    }

    /*public void addParkingSpot(ParkingSpot spot) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_SPOT_NUM, spot.get_spot_num());
        values.put(COLUMN_SPOT_LOC_LAT, spot.get_spot_loc_lat());
        values.put(COLUMN_SPOT_LOC_LONG, spot.get_spot_loc_long());
        values.put(COLUMN_PLATE_NUM, spot.get_plate_num());
        values.put(COLUMN_TIME_START, String.valueOf(spot.get_time_start()));
        values.put(COLUMN_TIME_END, String.valueOf(spot.get_time_end()));

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PARKINGSPOTS, null, values);
        db.close();
    }*/

    public ParkingSpot findParkingSpot(String spot_to_find) {
        String query = "Select * FROM " + TABLE_PARKINGSPOTS + " WHERE LAT " + COLUMN_SPOT_LOC_LAT + " AND WHERE LONG" + COLUMN_SPOT_LOC_LONG + " =  \"" + spot_to_find + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ParkingSpot spot = new ParkingSpot();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            spot.set_spot_num(Integer.parseInt(cursor.getString(0)));
            spot.setProductName(cursor.getString(1));
            spot.setQuantity(Integer.parseInt(cursor.getString(2)));
            spot.setQuantity(Integer.parseInt(cursor.getString(3)));
            spot.setQuantity(Integer.parseInt(cursor.getString(4)));
            cursor.close();
        } else {
            spot = null;
        }
        db.close();
        return spot;
    }

    /*public boolean deleteParkingSpot(String spot) {

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
    }*/

}