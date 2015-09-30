package com.example.administrator.homework2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This activity handles the soccer match to be played by two teams.
 * The user chooses a match between two teams and then is able to see the players take the field.
 * Once a specific game is chosen, the user can press "Play Game" to determine a winner.
 */

public class MainActivity3 extends ActionBarActivity implements View.OnClickListener{

    //set up buttons, textViews and imageViews
    private Button buffaloVsTiger;
    private Button buffaloVsHawk;
    private Button buffaloVsMyTeam;
    private Button tigerVsHawk;
    private Button tigerVsMyTeam;
    private Button hawkVsMyTeam;
    private Button playGame;
    private Button goBack;

    private TextView winner;

    private ImageView goalKeeperOne;
    private ImageView firstMidFieldOne;
    private ImageView secondMidFieldOne;
    private ImageView goalKeeperTwo;
    private ImageView firstMidFieldTwo;
    private ImageView secondMidFieldTwo;

    //booleans to keep track of which players to put on the field
    boolean buffaloVTiger = false;
    boolean buffaloVHawk = false;
    boolean buffaloVMyTeam = false;
    boolean tigerVHawk = false;
    boolean tigerVMyTeam = false;
    boolean hawkVMyTeam = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        //set up the findViewByIds
        buffaloVsTiger = (Button) findViewById(R.id.buffaloVsTiger);
        buffaloVsHawk = (Button) findViewById(R.id.buffaloVsHawk);
        buffaloVsMyTeam = (Button) findViewById(R.id.buffaloVsMyTeam);
        tigerVsHawk = (Button) findViewById(R.id.tigerVsHawk);
        tigerVsMyTeam = (Button) findViewById(R.id.tigerVsMyTeam);
        hawkVsMyTeam = (Button) findViewById(R.id.hawkVsMyTeam);
        playGame = (Button) findViewById(R.id.playGame);
        goBack = (Button) findViewById(R.id.goBack);
        winner = (TextView) findViewById(R.id.winner);

        goalKeeperOne = (ImageView) findViewById(R.id.goalKeeperOne);
        firstMidFieldOne = (ImageView) findViewById(R.id.firstMidFieldOne);
        secondMidFieldOne = (ImageView) findViewById(R.id.secondMidFieldOne);
        goalKeeperTwo = (ImageView) findViewById(R.id.goalKeeperTwo);
        firstMidFieldTwo = (ImageView) findViewById(R.id.firstMidFieldTwo);
        secondMidFieldTwo = (ImageView) findViewById(R.id.secondMidFieldTwo);

        //set up onClickListeners
        buffaloVsTiger.setOnClickListener(this);
        buffaloVsHawk.setOnClickListener(this);
        buffaloVsMyTeam.setOnClickListener(this);
        tigerVsHawk.setOnClickListener(this);
        tigerVsMyTeam.setOnClickListener(this);
        hawkVsMyTeam.setOnClickListener(this);
        playGame.setOnClickListener(this);
        goBack.setOnClickListener(this);
    }

    public void onClick (View view){
        //if goBack button is clicked, end activity and go back to mainActivity
        if(view.getId() == R.id.goBack){
            finish();
        }
        //if this match up is selected, have buffalo team members and tiger team members take the field
        if(view.getId() == R.id.buffaloVsTiger){
            goalKeeperOne.setImageResource(R.mipmap.player1);
            firstMidFieldOne.setImageResource(R.mipmap.player2);
            secondMidFieldOne.setImageResource(R.mipmap.player3);
            goalKeeperTwo.setImageResource(R.mipmap.player4);
            firstMidFieldTwo.setImageResource(R.mipmap.player5);
            secondMidFieldTwo.setImageResource(R.mipmap.player6);
            //set up boolean values in order to determine winner
            buffaloVTiger = true;
            buffaloVHawk = false;
            buffaloVMyTeam = false;
            tigerVHawk = false;
            tigerVMyTeam = false;
            hawkVMyTeam = false;
        }
        //if this match up is selected, have buffalo team members and hawk team members take the field
        if(view.getId() == R.id.buffaloVsHawk){
            goalKeeperOne.setImageResource(R.mipmap.player6);
            firstMidFieldOne.setImageResource(R.mipmap.player1);
            secondMidFieldOne.setImageResource(R.mipmap.player5);
            goalKeeperTwo.setImageResource(R.mipmap.player4);
            firstMidFieldTwo.setImageResource(R.mipmap.player2);
            secondMidFieldTwo.setImageResource(R.mipmap.player3);
            //set up boolean values in order to determine winner
            buffaloVTiger = false;
            buffaloVHawk = true;
            buffaloVMyTeam = false;
            tigerVHawk = false;
            tigerVMyTeam = false;
            hawkVMyTeam = false;
        }
        //if this match up is selected, have buffalo team members and user team members take the field
        if(view.getId() == R.id.buffaloVsMyTeam){
            goalKeeperOne.setImageResource(R.mipmap.player1);
            firstMidFieldOne.setImageResource(R.mipmap.player2);
            secondMidFieldOne.setImageResource(R.mipmap.player3);
            goalKeeperTwo.setImageResource(R.mipmap.genericplayer2);
            firstMidFieldTwo.setImageResource(R.mipmap.genericplayer2);
            secondMidFieldTwo.setImageResource(R.mipmap.genericplayer2);
            //set up boolean values in order to determine winner
            buffaloVTiger = false;
            buffaloVHawk = false;
            buffaloVMyTeam = true;
            tigerVHawk = false;
            tigerVMyTeam = false;
            hawkVMyTeam = false;
        }
        //if this match up is selected, have tiger team members and hawk team members take the field
        if(view.getId() == R.id.tigerVsHawk){
            goalKeeperOne.setImageResource(R.mipmap.player4);
            firstMidFieldOne.setImageResource(R.mipmap.player5);
            secondMidFieldOne.setImageResource(R.mipmap.player6);
            goalKeeperTwo.setImageResource(R.mipmap.player2);
            firstMidFieldTwo.setImageResource(R.mipmap.player1);
            secondMidFieldTwo.setImageResource(R.mipmap.genericplayer2);
            //set up boolean values in order to determine winner
            buffaloVTiger = false;
            buffaloVHawk = false;
            buffaloVMyTeam = false;
            tigerVHawk = true;
            tigerVMyTeam = false;
            hawkVMyTeam = false;
        }
        //if this match up is selected, have user team members and tiger team members take the field
        if(view.getId() == R.id.tigerVsMyTeam){
            goalKeeperOne.setImageResource(R.mipmap.genericplayer2);
            firstMidFieldOne.setImageResource(R.mipmap.genericplayer2);
            secondMidFieldOne.setImageResource(R.mipmap.genericplayer2);
            goalKeeperTwo.setImageResource(R.mipmap.player4);
            firstMidFieldTwo.setImageResource(R.mipmap.player5);
            secondMidFieldTwo.setImageResource(R.mipmap.player6);
            //set up boolean values in order to determine winner
            buffaloVTiger = false;
            buffaloVHawk = false;
            buffaloVMyTeam = false;
            tigerVHawk = false;
            tigerVMyTeam = true;
            hawkVMyTeam = false;
        }
        //if this match up is selected, have hawk team members and user team members take the field
        if(view.getId() == R.id.hawkVsMyTeam){
            goalKeeperOne.setImageResource(R.mipmap.player2);
            firstMidFieldOne.setImageResource(R.mipmap.player1);
            secondMidFieldOne.setImageResource(R.mipmap.player3);
            goalKeeperTwo.setImageResource(R.mipmap.genericplayer2);
            firstMidFieldTwo.setImageResource(R.mipmap.genericplayer2);
            secondMidFieldTwo.setImageResource(R.mipmap.genericplayer2);
            //set up boolean values in order to determine winner
            buffaloVTiger = false;
            buffaloVHawk = false;
            buffaloVMyTeam = false;
            tigerVHawk = false;
            tigerVMyTeam = false;
            hawkVMyTeam = true;
        }
        //if this button is selected, determine a winner between the two selected teams
        if(view.getId() == R.id.playGame){
            int rand = (int) (Math.random() * 10 + 1); //set up logic to determine a winner
            //which ever boolean value matches the team match up, play the game, determine a winner
            if(buffaloVTiger == true) {
                if (rand % 2 == 0) {
                    winner.setText("Winner: Buffalo");
                } else {
                    winner.setText("Winner: Tigers");
                }
            }else if(buffaloVHawk == true){
                if(rand%2 == 0){
                    winner.setText("Winner: Buffalo");
                }else{
                    winner.setText("Winner: Hawks");
                }
            }else if(buffaloVMyTeam == true) {
                if (rand % 2 == 0) {
                    winner.setText("Winner: Buffalo");
                } else {
                    winner.setText("Winner: User Team");
                }
            }else if(tigerVHawk == true) {
                if (rand % 2 == 0) {
                    winner.setText("Winner: Tigers");
                } else {
                    winner.setText("Winner: Hawks");
                }
            }else if(tigerVMyTeam == true) {
                if (rand % 2 == 0) {
                    winner.setText("Winner: Tigers");
                } else {
                    winner.setText("Winner: User Team");
                }
            }else if(hawkVMyTeam == true) {
                if (rand % 2 == 0) {
                    winner.setText("Winner: Hawks");
                } else {
                    winner.setText("Winner: User Team");
                }
            }
        }
    }
}
