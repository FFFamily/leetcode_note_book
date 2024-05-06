package 图;

public class 矩阵置零 {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] matrixCopy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrixCopy[i][j] == 1){
                    // 被变换过
                    continue;
                }
                if (matrix[i][j] == 0){
                    for (int k = 0; k < matrix.length; k++) {
                        if (check(matrix[k][j])){
                            matrix[k][j] = 0;
                            matrixCopy[k][j] = 1;
                        }
                    }
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (check( matrix[i][k])){
                            matrix[i][k] = 0;
                            matrixCopy[i][k] = 1;
                        }

                    }
                }
            }
        }
    }

    public boolean check(int resource){
        return  resource != 0;
    }

}
