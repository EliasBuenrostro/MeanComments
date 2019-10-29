public class Main {
    public static void main(String[] args) {
        System.out.println(isRacist(""));
    }

    private static boolean isRacist(String s) {
        Statement statement=new Statement(1, s);
        statement.getRawWords();
        System.out.println("derogatory word= "+statement.containsDerogatoryWord());
        System.out.println("race classification= "+statement.containsRaceClassification());
        System.out.println("adjacence= "+statement.raceClassAdjacent());
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