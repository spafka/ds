package com.atguigu.kmp;

import java.util.Arrays;

public class KMPAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		//String str2 = "BBC";
		
		int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
		System.out.println("next=" + Arrays.toString(next));
		
		int index = kmpSearch(str1, str2, next);
		System.out.println("index=" + index); // 15浜�
		
		
	}
	
	//鍐欏嚭鎴戜滑鐨刱mp鎼滅储绠楁硶
	/**
	 * 
	 * @param str1 婧愬瓧绗︿覆
	 * @param str2 瀛愪覆
	 * @param next 閮ㄥ垎鍖归厤琛�, 鏄瓙涓插搴旂殑閮ㄥ垎鍖归厤琛�
	 * @return 濡傛灉鏄�-1灏辨槸娌℃湁鍖归厤鍒帮紝鍚﹀垯杩斿洖绗竴涓尮閰嶇殑浣嶇疆
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		
		//閬嶅巻 
		for(int i = 0, j = 0; i < str1.length(); i++) {
			
			//闇�瑕佸鐞� str1.charAt(i) 锛�= str2.charAt(j), 鍘昏皟鏁磈鐨勫ぇ灏�
			//KMP绠楁硶鏍稿績鐐�, 鍙互楠岃瘉...
			while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1]; 
			}
			
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}			
			if(j == str2.length()) {//鎵惧埌浜� // j = 3 i 
				return i - j + 1;
			}
		}
		return  -1;
	}

	//鑾峰彇鍒颁竴涓瓧绗︿覆(瀛愪覆) 鐨勯儴鍒嗗尮閰嶅�艰〃
	public static  int[] kmpNext(String dest) {
		//鍒涘缓涓�涓猲ext 鏁扮粍淇濆瓨閮ㄥ垎鍖归厤鍊�
		int[] next = new int[dest.length()];
		next[0] = 0; //濡傛灉瀛楃涓叉槸闀垮害涓�1 閮ㄥ垎鍖归厤鍊煎氨鏄�0
		for(int i = 1, j = 0; i < dest.length(); i++) {
			//褰揹est.charAt(i) != dest.charAt(j) 锛屾垜浠渶瑕佷粠next[j-1]鑾峰彇鏂扮殑j
			//鐩村埌鎴戜滑鍙戠幇 鏈�  dest.charAt(i) == dest.charAt(j)鎴愮珛鎵嶉��鍑�
			//杩欐椂kmp绠楁硶鐨勬牳蹇冪偣
			while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j-1];
			}
			
			//褰揹est.charAt(i) == dest.charAt(j) 婊¤冻鏃讹紝閮ㄥ垎鍖归厤鍊煎氨鏄�+1
			if(dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
