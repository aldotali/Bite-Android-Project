package app.com.redi.redidemo1;

import java.util.ArrayList;

/*

 *CREATED BY: ALDO TALI && REDI MUHARREMI
 *DESCRIPTION: CREATES A JAVA CLAS TO STORE SOME FOOD FACTS
 *DATE:05/01/2016

 */

public class FoodFacts {

    //properties && contants
    private ArrayList<String> facts;
    private static final int SIZE = 20;

    //contructor sets up  the arraylist
    public FoodFacts()
    {
        facts = new ArrayList<>(SIZE);
        initialize();

    }

    //initalizes the the facts
    private void initialize()
    {
        facts.add("Ounce by ounce, Nutritious food costs up to 10 times more than junk food");
        facts.add("Chicken contains 266% more fat than it did 40 years ago.");
        facts.add("There is a food substitute intended to supply all daily nutritional needs, known as \"Soylent\"");
        facts.add("Coconut water can be used (in emergencies) as a substitute for blood plasma");
        facts.add("Almost HALF of the world's food is thrown away every year");
        facts.add("CARROTS were originally PURPLE");
        facts.add("Honey is the only food that will never rot, it can last 3000 years");
        facts.add("Cheese is the most stolen food in the world");
        facts.add("Scientists can turn peanut butter into diamonds");
        facts.add("An average person in the U.S. eats 35 tons of food in a lifetime");
        facts.add("Fortune cookies are not a traditional Chinese custom. They were invented in early 1900 in San Francisco");
        facts.add("Dynamite is made with peanuts");
        facts.add("There is no single food that provides all the nutrients that humans need, except for breast milk");
        facts.add("Airplane food isn't very tasty because our sense of smell and taste decrease from 20 to 50 percent");
        facts.add("Eskimos use refrigerators to stop their food from freezing");
        facts.add("Eating fast food regularly has the same impact on the liver as hepatitis");
        facts.add("In the U.S., Childhood Food Allergies Cost Nearly US$25 Billion Every Year.");
        facts.add("Even thinking about a favorite food triggered release of dopamine, a feel-good hormone also produced during sex and drug use.");
        facts.add("The jars of Nutella sold in a year could cover The Great Wall of China 8 times.");
        facts.add("India has the world's lowest meat consumption per person.");
    }

    //returns a random fact
    public String getFact()
    {
        int random = (int) (Math.random()*SIZE);
        return facts.get(random);
    }

}
