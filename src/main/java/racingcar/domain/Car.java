package racingcar.domain;

import java.util.Objects;

public class Car {
	private static final int MINIMUM_LENGTH_OF_CAR_NAME = 1;
	private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
	private static final int MINIMUM_MOVE_NUMBER = 4;

	private final String name;
	private Position position;

	public Car(String name, Position position) {
		validateLengthOfCarName(name);
		this.name = name;
		this.position = position;
	}

	private void validateLengthOfCarName(String name) {
		if ((name.length() < MINIMUM_LENGTH_OF_CAR_NAME) || (name.length() > MAXIMUM_LENGTH_OF_CAR_NAME)) {
			throw new IllegalArgumentException(name + "의 길이가 1~5 사이에 있지 않습니다.");
		}
	}

	public void move(int value) {
		if (value >= MINIMUM_MOVE_NUMBER) {
			position.addOne();
		}
	}

	public Position biggerPosition(Position positionToCompare) {
		return position.biggerPosition(positionToCompare);
	}

	public boolean isSamePosition(Position positionToCompare) {
		return position.isSamePosition(positionToCompare);
	}

	public String getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(name, car.name) &&
				Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
