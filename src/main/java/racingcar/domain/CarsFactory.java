package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsFactory {
	private static final String SPACE = " ";
	private static final String EMPTY = "";
	private static final String COMMA = ",";
	private static final int LIMIT = -1;

	public static Cars createCars(String carsNameInput) {
		List<String> carsName = removeSpaceAndSplit(carsNameInput);
		List<Car> cars = new ArrayList<>();

		carsName.forEach(carName -> cars.add(new Car(carName, new Position(Position.INITIAL_POSITION))));
		return new Cars(cars);
	}

	private static List<String> removeSpaceAndSplit(String carsNameInput) {
		return Arrays.asList(carsNameInput.replace(SPACE, EMPTY)
				.split(COMMA, LIMIT));
	}
}
