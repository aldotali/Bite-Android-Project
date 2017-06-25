package app.com.redi.redidemo1;

import java.util.ArrayList;
import java.lang.Math.*;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A JAVA CLASS TO DISPLAY JOKES
 *DATE:05/1/2016

 */
public class Jokes {

    //Properties
    private ArrayList<String> jokes;
    private static final int SIZE = 20;

    //constructor sets up the arraylsit
    public Jokes()
    {
        jokes = new ArrayList<>(SIZE);
        initialize();

    }

    //sets the jokes in the arraylist
    private void initialize()
    {
        jokes.add("Q: Did you hear about the Italian chef that died? \nA: He pasta way ");
        jokes.add("Q: What do you call a fake noodle? \nA: An impasta. ");
        jokes.add("Q: How did Reese eat her ice cream? \nA: Witherspoon.");
        jokes.add("Q:How do you make an apple turnover? \nA:Push it down hill. ? ");
        jokes.add("Q: If a crocodile makes shoes, what does a banana make ? \nA: Slippers ! ");
        jokes.add("Q: Why doesn't bread like warm weather? \nA: Things get Toasty! ");
        jokes.add("Q: What does bread do after it's done baking? \nA: Loaf around. ");
        jokes.add("Q: What pick up line does yeast use on flour? \nA: I bread your pardon! ");
        jokes.add("Q: What do you call a pig thief? \nA: A hamburglar. ");
        jokes.add("Q: Why did the students eat their homework? \nA: Because the teacher said that it was a piece of cake. ");
        jokes.add("Q: How do you get a Minecraft themed party started? \nA: Let them eat cake.");
        jokes.add("Q: How do you get a mouse to smile? \nA: Say cheese! ");
        jokes.add("Q: When should you go on a cheese diet? \nA: If you need to cheddar a few pounds ");
        jokes.add("Q:How does the recipe for German chocolate cake begin? \nA:First, invade ze kitchen.");
        jokes.add("Q:Why did the blonde buy a brown cow? \nA:To get chocolate milk. ");
        jokes.add("Q: What do you call sad coffee?\" \nA: Despresso. ");
        jokes.add("Q: Why can Starbucks get away with charging outrageous prices for coffee? \nA: Because they have Italian titles for everything! ");
        jokes.add("Q:How do eggs leave the highway? \nA:By going through the eggs-it. ");
        jokes.add("1.When life hands you lemons, find someone with tequila and salt. ");
        jokes.add("Q: \"Waiter, will my pizza be long?\" \nA: \"No sir, it will be round!\" ");

    }

    //returns a random joke
    public String getJoke()
    {
        int random = (int) (Math.random()*SIZE);
        return jokes.get(random);
    }

}
