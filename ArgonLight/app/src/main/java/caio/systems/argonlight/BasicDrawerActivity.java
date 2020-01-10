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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
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

    //variaveis de tela
    private String strVal_total, strVal_emi_total, strVal_med_total;
    private TextView txtValor_total, txtValor_emissao_total, txtValor_media_total;

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

        txtValor_total = findViewById(R.id.valEconomia);
        txtValor_emissao_total = findViewById(R.id.valCarbon);
        txtValor_media_total = findViewById(R.id.valMediana);
        set_infos();

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

        yVal.add(new Entry(0, 250.32f));
        yVal.add(new Entry(1, 375.65f));
        yVal.add(new Entry(2, 1375.57f));
        yVal.add(new Entry(3, 2394.87f));
        yVal.add(new Entry(4, 3219.47f));
        yVal.add(new Entry(5, 4219.43f));
        yVal.add(new Entry(6, 5230.20f));
        yVal.add(new Entry(7, 6198.22f));
        yVal.add(new Entry(8, 7192));
        yVal.add(new Entry(9, 8140));
        yVal.add(new Entry(10, 9410.32f));
        yVal.add(new Entry(11, 10130.32f));
        yVal.add(new Entry(12, 12000.45f));

        LineDataSet setOne = new LineDataSet(yVal, "Economia"); //legenda e criacao da linha
        setOne.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setOne);
        LineData data = new LineData(dataSets);

        chart.setData(data);
    }

    public void set_infos(){
        double val_1, val_2, val_3;
        val_1 = 42000.37;
        val_2 = 5700.3;
        val_3 = (val_2/val_1);


        txtValor_total.setText("$" + new DecimalFormat("#.##").format(val_1));
        txtValor_emissao_total.setTextColor(getResources().getColor(R.color.green_emission));
        txtValor_emissao_total.setText(new DecimalFormat("#.##").format(val_2) + "Kg");
        txtValor_media_total.setText(new DecimalFormat("#.##").format(val_3) + "[R$/kg]");

    }
}
