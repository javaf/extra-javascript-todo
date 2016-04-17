package js.lang.object;
import java.lang.annotation.*;

/**
 * Defines annotation that can be used on classes and methods to describe the
 * accessibility of its fields and methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface aAccess {
	
	/**
	 * Tells whether the element is enumerable.
	 * @return Whether element is accessible in for..in loop.
	 */
	public boolean enumerable() default true;
	/**
	 * Tells whether the element is writable.
	 * @return Whether element can be written to.
	 */
	public boolean writable() default true;
	/** Tells the name of the property for this element.
	 * @return Name of the property this element represents. */
	public String value() default ".";
}
