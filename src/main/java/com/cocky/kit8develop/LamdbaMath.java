package com.cocky.kit8develop;

import java.util.Date;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class LamdbaMath {
	public void lamdbaFunction() {
		Consumer<Integer> integerConsumer = (Integer times) -> {
			System.out.println(times);
		};

		Consumer<Integer> comsumer = (Integer counts) ->{
			++counts;
		};
		Function<Integer, Integer> integerFunction = (Integer count) -> {
			return ++count;
		};
		BooleanSupplier booleanSupplier = () -> {
			return 1 == 0;
		};
		IntSupplier intSupplier = () -> {
			return 100;
		};

		comsumer.andThen(integerConsumer).accept(100);
		integerConsumer.accept(90);
		System.out.println(integerFunction.apply(100));
	}



}
