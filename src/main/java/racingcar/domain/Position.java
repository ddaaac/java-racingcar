package racingcar.domain;

public class Position {
	static final int INITIAL_POSITION = 0;

	private int position;

	public Position(int position) {
		validatePositive(position);
		this.position = position;
	}

	private void validatePositive(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("포지션은 양의 정수 또는 0이어야합니다.");
		}
	}

	public void addOne() {
		position++;
	}

	public int getPosition() {
		return position;
	}
}
