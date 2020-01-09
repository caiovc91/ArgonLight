package caio.systems.argontest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/*
 * Ver mais em:
 * NavHostFragment
 * https://code.tutsplus.com/articles/how-to-use-bottom-sheets-with-the-design-support-library--cms-26031
 * https://medium.com/@droidbyme/android-bottom-sheet-7e9cfcec6427
 * https://medium.com/android-bits/android-bottom-sheet-30284293f066
 * https://www.androidhive.info/2017/12/android-working-with-bottom-sheet/
 *
 */

public class MainActivity extends AppCompatActivity {

    private Activity ativ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ativ = new Activity();
    }

    public void openMenu(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        this.startActivity(i);
    }
}
