import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        
        List<String> singleChoiceAnswers=Arrays.asList("1. Right", "2. Wrong");
        Question singleChoiceQuestion= new SingleChoiceQuestion("Single Choice Question", singleChoiceAnswers);

        
        List<String> multipleChoiceAnswers= Arrays.asList("A", "B", "C", "D");
        Question multipleChoiceQuestion= new MultipleChoiceQuestion("Multiple Choice Question", multipleChoiceAnswers);
        
        VotingService singleChoiceVotingService= new VotingService();
        singleChoiceVotingService.finalizeQuestion(singleChoiceQuestion);
        
        VotingService multipleChoiceVotingService= new VotingService();
        multipleChoiceVotingService.finalizeQuestion(multipleChoiceQuestion);

        //Here I basically configured the answer simulation, of course, incorporating randomness for the different answers outputted
        Random random= new Random();
        int numberOfStudents = 100;

        
        for(int i=0; i<numberOfStudents; i++) {
            Student student = new Student(Student.generateRandomID());
            List<String> answers = Arrays.asList(singleChoiceAnswers.get(random.nextInt(singleChoiceAnswers.size())));
            singleChoiceVotingService.submitAnswer(student, answers);
        }

        
        for(int i=0; i<numberOfStudents; i++) {
            Student student = new Student(Student.generateRandomID());
            List<String> answers = new ArrayList<>();
            for(String answer : multipleChoiceAnswers) {
                if(random.nextBoolean()) {
                    answers.add(answer);
                }
            }
            if(answers.isEmpty()) {
                answers.add(multipleChoiceAnswers.get(random.nextInt(multipleChoiceAnswers.size())));
            }
            multipleChoiceVotingService.submitAnswer(student, answers);
        }

        
        System.out.println("Voting Results for Single-Choice Questions:");
        singleChoiceVotingService.outputStatistics();
        
        System.out.println("Voting Results for Multiple-Choice Questions:");
        multipleChoiceVotingService.outputStatistics();
    }
}
