package caio.systems.argonlight;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class DashboardUnit extends Fragment {
    private LineChart chart;
    private FragmentUtil fragUtil = new FragmentUtil();
    final FragmentManager fragmentManager = getFragmentManager();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //gen_charts();

        return inflater.inflate(R.layout.fragment_dashboard_unit, container, false);

    }

    public void gen_charts(){
        chart = getView().findViewById(R.id.chartUnit);

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

}
