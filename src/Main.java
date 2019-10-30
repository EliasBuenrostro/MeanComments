import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] testsuite=Read.getTestSuite();
        ArrayList<Boolean> results=new ArrayList<Boolean>();
        for (int i = 0; i < testsuite.length; i++) {
            System.out.println(testsuite[i].toString());
            Statement testStatement=new Statement(i, testsuite[i]);
            results.add(isRacist(testStatement));
            System.out.println(isRacist(testStatement));
        }

        System.out.println(results);
    }

    private static boolean isRacist(Statement statement) {
        statement.getRawWords();
        if (statement.containsDerogatoryWord()) {
            System.out.println("derogatory word: "+statement.containsDerogatoryWord());
            if (statement.containsRaceClassification()) {
                System.out.println("race classification: "+statement.containsRaceClassification());
                if (statement.raceClassAdjacent()) {
                    System.out.println("adjacence: "+statement.raceClassAdjacent());
                    return true;
                }
            }
        }
        return false;
    }
}