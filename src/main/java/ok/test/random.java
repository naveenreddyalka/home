package ok.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class random {

	Integer row = 0;
	Integer col = 0;
	String[][] newSheetStrings;
	List<List<String>> sheet;

	public random(Integer row, Integer col) {
		super();
		this.row = row;
		this.col = col;
		this.sheet = new ArrayList<List<String>>();
		newSheetStrings = new String[row][col];
		for (int i = 0; i < row; i++) {
			List<String> column = new ArrayList<String>();
			for (int j = 0; j < col; j++) {
				column.add("");
			}
			sheet.add(column);
		}
	}

	private void update(int r, int c, String value) {
		sheet.get(r).set(c, value);
	}

	private void print() {

		for (List<String> col : sheet) {
			for (int i = 0; i < col.size(); i++) {
				System.out.print(col.get(i));
				if (i < (col.size() - 1)) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}

	public int maxSubArray(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			ans = Math.max(sum, ans);
			sum = Math.max(sum, 0);
		}
		return ans;
	}

	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		int zero = n;
		int i = 0;
		while (i < zero) {
			if (nums[i] == 0) {
				shiftEnd(nums, i, zero);
				zero--;
			} else {
				i++;
			}
		}

	}

	public static int shortestSubarray(int[] A, int K) {
		int min = Integer.MAX_VALUE;
		int z = 0;
		int n = A.length;
		int[] P = new int[n];
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + A[i];
			P[i] = sum;

			if (sum >= K) {
				min = Math.min(min, i - z + 1);
				while (z <= i && sum >= K) {
					min = Math.min(min, i - z + 1);
					sum = sum - A[z];
					z++;
				}
			} else if (sum <= 0) {
				sum = 0;
				z = i;
			}

		}

		while (z < n && sum >= K) {
			sum = sum - A[z];
			if (sum >= K) {
				z++;
				min--;
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static void shiftEnd(int[] nums, int i, int end) {
		int roll = nums[i];
		for (; i < end - 1; i++) {
			nums[i] = nums[i + 1];
		}
		nums[end - 1] = roll;
	}

	private static void shift(int[] nums, int end_zero, int c_zero) {
		int roll = nums[c_zero];
		for (int i = end_zero; i <= c_zero; i++) {
			int temp = nums[i];
			nums[i] = roll;
			roll = temp;
		}
	}

	public static int change(int amount, int[] coins, int current) {
		if (amount < 0)
			return 0;
		if (amount == 0)
			return 1;
		int count = 0;
		for (int i = current; i < coins.length; i++) {
			count = count + change(amount - coins[i], coins, i);
		}
		return count;
	}

	public static int change(int amount, int[] coins) {
		int[] P = new int[amount + 1];
		P[0] = 1;
		for (int coin : coins) {
			for (int j = 1; j < P.length; j++) {
				if (j >= coin) {
					P[j] = P[j - coin] + P[j];
				}
			}
		}

		return P[amount];
	}

	class pair {
		public int x;
		public int y;

		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public Queue<pair> getNeighbors(char[][] board, pair a) {
		Queue<pair> chars = new LinkedList<pair>();
		int x = a.x;
		int y = a.y;

		if (x + 1 < board.length && board[x + 1][y] == 'O') {
			chars.add(new pair(x + 1, y));
		}
		if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
			chars.add(new pair(x, y + 1));
		}
		if (y - 1 >= 0 && board[x][y - 1] == 'O') {
			chars.add(new pair(x, y - 1));
		}
		if (x - 1 >= 0 && board[x - 1][y] == 'O') {
			chars.add(new pair(x - 1, y));
		}

		return chars;
	}

	public void markT(char[][] board, int i, int j) {
		Queue<pair> chars = new LinkedList<pair>();
		chars.add(new pair(i, j));
		while (!chars.isEmpty()) {
			pair l = chars.poll();
			board[l.x][l.y] = 'T';
			chars.addAll(getNeighbors(board, l));
		}
	}

	public void solveBFS(char[][] board) {

		if (board.length == 0)
			return;

		int[] r = { 0, board.length - 1 };
		int[] c = { 0, board[0].length - 1 };

		for (int i = 0; i < board.length; i++) {
			for (int j : c) {
				if (board[i][j] == 'O')
					markT(board, i, j);
			}
		}

		for (int j = 0; j < board[0].length; j++) {
			for (int i : r) {
				if (board[i][j] == 'O')
					markT(board, i, j);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'T')
					board[i][j] = 'O';
			}
		}

	}

	public void solve(char[][] b) {
		int m = b.length;
		if (m == 0)
			return;
		int n = b[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (j == 0 || j == n - 1 || i == 0 || i == m - 1) {
					if (b[i][j] == 'O') {
						dfs(b, i, j, m, n);
					}
				}
			}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (b[i][j] != '1')
					b[i][j] = 'X';
				else
					b[i][j] = 'O';
			}
	}

	public void dfs(char[][] b, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n)
			return;
		if (b[i][j] == 'X' || b[i][j] == '1')
			return;
		b[i][j] = '1';
		dfs(b, i + 1, j, m, n);
		dfs(b, i - 1, j, m, n);
		dfs(b, i, j + 1, m, n);
		dfs(b, i, j - 1, m, n);
	}

	public static void main(String[] args) {
		// int[] a = { 1, 2, 5 };
		random r = new random(1, 1);
		char[][] board = {
				{ 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' },
				{ 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X' },
				{ 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O' },
				{ 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O' },
				{ 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O' },
				{ 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O' },
				{ 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O',
						'O' } };
		r.solve(board);
		System.out.println(board);

		/*
		 * int[] nums = {0,0,1}; moveZeroes(nums); System.out.println(nums);
		 * 
		 * random test = new random(4, 3); test.update(0, 0, "bob"); test.update(0, 1,
		 * "10"); test.update(0, 2, "foo");
		 * 
		 * test.update(1, 0, "alice"); test.update(1, 1, "5");
		 * 
		 * test.print();
		 */
	}
}
