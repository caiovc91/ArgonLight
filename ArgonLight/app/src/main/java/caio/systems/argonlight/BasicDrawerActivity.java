package caio.systems.argonlight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class BasicDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView nvgView;
    private FragmentUtil fragUtil;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private ArrayList<Fragment> fragsList;
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_drawer);


        mDrawerLayout = findViewById(R.id.mainDrawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        nvgView = findViewById(R.id.navigView);
        nvgView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragUtil = new FragmentUtil();
        fragsList = new ArrayList<Fragment>();

        gen_charts();


    }
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        ArrayList <Fragment> fragments = new ArrayList <Fragment>();
        fragments.add(new MessagesFrag());
        fragments.add(new Billings());
        fragments.add(new DashboardUnit());
        Fragment fragment = fragments.get(position);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
   public boolean onOptionsItemSelected(MenuItem item){
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();


        switch(menuItem.getItemId()){

            case R.id.home: {
                Toast.makeText(this, "Voltou na Home", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.myData: {
                //fm.beginTransaction().replace(R.id.mainFrame,getItem(0)).commit();
                ft.addToBackStack("mydata");
                Toast.makeText(this, "Entrou em Meus Dados", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.unitDashboard: {
                //getItem(1);
                fm.beginTransaction().replace(R.id.mainFrame,new DashboardUnit()).commit();
                ft.addToBackStack("unitdashboard");
                //fm.beginTransaction().replace(R.id.mainFrame, new MessagesFrag() ).commit();
                Toast.makeText(this, "Entrou em Unidades", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.billing: {
                //getItem(1);
                fm.beginTransaction().replace(R.id.mainFrame,new Billings()).commit();
                ft.addToBackStack("billings");
                //fm.beginTransaction().replace(R.id.mainFrame, new MessagesFrag() ).commit();
                Toast.makeText(this, "Entrou em Faturamento", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.myLogs: {
                fm.beginTransaction().replace(R.id.mainFrame,getItem(0)).commit();
                ft.addToBackStack("logs");
                Toast.makeText(this, "Entrou em Logs", Toast.LENGTH_SHORT).show();
                break;
            }

            default: {
                Toast.makeText(this, "Menu Default", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void gen_charts(){
        chart = findViewById(R.id.lineChart);

        chart.setTouchEnabled(true);
        chart.setPinchZoom(false);
        MyMarkerView mv = new MyMarkerView(getApplicationContext(), R.layout.custom_marker_view);
        mv.setChartView(chart);
        chart.setMarker(mv);

        ArrayList<Entry> yVal = new ArrayList<>();

        yVal.add(new Entry(0, 748.2f));
        yVal.add(new Entry(1, 1394.6f));
        yVal.add(new Entry(2, 3458.12f));
        yVal.add(new Entry(3, 9994.34f));
        yVal.add(new Entry(4, 1200.2f));
        yVal.add(new Entry(5, 3222.2f));
        yVal.add(new Entry(6, 427.2f));
        yVal.add(new Entry(7, 1500.2f));
        yVal.add(new Entry(8, 5000));
        yVal.add(new Entry(9, 12000));
        yVal.add(new Entry(10, 2333.45f));
        yVal.add(new Entry(11, 222222.45f));
        yVal.add(new Entry(12, 222222.45f));

        LineDataSet setOne = new LineDataSet(yVal, "Economia"); //legenda e criacao da linha
        setOne.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setOne);
        LineData data = new LineData(dataSets);

        chart.setData(data);
    }
}
