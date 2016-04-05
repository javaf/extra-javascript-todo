/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.lang.control;

/**
 *
 * @author wolfram77
 */
public class oGenerator {
	
	/* data */
	private Object value;
	private Object state;
	private boolean done;
	
	/* property */
	public final Object value() {
		return value;
	}
	public final oGenerator value(Object newValue) {
		value = newValue;
		return this;
	}
	
	public final Object state() {
		return state;
	}
	public final oGenerator state(Object newValue) {
		state = newValue;
		return this;
	}
	
	public boolean done() {
		return done;
	}
	public oGenerator done(boolean newValue) {
		done = newValue;
		return this;
	}
	
	
}
