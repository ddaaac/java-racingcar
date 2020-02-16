package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {
	@Test
	void 포지션은_양의정수() {
		assertThatThrownBy(() -> new Position(-1))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessageContaining("포지션은 양의 정수 또는 0이어야합니다.");
	}

	@Test
	void 포지션_한칸_증가() {
		Position position = new Position(0);
		position.addOne();
		assertThat(position.getPosition()).isEqualTo(1);
	}

	@ParameterizedTest
	@CsvSource(value = {"3 1", "4 2", "5 3"}, delimiter = ' ')
	void 포지션_비교(int pos1, int pos2) {
		Position position1 = new Position(pos1);
		Position position2 = new Position(pos2);

		assertThat(position1.biggerPosition(position2).getPosition()).isEqualTo(position1.getPosition());
	}
}
