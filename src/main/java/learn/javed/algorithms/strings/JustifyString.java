
package learn.javed.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class JustifyString {

	public static void main(String[] args) {
		String words[] = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(fullJustify(words, 16));
	}

	private static final String SPACE_CHAR = " ";

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();

		List<String> lineWords = new ArrayList<>();
		int currentLength = 0;
		for (String word : words) {
			// TODO: For breaking word to fit given width
//			while (word.length() > maxWidth) {
//				if (!lineWords.isEmpty()) {
//					StringBuilder line = new StringBuilder();
//					line.append(String.join(SPACE_CHAR, lineWords)).append(SPACE_CHAR);
//					String tempWord = word.substring(maxWidth - line.length());
//					line.append(word.substring(0, maxWidth - line.length()));
//					word = tempWord;
//					result.add(line.toString());
//					lineWords.clear();
//					currentLength = 0;
//					continue;
//				}
//				String tempWord = word.substring(0, maxWidth);
//				result.add(tempWord);
//				word = word.substring(maxWidth);
//			}

			currentLength += word.length();
			lineWords.add(word);
			// currentLength has length of the words without spaces
			// number spaces between words will be no. of words - 1
			if (currentLength + lineWords.size() - 1 > maxWidth) {
				StringBuilder line = new StringBuilder();
				lineWords.remove(lineWords.size() - 1);
				currentLength -= word.length();
				int numOfSpaces = maxWidth - currentLength;
				int remainingSpace = lineWords.size() == 1 ? 0 : numOfSpaces % (lineWords.size() - 1);
				int wordSpace = lineWords.size() == 1 ? numOfSpaces : numOfSpaces / (lineWords.size() - 1);
				for (String lineWord : lineWords) {
					line.append(lineWord);
					for (int i = 0; i < wordSpace; i++) {
						line.append(SPACE_CHAR);
					}
					if (remainingSpace-- > 0) {
						line.append(SPACE_CHAR);
					}

				}
				result.add(line.toString().trim().length() == maxWidth ? line.toString().trim() : line.toString());
				lineWords.clear();
				lineWords.add(word);
				currentLength = word.length();

			}
		}
		if (lineWords.size() != 0) {
			StringBuilder line = new StringBuilder(String.join(SPACE_CHAR, lineWords));

			while (line.length() < maxWidth)
				line.append(SPACE_CHAR);
			result.add(line.toString());
		}
		return result;
	}
}
