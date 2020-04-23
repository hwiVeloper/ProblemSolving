package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {
	class Solution {
		public int[] solution(String[] genres, int[] plays) {
			int[] answer = {};

			Map<Integer, String> mapGenres = new HashMap<Integer, String>();
			Map<Integer, Integer> mapPlays = new HashMap<Integer, Integer>();

			for (int i = 0; i < genres.length; i++) {
				mapGenres.put(i, genres[i]);
				mapPlays.put(i, plays[i]);
			}

			Map<String, Integer> playCountByGenres = new HashMap<String, Integer>();

			for (int i = 0; i < genres.length; i++) {
				if (playCountByGenres.containsKey(genres[i])) {
					playCountByGenres.put(genres[i], playCountByGenres.get(genres[i]) + plays[i]);
				} else {
					playCountByGenres.put(genres[i], plays[i]);
				}
			}

			List<Map.Entry<String, Integer>> sortedPlayCountByGenres = new ArrayList<Map.Entry<String, Integer>>(playCountByGenres.entrySet());
			Collections.sort(sortedPlayCountByGenres, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o1.getValue().compareTo(o2.getValue()) * -1; // desc
				}
			});

			List<Integer> answerIndex = new ArrayList<Integer>();

			for (int i = 0; i < sortedPlayCountByGenres.size(); i++) {
				String genre = sortedPlayCountByGenres.get(i).getKey();

				int[] tmpArr;
				int cnt = 0;
				for (int idxGenre : mapGenres.keySet()) {
					if (mapGenres.get(idxGenre).toString().equals(genre)) {
						cnt += 1;
					}
				}

				tmpArr = new int[cnt];
				int tmpIdx = 0;
				for (int idxGenre : mapGenres.keySet()) {
					if (mapGenres.get(idxGenre).equals(genre)) {
						tmpArr[tmpIdx] = mapPlays.get(idxGenre);
						tmpIdx++;
					}
				}

				if (cnt != 1) {
					Arrays.sort(tmpArr);
					for (int k = tmpArr.length - 1; k >= tmpArr.length - 2; k--) {
						for (int play : mapPlays.keySet()) {
							if (tmpArr[k] == mapPlays.get(play)) {
								answerIndex.add(play);
								mapPlays.put(play, 0);
								break;
							}
						}
					}
				} else {
					for (int play : mapPlays.keySet()) {
						if (tmpArr[0] == mapPlays.get(play)) {
							answerIndex.add(play);
							break;
						}
					}
				}
			}

			answer = new int[answerIndex.size()];
			for (int i = 0; i < answerIndex.size(); i++) {
				answer[i] = answerIndex.get(i);
			}

			return answer;
		}
	}
}
