package com.example.administrator.homework2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by macnary17 on 9/25/2015.
 * This activity handles adding additional players to which ever team the user pleases.
 * The user can still see all players that were added in the first activity, as well as players added in this activity.
 * The players added in this activity will also show up in the spinners of activity one once this activity ends.
 */
public class MainActivity2 extends ActionBarActivity implements View.OnClickListener{

    //set up buttons, imageButtons, spinners, editTexts, etc.
    private Button goBack;
    private ImageButton tigerTeam;
    private ImageButton buffaloTeam;
    private ImageButton hawkTeam;
    private ImageButton noTeam;

    Spinner buffaloSpinner;
    Spinner hawkSpinner;
    Spinner tigerSpinner;
    Spinner noTeamSpinner;

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText teamField;
    private EditText uniformNumberField;
    private EditText goalsScoredField;

    ArrayList<String> buffaloPlayers;
    ArrayList<String> hawkPlayers;
    ArrayList<String> tigerPlayers;
    ArrayList<String> noTeamPlayers;

    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        intent = getIntent();

        goBack = (Button) findViewById(R.id.goBack);
        tigerTeam = (ImageButton) findViewById(R.id.tigerTeam);
        buffaloTeam = (ImageButton) findViewById(R.id.buffaloTeam);
        hawkTeam = (ImageButton) findViewById(R.id.hawkTeam);
        noTeam = (ImageButton) findViewById(R.id.noTeam);

        firstNameField = (EditText)findViewById(R.id.firstNameField);
        lastNameField = (EditText)findViewById(R.id.lastNameField);
        uniformNumberField = (EditText)findViewById(R.id.uniformNumberField);
        goalsScoredField = (EditText)findViewById(R.id.goalsScoredField);

        buffaloSpinner = (Spinner) findViewById(R.id.buffaloSpinner);
        hawkSpinner = (Spinner) findViewById(R.id.hawkSpinner);
        tigerSpinner = (Spinner) findViewById(R.id.tigerSpinner);
        noTeamSpinner = (Spinner) findViewById(R.id.noTeamSpinner);

        //get information from activity one, bring it over to activity two
        buffaloPlayers = intent.getStringArrayListExtra("buffaloPlayers");
        hawkPlayers = intent.getStringArrayListExtra("hawkPlayers");
        tigerPlayers = intent.getStringArrayListExtra("tigerPlayers");
        noTeamPlayers = intent.getStringArrayListExtra("noTeamPlayers");

        ArrayAdapter<String> buffaloAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buffaloPlayers);
        ArrayAdapter<String> hawkAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hawkPlayers);
        ArrayAdapter<String> tigerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tigerPlayers);
        ArrayAdapter<String> noTeamAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noTeamPlayers);

        //set up adapters
        buffaloSpinner.setAdapter(buffaloAdapter);
        hawkSpinner.setAdapter(hawkAdapter);
        tigerSpinner.setAdapter(tigerAdapter);
        noTeamSpinner.setAdapter(noTeamAdapter);

        //set up onclicklisteners
        goBack.setOnClickListener(this);
        tigerTeam.setOnClickListener(this);
        buffaloTeam.setOnClickListener(this);
        hawkTeam.setOnClickListener(this);
        noTeam.setOnClickListener(this);
    }


    public void onClick(View view){
        //if go back button is pressed, send information back to activity one
        if(view.getId() == R.id.goBack){
            intent.putStringArrayListExtra("buffaloPlayers", buffaloPlayers);
            intent.putStringArrayListExtra("hawkPlayers", hawkPlayers);
            intent.putStringArrayListExtra("tigerPlayers", tigerPlayers);
            intent.putStringArrayListExtra( "noTeamPlayers", noTeamPlayers);
            setResult(12, intent);
            finish();
        }

        //if tiger team is pressed, add player to tiger team
        if(view.getId() == R.id.tigerTeam){
            tigerPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            resetFields();
        }

        //if buffalo team is pressed, add to buffalo team
        if(view.getId() == R.id.buffaloTeam){
            //show people on buffalo team
            buffaloPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            resetFields();
        }

        //if hawk team is pressed, add to hawk team
        if(view.getId() == R.id.hawkTeam){
            //show people on hawk team
            hawkPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            resetFields();
        }

        //if "my team" is pressed, add player to my team (called noTeam in the code)
        if(view.getId() == R.id.noTeam){
            //show people that aren't on a team
            noTeamPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            resetFields();
        }
    }

    //clear text fields
    public void resetFields(){
        firstNameField.setText("");
        lastNameField.setText("");
        uniformNumberField.setText("");
        goalsScoredField.setText("");

    }
}
