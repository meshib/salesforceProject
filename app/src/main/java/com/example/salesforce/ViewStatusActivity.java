package com.example.salesforce;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.salesforce.SalesTrackerModel.AgentList;
import com.example.salesforce.SalesTrackerModel.CustomerList;

/**
 *
 * @author Meshi
 */

public class ViewStatusActivity extends AppCompatActivity {
                                            
    private static CustomerList customerList;
    private static AgentList agentList;
    private Button viewCustomers;
    private Button viewAgents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerList = getIntent().getParcelableExtra("CUSTOMER_LIST");
        viewCustomers = (Button) findViewById(R.id.recycleview_l);
        viewCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewStatusActivity.this, ViewStatusActivity.class);
                i.putExtra("CUSTOMER_LIST", (Parcelable) customerList);
                startActivity(i);
            }
        });
        viewAgents = (Button) findViewById(R.id.recycleview_l);
        viewAgents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewStatusActivity.this, ViewStatusActivity.class);
                i.putExtra("AGENT_LIST", (Parcelable) agentList);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    public void onBackPressed() {

        Log.d("Application", "Moved back");
        Intent result = new Intent();
        result.putExtra("AGENT_LIST", (Parcelable) agentList);
        result.putExtra("CUSTOMER_LIST", (Parcelable) customerList);
        setResult(RESULT_OK, result);
        finish();
    }

}