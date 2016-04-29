package js.lang.math;

/**
 * Defines basic operations that can be preformed on a number.
 */
public interface iNum extends Comparable<iNum> {
	
	iNum add(iNum number);
	iNum sub(iNum number);
	iNum mul(iNum number);
	iNum div(iNum number);
}
