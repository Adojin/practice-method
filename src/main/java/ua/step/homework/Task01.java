package ua.step.homework;

import java.util.Arrays;

/**
 * Написать и методы работы с квадратными матрицами (матрицы
 * представить в виде двухмерных массивов). 
 * Должны присутствовать методы:
 * • создания единичной (диагональной) матрицы (метод createOne)
 * • создания нулевой матрицы (метод createNull)
 * • сложение матриц (метод sumMatrix)
 * • умножения матриц (метод productMatrix)
 * • умножение матрицы на скаляр (метод productMatrix)
 * • определение детерминанта матрицы (метод determinant)
 * • вывод матрицы на консоль (метод printMatrix)
 */
public class Task01 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		printMatrix(arr);
	}

	/**
	 * Создает единичную матрицу
	 * @param n - количество строк
	 * @param m - количество колонок
	 * @return единичную (диагональную) матрицу
	 */
	public static int[][] createOne (int n, int m) {
		int[][] arr = new int[n][m];
		for(int i = 0; i < arr.length; i++){
			arr[i][i] = 1;
		}
		return arr;
	}

	/**
	 * Создает нулевую матрицу
	 * @param n - количество строк
	 * @param m - количество колонок
	 * @return нулевую матрицу
	 */
	public static int[][] createNull (int n, int m) {
		return new int[n][m];
	}

	/**
	 * Вычисляет сумму двух матриц
	 * @param one - первая матрица
	 * @param two - вторая матрица
	 * @return сумму двух матриц
	 */
	public static int[][] sumMatrix(int[][] one, int[][] two) {
		int[][] arr = new int[one.length][one.length];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				arr[i][j] = one[i][j] + two[i][j];
			}
		}
		return arr;
	}

	/**
	 * Вычисляет произведение двух матриц
	 * @param a - первая матрица
	 * @param b - вторая матрица
	 * @return произведение матриц
	 */
	public static int[][] productMatrix(int[][] a, int[][] b) {
		int[][] c = new int[a.length][a[0].length];
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c.length; j++) {
				for(int k = 0; k < c.length; k++) {
                  c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	/**
	 * Вычисляет произведение матрицы на скаляр
	 * @param matrix - матрица
	 * @param num - скаляр
	 * @return произведение матрицы на скаляр
	 */
	public static int[][] productMatrix(int[][] matrix, int num) {
		// TODO: удалите исключение и пишите здесь код
		int[][] arr = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] = matrix[i][j] * num;
			}
		}
	}

	/**
	 * Вычисляет детерминант матрицы
	 * @param matrix - матрица
	 * @return детерминант матрицы
	 */
	public static int determinant(int[][] matrix) {
		int d = 0;
		if(matrix.length == 2 && matrix.length == 2) {
			d = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}
		else if(matrix.length == 3 && matrix.length == 3) {
			d = matrix[0][0] * determinant(subMatrix(0, 0, matrix));
			- matrix[0][1] * determinant(sumMatrix(0, 1, matrix))
					+ matrix[0][2] * determinant(sumMatrix(0, 2, matrix));
		}
		return d;
	}
	private static int[][] subMatrix(int _i, int _j, int[][] matrix) {
		int[][] arr = new int[matrix.length - 1][matrix[0].length - 1];
		int ii = 0;
		int jj = 0;
		for(int i = 0; i < matrix.length; i++) {
			if(i != _i) {
				for(int j = 0; j < matrix.length; j++) {
					if(j != _j) {
						arr[ii][jj] = matrix[i][j];
						jj++;
					}
				}
				ii++;
			}
		}
		return arr;
	}

	/**
	 * Печатает матрицу в стандартный поток вывода
	 * @param matrix - матрица
	 */
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
		System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
