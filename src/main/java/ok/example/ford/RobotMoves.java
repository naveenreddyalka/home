package ok.example.ford;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RobotMoves {

	public static long playlist2(List<Integer> songs) {

		songs = songs.stream().map(i -> i % 60).map(i -> {
			if (i == 0)
				return 60;
			else
				return i;
		}).collect(Collectors.toList());

		Collections.sort(songs);

		int l = songs.size() - 1;
		int count = 0;
		int i = 0;

		while (i < l) {

			if (songs.get(i) + songs.get(l) > 60) {
				l--;
			} else if (songs.get(i) + songs.get(l) < 60) {
				i++;
			} else {
				count++;
				if (songs.get(i) == songs.get(i + 1)) {
					i++;
					continue;
				}

				if (songs.get(l) == songs.get(l - 1)) {
					l--;
					continue;
				}

				i++;
				l--;
			}
		}

		l = songs.size() - 1;
		i = 0;

		while (i < l) {

			if (songs.get(i) + songs.get(l) > 120) {
				l--;
			} else if (songs.get(i) + songs.get(l) < 120) {
				i++;
			} else {
				count++;
				if (songs.get(i) == songs.get(i + 1)) {
					i++;
					continue;
				}

				if (songs.get(l) == songs.get(l - 1)) {
					l--;
					continue;
				}

				i++;
				l--;
			}
		}

		return count;
	}

	public static long playlist(List<Integer> songs) {
		int n = songs.size();
		int zeron = 0;

		for (int i = 0; i < n; i++) {
			// if (songs.get(i) != 60) {
			if (songs.get(i) == 0)
				zeron++;

			songs.set(i, songs.get(i) % 60);
			// }
		}

		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {

			if (!hm.containsKey(songs.get(i))) {
				hm.put(songs.get(i), 0);
			}

			hm.put(songs.get(i), hm.get(songs.get(i)) + 1);
		}

		long count = 0;

		for (int i = 0; i < n; i++) {
			if (songs.get(i) == 0) {
				if (hm.get(0) != null) {
					count += hm.get(0);
					count--;
				}
			} else {
				if (hm.get(60 - songs.get(i)) != null)
					count += hm.get(60 - songs.get(i));

				if (60 - songs.get(i) == songs.get(i))
					count--;
			}
		}

		return (long) (count / 2);

	}

	public static void main(String[] args) {
		System.out.println(playlist(Arrays.asList(3, 60, 60, 60)));

	}
}