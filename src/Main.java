import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] testsuite=Read.getTestSuite();
        ArrayList<Boolean> results=new ArrayList<Boolean>();

        for (int i = 0; i < testsuite.length; i++) {
            Statement testStatement=new Statement(i, testsuite[i]);
            System.out.println(testsuite[i].toString());
            System.out.println("racist? "+isRacist(testStatement));
            System.out.println("derogatory word: "+testStatement.containsDerogatoryWord());
            System.out.println("race classification: "+testStatement.containsRaceClassification());
            System.out.println("adjacence: "+testStatement.raceClassAdjacent());
            results.add(isRacist(testStatement));
            System.out.println();
        }
    }

    private static boolean isRacist(Statement statement) {
        statement.getRawWords();
        if (statement.containsDerogatoryWord()) {
            if (statement.containsRaceClassification()) {
                if (statement.raceClassAdjacent()) {
                    return true;
                }
            }
        }
        return false;
    }
}