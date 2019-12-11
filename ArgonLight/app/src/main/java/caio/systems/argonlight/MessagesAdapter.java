package caio.systems.argonlight;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class MessagesAdapter extends BaseAdapter {

    private final Fragment fragment;
    private List<MessagesClass> listMsg;

    public MessagesAdapter(Fragment fragment, List<MessagesClass> listMsg) {
        this.fragment = fragment;
        this.listMsg = listMsg;
    }

    @Override
    public int getCount() {
        return listMsg.size();
    }

    @Override
    public Object getItem(int i) {
        return listMsg.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = fragment.getLayoutInflater().inflate(R.layout.listcell, viewGroup, false);
        MessagesClass messages = listMsg.get(i);

        TextView title = view.findViewById(R.id.msgText);
        ImageView img = view.findViewById(R.id.thumbnail);

        title.setText(messages.getMsgTitle());
        img.setImageResource(messages.getMsgIcon());

        return view;
    }
}
