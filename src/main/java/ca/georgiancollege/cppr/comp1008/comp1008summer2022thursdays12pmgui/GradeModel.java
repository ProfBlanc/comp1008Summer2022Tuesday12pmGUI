package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

public class GradeModel {

    private int score;
    private String letter;

    void process(String score){
        try{
            this.score = Integer.parseInt(score);
            setLetter();
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Unable to convert the value of " + score + " to a number");
        }
    }

    public String getLetter() {
        return letter;
    }

    private void setLetter() {
        if(score < 0 )
            throw new IllegalArgumentException("Grade must be greater or equal to zero");
        else if(score > 100 )
            throw new IllegalArgumentException("Grade must be less than or equal to 100");

        if(score >= 90)
            letter = "A+";
        else if(score >= 80)
            letter = "A";
        else if(score >= 70)
            letter = "B";
        else if(score >= 60)
            letter = "C";
        else if(score >= 50)
            letter = "D";
        else
            letter = "F";

    }
}
