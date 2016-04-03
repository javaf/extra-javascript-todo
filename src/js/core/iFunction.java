package js.core;
import java.util.function.*;


/**
 * To be written.
 * @param <T>
 * @param <U>
 * @param <R> 
 */
public interface iFunction<T, U, R> extends Consumer<T>, BiConsumer<T, U>, Function<T, R>, BiFunction<T, U, R> {
	
	/* super method */
	@Override
	default <V> iFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
		return new iFunction<T, U, V>() {

			@Override
			public void accept(T t, U u) {
				after.apply(iFunction.this.apply(t, u));
			}

			@Override
			public void accept(T t) {
				after.apply(iFunction.this.apply(t));
			}
			
			@Override
			public V apply(final T t, final U u) {
				return after.apply(iFunction.this.apply(t, u));
			}

			@Override
			public V apply(final T t) {
				return after.apply(iFunction.this.apply(t));
			}
		};
	}
}
