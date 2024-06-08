import java.util.List;

public class SingleChoiceQuestion extends Question{

    public SingleChoiceQuestion(String question, List<String> candidateAnswers){
        super(question, candidateAnswers);
    }

    public boolean validateAnswer(List<String> answers){
        return answers.size()==1 && candidateAnswers.contains(answers.get(0));
    }
    
}
