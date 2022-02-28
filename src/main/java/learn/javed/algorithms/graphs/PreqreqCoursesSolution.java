/**
* author: Javed Attar
*/
package learn.javed.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting
 * should be scheduled when a student has completed 50% of their academic program.
 * 
 * Each course at our university has at most one prerequisite that must be taken first. No two courses share a
 * prerequisite. There is only one path through the program.
 * 
 * Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the
 * student will be taking when they are halfway through their program. (If a track has an even number of courses, and
 * therefore has two "middle" courses, you should return the first one.)
 * 
 * Sample input 1: (arbitrarily ordered)
 * prereqs_courses1 = [
 * ["Foundations of Computer Science", "Operating Systems"],
 * ["Data Structures", "Algorithms"],
 * ["Computer Networks", "Computer Architecture"],
 * ["Algorithms", "Foundations of Computer Science"],
 * ["Computer Architecture", "Data Structures"],
 * ["Software Design", "Computer Networks"]
 * ]
 * 
 * In this case, the order of the courses in the program is:
 * Software Design
 * Computer Networks
 * Computer Architecture
 * Data Structures
 * Algorithms
 * Foundations of Computer Science
 * Operating Systems
 * 
 * Sample output 1:
 * "Data Structures"
 * 
 * Sample input 2:
 * prereqs_courses2 = [
 * ["Algorithms", "Foundations of Computer Science"],
 * ["Data Structures", "Algorithms"],
 * ["Foundations of Computer Science", "Logic"],
 * ["Logic", "Compilers"],
 * ["Compilers", "Distributed Systems"],
 * ]
 * 
 * Sample output 2:
 * "Foundations of Computer Science"
 * 
 * Sample input 3:
 * prereqs_courses3 = [
 * ["Data Structures", "Algorithms"],
 * ]
 * 
 * Sample output 3:
 * "Data Structures"
 * 
 * Complexity analysis variables:
 * 
 * n: number of pairs in the input
 * 
 */
public class PreqreqCoursesSolution {

	public static void main(String[] argv) {
		String[][] prereqsCourses1 = { { "Foundations of Computer Science", "Operating Systems" },
				{ "Data Structures", "Algorithms" }, { "Computer Networks", "Computer Architecture" },
				{ "Algorithms", "Foundations of Computer Science" }, { "Computer Architecture", "Data Structures" },
				{ "Software Design", "Computer Networks" } };

		String[][] prereqsCourses2 = { { "Algorithms", "Foundations of Computer Science" },
				{ "Data Structures", "Algorithms" }, { "Foundations of Computer Science", "Logic" },
				{ "Logic", "Compilers" }, { "Compilers", "Distributed Systems" }, };

		String[][] prereqsCourses3 = { { "Data Structures", "Algorithms" } };

		System.out.println(findMiddleOfCourse(prereqsCourses1));
		System.out.println(findMiddleOfCourse(prereqsCourses2));
		System.out.println(findMiddleOfCourse(prereqsCourses3));
	}

	public static String findMiddleOfCourse(String[][] prereqsCourses) {
		Map<String, String> mapPrereqsCourses = new HashMap<>();

		List<String> courses = new ArrayList<>();

		for (int i = 0; i < prereqsCourses.length; i++) {
			mapPrereqsCourses.put(prereqsCourses[i][0], prereqsCourses[i][1]);
		}
		String firstPrereq = findFirst(mapPrereqsCourses);
		String course = mapPrereqsCourses.get(firstPrereq);
		courses.add(firstPrereq);
//		courses.add(course);

		while (mapPrereqsCourses.containsKey(course)) {

			courses.add(course);
			course = mapPrereqsCourses.getOrDefault(course, "VOID");

		}

		courses.add(course);

		return courses.size() % 2 == 0 ? courses.get(courses.size() / 2 - 1) : courses.get(courses.size() / 2);
	}

	private static String findFirst(Map<String, String> mapPrereqsCourses) {

		for (String key : mapPrereqsCourses.keySet()) {

			if (!mapPrereqsCourses.containsValue(key)) {
				return key;
			}
		}

		return null;
	}

}
