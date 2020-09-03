package com.lysenko.char_counter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static java.lang.System.lineSeparator;

import org.junit.jupiter.api.Test;

import com.lysenko.charcounter.CharCounter;
import com.lysenko.charcounter.Main;

class CharCounterTest {

	private Main main;

	@BeforeEach
	void setUp() {
		main = new Main();
	}

	@Test
	void givenNullThenGetException() {
		assertThrows(NullPointerException.class, () -> Main.showResult(null));
	}

	@Test
	void givenEmptyThenGetResult() {
		StringBuilder expected = new StringBuilder("");
		String actual = Main.showResult("");
		assertEquals(expected.toString(), actual);
	}

	@Test
	void givenSynchrophasotronThenGetResult() {
		StringBuilder expected = new StringBuilder();
		expected.append("\"s\" - 2").append(lineSeparator()).append("\"y\" - 1").append(lineSeparator())
				.append("\"n\" - 2").append(lineSeparator()).append("\"c\" - 1").append(lineSeparator())
				.append("\"h\" - 2").append(lineSeparator()).append("\"r\" - 2").append(lineSeparator())
				.append("\"o\" - 3").append(lineSeparator()).append("\"p\" - 1").append(lineSeparator())
				.append("\"a\" - 1").append(lineSeparator()).append("\"t\" - 1").append(lineSeparator());
		String actual = Main.showResult("synchrophasotron");
		assertEquals(expected.toString(), actual);
	}

	@Test
	void givenCollectionFrameworkThenGetResult() {
		StringBuilder expected = new StringBuilder();
		expected.append("\"c\" - 2").append(lineSeparator()).append("\"o\" - 3").append(lineSeparator())
				.append("\"l\" - 2").append(lineSeparator()).append("\"e\" - 2").append(lineSeparator())
				.append("\"t\" - 1").append(lineSeparator()).append("\"i\" - 1").append(lineSeparator())
				.append("\"n\" - 1").append(lineSeparator()).append("\" \" - 1").append(lineSeparator())
				.append("\"f\" - 1").append(lineSeparator()).append("\"r\" - 2").append(lineSeparator())
				.append("\"a\" - 1").append(lineSeparator()).append("\"m\" - 1").append(lineSeparator())
				.append("\"w\" - 1").append(lineSeparator()).append("\"k\" - 1").append(lineSeparator());
		String actual = Main.showResult("collection framework");
		assertEquals(expected.toString(), actual);
	}

	@Test
	void givenHelloWorldThenGetResult() {
		StringBuilder expected = new StringBuilder();
		expected.append("\"h\" - 1").append(lineSeparator()).append("\"e\" - 1").append(lineSeparator())
				.append("\"l\" - 3").append(lineSeparator()).append("\"o\" - 2").append(lineSeparator())
				.append("\" \" - 1").append(lineSeparator()).append("\"w\" - 1").append(lineSeparator())
				.append("\"r\" - 1").append(lineSeparator()).append("\"d\" - 1").append(lineSeparator())
				.append("\"!\" - 1").append(lineSeparator());
		String actual = Main.showResult("hello world!");
		assertEquals(expected.toString(), actual);
	}

}
