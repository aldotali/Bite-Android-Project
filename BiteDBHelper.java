package app.com.redi.redidemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ali Altaf Salemwala on 4/30/2016.
 */
public class BiteDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Bite.db";
    public static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    // STORAGE CLASSES IN SQLITE
    private static final String NULL_TYPE = " NULL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " BLOB";
    private static final String REAL_TYPE = " REAL";

    // CONSTANTS FOR RECIPES TABLE
    private static final String RECIPES_TB_NAME = "Recipes";
    private static final String C1_REC_NAME = "Name";
    private static final String C2_REC_ING = "Ingredients";
    private static final String C3_REC_INSTR = "Instructions";
    private static final String C4_REC_CUI = "Cuisine";
/*    private static final String CREATE_RECIPES_TABLE = "CREATE TABLE IF NOT EXISTS " +
            RECIPES_TB_NAME + " (" +
            C1_REC_NAME + TEXT_TYPE + ", " +
            C2_REC_ING + TEXT_TYPE + ", " +
            C3_REC_INSTR + TEXT_TYPE + ", " +
            C4_REC_CUI + TEXT_TYPE +
            ")";*/
    public static String CREATE_RECIPES_TABLE = "CREATE TABLE IF NOT EXISTS Recipes (Name TEXT, Ingredients TEXT, Instructions TEXT, Cuisine TEXT)";

    // CONSTANTS FOR USER TABLE
    private static final String USERS_TB_NAME = "Users";
    private static final String C1_USERNAME = "Username";
    private static final String C2_PASSWORD = "Password";
/*    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " +
            USERS_TB_NAME + " (" +
            C1_USERNAME + TEXT_TYPE + ", " +
            C2_PASSWORD + TEXT_TYPE +
            ")";*/
    public static String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS Users (Username TEXT, Password TEXT)";


    // CONSTANTS FOR INVENTORY TABLE TEMPLATE
    private static final String C1_INGREDIENT_NAME = "Ingredient";
    private static final String C2_INGREDIENT_AMOUNT_IN_KILO = "Amount";
    private static final String C3_COST_PER_KILO = "Cost";

    // CONSTRUCTOR
    public BiteDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // onCreate METHOD, CREATES RECIPES AND USERS TABLE
    public void onCreate(SQLiteDatabase db){
        this.db = db;
        db.execSQL(CREATE_RECIPES_TABLE);
        db.execSQL(CREATE_USERS_TABLE);
    }

    // onUpgrade METHOD, DOES NOTHING
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        this.db = db;
        db.execSQL("DROP TABLE IF EXISTS " + RECIPES_TB_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TB_NAME);
        onCreate(db);
    }

    /* CREATES NEW USER USING username AND password
       CREATES NEW Inventory TABLE FOR USER, WITH NAME username + "Inv" */
    public void addUser(String username, String password){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(C1_USERNAME, username);
        values.put(C2_PASSWORD, password);
        db.insert(USERS_TB_NAME, null, values);
        db.execSQL("CREATE TABLE " +
                username + "Inv (" + C1_INGREDIENT_NAME + TEXT_TYPE + ", " +
                C2_INGREDIENT_AMOUNT_IN_KILO + REAL_TYPE + ", " +
                C3_COST_PER_KILO + REAL_TYPE +
                ")");
    }

    // CHECKS TO SEE IF USERNAME ALREADY USED EARLIER, RETURNS TRUE IF YES
    public boolean checkUsername(String username){
        db = this.getReadableDatabase();
        int count = -1;
        try {
            Cursor foo = db.rawQuery("SELECT * FROM " + USERS_TB_NAME + " WHERE " +
                    C1_USERNAME + " = '" + username + "'", null);
            count = foo.getCount();
            foo.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count > 0;
    }

    // CHECKS TO SEE IF USERNAME PASSWORD COMBO IS RIGHT; IF SO RETURNS TRUE
    public boolean checkLogin(String username, String password){
        db = this.getReadableDatabase();
        String s = "";
        if (checkUsername(username)){
            try {
                String[] col = {C2_PASSWORD};
                String[] args = {username};
                Cursor foo = db.query(USERS_TB_NAME, col, C1_USERNAME + " = ?", args, null, null, null);
                foo.moveToFirst();
                s = foo.getString(0);
                foo.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return s.equals(password);
        }
        else return false;
    }

    // ADDS RECIPE TO RECIPES TABLE AND CREATES THAT RECIPE'S INVENTORY TOO
    public void addRecipe(String rec_name, String[] rec_ings, String rec_instr, String rec_cui){
        db = this.getWritableDatabase();
        String str_rec_ings = "";
        for (int i = 0; i < rec_ings.length; i++)
            str_rec_ings = str_rec_ings + rec_ings[i] + " - ";
        db.execSQL("INSERT INTO " + RECIPES_TB_NAME + " (" + C1_REC_NAME + ", " + C2_REC_ING +
                ", " + C3_REC_INSTR + ", " + C4_REC_CUI + ") VALUES (" + rec_name + ", " +
                str_rec_ings + ", " + rec_instr + ", " + rec_cui + ")");
        db.execSQL("CREATE TABLE " +
                rec_name + "Inv (" + C1_INGREDIENT_NAME + TEXT_TYPE + ", " +
                C2_INGREDIENT_AMOUNT_IN_KILO + REAL_TYPE +
                ")");
        ContentValues values = new ContentValues();
        for (int i = 0; i < rec_ings.length; i++){
            values.clear();
            values.put(C1_INGREDIENT_NAME, rec_ings[i]);
            values.put(C2_INGREDIENT_AMOUNT_IN_KILO, 2.5);
            db.insert(rec_name + "Inv", null, values);
        }
    }

    // SHOWS INGREDIENTS IN RECIPES TABLE
    public String returnIngredients(String rec_name){
        db = this.getReadableDatabase();

        String s = "";
        String[] col = {C1_REC_NAME};
        Cursor c = null;
        try {
            c = db.query(RECIPES_TB_NAME, col, C1_REC_NAME + " = " + rec_name, null, null, null, null);
        }
        catch (Exception e){}
        if (c.moveToFirst()) {
            s = c.getString(c.getColumnIndex(C2_REC_ING));
        }
        c.close();
        return s;
    }

    // SHOWS INSTRUCTIONS IN RECIPES TABLE
    public String returnInstructions(String rec_name){
        db = this.getReadableDatabase();
        String s = "";
        String[] col = {C3_REC_INSTR};
        Cursor c = null;
        try {
            c = db.query(RECIPES_TB_NAME, col, C1_REC_NAME + " = " + rec_name, null, null, null, null);
        }
        catch (Exception e){}
        if (c.moveToFirst()) {
            s = c.getString(c.getColumnIndex(C3_REC_INSTR));
        }
        c.close();
        return s;
    }
}
