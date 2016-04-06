package js.lang.reflect;

/**
 * Reflect is a built-in object that provides methods for interceptable JavaScript
 * operations. The methods are the same as those of proxy handlers. Reflect is not
 * a function object, so it's not constructible.
 */
public class oReflect {
	
	/* static method */
	/**
	 * The static Reflect.apply() method calls a target function with arguments as specified.
	 * @param target The target function to call.
	 * @param thisArgument The value of this provided for the call to target.
	 * @param argumentsList An array-like object specifying the arguments with which target should be called.
	 * @return Return value from target function.
	 */
	public static Object apply(Object target, Object thisArgument, Object[] argumentsList) {
		return null;
	}
	
	/**
	 * The static Reflect.construct() method acts like the new operator as a
	 * function. It is equivalent to calling new target(...args).
	 * @param target The target function to call.
	 * @param argumentsList An array-like object specifying the arguments with which target should be called.
	 * @param newTarget The constructor to be used. See also the new.target operator.
	 * If newTarget is not present, it is target.
	 * @return Constructed object.
	 */
	public static Object construct(Object target, Object[] argumentsList, Object newTarget) {
		return null;
	}
	/**
	 * The static Reflect.construct() method acts like the new operator as a
	 * function. It is equivalent to calling new target(...args).
	 * @param target The target function to call.
	 * @param argumentsList An array-like object specifying the arguments with which target should be called.
	 * @return Constructed object.
	 */
	public static Object construct(Object target, Object[] argumentsList) {
		return null;
	}
	
	/**
	 * The static Reflect.defineProperty() method is like Object.defineProperty() but returns a Boolean.
	 * @param target The target object on which to define the property.
	 * @param propertyKey The name of the property to be defined or modified.
	 * @param attributes The attributes for the property being defined or modified.
	 * @return A Boolean indicating whether or not the property was successfully defined.
	 */
	public static boolean defineProperty(Object target, String propertyKey, Object attributes) {
		return false;
	}
	
	/**
	 * The static Reflect.deleteProperty() method allows to delete properties.
	 * It is like the delete operator as a function.
	 * @param target The target object on which to delete the property.
	 * @param propertyKey The name of the property to be deleted.
	 * @return A Boolean indicating whether or not the property was successfully deleted.
	 */
	public static boolean deleteProperty(Object target, String propertyKey) {
		return false;
	}
	
	/**
	 * The static Reflect.get() method works like getting a property from an
	 * object (target[propertyKey]) as a function.
	 * @param target The target object on which to get the property.
	 * @param propertyKey The name of the property to get.
	 * @param receiver The value of this provided for the call to target if a getter is encountered.
	 * @return The value of the property.
	 */
	public static Object get(Object target, String propertyKey, Object receiver) {
		return null;
	}
	/**
	 * The static Reflect.get() method works like getting a property from an
	 * object (target[propertyKey]) as a function.
	 * @param target The target object on which to get the property.
	 * @param propertyKey The name of the property to get.
	 * @return The value of the property.
	 */
	public static Object get(Object target, String propertyKey) {
		return null;
	}
	
	/**
	 * The static Reflect.getOwnPropertyDescriptor() method is similar to
	 * Object.getOwnPropertyDescriptor(). It returns a property descriptor
	 * of the given property if it exists on the object, undefined otherwise.
	 * @param target The target object in which to look for the property.
	 * @param propertyKey The name of the property to get an own property descriptor for.
	 * @return A property descriptor object or undefined.
	 */
	public static Object getOwnPropertyDescriptor(Object target, String propertyKey) {
		return null;
	}
	
	/**
	 * The static Reflect.getPrototypeOf() method is the same method as
	 * Object.getPrototypeOf(). It returns the prototype (i.e. the value
	 * of the internal [[Prototype]] property) of the specified object.
	 * @param target The target object of which to get the prototype.
	 * @return The prototype of the object or null.
	 */
	public static Object getPrototypeOf(Object target) {
		return null;
	}
	
	/**
	 * The static Reflect.has() method works like the in operator as a function.
	 * @param target The target object in which to look for the property.
	 * @param propertyKey The name of the property to check.
	 * @return A Boolean indicating whether or not the target has the property.
	 */
	public static boolean has(Object target, String propertyKey) {
		return false;
	}
	
	/**
	 * The static Reflect.isExtensible() method determines if an object is
	 * extensible (whether it can have new properties added to it). It is similar
	 * to Object.isExtensible(), but with some differences.
	 * @param target The target object which to check if it is extensible.
	 * @return A Boolean indicating whether or not the target is extensible.
	 */
	public static boolean isExtensible(Object target) {
		return false;
	}
	
	/**
	 * The static Reflect.ownKeys() method returns an array of the target object's own property keys.
	 * @param target The target object from which to get the own keys.
	 * @return An Array of the target object's own property keys.
	 */
	public static String[] ownKeys(Object target) {
		return null;
	}
	
	/**
	 * The static Reflect.preventExtensions() method prevents new properties from
	 * ever being added to an object (i.e. prevents future extensions to the object).
	 * It is similar to Object.preventExtensions(), but with some differences.
	 * @param target The target object on which to prevent extensions.
	 * @return A Boolean indicating whether or not the target was successfully set to prevent extensions.
	 */
	public static boolean preventExtensions(Object target) {
		return false;
	}
	
	/**
	 * The static Reflect.set() method works like setting a property on an object.
	 * @param target The target object on which to set the property.
	 * @param propertyKey The name of the property to set.
	 * @param value The value to set.
	 * @param receiver The value of this provided for the call to target if a setter is encountered.
	 * @return A Boolean indicating whether or not setting the property was successful.
	 */
	public static boolean set(Object target, String propertyKey, Object value, Object receiver) {
		return false;
	}
	/**
	 * The static Reflect.set() method works like setting a property on an object.
	 * @param target The target object on which to set the property.
	 * @param propertyKey The name of the property to set.
	 * @param value The value to set.
	 * @return A Boolean indicating whether or not setting the property was successful.
	 */
	public static boolean set(Object target, String propertyKey, Object value) {
		return false;
	}
	
	/**
	 * The static Reflect.setPrototypeOf() method is the same method as Object.setPrototypeOf().
	 * It sets the prototype (i.e., the internal [[Prototype]] property) of a specified object
	 * to another object or to null.
	 * @param target The target object of which to set the prototype.
	 * @param prototype The object's new prototype (an object or null).
	 * @return A Boolean indicating whether or not the prototype was successfully set.
	 */
	public static boolean setPrototypeOf(Object target, Object prototype) {
		return false;
	}
}
