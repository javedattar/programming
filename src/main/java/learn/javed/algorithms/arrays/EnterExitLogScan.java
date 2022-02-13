/**
* author: Javed Attar
*/

package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

badge_records_1 = [
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Martha",   "enter"],
  ["Steve",    "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Paul",     "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Paul",     "exit"],
  ["Paul",     "exit"] 
]
// leave without badge. enter without
Expected output: ["Paul", "Curtis", "Steve"], ["Martha", "Curtis", "Paul"]

Other test cases:

badge_records_2 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

badge_records_3 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

badge_records_4 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
]

Expected output: ["Paul"], ["Paul"]

n: length of the badge records array


*/
public class EnterExitLogScan {
	public static void main(String[] argv) {
		String badgeRecords1[][] = new String[][] { { "Martha", "exit" }, { "Paul", "enter" }, { "Martha", "enter" },
				{ "Steve", "enter" }, { "Martha", "exit" }, { "Jennifer", "enter" }, { "Paul", "enter" },
				{ "Curtis", "exit" }, { "Curtis", "enter" }, { "Paul", "exit" }, { "Martha", "enter" },
				{ "Martha", "exit" }, { "Jennifer", "exit" }, { "Paul", "enter" }, { "Paul", "enter" },
				{ "Martha", "exit" }, { "Paul", "enter" }, { "Paul", "enter" }, { "Paul", "exit" },
				{ "Paul", "exit" } };

		String badgeRecords2[][] = new String[][] { { "Paul", "enter" }, { "Paul", "exit" }, };

		String badgeRecords3[][] = new String[][] { { "Paul", "enter" }, { "Paul", "enter" }, { "Paul", "exit" },
				{ "Paul", "exit" }, };

		String badgeRecords4[][] = new String[][] { { "Paul", "enter" }, { "Paul", "exit" }, // room {}
				{ "Paul", "exit" },  // missing enter for paul, in 2nd collection, room {}
				{ "Paul", "enter" }, // room {paul}
		};
		// room
		//
		EnterExitLogScan s = new EnterExitLogScan();
		List<Set<String>> output = s.scanLogs(badgeRecords2);
		System.out.println(output.get(0));
		System.out.println(output.get(1));
		output = s.scanLogs(badgeRecords3);
		System.out.println(output.get(0));
		System.out.println(output.get(1));
		output = s.scanLogs(badgeRecords4);
		System.out.println(output.get(0));
		System.out.println(output.get(1));
		output = s.scanLogs(badgeRecords1);
		System.out.println(output.get(0));
		System.out.println(output.get(1));

	}

	private Set<String> room = new HashSet<>();

	public List<Set<String>> scanLogs(String badgeRecords[][]) {
		Set<String> exitDefaulters = new HashSet<>();
		Set<String> enterDefaulters = new HashSet<>();

		for (int i = 0; i < badgeRecords.length; i++) {

			String personName = badgeRecords[i][0];
			String action = badgeRecords[i][1];
			if (room.contains(personName)) {
				if (action.equals("enter")) {
					System.out.println(personName + "(present enter)>>" + action);
					exitDefaulters.add(personName);
				} else {
					System.out.println(personName + "(present exit)>>" + action);
					room.remove(personName);
				}
			} else if (!room.contains(personName)) {
				if (action.equals("exit")) {
					System.out.println(personName + "(absent exit)>>" + action);
					enterDefaulters.add(personName);

				} else {
					System.out.println(personName + "(absent enter)>>" + action);
					room.add(personName);
				}
			}

		}
		if (!room.isEmpty()) {
			exitDefaulters.addAll(room);
		}
		List<Set<String>> output = new ArrayList<>();
//		Set<String>[] op = new HashSet[2];
		output.add(exitDefaulters);
		output.add(enterDefaulters);
		return output;

	}
}

// O(nx2)
// constants
// O(n)
