package caio.systems.argonlight;

import android.app.ListActivity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MessagesFrag extends Fragment {

    private ListView list;
    private List<MessagesClass> msgList;


    public MessagesFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        list = view.findViewById(R.id.lvMessages);
        //set the adapter, etc
        msgList = new ArrayList<MessagesClass>();

        msgList.add(new MessagesClass(R.drawable.ic_menu_info_details, "Message 1"));
        msgList.add(new MessagesClass(R.drawable.ic_menu_info_details, "Message 2"));
        msgList.add(new MessagesClass(R.drawable.ic_menu_info_details, "Message 3"));
        msgList.add(new MessagesClass(R.drawable.ic_menu_info_details, "Message 4"));

        final MessagesAdapter msgAdap = new MessagesAdapter(this, msgList);


        list.setAdapter(msgAdap);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MessagesClass selectedMsg = msgList.get(i);
                Toast.makeText(getActivity(), "Mensagem Selecionada: " + selectedMsg.getMsgTitle(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



}
