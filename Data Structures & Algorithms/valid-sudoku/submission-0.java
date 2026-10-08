class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rowList = new ArrayList<>();
        List<HashSet<Character>> colList = new ArrayList<>();
        List<HashSet<Character>> sqList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> sqSet = new HashSet();
            rowList.add(rowSet);
            colList.add(colSet);
            sqList.add(sqSet);
        }


        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                if (rowList.get(row).contains(c)) {
                    return false;
                }
                if (colList.get(col).contains(c)) {
                    return false;
                }
                int sq = (row / 3) * 3 + (col / 3);
                if (sqList.get(sq).contains(c)) {
                    return false;
                }
                rowList.get(row).add(c);
                colList.get(col).add(c);
                sqList.get(sq).add(c);
            }
        }

        return true;
    }
}
