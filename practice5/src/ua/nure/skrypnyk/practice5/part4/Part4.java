package ua.nure.skrypnyk.practice5.part4;

public class Part4 {
    public static void main(String[] args) {
        int[][] matrx = new int[4][100];
        Long before;
        MatrixUtils.fillMatrix(matrx);
        System.out.println("~~~~~~~~~~~~~~without threads~~~~~~~~");
        before = System.currentTimeMillis();
        System.out.println(MatrixUtils.foundMaxMatrxValue(matrx));
        System.out.print("time: ");
        System.out.println(System.currentTimeMillis() - before);
        System.out.println("~~~~~~~~~~~~~~via Threads~~~~~~~~~~~~");
        before = System.currentTimeMillis();
        System.out.println(MatrixUtils.foundMaxMatrixValueViaThreads(matrx));
        System.out.print("time: ");
        System.out.println(System.currentTimeMillis() - before);
    }
}
