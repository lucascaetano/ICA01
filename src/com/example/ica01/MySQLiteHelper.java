package com.example.ica01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "APS01";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Books table name
	private static final String TABELA_ITENS = "ITEMLISTA";

	// Books Table Columns names
	private static final String KEY_ID = "id";
	private static final String nomeLista = "nomeLista";
	private static final String nomeItem = "nomeItem";
	private static final String numItens = "numItens";
	private static final String comprado = "comprado";

	private static final String[] COLUNAS = { KEY_ID, nomeLista, nomeItem,
			numItens, comprado };

	public void addItem(ItensListaCompras itens) {
		// for logging
		Log.d("adicionar Item", itens.toString());

		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();

		// 2. create ContentValues to add key "column"/value
		ContentValues values = new ContentValues();
		values.put(nomeLista, itens.getNomeLista());
		values.put(nomeItem, itens.getNomeitem());
		values.put(numItens, itens.getNumItens());
		values.put(comprado, itens.getComprado());
		

		// 3. insert
		db.insert(TABELA_ITENS, // table
				null, // nullColumnHack
				values); // key/value -> keys = column names/ values = column
							// values

		// 4. close
		db.close();
	}
	
	public ItensListaCompras getItens(int id){
		 
	    // 1. get reference to readable DB
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    // 2. build query
	    Cursor cursor = 
	            db.query(TABELA_ITENS, // a. table
	            COLUNAS, // b. column names
	            " id = ?", // c. selections 
	            new String[] { String.valueOf(id) }, // d. selections args
	            null, // e. group by
	            null, // f. having
	            null, // g. order by
	            null); // h. limit
	 
	    // 3. if we got results get the first one
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    // 4. build book object
	    ItensListaCompras itens = new ItensListaCompras(0,"","","","");
	    itens.setId(Integer.parseInt(cursor.getString(0)));
	    itens.setNomeLista(cursor.getString(1));
	    itens.setNomeitem(cursor.getString(2));
	    itens.setNumItens(cursor.getString(2));
	    itens.setComprado(cursor.getString(2));
	 
	    //log 
	Log.d("Obtem Item("+id+")", itens.toString());
	 
	    // 5. return book
	    return itens;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// SQL statement to create book table
		String CRIAR_TABELA_ITENS = "CREATE TABLE ITEMLISTA ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nomeLista TEXT, "
				+ "nomeItem TEXT" + "numItens INTEGER" + "comprado INTEGER "
				+ " )";

		// create books table
		db.execSQL(CRIAR_TABELA_ITENS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older books table if existed
		db.execSQL("DROP TABLE IF EXISTS ITEMLISTA");

		// create fresh books table
		this.onCreate(db);
	}

}