package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		boolean valid = inputValidation(array);

		if (valid) {

			return buscaBinariaFloor(array, x, 0, array.length - 1);
		}

		return null;
	}

	private Integer buscaBinariaFloor(Integer[] array, Integer x, int begin, int end) {
		int middle = (begin + end) / 2;

		if (begin > end)
			return array[end];

		if (x < array[middle])
			return buscaBinariaFloor(array, x, begin, middle - 1);
		else if (x > array[middle])
			return buscaBinariaFloor(array, x, middle + 1, end);
		else
			return array[middle];

	}

	private boolean inputValidation(Integer[] array) {
		if (array == null)
			return false;
		if (array.length > 0)
			return false;

		return true;
	}

}
