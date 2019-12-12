package caio.systems.argonlight;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class BillingsAdapter extends BaseAdapter {
    private final Fragment fragment;
    private List<BillingClass> listBill;

    public BillingsAdapter(Fragment fragment, List<BillingClass> listBill) {
        this.fragment = fragment;
        this.listBill = listBill;
    }

    @Override
    public int getCount() {
        return listBill.size();
    }

    @Override
    public Object getItem(int position) {
        return listBill.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = fragment.getLayoutInflater().inflate(R.layout.bill_cell_list, parent, false);
        BillingClass bills = listBill.get(i);

        TextView title = view.findViewById(R.id.billCode);
        TextView status = view.findViewById(R.id.txtStatus);
        ImageView img = view.findViewById(R.id.thumbnail);

        title.setText(bills.getBillCode());
        status.setText(bills.getStatus());
        img.setImageResource(bills.getMsgIcon());
        return view;
    }
}
