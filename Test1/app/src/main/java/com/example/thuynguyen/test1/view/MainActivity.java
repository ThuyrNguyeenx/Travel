package com.example.thuynguyen.test1.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thuynguyen.test1.R;
import com.example.thuynguyen.test1.control.CityDAO;
import com.example.thuynguyen.test1.control.SQLiteController;
import com.example.thuynguyen.test1.model.City;


public class MainActivity extends AppCompatActivity {

    GridView gridview;
    ViewPager viewPager;
    CustomSlideAdapter slideAdapter;
    TextView txtTen;
    TextView txtOverView;
    ImageView imgCity;
    CityDAO cityDAO;
    City city;
    Button btnBack, btnMap;

    Bundle myBackupBundle;

    final int[] listImg = {R.drawable.hanoi, R.drawable.hcm, R.drawable.dn, R.drawable.cantho,
            R.drawable.haiphong,R.drawable.hue,R.drawable.laocai};
    final String[] name = {"Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Cần Thơ","Hải Phòng", "Huế","Lào Cai"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBackupBundle = savedInstanceState;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridview = (GridView)findViewById(R.id.gridview);

        viewPager = (ViewPager) findViewById(R.id.viewPage);
        slideAdapter = new CustomSlideAdapter(this);
        viewPager.setAdapter(slideAdapter);

        CustomGrid adapter = new CustomGrid(MainActivity.this, name, listImg );
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                setContentView(R.layout.chitietcity);
                txtTen = (TextView) findViewById(R.id.txtTenCity);
                txtOverView = (TextView) findViewById(R.id.txtoverView);
                imgCity = (ImageView) findViewById(R.id.imgCity);
                btnBack = (Button) findViewById(R.id.btnBack);
                btnMap = (Button) findViewById(R.id.btnMap);

                creatDB();
                cityDAO = new CityDAO(view.getContext());
                city = cityDAO.getCityByName(name[position]);
                imgCity.setImageResource(listImg[position]);
                txtTen.setText(city.getName());
                txtOverView.setText(city.getOverView());

                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onCreate(myBackupBundle);
                    }
                });
                btnMap.setOnClickListener(onClickMap);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void creatDB(){
        try {
            SQLiteController connect = new SQLiteController(this);
            connect.isCreatedDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    View.OnClickListener onClickBack = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            onCreate(myBackupBundle);
//        }
//    };
    View.OnClickListener onClickMap = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
