import java.util.List;

public abstract class Question {
    protected String question;
    protected List<String> candidateAnswers;
    

    public Question(String question, List<String> candidateAnswers){
        this.question=question;
        this.candidateAnswers=candidateAnswers;
        
    }

    public abstract boolean validateAnswer(List<String> answers);


    public List<String> getCandidateAnswers(){
        return candidateAnswers;
    }
}
