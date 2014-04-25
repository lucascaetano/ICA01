package com.example.ica01;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Build;

public class ItensListaActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_itens_lista);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.itens_lista, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		public void teste() {
			ListView itemList = (ListView) getView().findViewById(
			R.id.itensLst);
			Spinner s = (Spinner) getView().findViewById(R.id.ListaComprasSpn);
			String txt1 = s.getSelectedItem().toString();
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_itens_lista,
					container, false);
			Button button = (Button) rootView.findViewById(R.id.selecionarBtn);

			button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					teste();

				}
			});

			ListView itemList = (ListView) rootView
					.findViewById(R.id.itensLst);
			ArrayList<String> itemNameList = new ArrayList<String>();
		
				itemNameList.add("FARINHA - 1KG");
				itemNameList.add("ARROZ - 5KG");
				itemNameList.add("FEIJAO - 2KG");
			
			ItensListaActivity classe = (ItensListaActivity) getActivity();
			ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
					classe, android.R.layout.simple_list_item_1,
					itemNameList);
			itemList.setAdapter(arrayAdapter);

			String[] array_spinner = new String[4];
			array_spinner[0] = "Lista de Compras - Carone";
			array_spinner[1] = "Lista de Compras - ExtraBom";
			array_spinner[2] = "Lista de Compras - Perim";
			array_spinner[3] = "Lista de Compras - Epa";
			Spinner s = (Spinner) rootView.findViewById(R.id.ListaComprasSpn);
			ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, array_spinner);
			s.setAdapter(adapter);

			return rootView;
		}
	}

}
