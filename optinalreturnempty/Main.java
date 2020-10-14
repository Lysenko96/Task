package com.lysenko.optinalreturnempty;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Optional<ListStep> l = returnLists();
		if (l.isPresent()) {
			System.out.println(l.get());
		}

	}

	static Optional<ListStep> returnLists() {
		if (false) {
			ArrayList l1 = new ArrayList<>();
		}
		return Optional.empty();
	}

}

class ListStep {
	List<String> l1 = new ArrayList<>();
	List<String> l2 = new ArrayList<>();
}
