package com.Logik.dawn.of.ages;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestQuest extends Activity {
	static int intPath = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_testquest);
		final TextView questText = (TextView) findViewById(R.id.textQuest);
		final Button btnOption1 = (Button) findViewById(R.id.btnOption1);
		final Button btnOption2 = (Button) findViewById(R.id.btnOption2);
		final Button btnOption3 = (Button) findViewById(R.id.btnOption3);

		questText
				.setText("Darkness.  As you come to your senses you realize you have no idea where you are. The last thing you remember is walking through a forest with a goblin. A GOBLIN?! you exclaim. Why was I with a goblin..? You start putting pieces back together and remember that the goblin was leading you to a town. A town called.. ugh.. why can't I remember anything? What happened? In an attempt to recall the name of the town, you decide to start walking down a dirt path. Maybe I can find a sign so I can figure out where I'm at. As you continue down the dirt path you come to 2 more paths facing different directions. The path you're on is heading north. The other two: East and West. The western path leads into a thicker region of the forest you're in. Not much light is showing through the trees and you can't hear any of the forest animals that way. The path to the East winds around a river and you spot a broken bridge up ahead. The path North remains the same, enough light for you to see your surroundings and very calm too calm.\n\n");

		btnOption1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (btnOption1.getText().toString().equals("Continue North")) {
					btnOption1.setText("Ignore the footprints and continue towards the glowing red light.");
					btnOption2.setText("Investigate the footprints.");
					btnOption3.setText("Turn back the way you came.");

					questText
							.setText("You decide to continue forward. As you�re walking down the path, you realize that you haven�t been seeing many forest creatures� in fact you haven�t seen any for miles. You stop and take a look around. �It�s getting dark out..� you say to yourself. Up ahead you see a faint red light. You continue forward and as you reach closer, you hear a branch behind you snap along with fast paced footsteps. When you turn around you see there is no one there, yet on the ground there are footprints leading into the forest away from the path.");
				} else if (btnOption1.getText().toString().equals("Ignore the footprints and continue towards the glowing red light.")) {
					btnOption1.setText("Take the amulet.");
					btnOption2.setText("Bury the dead creature with the amulet.");
					btnOption3.setText("Investigate the forest.");

					questText
							.setText("�It was probably nothing�, you say to reassure yourself. You continue walking down the path and reach the glowing light. �It�s a dead carcass!� you exclaim. It looks like it has been dead for quite some time as you can�t tell what it is. But around its neck is an amulet. �That must have been that light I saw.. the light reflecting from this amulet.� Again you hear sticks snapping and popping in the forest. �Who�s out there!?� you yell. The forest grows quiet�");
				}
			}
		});
	}
}
