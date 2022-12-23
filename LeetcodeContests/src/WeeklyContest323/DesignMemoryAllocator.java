package WeeklyContest323;

import java.util.Arrays;

public class DesignMemoryAllocator {

	int arr[];
	int n;

	public DesignMemoryAllocator(int n) {
		arr = new int[n];
		Arrays.fill(arr, -1);
		this.n = n;
	}

	public int allocate(int size, int mID) {
		int i = 0;
		while (i < n) {
			int c = 0;
			for (int j = i; j < i + size; j++) {
				if (j < n) {
					if (arr[j] == -1) {
						c++;
					} else {
						i = j + 1;
						c = 0;
						break;
					}
				} else {
					return -1;
				}

			}
			if (c == size) {
				for (int j = i; j < i + size; j++) {
					arr[j] = mID;
				}
				return i;
			}
		}
		return -1;
	}

	public int free(int mID) {
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == mID) {
				arr[i] = -1;
				c++;
			}
		}
		return c;
	}

}
