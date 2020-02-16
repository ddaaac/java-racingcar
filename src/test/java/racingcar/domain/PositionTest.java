package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {
	@Test
	void 포지션은_양의정수() {
		assertThatThrownBy(() -> new Position(-1))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessageContaining("포지션은 양의 정수 또는 0이어야합니다.");
	}
}
