import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.util.Types;
import javax.security.auth.callback.CallbackHandler;
import java.util.Hashtable;

public class FiniteAutomataPractice {

    public static void main(String[] args) {

    }
}

class Lexer {


}

class State {

    public static final State CRASH = null;
    public boolean isFinal;
    public Hashtable<Character, State> transitions;

    public State() { this(false); }
    public State(boolean isFinal) {
        this(isFinal, new Hashtable<>());
    }

    public State(boolean isFinal, Hashtable<Character, State> transitions) {
        this.isFinal = isFinal;
        this.transitions = transitions;
    }

    public void addTransition(char c, State s) {
        transitions.put(c, s);
    }
    public State transition(char c) {
        return transitions.getOrDefault(c, CRASH);
    }
}