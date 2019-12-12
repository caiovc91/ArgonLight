package caio.systems.argonlight;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Billings extends Fragment {
    private ListView list;
    private List<BillingClass> bill_List;

    public Billings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View billing = inflater.inflate(R.layout.fragment_billings, container, false);

        list = billing.findViewById(R.id.listBills);
        //set the adapter, etc
        bill_List = new ArrayList<BillingClass>();

        bill_List.add(new BillingClass(R.drawable.ic_menu_info_details, "Message 1", "OK"));
        bill_List.add(new BillingClass(R.drawable.ic_menu_info_details, "Message 2", "OK"));
        bill_List.add(new BillingClass(R.drawable.ic_menu_info_details, "Message 3", "DUE"));
        bill_List.add(new BillingClass(R.drawable.ic_menu_info_details, "Message 4", "OK"));

        final BillingsAdapter msgAdap = new BillingsAdapter(this, bill_List);


        list.setAdapter(msgAdap);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BillingClass selectedMsg = bill_List.get(i);
                Toast.makeText(getActivity(), "Fatura selecionada: " + selectedMsg.getBillCode(), Toast.LENGTH_LONG).show();
            }
        });
        return billing;
    }

}
