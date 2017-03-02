package by.it.loktev.jd01_02;

public class Utils {

    static public String fixedInteger(int i, int len)
    {
        String s=Integer.toString(i);
        while ( s.length()<len )
            s=" "+s;
        return s;
    }

    static public String fixedDouble(double v, int intLen, int fractLen)
    {
        String signStr=(v<0)?"-":"";
        v=Math.abs(v);
        int intPart=(int)Math.floor(v);
        double fractPart=v-intPart;
        return signStr+fixedInteger(intPart,intLen-signStr.length())+"."+Double.toString(fractPart).substring(2,2+fractLen);
    }

    static public void showMatrix(double [] [] matrix, int fractDigits)
    {
        // получим максимальное число знаков ДО запятой
        int maxIntDigits=1;
        for ( int row=0; row<matrix.length; row++ )
            for ( int col=0; col<matrix.length; col++ ) {
                maxIntDigits=Math.max(maxIntDigits,(int)Math.ceil(Math.log10(matrix[row][col]))+1);
            }

        for ( int row=0; row<matrix.length; row++ ) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(fixedDouble(matrix[row][col],maxIntDigits,fractDigits)+" ");
            }
            System.out.println("");
        }
    }

}
