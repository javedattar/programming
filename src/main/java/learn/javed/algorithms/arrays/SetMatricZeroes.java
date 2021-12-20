/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatricZeroes {

	public static void main(String[] args) {
		SetMatricZeroes obj = new SetMatricZeroes();
		int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		obj.setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
		matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		obj.setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
		matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		obj.setZeroes2(matrix);
		System.out.println(Arrays.deepToString(matrix));

	}

	public void setZeroes(int[][] matrix) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (Integer index : rows) {

			for (int i = 0; i < matrix[0].length; i++) {
				matrix[index][i] = 0;
			}
		}
		for (Integer index : cols) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][index] = 0;
			}
		}

	}

	/**
	 * Not Working
	 * 
	 * @param matrix
	 */
	public void setZeroes2(int[][] matrix) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					int k = 0;
					while (k < matrix[0].length) {
						matrix[i][k++] = 0;
					}
				}
			}
		}
	}

}
