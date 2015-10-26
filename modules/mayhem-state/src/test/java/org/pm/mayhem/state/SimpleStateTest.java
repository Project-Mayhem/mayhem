package org.pm.mayhem.state;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pm.mayhem.state.example.Events;
import org.pm.mayhem.state.example.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.transition.Transition;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration (locations="classpath:META-INF/state-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleStateTest {

	 private static final Log log = LogFactory.getLog(SimpleStateTest.class);

	@Autowired
    StateMachine<States, Events> stateMachine;

	
	@Test
	public void DoSignalsTest() {
		
        stateMachine.start();
        log.info("Started stateMachine:");
        log.info("Initial state: " + stateMachine.getInitialState().getId());
        Collection<Transition<States, Events>> transistions = stateMachine.getTransitions();
        for (Transition<States, Events> object : transistions) {
			log.info("transition: Source: " + object.getSource().getId().name() + 
					", target: " + object.getTarget().getId().name() + 
					", trigger: " + object.getTrigger().getEvent().name());
		}
        stateMachine.sendEvent(Events.EVENT1);
        
        stateMachine.sendEvent(Events.EVENT2);
    
	}
}
