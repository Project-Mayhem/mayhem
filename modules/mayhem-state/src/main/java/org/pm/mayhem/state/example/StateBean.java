package org.pm.mayhem.state.example;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class StateBean {
	
	static class MyBean {

	    @OnTransition(target = "STATE1")
	    void toState1() {
	    }

	    @OnTransition(target = "STATE2")
	    void toState2() {
	    }
	}
}
