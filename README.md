oObject is:
- standard class object
- enumerable class object
- map storing keys and value
- does it make sense to restrict map fields
- but a prototypal map does make sense
- map may prototype to standard object as well
map -> standard object (encapsulate?)
- prototype can in main oObject, or is each part
- what about objects inside objects (for tostring)
@Describes
class {
	@Part
	field0
	field1
	
	@Part
	method0
	method1
}

issues with object:
- incorrectly includes fields not to be included in enumerable case
- includes more functions than it should causing unexpected behavior.
- fast access fields is a functionality that could be implemented in function

issues with arrays:
- are not iterable
- difficult to convert to string.
- generic algorithms are hard to implement
- not matlab-like
- are different from a buffer (but why?)
- are not instanceof, so cannot be used where map can be used
- hard to modify, but there is list for that though
- do not perform simd operations.
- clone interface (deep?)
- generic object operator interface
