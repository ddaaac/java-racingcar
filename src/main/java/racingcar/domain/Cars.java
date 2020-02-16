package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final int MINIMUM_NUMBER_OF_CARS = 2;

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateDuplicateCarName(cars);
		validateNumberOfCars(cars);
		this.cars = Collections.unmodifiableList(cars);
	}

	private void validateDuplicateCarName(List<Car> cars) {
		if (cars.stream()
				.map(Car::getName)
				.distinct()
				.count() != cars.size()) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	private void validateNumberOfCars(List<Car> cars) {
		if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
			throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
		}
	}

	public void moveAll() {
		cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
	}

	public List<Car> getWinners() {
		return cars.stream()
				.filter(car -> car.isSamePosition(maxPosition()))
				.collect(Collectors.toUnmodifiableList());
	}

	private Position maxPosition() {
		Position maxPosition = new Position(Position.INITIAL_POSITION);
		for (Car car : cars) {
			maxPosition = car.biggerPosition(maxPosition);
		}

		return maxPosition;
	}

	public List<Car> getCars() {
		return cars;
	}
}
