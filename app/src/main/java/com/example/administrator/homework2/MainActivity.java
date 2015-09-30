package com.example.administrator.homework2;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.util.*;
import android.widget.ImageView;
import android.widget.Spinner;

import java.lang.Integer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the first activity.
 * Teams are set up and some preset players are added to certain teams.
 * In this activity, the user can scroll through each teams players and their stats via spinners.
 * The user can also add players to whichever team he/she pleases, including a team that is empty.
 * The empty team is meant to be the user's created team. The user can add players to it if he/she wants.
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    //setting up all of my buttons, image views, spinners and other objects needed in program
    ArrayList<String> buffaloPlayers;
    ArrayList<String> hawkPlayers;
    ArrayList<String> tigerPlayers;
    ArrayList<String> noTeamPlayers;

    Player p1;
    HashMap<String, Player> soccerPlayers;
    Spinner buffaloSpinner;
    Spinner hawkSpinner;
    Spinner tigerSpinner;
    Spinner noTeamSpinner;

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText uniformNumberField;
    private EditText goalsScoredField;

    private Button newBuffaloPlayer;
    private Button newHawkPlayer;
    private Button newTigerPlayer;
    private Button newUserTeamPlayer;
    private Button switchActivity;
    private Button toSoccerPitch;

    private ImageView playerImage;
    private ImageView teamLogo_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up image views
        playerImage = (ImageView) findViewById(R.id.playerImage);
        teamLogo_top = (ImageView) findViewById(R.id.teamLogo_top);

        //setting up my Spinners and adapters for those spinners
        buffaloSpinner = (Spinner) findViewById(R.id.buffaloSpinner);
        hawkSpinner = (Spinner) findViewById(R.id.hawkSpinner);
        tigerSpinner = (Spinner) findViewById(R.id.tigerSpinner);
        noTeamSpinner = (Spinner) findViewById(R.id.noTeamSpinner);
        buffaloPlayers = new ArrayList<String>();
        hawkPlayers = new ArrayList<String>();
        tigerPlayers = new ArrayList<String>();
        noTeamPlayers = new ArrayList<String>();
        ArrayAdapter<String> buffaloAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buffaloPlayers);
        ArrayAdapter<String> hawkAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hawkPlayers);
        ArrayAdapter<String> tigerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tigerPlayers);
        ArrayAdapter<String> noTeamAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noTeamPlayers);
        buffaloSpinner.setAdapter(buffaloAdapter);
        hawkSpinner.setAdapter(hawkAdapter);
        tigerSpinner.setAdapter(tigerAdapter);
        noTeamSpinner.setAdapter(noTeamAdapter);

        //add preset players
        buffaloPlayers.add("Josh Smith\n          Uniform Number: 1\n          Goals: 2");
        buffaloPlayers.add("Kiko Alonso\n          Uniform Number: 34\n          Goals: 1");
        buffaloPlayers.add("Julio Jones\n          Uniform Number: 21\n          Goals: 0");
        buffaloPlayers.add("Matt Birk\n          Uniform Number: 0\n          Goals: 1");

        tigerPlayers.add("Jeremy Hill\n          Uniform Number: 1\n          Goals: 1");
        tigerPlayers.add("Michael Roos\n          Uniform Number: 2\n          Goals: 1");
        tigerPlayers.add("Jeremy Lin\n          Uniform Number: 3\n          Goals: 0");
        tigerPlayers.add("Doug Baldwin\n          Uniform Number: 4\n          Goals: 3");

        hawkPlayers.add("Tom Brady\n          Uniform Number: 12\n          Goals: 4");
        hawkPlayers.add("Randy Moss\n          Uniform Number: 84\n          Goals: 2");
        hawkPlayers.add("Andy Dalton\n          Uniform Number: 14\n          Goals: 0");
        hawkPlayers.add("Joe Flacco\n          Uniform Number: 3\n          Goals: 1");

        //set up all the findViewByIds
        firstNameField = (EditText)findViewById(R.id.firstNameField);
        lastNameField = (EditText)findViewById(R.id.lastNameField);
        uniformNumberField = (EditText)findViewById(R.id.uniformNumberField);
        goalsScoredField = (EditText)findViewById(R.id.goalsScoredField);

        newBuffaloPlayer = (Button) findViewById(R.id.newBuffaloPlayer);
        newHawkPlayer = (Button) findViewById(R.id.newHawkPlayer);
        newTigerPlayer = (Button) findViewById(R.id.newTigerPlayer);
        newUserTeamPlayer = (Button) findViewById(R.id.newUserTeamPlayer);
        switchActivity = (Button)findViewById(R.id.switchActivity);
        toSoccerPitch = (Button) findViewById(R.id.toSoccerPitch);

        //Set up all the onClickListeners
        newHawkPlayer.setOnClickListener(this);
        newTigerPlayer.setOnClickListener(this);
        newUserTeamPlayer.setOnClickListener(this);
        switchActivity.setOnClickListener(this);
        newBuffaloPlayer.setOnClickListener(this);
        toSoccerPitch.setOnClickListener(this);
    }

    public void onClick(View view){

        //send information over to the second activity when "to second activity" button is pressed
        if(view.getId() == R.id.switchActivity){
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putStringArrayListExtra("buffaloPlayers", buffaloPlayers);
            intent.putStringArrayListExtra("hawkPlayers", hawkPlayers);
            intent.putStringArrayListExtra("tigerPlayers", tigerPlayers);
            intent.putStringArrayListExtra("noTeamPlayers", noTeamPlayers);
            startActivityForResult(intent,100);
        }

        //start soccer activity so user can see
        if(view.getId() == R.id.toSoccerPitch){
            startActivity(new Intent(MainActivity.this, MainActivity3.class));
        }

        //if "add player to buffalo" button is pressed, add typed in information to the Buffalo team
        if(view.getId() == R.id.newBuffaloPlayer) {
            buffaloPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            teamLogo_top.setImageResource(R.mipmap.buffalo);
            playerImage.setImageResource(R.mipmap.player5);
            resetFields(); //call the resetFields function which wipes the fields after a player is added so another one can be added
        }

        //add player to hawk team if "add player to hawks" is pressed
        if(view.getId() == R.id.newHawkPlayer){
            hawkPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            teamLogo_top.setImageResource(R.mipmap.hawk);
            playerImage.setImageResource(R.mipmap.player4);
            resetFields();
        }
        //add player to tiger team
        if(view.getId() == R.id.newTigerPlayer){
            tigerPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            teamLogo_top.setImageResource(R.mipmap.tiger);
            playerImage.setImageResource(R.mipmap.player3);
            resetFields();
        }
        //add player to users team
        if(view.getId() == R.id.newUserTeamPlayer){
            noTeamPlayers.add(firstNameField.getText().toString() + " " + lastNameField.getText().toString() + "\n          Uniform Number: " + uniformNumberField.getText().toString() + "\n          Goals: " + goalsScoredField.getText().toString());
            teamLogo_top.setImageResource(R.mipmap.myteam);
            playerImage.setImageResource(R.mipmap.player2);
            resetFields();
        }
    }

    //resetFields clears the fields
    public void resetFields(){
        firstNameField.setText("");
        lastNameField.setText("");
        uniformNumberField.setText("");
        goalsScoredField.setText("");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        //code that gets the data back from the second activity and replaces the old data from activity one
        if(requestCode == 100){
            if(resultCode == 12){
                buffaloPlayers = data.getStringArrayListExtra("buffaloPlayers");
                ArrayAdapter<String> buffaloAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buffaloPlayers);
                buffaloSpinner.setAdapter(buffaloAdapter);

                hawkPlayers = data.getStringArrayListExtra("hawkPlayers");
                ArrayAdapter<String> hawkAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hawkPlayers);
                hawkSpinner.setAdapter(hawkAdapter);

                tigerPlayers = data.getStringArrayListExtra("tigerPlayers");
                ArrayAdapter<String> tigerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tigerPlayers);
                tigerSpinner.setAdapter(tigerAdapter);

                noTeamPlayers = data.getStringArrayListExtra("noTeamPlayers");
                ArrayAdapter<String> noTeamAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noTeamPlayers);
                noTeamSpinner.setAdapter(noTeamAdapter);
            }
        }
    }
}
