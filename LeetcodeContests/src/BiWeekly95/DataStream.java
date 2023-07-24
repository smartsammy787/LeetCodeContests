package BiWeekly95;

import java.util.ArrayDeque;
import java.util.Deque;

public class DataStream {

	Deque<Integer> list;
	int size;
	int target;
	int counter;

	public DataStream(int value, int k) {
		list = new ArrayDeque<Integer>(k);
		this.size = k;
		this.target = value;

		this.counter = 0;
	}

	public boolean consec(int num) {
		if (list.size() < size) {
			list.addLast(num);
			if (num == target) {
				counter = counter + 1;
			}

		} else {
			int rem = list.removeFirst();
			if (rem == target) {
				counter = counter - 1;
			}
			list.addLast(num);
			if (num == target) {
				counter = counter + 1;
			}
		}

		if (list.size() < size) {
			return false;
		} else {
			if (counter == size) {
				return true;
			} else {
				return false;
			}
		}

	}
}
