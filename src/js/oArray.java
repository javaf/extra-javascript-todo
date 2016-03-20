package js;
import java.util.function.*;

/**
 * Class that is used in the construction of arrays; which are high-level, list-like objects.
 */
public class oArray {
	
	/* constructor */
	/**
	 * Create a new array.
	 * @param element0 A JavaScript array is initialized with the given elements,
	 * except in the case where a single argument is passed to the Array
	 * constructor and that argument is a number. (See below.) Note that this
	 * special case only applies to JavaScript arrays created with the Array
	 * constructor, not array literals created with the bracket syntax.
	 * @param element1 Second array element.
	 * @param elements Nth array element.
	 */
	public oArray(Object element0, Object element1, Object... elements) {
	}
	/**
	 * Create a new array.
	 * @param arrayLength If the only argument passed to the Array constructor is
	 * an integer between 0 and 232-1 (inclusive), this returns a new JavaScript
	 * array with length set to that number. If the argument is any other number,
	 * a RangeError exception is thrown.
	 */
	public oArray(int arrayLength) {
	}

	
	/* method */
	/**
	 * Reflects the number of elements in an array.
	 * @return Number of elements in array.
	 */
	public int length() {
		return 0;
	}
	
	/**
	 * Sets the number of elements in an array.
	 * @param value New length of array.
	 * @return Length of array.
	 */
	public int length(int value) {
		return 0;
	}
	
	/**
	 * Copies the sequence of array elements within the array to the position
	 * starting at target. The copy is taken from the index positions of the
	 * second and third arguments start and end. The end argument is optional
	 * and defaults to the length of the array.
	 * @param target Target start index position where to copy the elements to.
	 * @param start Source start index position where to start copying elements
	 * from.
	 * @param end Optional. Source end index position where to end copying
	 * elements from.
	 * @return This array.
	 */
	public oArray copyWithin(int target, int start, int end) {
		return null;
	}
	
	
	
	/* static method */
	/**
	 * Creates a new Array instance from an array-like or iterable object.
	 * @param arrayLike An array-like or iterable object to convert to an array.
	 * @param mapFn Optional. Map function to call on every element of the array.
	 * @return Created array.
	 */
	public static oArray from(Iterable arrayLike, BiFunction mapFn) {
		return null;
	}
	
	/**
	 * Returns true if an object is an array, false if it is not.
	 * @param obj The object to be checked.
	 * @return Whether object is an array.
	 */
	public static boolean isArray(Object obj) {
		return false;
	}
	
	/**
	 * Creates a new Array instance with a variable number of arguments,
	 * regardless of number or type of the arguments.
	 * @param elements Elements of which to create the array.
	 * @return Arrays created from elements.
	 */
	public static oArray of(Object... elements) {
		return null;
	}
}
