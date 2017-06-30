package com.Logik.dawn.of.ages;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MoreInfo extends Activity {
	// CHANGE THE WORD FIGHTER TO
	// WARRIOR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!++++++++++++++++++++++____________________________________)))))))))))))))))))))))))))))))))))))))))))
	List<ScrollView> sv;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_info);
		final ScrollView scrollViewRaces = (ScrollView) findViewById(R.id.scrollViewRaces);
		final ScrollView scrollViewClasses = (ScrollView) findViewById(R.id.scrollViewClasses);
		final ScrollView scrollViewAlignments = (ScrollView) findViewById(R.id.scrollViewAlignments);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setDisplayShowTitleEnabled(false);
		
		TextView textView1 = (TextView) findViewById(R.id.textQuest);
		Typeface type = Typeface.createFromAsset(getAssets(),"vineritc.ttf"); 
		textView1.setTypeface(type);

		scrollViewRaces.setVisibility(View.VISIBLE);
		scrollViewClasses.setVisibility(View.GONE);
		scrollViewAlignments.setVisibility(View.GONE);

		final TextView humansTxt = (TextView) findViewById(R.id.textViewHumans);
		humansTxt.setVisibility(View.VISIBLE);
		humansTxt.setText("Humans \n\nOverview\n\nOf all the civilized races, "
                + "humans are the most adaptable and diverse. "
                + "Human settlements can be found almost anywhere, and human morals, customs, and interests vary greatly. "
                + "\n\nPlay a human if you want . . . "
                + "\n ✦ to be a decisive, resourceful hero with enough determination to face any challenge. "
                + "\n ✦ to have the most versatility and flexibility of any race. "
                + "\n ✦ to be able to excel at any class you choose."
                + "\n\nPhysical Qualities"
                + "\n\nHumans come in a wide variety of heights, weights, and colors. Some humans have black or dark brown skin, others are as pale as snow, and they cover the whole range of tans and browns in between. Their hair is black, brown, or a range of blonds and reds. Their eyes are most often brown, blue, or hazel. Human attire varies wildly, depending on the environment"
                + " and society in which they live. Their clothing can be simple, ostentatious, or anything in between. It’s not unusual for several distinct human cultures"
                + " to live side by side in a particular area and mingle, so human armor, weaponry, and other items incorporate a variety of designs and motifs. Humans average life spans of about 75 years,"
                + " though some venerable members of the race live as long as 90 or more years."
                + "\n\nPlaying a Human"
                + "\n\nHumans are decisive and sometimes rash. They explore the darkest reaches of the world in search of knowledge and power. They hurl themselves into danger, dealing with consequences as they arise. They act first and ponder later, trusting their will to prevail"
                + " and their native resourcefulness to see them through perilous situations. Humans always look to the horizon, seeking to expand their influence and their territory. They chase power and want to change the world, for good or for"
                + " ill. Their settlements are among the brightest lights in a dark and untamed world, and humans constantly seek to explore new lands and settle new frontiers. Their self-reliance and bravery inclines humans"
                + " toward martial classes such as fighter, warlord, and rogue. They often prefer to find hidden reserves of strength in themselves rather than trust to the magic of wizards or clerics. That said, humans tend to be a pious race, worshiping"
                + " the whole pantheon of gods. Their myths name no god as the creator of the race. Some tales say the gods worked together to create them, infusing them with the best qualities of each race that had come before. Other"
                + " tales say that humans were the creation of a god whose name is no longer known, a god killed in the war against the primordials or perhaps assassinated by another deity (Asmodeus and Zehir are often accused of the deed)."
                + " Humans are tolerant of other races, different beliefs, and foreign cultures. Most human settlements are diverse places where different races live together in relative peace. The human empire of Nerath, the last great world power, united many different"
                + " peoples. Most of the human towns that have survived the empire’s fall are fortified bastions against the encroaching darkness. When elven forests are razed or dwarven mines overrun, the survivors often flee to the nearest human town for protection."
                + " Despite the far reach and power of Nerath, humansnin the present day are a scattered and divided people. Dozens of small kingdoms, fiefdoms, and free cities have arisen from Nerath’s ruins, and many of these realms are petty, weak, or isolated. Tensions and"
                + " misunderstandings among them often precipitate skirmishes, espionage, betrayal, and even open warfare."
                + "\n\nHuman Characteristics:"
                + "\n\nAdaptable, ambitious, bold, corruptible, creative, driven, hardy, pragmatic, resourceful, territorial, tolerant"
                + "\n\n");

		final TextView dwarvesTxt = (TextView) findViewById(R.id.textViewDwarves);
		dwarvesTxt.setVisibility(View.INVISIBLE);

		final TextView elvesTxt = (TextView) findViewById(R.id.textViewElves);
		elvesTxt.setVisibility(View.INVISIBLE);

		final TextView halfElvesTxt = (TextView) findViewById(R.id.textViewHalfElves);
		halfElvesTxt.setVisibility(View.INVISIBLE);

		final TextView eladrinsTxt = (TextView) findViewById(R.id.textViewEladrins);
		eladrinsTxt.setVisibility(View.INVISIBLE);

		final TextView dragonbornsTxt = (TextView) findViewById(R.id.textViewDragonborns);
		dragonbornsTxt.setVisibility(View.INVISIBLE);

		final TextView gnomesTxt = (TextView) findViewById(R.id.textViewGnomes);
		gnomesTxt.setVisibility(View.INVISIBLE);

		final TextView orcsTxt = (TextView) findViewById(R.id.textViewOrcs);
		orcsTxt.setVisibility(View.INVISIBLE);

		final TextView halfOrcsTxt = (TextView) findViewById(R.id.textViewHalfOrcs);
		halfOrcsTxt.setVisibility(View.INVISIBLE);

		final TextView tieflingsTxt = (TextView) findViewById(R.id.textViewTieflings);
		tieflingsTxt.setVisibility(View.INVISIBLE);

		final TextView halflingsTxt = (TextView) findViewById(R.id.textViewHalflings);
		halflingsTxt.setVisibility(View.INVISIBLE);

		final TextView classesTxt = (TextView) findViewById(R.id.textViewClasses);
		classesTxt.setVisibility(View.INVISIBLE);

		final TextView alignmentsTxt = (TextView) findViewById(R.id.textViewAlignments);
		alignmentsTxt.setVisibility(View.INVISIBLE);

		Button btnRaces = (Button) findViewById(R.id.btnRaces);
		Button btnClasses = (Button) findViewById(R.id.btnClasses);
		Button btnAlignments = (Button) findViewById(R.id.btnAlignments);

		btnRaces.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				scrollViewRaces.setVisibility(View.GONE);
				scrollViewClasses.setVisibility(View.GONE);
				scrollViewAlignments.setVisibility(View.GONE);
				humansTxt.setVisibility(View.GONE);

				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(
						MoreInfo.this);
				dlgAlert.setTitle("Races");
				dlgAlert.setItems(R.array.Races,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int position) {
								switch (position) {
								case 0: // Humans
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.VISIBLE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									humansTxt
											.setText("Humans \n\nOverview\n\nOf all the civilized races, "
													+ "humans are the most adaptable and diverse. "
													+ "Human settlements can be found almost anywhere, and human morals, customs, and interests vary greatly. "
													+ "\n\nPlay a human if you want . . . "
													+ "\n ✦ to be a decisive, resourceful hero with enough determination to face any challenge. "
													+ "\n ✦ to have the most versatility and flexibility of any race. "
													+ "\n ✦ to be able to excel at any class you choose."
													+ "\n\nPhysical Qualities"
													+ "\n\nHumans come in a wide variety of heights, weights, and colors. Some humans have black or dark brown skin, others are as pale as snow, and they cover the whole range of tans and browns in between. Their hair is black, brown, or a range of blonds and reds. Their eyes are most often brown, blue, or hazel. Human attire varies wildly, depending on the environment"
													+ " and society in which they live. Their clothing can be simple, ostentatious, or anything in between. It’s not unusual for several distinct human cultures"
													+ " to live side by side in a particular area and mingle, so human armor, weaponry, and other items incorporate a variety of designs and motifs. Humans average life spans of about 75 years,"
													+ " though some venerable members of the race live as long as 90 or more years."
													+ "\n\nPlaying a Human"
													+ "\n\nHumans are decisive and sometimes rash. They explore the darkest reaches of the world in search of knowledge and power. They hurl themselves into danger, dealing with consequences as they arise. They act first and ponder later, trusting their will to prevail"
													+ " and their native resourcefulness to see them through perilous situations. Humans always look to the horizon, seeking to expand their influence and their territory. They chase power and want to change the world, for good or for"
													+ " ill. Their settlements are among the brightest lights in a dark and untamed world, and humans constantly seek to explore new lands and settle new frontiers. Their self-reliance and bravery inclines humans"
													+ " toward martial classes such as fighter, warlord, and rogue. They often prefer to find hidden reserves of strength in themselves rather than trust to the magic of wizards or clerics. That said, humans tend to be a pious race, worshiping"
													+ " the whole pantheon of gods. Their myths name no god as the creator of the race. Some tales say the gods worked together to create them, infusing them with the best qualities of each race that had come before. Other"
													+ " tales say that humans were the creation of a god whose name is no longer known, a god killed in the war against the primordials or perhaps assassinated by another deity (Asmodeus and Zehir are often accused of the deed)."
													+ " Humans are tolerant of other races, different beliefs, and foreign cultures. Most human settlements are diverse places where different races live together in relative peace. The human empire of Nerath, the last great world power, united many different"
													+ " peoples. Most of the human towns that have survived the empire’s fall are fortified bastions against the encroaching darkness. When elven forests are razed or dwarven mines overrun, the survivors often flee to the nearest human town for protection."
													+ " Despite the far reach and power of Nerath, humansnin the present day are a scattered and divided people. Dozens of small kingdoms, fiefdoms, and free cities have arisen from Nerath’s ruins, and many of these realms are petty, weak, or isolated. Tensions and"
													+ " misunderstandings among them often precipitate skirmishes, espionage, betrayal, and even open warfare."
													+ "\n\nHuman Characteristics:"
													+ "\n\nAdaptable, ambitious, bold, corruptible, creative, driven, hardy, pragmatic, resourceful, territorial, tolerant"
													+ "\n\n");
									break;
								case 1: // Dwarfs
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.VISIBLE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									dwarvesTxt
											.setText("Dwarves \n\nOverview\n\nCarved from the bedrock of the universe, dwarves endured an age of servitude to giants before winning their freedom. Their mighty mountain fortress-cities testify to the power of their ancient empires. Even those who live in human cities are counted among the"
													+ " staunchest defenders against the darkness that threatens to engulf the world."
													+ "\n\nPlay a dwarf if you want . . ."
													+ "\n✦ to be tough, gruff, and strong as bedrock."
													+ "\n✦ to bring glory to your ancestors or serve as your god’s right hand."
													+ "\n✦ to be able to take as much punishment as you dish out."
													+ "\n✦ to be a member of a race that favors the paladin, cleric, and fighter classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nDwarves average about 4½ feet in height and are very broad, weighing as much as an adult human. Dwarves have the same variety of skin, eye, and hair colors as humans, although dwarf skin is sometimes gray or sandstone red and red hair is more common among them. Male dwarves are often bald and braid their"
													+ " long beards into elaborate patterns. Female dwarves braid their hair to show clan and ancestry. Dwarven attire and equipment, including weapons and shields, are decorated with bold geometric shapes, natural gems, and ancestral faces. Although they reach physical maturity at roughly"
													+ " the same age as humans, dwarves age more slowly and remain vigorous well past 150 years of age, often living to see 200."
													+ "\n\nPlaying a Dwarf"
													+ "\n\nProudly proclaiming they were made from the earth itself, dwarves share many qualities with the rock they love. They are strong, hardy, and dependable. They value their ancestral traditions, which they preserve through the ages as fiercely as they defend the carved structures of their mountain homes."
													+ " Dwarves believe in the importance of clan ties and ancestry. They deeply respect their elders, and they honor long-dead clan founders and ancestral heroes. They place great value on wisdom and the experience of years, and most are polite to elders of any race. More so than most other races, dwarves seek guidance"
													+ " and protection from the gods. They look to the divine for strength, hope, and inspiration, or they seek to propitiate cruel or destructive gods. Individual dwarves might be impious or openly heretical, but temples and shrines of some sort are found in almost every dwarven community. Dwarves revere Moradin"
													+ " as their creator, but individual dwarves honor those deities who hold sway over their vocations; warriors pray to Bahamut or Kord, architects to Erathis, and merchants to Avandra—or even to Tiamat, if a dwarf is consumed by the dwarven taste for wealth. Dwarves never forget their enemies, either individuals"
													+ " who have wronged them or entire races of monsters who have done ill to their kind. Dwarves harbor a fierce hatred for orcs, which often inhabit the same mountainous areas that dwarves favor and which wreak periodic devastation on dwarf communities. Dwarves also despise giants and titans, because"
													+ " the dwarf race once labored as the giants’ slaves. They feel a mixture of pity and disgust toward those corrupted dwarves who still have not freed themselves from the giants’ yoke—azers and galeb duhrs among them. To a dwarf, it is a gift and a mark of deep respect to stand beside an ally in battle, and a sign of deepest"
													+ " loyalty to shield that ally from enemy attack. Dwarven legends honor many heroes who gave their lives to save their clans or their friends."
													+ "\n\nDwarf Characteristics:"
													+ "\n\nAcquisitive, brave, hardworking, loyal, organized, stern, stubborn, tenacious, vengeful"
													+ "\n\n");
									break;
								case 2: // Elves
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.VISIBLE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									elvesTxt.setText("Elves \n\nOverview\n\nWild and free, elves guard their forested lands using stealth and deadly arrows from the trees. They build their homes in close harmony with the forest, so perfectly joined that travelers often fail to notice that they have entered an elven community until it is too late."
											+ "\n\nPlay an elf if you want . . ."
											+ "\n✦ to be quick, quiet, and wild."
											+ "\n✦ to lead your companions through the deep woods  and pepper your enemies with arrows."
											+ "\n✦ to be a member of a race that favors the ranger, rogue, and cleric classes."
											+ "\n\nPhysical Qualities"
											+ "\n\nElves are slender, athletic folk about as tall as humans. They have the same range of complexions as humans, tending more toward tan or brown hues. A typical elf ’s hair color is dark brown, autumn orange, mossy green,or deep gold. Elves’ ears are long and pointed, and their eyes are vibrant blue, violet, or green."
											+ " Elves have little body hair, but they favor a wild and loose look to their hair. Elves mature at about the same rate as humans, but show few effects of age past adulthood. The first sign of an elf ’s advancing age is typically a change in hair color—sometimes graying but usually darkening or taking on more autumnal hues."
											+ " Most elves live to be well over 200 years old and remain vigorous almost to the end."
											+ "\n\nPlaying an Elf"
											+ "\n\nElves are a people of deeply felt but short-lived passions. They are easily moved to delighted laughter, blinding wrath, or mournful tears. They are inclined to impulsive behavior, and members of other races sometimes see elves as flighty or impetuous, but elves do not shirk responsibility or forget commitments."
											+ " Thanks in part to their long life span, elves sometimes have difficulty taking certain matters as seriously as other races do, but when genuine threats arise, elves are fierce and reliable allies. Elves revere the natural world. Their connection to their surroundings enables them to perceive much."
											+ " They never cut living trees, and when they create permanent communities, they do so by carefully growing or weaving arbors, tree houses, and catwalks from living branches. They prefer the primal power of the natural world to the arcane magic their eladrin cousins employ. Elves love to explore new forests and"
											+ " new lands, and it’s not unusual for individuals or small bands to wander hundreds of miles from their homelands. Elves are loyal and merry friends. They love simple pleasures—dancing, singing, footraces, and contests of balance and skill—and rarely see a reason to tie themselves down to dull or disagreeable tasks. Despite"
											+ " how unpleasant war can be, a threat to their homes, families, or friends can make elves grimly serious and prompt them to take up arms. At the dawn of creation, elves and eladrin were a single race dwelling both in the Feywild and in the world, and passing freely between the two. When the drow rebelled against their kin, under the leadership"
											+ " of the god Lolth, the resulting battles tore the fey kingdoms asunder. Ties between the peoples of the Feywild and the world grew tenuous, and eventually the elves and eladrin grew into two distinct races. Elves are descended from those who lived primarily in the world, and they no longer dream of the Feywild. They love the forests and wilds of the world that they"
											+ " have made their home."
											+ "\n\nElf Characteristics:"
											+ "\n\nAgile, friendly, intuitive, joyful, perceptive, quick, tempestuous, wild"
											+ "\n\n");
									break;
								case 3: // Half Elves
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.VISIBLE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									halfElvesTxt
											.setText("Half Elves \n\nOverview\n\nDescended from elves and humans, half-elves are a vital race in which the best features of elves and humans often appear."
													+ "\n\nPlay a half-elf if you want . . ."
													+ "\n✦ to be an outgoing, enthusiastic leader."
													+ "\n✦ to be a charismatic hero equally at home in two different cultures."
													+ "\n✦ to be a member of a race that favors the warlord, paladin, and warlock classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nHalf-elves tend to be sturdier of build than elves but more slender than most humans. Half-elves have the same range of complexions as humans and elves, and like elves, half-elves often have eye or hair colors not normally found among humans. Male half-elves can grow facial hair, unlike male elves, and often sport"
													+ " thin mustaches, goatees, or short beards. Half-elves’ ears are about the size of human ears, but they are tapered, like the ears of their elven ancestors. Half-elves usually adopt the dress and hairstyles of the society they spend the most time with; for example, a half-elf raised among a barbaric human"
													+ " tribe dresses in the furs and skins favored by the tribe and adopts the tribe’s style of braids and face paint. However, it would not be unusual for half-elves raised among humans to seek out articles of elven clothing or jewelry so that they can proudly display signs of their"
													+ " dual heritage. Half-elves have life spans comparable to humans, but like elves they remain vigorous well into old age."
													+ "\n\nPlaying a Half-Elf"
													+ "\n\nHalf-elves are more than just a combination of two races—the combination of human and elf blood produces a unique race with qualities all its own. They share some of the natural grace, athleticism, and keen perceptiveness of elves, along with the passion and drive of humans. But in their own right, they are charismatic,"
													+ " confident, and open-minded and are natural diplomats, negotiators, and leaders. Half-elves like to be around people, the more diverse the better. They gravitate toward population centers, especially larger settlements where members of many races mingle freely. Half-elves cultivate large"
													+ " networks of acquaintances, as much out of genuine friendliness as for practical purposes. They like to establish relationships with humans, elves, and members of other races so they can learn about them, the way they live, and how they make their way in the world. Half-elves rarely settle down for any length of time."
													+ " Their wanderlust makes them natural adventurers, and they quickly make themselves at home wherever they end up. When their paths take them back to a place they have visited before, they track down old friends and renew old contacts. Ultimately, half-elves are survivors, able to adapt to"
													+ " almost any situation. They are generally well liked and admired by everyone, not just elves and humans. They are empathetic, better at putting themselves in others’ shoes than most. Half-elves naturally inspire loyalty in others, and they return that feeling with deep friendship and a"
													+ " keen sense of responsibility for those who place themselves in their care. Half-elf warlords and generals do not order their followers into danger that they would not face themselves, and they usually lead from the front, trusting their allies to follow."
													+ " Half-elves have no culture of their own and are not a numerous people. They usually bear human or elf names, sometimes using one name among elves and a different one among humans. Some are anxious about their place in the world, feeling no kinship with any race, except other half-elves, but most call themselves citizens of the world and kin to all."
													+ "\n\nHalf-Elf Characteristics:"
													+ "\n\nAccommodating, adaptable, charming, confident, gregarious, open-minded"
													+ "\n\n");
									break;
								case 4: // Eladrin
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.VISIBLE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									eladrinsTxt
											.setText("Eladrin \n\nOverview\n\nCreatures of magic with strong ties to nature, eladrin live in cities in the twilight realm of the Feywild. Their cities lie close enough to the world that they sometimes cross over, appearing briefly in mountain valleys or deep forest glades before fading back into the Feywild."
													+ "\n\nPlay an eladrin if you want . . ."
													+ "\n✦ to be otherworldly and mysterious."
													+ "\n✦ to be graceful and intelligent."
													+ "\n✦ to teleport around the battlefield, cloaked in the magic of the Feywild."
													+ "\n✦ to be a member of a race that favors the wizard, rogue, and warlord classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nEladrin are of human height. They are slim, and even the strongest simply look athletic rather than musclebound. They have the same range of complexions as humans, though they are more often fair than dark. Their straight, fine hair is often white, silver, or pale gold, and they wear it long and loose. Their ears are"
													+ " long and pointed, and their eyes are pearly and opalescent orbs of vibrant blue, violet, or green, lacking pupils. Eladrin can’t grow facial hair and have little body hair. Eladrin children grow much as human children do, but their aging process slows to a crawl when they"
													+ " reach maturity. They enjoy youth and health for most of their lives and don’t begin to feel the effects of age until the middle of their third century. Most live for over 300 years, and even at the end they suffer few of the infirmities of old age."
													+ "\n\nPlaying an Eladrin"
													+ "\n\nEladrin society straddles the boundary between the Feywild and the natural world. Eladrin build their elegant cities and towers in places of striking natural splendor, especially where the veil between the worlds is thin—isolated mountain vales, green islands along wild and storm-wracked coasts, and the deepest"
													+ " recesses of ancient forests. Some eladrin realms exist mostly in the Feywild, only rarely touching the world, while others appear in the world at sunset each day, only to fade back into the Feywild at dawn. Long-lived and strongly tied to the Feywild, eladrin have a detached view of the world. Eladrin often have"
													+ " difficulty believing that events in the world have much importance to them, and they consider courses of action that can last for centuries. Their general detachment from the world can make eladrin seem distant and intimidating to other races. Their fey nature also makes them simultaneously"
													+ " alluring and a little frightening. However, eladrin take friendships and alliances to heart and can react with swift fury when their friends are endangered. Combined with their intellect, bravery, and magical power, this loyalty makes them powerful and respected allies."
													+ " Eladrin live by an aesthetic philosophy common to the Feywild and personified by Corellon, the god of beauty and patron of the fey. Eladrin seek to exemplify grace, skill, and learning in every part of life, from dance and song to swordplay and magic. Their cities"
													+ " are places of stunning beauty that shape and guide their natural surroundings into elegant forms. Eladrin are close cousins to the elves and are occasionally called high elves or gray elves. Eladrin favor the Feywild and arcane magic more than elves do, but the two races hold each other in high regard. They"
													+ " share a burning hatred for the third branch of their race—the drow. The Feywild’s most powerful eladrin, called noble eladrin, become so infused with their realm’s inherent magic that they transform into entirely new creatures. These noble eladrin take on characteristics of the seasons and other natural phenomena."
													+ "\n\nEladrin Characteristics:"
													+ "\n\nAesthetic, deliberative, detached, free, graceful, magical, otherworldly, patient, perceptive"
													+ "\n\n");
									break;
								case 5: // Dragonborn
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.VISIBLE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									dragonbornsTxt
											.setText("Dragonborn \n\nOverview\n\nBorn to fight, dragonborn are a race of wandering mercenaries, soldiers, and adventurers. Long ago, their empire contended for worldwide dominion, but now only a few rootless clans of these honorable warriors remain to pass on their legends of ancient glory."
													+ "\n\nPlay a dragonborn if you want . . ."
													+ "\n✦ to look like a dragon."
													+ "\n✦ to be the proud heir of an ancient, fallen empire."
													+ "\n✦ to breathe acid, cold, fire, lightning, or poison."
													+ "\n✦ to be a member of a race that favors the warlord, fighter, and paladin classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nDragonborn resemble humanoid dragons. They’re covered in scaly hide, but they don’t have tails. They are tall and strongly built, often standing close to 6½ feet in height and weighing 300 pounds or more. Their hands and feet are strong, talonlike claws with three fingers and a thumb on each hand. A dragonborn’s"
													+ " head features a blunt snout, a strong brow, and distinctive frills at the cheek and ear. Behind the brow, a crest of hornlike scales of various lengths resembles thick, ropy hair. Their eyes are shades of red or gold. A typical dragonborn’s scales can be scarlet, gold,"
													+ " rust, ocher, bronze, or brown. Rarely do an individual’s scales match the hue of a chromatic or metallic dragon, and scale color gives no indication of the type of breath weapon a dragonborn uses. Most dragonborn have very fine scales over most of their body, giving"
													+ " their skin a leathery texture, with regions of larger scales on the forearms, lower legs and feet, shoulders, and thighs. Young dragonborn grow faster than human children do. They walk hours after hatching, reach the size and development of a 10-year-old human child"
													+ " by the age of 3 and reach adulthood by 15. They live about as long as humans do."
													+ "\n\nPlaying a Dragonborn"
													+ "\n\nTo a dragonborn, honor is more important than life itself. First and foremost, honor is tied to battlefield conduct. Adversaries should be treated with courtesy and respect, even if they are bitter enemies. Caution and discretion are key to a warrior’s survival, but fear"
													+ " is a disease and cowardice is a moral failing. The drive to behave honorably extends into the rest of a dragonborn’s life: Breaking an oath is the height of dishonor, and attention to honesty extends to every word. A commitment made must be carried out. Ultimately, a dragonborn takes responsibility for his or her"
													+ " actions and their consequences. A continual drive for self-improvement reveals an additional aspect of dragonborn honor. Dragonborn value skill and excellence in all endeavors. They hate to fail, and they push themselves to extreme efforts before they give up on something. A dragonborn holds"
													+ " mastery of a particular skill as a lifetime goal. Members of other races who share the same commitment find it easy to earn the respect of a dragonborn. The dragonborn dedication to honor and excellence sometimes leads others to view dragonborn as arrogant and proud. Most dragonborn share a great pride"
													+ " in their race’s past and present accomplishments, but they are also quick to admire the accomplishments of others. Even though the tiefling empire of Bael Turath was the enemy of the ancient dragonborn empire of Arkhosia, dragonborn recognize tieflings as worthy"
													+ " companions or opponents, admiring their strength and tenacity as friends or enemies. Dragonborn seek adventure for the chance to prove their worth, win renown, and perhaps become champions about whom stories will be told for generations. To win everlasting glory through mighty deeds, daring"
													+ " exploits, and supreme skill—that is the dragonborn dream."
													+ "\n\nDragonborn Characteristics:"
													+ "\n\nDriven, honor-bound, noble, perfectionist, proud, reliable, reserved, rooted in ancient history"
													+ "\n\n");
									break;
								case 6: // Gnomes
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.VISIBLE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									gnomesTxt
											.setText("Gnomes \n\nOverview\n\nIn the Feywild, the best way for a small creature to survive is to be overlooked. While suffering in servitude to the fomorian tyrants of the Feydark, gnomes learned to hide, to mislead, and to deflect—and by these means, to survive. The same talents sustain"
													+ " them still, allowing them to prosper in a world filled with creatures much larger and far more dangerous than they are."
													+ "\n\nPlay a gnome if you want . . ."
													+ "\n✦ to be curious, funny, and tricky."
													+ "\n✦ to rely more on stealth and deception than on brute strength and intimidation."
													+ "\n✦ to be a member of a race that favors the bard, sorcerer, warlock, and wizard classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nGnomes are smaller even than halflings, rarely exceeding 4 feet in height. Apart from their size, they resemble elves or eladrin, with pointed ears and chiseled facial features such as high cheekbones and sharp jaws. They have a more wild look than eladrin do, though, particularly in the hair that sprouts from"
													+ " their heads in random directions. Some male gnomes sprout tufts of hair from their chins, but they otherwise lack body hair. Gnome skin tone ranges from a ruddy tan through woody brown to rocky gray. Their hair can be virtually any color, from stark white to blond and various"
													+ " shades of brown to autumnal orange or green. Their eyes are glittering black orbs. Gnomes are as long-lived as eladrin, living over 300 years, but they show more of the effects of age. A gnome over the age of 100 has gray or white hair and skin that shows the wrinkled and weathered lines"
													+ " of a century of laughter, but even the oldest gnome retains the strength and agility of youth."
													+ "\n\nPlaying a Gnome"
													+ "\n\nIn quiet forests of the Feywild and remote woodlands in the world, gnomes live out of sight and mostly beneath the notice of larger races. Gnomes dwell in homes dug among the roots of trees, easily overlooked and cleverly concealed by camouflage and illusion."
													+ " They are fond of the burrowing mammals that share their habitat, such as badgers, foxes, and rabbits, and have a sense of kinship with these small animals that share their forests. Unobtrusiveness is a virtue among gnomes. They grow up on games of stealth and silence, in which"
													+ " the winner is the last to be discovered. An adult gnome who draws attention in a crowd is considered dangerously rude. Gnome folk heroes are not mighty warriors, but tricksters who slip out of captivity, play great pranks without being detected, or sneak past magical guardians. They deflect both aggression and"
													+ " attention with humor, and they guard their thoughts with friendly laughter. Gnomes also value a quick mind and the ability to come up with a clever solution to any problem. They appreciate witty conversation, especially rapidfire repartee. They are inventive and resourceful,"
													+ " although they have little interest in or aptitude for the kind of technology found in human cities. They have an innate talent for magic and a love of illusion, music, poetry, and story. Eager to see what the world has to offer and willing to be awed by its wonders, gnomes greet the"
													+ " world with open curiosity. Gnomes who are drawn to adventure are most often driven by curiosity and wanderlust above any desire for wealth or glory. Gnomes were once enslaved by the fomorian rulers of the Feydark, the subterranean caverns of the Feywild. They regard their former masters with"
													+ " more fear than hatred, and they feel some degree of sympathy for the fey that still toil under fomorian lashes—particularly the spriggans, which some say are corrupted gnomes. Gnomes are not fond of goblins or kobolds, but in typical gnome fashion, they avoid creatures they dislike rather than crusading"
													+ " against them. They are fond of eladrin and other friendly fey, and gnomes who travel the world have good relations with elves and halflings."
													+ "\n\nGnome Characteristics:"
													+ "\n\nAffable, clever, crafty, curious, funny, guarded, inconspicuous, inventive, secretive, sly, tricky"
													+ "\n\n");
									break;
								case 7: // Orcs
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.VISIBLE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									orcsTxt.setText("Orcs \n\nOverview\n\nMost Orc tribes worship Gruumsh, the one-eyed god of slaughter. They are a savage race, bloodthirsty, and violent. They are known to roam the land, ripping apart civilizations. Orcs are a very violent race, often waging war between large clans and battle groups. The Orcs love close combat,"
											+ " the taste and feel that a battle provides, and tend to eschew ranged weapons like the longbow or sling for a good warhammer or axe. Most orcs in the tribe follow their leaders into battle, following the strongest and most powerful in their tribe. Orcs rarely retreat or surrender, and would rather die in battle, pursuing the kill."
											+ " As in most primitive societies, orc civilization utilizes hereditary classes, and certain members of the society are born into warrior, servant, and leader classes. However, this society is far more 'egalitarian' than others, favoring strength and allowing worthy lower-class orcs to move up in the system."
											+ " Orcs believe that they were created from Grummsh, the one-eyed god who asks his followers to multiply, raid, kill, and conquer. Gruumsh created the orcs in his image, placing them on all parts of the world to maximize the carnage that ensued. Often, to thank Gruumsh, a superbly strong orc will remove one of his eyes"
											+ " as a tribute to the one-eyed god of slaughter. Most Orcs are surprisingly honorable when it comes to defeating an enemy, never resorting to underhanded trickery in their battle 'tactics'. They work off an ideology that every person they kill gives them strength and some tribes even consume enemies, or sacrifice them to Gruumsh."
											+ " Orcs are fierce creatures created purely for one thing: War. For this reason, and the fact that many orcs don't speak Common, it is very rare to see an orc in the civilized world, let alone adventuring. However, sometimes an orc is born with an unusually intelligent brain and cast out of its' tribe, or an orc child is captured by a raiding party and spared."
											+ " Orcs are predisposed to evil, and chaotic evil at that, but orcs raised in the civilized world can be good, or even lawful good with a creative backstory."
											+ "\n\nPlay an Orc if you want..."
											+ "\n✦ to be a tough, brutal, and intimidating hero who is feared by many."
											+ "\n✦ to excel in physical combat."
											+ "\n✦ to play a unique character that will literally turn heads, if not bows, in every city you come to."
											+ "\n✦ to be a member of a race that favors the Fighter, Warlord and Barbarian class."
											+ "\n\nPhysical Qualities"
											+ "\n\nOrcs are tall, broad and muscular, lacking all of the grace and subtlety of most other races. Taller than humans, the skin of an orc can range from gray to a dark green. Most male orcs shave their heads in order to enhance their battle-readiness. However, some females may keep their hair long."
											+ " Orcs that originate from tribes tend to have tattoos covering their chests and backs with axes, skulls and Orc symbols being very common, a Orc will normally receive or place these on his own body when he has proven himself in defeating a powerful opponent stronger and superior to another beings,"
											+ " the more of these a tribal orc has on their body the more powerful they are likely to be. As young male adolescents receiving theirs after raiding villages in the wastes or slaying a fellow they have challenged in mortal combat."
											+ " Due to the manner in which the Orcs were created, and shown by how their diety leads them, Orc were lost the famous long age of the elves, they live for as long as a Human in most cases, children are expected to toughen up quickly handling weapons as early as 8 years old when a Orc is normally as tall as a adolescent human of their gender,"
											+ " Though the orc race due to its violent ways doesn't result in them living to their highest life expectancy, as well as the unhealthy way they often live. Those in the armies tend to grow up with similar swiftness though they are considered battle ready by the age ten. With many of the Human run slaving camps using alchemical means to make growth"
											+ " more rapid taking around six or seven months to raise an Orc to be strong and tough enough to fight in battle."
											+ "\n\nPlaying an Orc"
											+ "\n\nFull Blooded Orc heros are not too common, there are a large number of orcs, however, they rarely leave their tribe outside of marriage, or being forcibly removed due to defeat and shame. Most orcs are murderous marauders who ache for the thrill of battle, and are very selfish looters. However there are a few groups of orcs that, while crude,"
											+ " violent and barbaric, have experienced the luxuries of a civilization over their tents and movable huts. Usually they have a low intelligence and act quickly without thinking; they act on their baser instinct, however have too much pride to be ashamed of past actions."
											+ " Orc often come from tribes, having gone off to start their own, or challenging the leader for power and losing. Some orcs have seen the luxuries that cities have, and choose to live in them. Other orcs seen in towns might be mercenaries, hired to kill as part of an army, or as an assassin, though Orc assassins"
											+ " are in no way stealthy, or hide the fact that they are one. Orcs enjoy being hired to kill because it merges their love of the fight for their love of material things."
											+ "\n\nOrc Characteristics:"
											+ "\n\nBrash, ferocious, hedonistic, impulsive, short-tempered, tough, uninhibited, Honorable"
											+ "\n\n");
									break;
								case 8: // Half Orcs
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.VISIBLE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.GONE);
									halfOrcsTxt
											.setText("Half Orcs \n\nOverview\n\nAn obscure legend claims that when Corellon put out Gruumsh’s eye in a primeval battle, part of the savage god’s essence fell to earth, where it transformed a race of humans into fierce half-orcs. Another story suggests that an ancient hobgoblin empire created"
													+ " half-orcs to lead orc tribes on the empire’s behalf. Yet another legend claims that a tribe of brutal human barbarians chose to breed with orcs to strengthen their bloodline. Some say that Kord created half-orcs, copying the best elements from the human and orc"
													+ " races to make a strong and fierce people after his own heart. If you ask a half-orc about his origin, you might hear one of these stories. You might also get a punch in the face for asking such a rude question."
													+ "\n\nPlay a half-orc if you want . . ."
													+ "\n✦ to be big, strong, and fast."
													+ "\n✦ to harness anger into resilience and combat power."
													+ "\n✦ to be a member of a race that favors the barbarian, fighter, ranger, and rogue classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nHalf-orcs favor their human lineage in appearance, but are distinguished by skin that tends to various shades of gray, broad jaws, and prominent lower canine teeth—though these are still a far cry from the jutting tusks of orcs. On average, they are taller and stronger than humans as well. Their hair is usually"
													+ " black, though it grays quickly with age. Most half-orcs who live among humans favor human styles of clothing and hairstyle, but a few adopt orc traditions, tying small bones or beads into long braids or bunches of hair. Half-orcs don’t live quite as long as humans do."
													+ " They mature quickly, reaching adulthood at about 16 years, and rarely live past the age of 60."
													+ "\n\nPlaying a Half-Orc"
													+ "\n\nHalf-orcs combine the best qualities of humans and orcs, though some would argue that the good qualities of orcs are few and hard to find. From their orc blood, half-orcs inherit great physical strength and toughness. They are fierce warriors, fleet of foot as"
													+ " they charge into battle. Their human blood makes half-orcs decisive and bold, resourceful and self-reliant. They are adaptable and able to make their way in almost any circumstance. Although half-orcs often live on the fringes of"
													+ " society in human towns and cities, they still find ways to prosper in a world to which they don’t fully belong. For all their good qualities, many half-orcs exhibit characteristics that polite society finds uncouth or"
													+ " undesirable. Half-orcs have little patience for complicated rules of etiquette or procedure and find little value in hiding their true opinions in order to spare someone’s feelings. They enjoy the simple pleasures of food and drink, boasting, singing, wrestling,"
													+ " drumming, and dancing, and they don’t find much satisfaction in more refined or sophisticated arts. They’re prone to act without much deliberation, preferring to overcome obstacles as they arise rather than consider every possible outcome and make contingency"
													+ " plans. These qualities lead some members of other races to consider them rude or crass, but others find their brashness refreshing. Half-orcs generally live among either human or orc cultures—some in bustling human towns or"
													+ " cities, others among remote human or orc tribes. Most half-orcs have two half-orc parents, but sometimes half-orcs marry and have half-orc children with humans or orcs. Orcs show grudging respect to half-orcs for their considerable strength and for their"
													+ " cunning intelligence, which sometimes allows halforcs to rise to leadership positions in orc tribes. Although possessed of many strengths, half-orcs frequently encounter prejudice in human communities. Thus, most half-orcs gravitate to careers"
													+ " involving physical labor or violence. For some, the life of an adventurer is either a natural extension of that trend or a way to throw off the weight of prejudice. The adventuring life also means finding a place in a group of allies and equals—a simple pleasure that is all too hard for many half-orcs to find in the world."
													+ "\n\nHalf-Orc Characteristics:"
													+ "\n\nBrash, ferocious, hedonistic, impulsive, short-tempered, tough, uninhibited"
													+ "\n\n");
									break;
								case 9: // Tiefling
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.VISIBLE);
									halflingsTxt.setVisibility(View.GONE);
									tieflingsTxt
											.setText("Tieflings \n\nOverview\n\nHeirs to an ancient, infernal bloodline, tieflings have no realms of their own but instead live within human kingdoms and cities. They are descended from human nobles who bargained with dark powers, and long ago their empire subjugated half the world. But the"
													+ " empire was cast down into ruin, and tieflings were left to make their own way in a world that often fears and resents them."
													+ "\n\nPlay a tiefling if you want . . ."
													+ "\n✦ to be a hero who has a dark side to overcome."
													+ "\n✦ to be good at tricking, intimidating, or persuading others to do your will."
													+ "\n✦ to be a member of a race that favors the warlock, warlord, and rogue classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nTieflings’ appearance testifies to their infernal bloodline. They have large horns; thick, nonprehensile tails that range in length from 4 to 5 feet; sharply pointed teeth; and eyes that are solid orbs of black, red, white, silver, or gold. Their skin color covers the whole"
													+ " human range and also extends to reds, from a ruddy tan to a brick red. Their hair, cascading down from behind their horns, is as likely to be dark blue, red, or purple as more common human colors. Tieflings favor dark colors and reds, leathers and glossy furs, small spikes and buckles. Tiefling-crafted"
													+ " arms and armor often have an archaic style, harkening back to the glory of their long-vanished empire."
													+ "\n\nPlaying a Tiefling"
													+ "\n\nHundreds of years ago, the leaders of the human empire of Bael Turath made pacts with devils to solidify their hold over its enormous territory. Those humans became the first tieflings, and they governed their empire in the name of their infernal masters. In time, Bael Turath came into conflict with Arkhosia,"
													+ " the ancient empire of the dragonborn, and decades of warfare left both empires in ruins. Bael Turath’s grand capital was thrown down in ruin. Tieflings are the heirs of the surviving noble dynasties that ruled the empire. Their bloodline is tainted by their diabolical connections, passing to their descendants"
													+ " through all generations. In many ways, they are human; they can have children with humans, for example, but their offspring are always tieflings. Centuries of other races’ distrust and outright hatred have made tieflings self-reliant and often too willing to live up to the stereotypes imposed on them."
													+ " As a race without a homeland, tieflings know that they have to make their own way in the world and that they have to be strong to survive, and they are not quick to trust anyone who claims to be a friend. However, when a tiefling’s companions demonstrate that they trust him"
													+ " or her, the tiefling quickly learns to extend the same trust to them. And once a tiefling gives someone trust and loyalty, the tiefling is a firm friend and ally for life. Although the nobles of Bael Turath subjugated themselves to devils, most present-day tieflings give"
													+ " little thought to gods or patrons, preferring to look out for themselves. Therefore, they do not often follow the path of the divine; tiefling clerics or paladins are rare. Tieflings are not numerous. Sometimes a tiefling merchant clan that is descended from a Bael Turath"
													+ " dynasty settles as a group in a land where wealth can purchase safety and comfort. But most tieflings are born outside such hidden dynasties and grow up in the roughest quarters of human cities and towns. These tieflings often become swindlers, thieves, or crime lords, who carve out a niche for themselves amid the squalor of their surroundings."
													+ "\n\nTiefling Characteristics:"
													+ "\n\nCunning, disquieting, imposing, mysterious, proud, rebellious, self-reliant, sinister, sly, unconventional"
													+ "\n\n");
									break;
								case 10: // Halfling
									scrollViewRaces.scrollTo(0, 0);
                                    scrollViewRaces.setVisibility(View.VISIBLE);
									humansTxt.setVisibility(View.GONE);
									dwarvesTxt.setVisibility(View.GONE);
									elvesTxt.setVisibility(View.GONE);
									halfElvesTxt.setVisibility(View.GONE);
									eladrinsTxt.setVisibility(View.GONE);
									dragonbornsTxt.setVisibility(View.GONE);
									gnomesTxt.setVisibility(View.GONE);
									orcsTxt.setVisibility(View.GONE);
									halfOrcsTxt.setVisibility(View.GONE);
									tieflingsTxt.setVisibility(View.GONE);
									halflingsTxt.setVisibility(View.VISIBLE);
									halflingsTxt
											.setText("Halflings \n\nOverview\n\nHalflings are a small race known for their resourcefulness, quick wits, and steady nerves. They are a nomadic folk who roam waterways and marshlands. No people travel farther or see more of what happens in the world than halflings."
													+ "\n\nPlay a halfling if you want . . ."
													+ "\n✦ to be a plucky hero who is all too easy to underestimate."
													+ "\n✦ to be likable, warm, and friendly."
													+ "\n✦ to be a member of a race that favors the rogue, ranger, and warlock classes."
													+ "\n\nPhysical Qualities"
													+ "\n\nHalflings stand about 4 feet tall and weigh about 80 pounds. They resemble small humans and are proportioned like human adults. Halflings have the same range of complexions as humans, but most halflings have dark hair and eyes. Halfling males don’t have beards, but many have long, full sideburns. Halflings"
													+ " of both genders often wear complicated hairstyles, featuring complex braiding and weaving. Halflings typically dress in clothes that match their surroundings and prefer earth tones and various shades of green. Their clothing and gear feature woven textures and stitching. Birds, river patterns,"
													+ " boats, and fish are common images in halfling art and decoration. Halflings have life spans comperable to humans."
													+ "\n\nPlaying a Halfling"
													+ "\n\nHalflings are an affable, warm, and cheerful people. They survive in a world full of larger creatures by avoiding notice or, barring that, avoiding offense. They appear harmless and so have managed to survive for centuries in the shadow of empires and on the edges of"
													+ " wars and political strife. Halflings are practical and down-to-earth. They concern themselves with basic needs and simple pleasures, harboring few dreams of gold or glory. Adventurers are no more rare among halflings than among other races, but they usually pursue the"
													+ " adventurer’s life for reasons of community, friendship, wanderlust, or curiosity. Halfling adventurers are brave and faithful companions, relying on stealth and trickery in battle rather than raw might or magic. Tight-knit halfling communities are found near"
													+ " the settlements of other races, often along or even on the surface of a body of water. Halflings have never built a kingdom of their own or even held much land. They don’t recognize any sort of royalty or nobility of their own, instead looking to family elders to guide"
													+ " them. This emphasis on family and community has enabled halflings to maintain their traditional ways for thousands of years, unaffected by the rise and fall of empires. According to halfling legend, Melora and Sehanine created the halflings together, giving the race a love"
													+ " of nature and the gift of stealth. When their interest waned, Melora and Sehanine stopped looking after the race, or so the legends go, and halflings made their own way in the world. They say Avandra, the god of luck, admired their resourcefulness and adopted them, favoring them with good fortune. Not all halflings"
													+ " worship Avandra, but nearly all breathe a prayer of thanks to her when fortune favors them. Halflings are fond of stories and legends such as the myth of Avandra, and their culture is rich in oral tradition. Few members of other races realize that halfling folktales contain a vast amount of lore about people"
													+ " and places long past. Many halflings are able to dredge up knowledge about the history, religion, or culture of other races, but that knowledge is usually wrapped in a fable."
													+ "\n\nHalfling Characteristics:"
													+ "\n\nBrave, curious, determined, down-to-earth, friendly, good-natured, lucky, nimble, optimistic, practical, resourceful, warm"
													+ "\n\n");
									break;
								}

							}
						});
				dlgAlert.setCancelable(true);
				dlgAlert.create().show();
			}
		});

		btnClasses.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				scrollViewRaces.setVisibility(View.GONE);
				scrollViewClasses.setVisibility(View.VISIBLE);
				scrollViewAlignments.setVisibility(View.GONE);
				classesTxt.setVisibility(View.GONE);

				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(
						MoreInfo.this);
				dlgAlert.setTitle("Classes");
				dlgAlert.setItems(R.array.Classes,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int position) {
								switch (position) {
								case 0: // Warrior
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Warriors \n\nWarriors are determined combat adepts trained to protect the other members of their adventuring groups. Warriors define the front line by bashing and slicing foes into submission while reflecting enemy attacks through the use of heavy armor. Warriors draw weapons"
													+ " for gold, for glory, for duty, and for the mere joy of unrestrained martial exercise. Regardless of your level of skill and the specific weapons you eventually master, your motivations determine who you defend and who you slay. You could be a noble champion who pledges your blade"
													+ " to gallant causes, a calculating mercenary who cares more for the clink of gold than praise, a homeless prince on the run from assassins, or a blood-loving thug looking for the next good fight. Your future is yours. When you unsheathe your weapon, what battle cry flies from your lips?"
													+ "\n\n");
									break;
								case 1: // Cleric
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Clerics \n\nClerics are battle leaders who are invested with divine power. They blast foes with magical prayers, bolster and heal companions, and lead the way to victory with a mace in one hand and a holy symbol in the other. Clerics run the gamut from humble servants of the"
													+ " common folk to ruthless enforcers of evil gods. As a cleric, the deity (or deities) you choose to revere goes a long way toward defining you, or at least how other people in the world see you. You could be a platinum-garbed envoy of Bahamut seeking justice throughout the land, a shadowy follower of Sehanine"
													+ " with a roguish streak, a burly disciple of Kord who believes the virtue of strength is sufficient for all challenges, or a dwarf cleric of Moradin bringing honor to the denizens of your mountain home. Will you protect what is sacred to your god, quest for legendary holy artifacts, pursue a life of evangelical"
													+ " adventuring, or attempt all these deeds and more?"
													+ "\n\n");
									break;
								case 2: // Druid
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Druids \n\nSecretive and enigmatic, druids call the wilderness their home. They are capable of running with a wolf pack, speaking with the most ancient trees, and watching thunderstorms from atop the clouds themselves. They regard challenges as tests, both of their"
													+ " fitness and of their connection with the wild places of the world. And though many druids project an outward calm, they have the cunning of the beast and the fury of the storm. Whether you were born to the wilds or retreated from civilization, whether you chose your path or"
													+ " answered a call that whispered in your heart, you share a bond with the primal spirits of nature. You are neither their servant nor their master, but winds, trees, and beasts heed your words, for they recognize you as kin. Call to the spirits, and they will entangle your foes"
													+ " or smite your enemies with the storm. Unleash your own spirit, and you will become the Primal Beast, uncaged and untamed."
													+ "\n\n");
									break;
								case 3: // Sorcerer
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Sorcerers \n\nThe sorcerer is the arcane antithesis of the wizard. Wielding raw, barely contained magical power, sorcerers channel bursts and blasts of arcane energy through their bodies. They gain their power not through rigorous study of esoteric tomes, but by harnessing"
													+ " magic in their blood, waiting to be tapped and shaped. If wizards wield magic as fighters wield swords, a sorcerer’s magic is the arcing greataxe of a raging barbarian. You might be a proud dragonborn scion of ancient Arkhosia, calling on the draconic power of your heritage,"
													+ " or perhaps you were bathed in dragon blood as an infant to fill you with that power. You might have been born in a place where planar forces converge in strange eddies, infusing you with chaos, or perhaps you survived implantation of a slaad embryo, which"
													+ " left the taint of chaos upon you. Magic pulses through your veins, calling on you to give it expression. As it grows ever stronger, will it consume you or transform you into magic incarnate?"
													+ "\n\n");
									break;
								case 4:// Monk
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Monks \n\nFrom high in forbidding mountains to deep in the alleys of a city's meanest district, the ascetic warriors known as monks practice their art. By focusing on their minds and bodies, honing both to near perfection, they master a psionic fighting art that allows"
													+ " them to deliver a punch with the force of a giant's club and to absorb attacks as easily as a heavily armored knight. Monks tap into the psionic potential that rests within themselves. turning that energy further inward to fortify their bodies and sharpen their minds."
													+ "\n\nPerhaps you set out on this path to put a dark past behind you. Or your village was victimized one time too many by an evil lord or marauding beasts, and you now seek justice. No matter what your motivation. the path of the monk transforms you into a living weapon."
													+ "\n\nThe road opens wide before you. With little more than a walking stick and perhaps a satchel of food, you are ready to  take on whatever the world can throw at you. Your years of training taught you to turn your eye inward. Now it is time to look ooutward and use  yourself against the world's dangers"
													+ "\n\n");

									break;
								case 5: // Paladin
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Paladins \n\nPaladins are indomitable warriors who’ve pledged their prowess to something greater than themselves. Paladins smite enemies with divine authority, bolster the courage of nearby companions, and radiate as if a beacon of inextinguishable hope. Paladins are transfigured"
													+ " on the field of battle, exemplars of divine ethos in action. To you is given the responsibility to unflinchingly stand before an enemy’s charge, smiting them with your sword while protecting your allies with your sacrifice. Where others waver and wonder, your motivation"
													+ " is pure and simple, and your devotion is your strength. Where others scheme and steal, you take the high road, refusing to allow the illusions of temptation to dissuade you from your obligations. Take up your blessed sword and sanctified shield, brave warrior, and charge forward to hallowed glory!"
													+ "\n\n");
									break;
								case 6: // Ranger
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Rangers \n\nRangers are watchful warriors who roam past the horizon to safeguard a region, a principle, or a way of life. Masters of bow and blade, rangers excel at hit-andrun assaults and can quickly and silently eliminate foes. Rangers lay superb ambushes and excel at avoiding"
													+ " danger. As a ranger, you possess almost supernaturally keen senses and a deep appreciation for untamed wilderness. With your knowledge of the natural world, you are able to track enemies through nearly any landscape, using the smallest clue to set your course, even"
													+ " sometimes the calls and songs of beasts and birds. Your severe demeanor promises a deadly conclusion to any enemy you hunt. When you catch sight of your quarry, will the transgressor perish by swift bow shots from a distance, or by the twofold blades that glint and glitter in each of"
													+ " your battle-scarred hands?"
													+ "\n\n");
									break;
								case 7: // Rogue
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Rogues \n\nRogues are cunning and elusive adversaries. Rogues slip into and out of shadows on a whim, pass anywhere across the field of battle without fear of reprisal, and appear suddenly only to drive home a lethal blade. As a rogue, you might face others’ preconceptions"
													+ " regarding your motivations, but your nature is your own to mold. You could be an agent fresh from the deposed king’s shattered intelligence network, an accused criminal on the lam seeking to clear your name, a wiry performer whose goals transcend the theatrical stage, a kid trying to turn around your hardluck"
													+ " story, or a daredevil thrill-seeker who can’t get enough of the adrenaline rush of conflict. Or perhaps you are merely in it for the gold, after all. With a blade up your sleeve and a concealing cloak across your shoulders, you stride forth, eyes alight with anticipation. What worldly wonders and rewards are"
													+ " yours for the taking?"
													+ "\n\n");
									break;
								case 8: // Warlock
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Warlocks \n\nWarlocks channel arcane might wrested from primeval entities. They commune with infernal intelligences and fey spirits, scour enemies with potent blasts of eldritch power, and bedevil foes with hexing curses. Armed with esoteric secrets and dangerous lore, warlocks"
													+ " are clever and resourceful foes. However you came to your arcane knowledge, you need not accept the poor reputation warlocks sometimes endure. You could be a libram-toting scholar captivated by ominous lore, a foot-loose wanderer searching for elusive ultimate truths, a devil-touched"
													+ " hunter using infernal spells to eliminate evil, or even a black-clad mercenary who uses sinister trappings to discourage prying strangers and unwanted attention. On the other hand, you could be a true diabolist using your gifts to tyrannize the weak—some warlocks unfortunately "
													+ " are exactly that. The pacts are complete. The rites have concluded. The signs are drawn in blood, and the seals are broken. Your destiny beckons."
													+ "\n\n");
									break;
								case 9: // Bard
									scrollViewClasses.scrollTo(0, 0);
									classesTxt.setVisibility(View.VISIBLE);
									classesTxt
											.setText("Bards \n\nBards are artists first and foremost, and they practice magic just as they practice song, drama, or poetry. They have a clear sense of how people perceive reality, so they master charm magic and some illusions. Sagas of great heroes are part of a bard’s repertoire,"
													+ " and most bards follow the example of many fables and become skilled in a variety of fields. A bard’s artistic ability, knowledge of lore, and arcane might are widely respected, particularly among the world’s rulers. Art and magic share a sublime beauty, and, as a"
													+ " bard, you seek the place where the two meet. You might be a naturally talented wanderer who casts impressive spells almost instinctively, a student of a bardic college who learned ordered systems of magic and epic poetry, a warrior skald who mixes skill at arms with thundering music, a dashing performer"
													+ " known for putting on a good show even for your enemies, or a perfectionist who seeks the consummate formula that blends art and magic into a higher force. A steady rhythm beats in the back of your mind as you brandish your sword. Your eyes and ears pick up the motion of the villains that surround you, and"
													+ " one glance tells you everything you need to know to defeat them. You whistle three staccato notes, letting your allies know the symphony of battle is about to begin."
													+ "\n\n");
									break;
								case 10:

									break;

								}
							}
						});
				dlgAlert.setCancelable(true);
				dlgAlert.create().show();
			}
		});

		btnAlignments.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				scrollViewRaces.setVisibility(View.GONE);
				scrollViewClasses.setVisibility(View.GONE);
				scrollViewAlignments.setVisibility(View.GONE);

				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(
						MoreInfo.this);
				dlgAlert.setTitle("Alignments");
				dlgAlert.setItems(R.array.Alignment,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int position) {
								switch (position) {
								case 0: // Life
									scrollViewAlignments.scrollTo(0, 0);
                                    scrollViewAlignments.setVisibility(View.VISIBLE);
									alignmentsTxt.setVisibility(View.VISIBLE);
									alignmentsTxt
											.setText("The Order of Life"
													+ "\n\nThe Order of Life is the strongest faction in Arendor. They worship Nevia, the Goddess of Creation, Rebirth, and Love."
													+ " The Order of Life seeks to uphold the laws of Arendor, and is the sworn enemy of the Order of Death."
													+ " They focus on preventing war and prolonging all forms of life. Their sanctuary is in the mountains of Anima and is guarded by a mystic stone effigy in the image of Ryliik, the son of Nevia."
													);

									break;
								case 1: // Chaos
									scrollViewAlignments.scrollTo(0, 0);
                                    scrollViewAlignments.setVisibility(View.VISIBLE);
									alignmentsTxt.setVisibility(View.VISIBLE);
									alignmentsTxt
											.setText("The Order of Chaos"
													+ "\n\nThe Order of Chaos is the most violent and war-hungry faction in Arendor. They follow Khaos, the God of Destruction, War, and Disorder."
													+ " The Order of Chaos seeks to wreak havoc among the world, dispose of the Great Kings and claim the world for themselves. They originate from the Plains of Facultas in Grendor. "
													+ "Their dwelling is located deep inside the Exuro Volcano and is guarded by an Ancient Flame Elemental risen by Dohkir, the Master of Chaos.");
									break;
								case 2: // Shadows
									scrollViewAlignments.scrollTo(0, 0);
                                    scrollViewAlignments.setVisibility(View.VISIBLE);
									alignmentsTxt.setVisibility(View.VISIBLE);
									alignmentsTxt
											.setText("The Order of Shadow"
													+ "\n\nNot much is known about the Order of Shadows. It is said that they worship Noxedius “Nox” Aeterna. What they stand for is unknown. Some believe that the Order doesn’t exist but most are afraid to speak against it."
													+ " The location of their sanctuary is unknown, although some report seeing mysterious figures crossing into Malendroth Cavern in Tenebris Valley – though no one dares go near due to the Dark Necrometus and its Necrolites. ");
									break;
								case 3: // Death
									scrollViewAlignments.scrollTo(0, 0);
                                    scrollViewAlignments.setVisibility(View.VISIBLE);
									alignmentsTxt.setVisibility(View.VISIBLE);
									alignmentsTxt
											.setText("The Order of Death"
													+ "\n\nThe Order of Death is the second strongest faction in Arendor. They worship Diabolus, the God of Darkness, Abhorrence, and the Afterlife."
													+ " The Order of Death seeks to end most forms of life in praise of Diabolus, and is the sworn enemy of the Order of Life."
													+ " Their sanctum is located deep in The Underworld guarded by Corvus and Cornix the undead raven and crow servants of Diabolus.");
									break;
								case 4: // Souls
									scrollViewAlignments.scrollTo(0, 0);
                                    scrollViewAlignments.setVisibility(View.VISIBLE);
									alignmentsTxt.setVisibility(View.VISIBLE);
									alignmentsTxt.setText("The Order of Souls" +
									"\n\nThe Order of Souls is on the brink of collapse. The faction has been at war with itself for over 300 years. The Goddess of Souls, Anima, believes in saving the souls of the people and those who have fallen in battle." +
									" She protects the souls from getting lost and guides them to Iudex, the Judge of the Dead, to sentence them to eternal bliss or damnation." +
									"\n\nAnima’s brother, Animus, is the God of Souls. He devours souls to gain strength and power. He forces his followers to track and capture lost souls and cage them until Epulor, the Feasting Day." +
									" In consequence for his betrayal of Iudex, his followers are sentenced to Eternal Darkness after passing from the living realm. " +
									"\n\nThe Order of Souls has been torn into two factions since The Great War. Anima is guarded by the Order of Life and sits aside Nevia. Animus is aided by the Order of Chaos and guides Khaos’ faction into battle, reaping all the fallen warriors’ souls." +                                                   
									" Animus is also an enemy of Diabolus, the God of Death, for stealing souls that belong to the Underworld." +
									"\n\n");
									break;
								}
							}
						});
				dlgAlert.setCancelable(true);
				dlgAlert.create().show();
			}
		});
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent CreateNew = new Intent(getApplicationContext(),
				CreateNew.class);
		startActivity(CreateNew);
		finish();
	}
}