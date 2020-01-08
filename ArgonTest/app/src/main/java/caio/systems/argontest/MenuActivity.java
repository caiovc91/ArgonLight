package caio.systems.argontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {
    private RecyclerViewAdapter adapter;
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<Button> listButtons = new ArrayList<>();
        for(int x = 0; x < 5; x++) {
            menuButton = findViewById(R.id.btnView);
            menuButton.setOnClickListener((View.OnClickListener) this); // maybe
            listButtons.add(menuButton);
        }



    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public Button create_button(Button button, int id, Intent i, Context context, String name){
            button = findViewById(id);
        return button;
    }

}
