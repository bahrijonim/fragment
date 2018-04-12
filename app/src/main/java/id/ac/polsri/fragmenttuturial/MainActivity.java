package id.ac.polsri.fragmenttuturial;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        FragmentSatu.OnFragmentInteractionListener, FragmentDua.OnFragmentInteractionListener, FragmentTiga.OnFragmentInteractionListener {

    private BottomNavigationView bottomNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, FragmentSatu.newInstance());
        fragmentTransaction.commit();

        bottomNavigationMenu = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_satu :
                fragment = FragmentSatu.newInstance();
                break;
            case R.id.menu_dua :
                fragment = FragmentDua.newInstance();
                break;
            case R.id.menu_tiga :
                fragment = FragmentTiga.newInstance();
                break;
        }

        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Mau keluar?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();
    }
}
