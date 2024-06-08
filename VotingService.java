import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VotingService {
    private Question question;
    private Map<String, List<String>> submissions;

    public VotingService(){
        this.submissions=new HashMap<>();
        
    }

    public void finalizeQuestion(Question question){
        this.question=question;
    }

    public void submitAnswer(Student student, List<String> answers){
        if(question.validateAnswer(answers)){
            submissions.put(student.getId(), answers);
        }
    }

   
    public void outputStatistics(){
        Map<String, Integer> stats = new HashMap<>();
        for(String candidate: question.getCandidateAnswers()){
            stats.put(candidate, 0);
        }

        for(List<String> answers: submissions.values()){
            for(String answer:answers){
                stats.put(answer, stats.get(answer) +1);
            }
        }

        for(Map.Entry<String, Integer> entry:stats.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println();
    }
}
