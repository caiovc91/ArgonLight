package caio.systems.argonlight;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class DashboardUnit extends Fragment {
    private LineChart chart;
    private FragmentUtil fragUtil = new FragmentUtil();
    final FragmentManager fragmentManager = getFragmentManager();

    private TextView txtValor_unidade, txtValor_emissao_unidade, txtValor_media_unidade;
    private String strVal_unit, strVal_emi_unit, strVal_med_unit;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //gen_charts();
        View dashUnit = inflater.inflate(R.layout.fragment_dashboard_unit, container, false);
        chart = dashUnit.findViewById(R.id.chartUnit);
        gen_charts();

        txtValor_unidade = dashUnit.findViewById(R.id.valueData1);
        txtValor_emissao_unidade = dashUnit.findViewById(R.id.valueData2);
        txtValor_media_unidade = dashUnit.findViewById(R.id.valUnitMedia);
        set_infos();

        return dashUnit;

    }

    public void gen_charts(){


        chart.setTouchEnabled(true);
        chart.setPinchZoom(false);
        MyMarkerView mv = new MyMarkerView(getActivity().getApplicationContext(), R.layout.custom_marker_view);
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

    public void set_infos(){
        double val_1, val_2, val_3;
        val_1 = 5999.32;
        val_2 = 320.3;
        val_3 = (val_2/val_1);

        txtValor_unidade.setText("$" + new DecimalFormat("#.##").format(val_1));
        txtValor_emissao_unidade.setTextColor(getResources().getColor(R.color.green_emission));
        txtValor_emissao_unidade.setText(new DecimalFormat("#.##").format(val_2) + "Kg");
        txtValor_media_unidade.setText(new DecimalFormat("#.##").format(val_3) + "[R$/kg]");

    }

}
