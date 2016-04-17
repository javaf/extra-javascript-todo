package js.lang.object;
import java.lang.annotation.*;

/**
 * Defines annotation that can be used on classes and methods to describe the
 * accessibility of its fields and methods.
 */
@aAccess
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface aAccess {
	
	/* static data */
	static aAccess DEFAULT = aAccess.class.getAnnotation(aAccess.class);
	
	
	/* method */
	/**
	 * Tells whether the element is enumerable.
	 * @return Whether element is accessible in for..in loop.
	 */
	boolean enumerable() default true;
	/**
	 * Tells whether the element is writable.
	 * @return Whether element can be written to.
	 */
	boolean writable() default true;
	/** Tells the name of the property for this element.
	 * @return Name of the property this element represents. */
	String value() default ".";
}
