import java.util.List;

public class MultipleChoiceQuestion extends Question{
   public MultipleChoiceQuestion(String question, List<String> candidateAnswers){
    super(question, candidateAnswers);
   } 

   public boolean validateAnswer(List<String> answers){
    return candidateAnswers.containsAll(answers);
   }
}
