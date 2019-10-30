import java.util.ArrayList;
import java.util.Arrays;

public class Statement {
    private String statement;
    private int count;
    private boolean derogatoryWord;
    private boolean raceClassification;
    private int indexOfRaceClass;
    private String[] words;
    private String[] derogatoryWords;
    private String[] raceClassifications={"white","gringo","caucasian","black","negro","african","african american","italian","mafia","latin","indian","muslim","asian","jewish"};
    private String[] peopleSynonyms={"people","teen","teens","boys","boy","lady","girl","man","woman","dude","guy"};
    private String raceClass="";
    public boolean isRacist;

    public Statement (int count, String statement) {
        this.statement=statement;
        this.count=count;
        derogatoryWords=Read.getBadWords();
    }

    public void getRawWords() {
        String alphabet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String output="";
        for (int i = 0; i < statement.length(); i++) {
            if (alphabet.contains(statement.substring(i, i+1))) output+=statement.substring(i,i+1).toLowerCase();
        }
        this.statement=output;
        words=this.statement.split(" ");
    }

    public boolean containsDerogatoryWord() {
        for (String word : words) {
            for (String derogatoryWord : derogatoryWords) {
                if (word.contains(derogatoryWord)) return true;
            }
        }
        return false;
    }
    public boolean containsRaceClassification() {
        for (int i=0; i<words.length;i++) {
            for (String eachRaceClass : raceClassifications) {
                if (words[i].contains(eachRaceClass)) {
                    this.raceClass=eachRaceClass;
                    this.indexOfRaceClass=i;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean raceClassAdjacent() {
        if (raceClass.substring(raceClass.length()).equals("s")) return true;
        else {
            for (String peopleSynonym : peopleSynonyms) {
                if (words[indexOfRaceClass + 1].equals(peopleSynonym)) return true;
            }
        }
        return false;
    }
    public void setIsRacist(boolean b) {
        isRacist=b;
    }

    public String toString() {
        return this.statement;
    }


}
