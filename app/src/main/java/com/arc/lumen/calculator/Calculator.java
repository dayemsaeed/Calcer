package com.arc.lumen.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Calculator extends AppCompatActivity {

    // Variables for navigation drawer
    private String[] mCalculatorTypes;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Code for navigation drawer
        mCalculatorTypes = getResources().getStringArray(R.array.calculator_type);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);

        // Set ListView adapter
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mCalculatorTypes));

        // Set list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position);
        }
    }

    /**
     * Displaying fragment view for selected nav drawer list item.
     */
    private void displayView(int position) {

        // Update the main content by replacing fragments.
        Fragment fragment = null;
        switch(position) {

            case 0:
                fragment = new SimpleCalculator();
                break;

            case 1:
                fragment = new ScientificCalculator();
                break;

            /*
            case 2:
                fragment = new FinancialCalculator();
                break;
            */

            default:
                break;

        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

            // update selected item, then close drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList);

        }

        else {

            Log.e("Calculator", "Error in creating fragment.");

        }

    }

}
