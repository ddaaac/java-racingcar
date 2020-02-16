package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
	@ParameterizedTest
	@MethodSource("generateInput")
	void 이름_길이_1이상_5이하(String input) {
		assertThatThrownBy(() -> new Car(input, new Position(Position.INITIAL_POSITION)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("의 길이가 1~5 사이에 있지 않습니다.");
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(Arguments.of("bumblebee,pobi,sika"),
				Arguments.of("ie,aaaaa,jjjj"));
	}

	@ParameterizedTest
	@CsvSource(value = {"0 0", "3 0", "4 1", "9 1"}, delimiter = ' ')
	void 이동조건(int value, int expected) {
		Car car = new Car("bumbl", new Position(Position.INITIAL_POSITION));
		car.move(value);
		assertThat(car.getPosition().getPositionValue()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"3 5 5", "4 0 4"}, delimiter = ' ')
	void 큰_포지션_반환(int pos1, int pos2, int expectedPos) {
		Car car1 = new Car("a", new Position(pos1));
		Car car2 = new Car("a", new Position(pos2));

		assertThat(car1.biggerPosition(car2.getPosition())
				.getPositionValue()).isEqualTo(expectedPos);
	}

	@ParameterizedTest
	@CsvSource(value = {"2:2:true", "3:2:false", "4:3:false"}, delimiter = ':')
	void 포지션_같은지_확(int pos1, int pos2, boolean expected) {
		Car car1 = new Car("a", new Position(pos1));
		Car car2 = new Car("a", new Position(pos2));

		assertThat(car1.isSamePosition(car2.getPosition())).isEqualTo(expected);
	}
}
