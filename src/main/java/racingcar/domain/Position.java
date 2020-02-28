package racingcar.domain;

import java.util.Objects;

public class Position {
	static final int INITIAL_POSITION = 0;

	private int positionValue;

	public Position(int positionValue) {
		validatePositive(positionValue);
		this.positionValue = positionValue;
	}

	private void validatePositive(int positionValue) {
		if (positionValue < 0) {
			throw new IllegalArgumentException("포지션은 양의 정수 또는 0이어야합니다.");
		}
	}

	public void addOne() {
		positionValue++;
	}

	public int getPositionValue() {
		return positionValue;
	}

	public Position biggerPosition(Position positionToCompare) {
		if (positionValue > positionToCompare.positionValue) {
			return this;
		}
		return positionToCompare;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return positionValue == position.positionValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positionValue);
	}

	public boolean isSamePosition(Position positionToCompare) {
		return positionValue == positionToCompare.positionValue;
	}
}
