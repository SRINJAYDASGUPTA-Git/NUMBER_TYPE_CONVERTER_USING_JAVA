package Public.converter;
public class Decimal
{
    public static String toBinary(double dec)
    {
        String bin=""; int dec_in,d;double dec_frac;
        dec_in=(int)dec;
        dec_frac=dec-dec_in;
        while(dec_in!=0)
        {
            d=dec_in%2;
            bin=Integer.toString(d)+bin;
            dec_in/=2;
        }
        bin=bin+".";
        for(int i=0;i<5;i++)
        {
            dec_frac*=2;
            int fract_bit = (int) dec_frac; 

            if (fract_bit == 1) 
            {
                dec_frac -= fract_bit; 
                bin+= (char)(1 + '0'); 
            } 
            else
            { 
                bin += (char)(0 + '0'); 
            } 
        }
        return bin;
    }

    public static String toHexadecimal (double dec)
    {
        int r,n;
        String hex="";
        n=(int)dec;
        char dig[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n!=0)
        {
            r=n%16;
            hex=dig[r]+hex;
            n=n/16;
        }
        hex=hex+".";
        double f=dec-((int)dec);
        
        for(int i=0;i<5;i++)
        {
            f*=16;
            int fract_bit = (int) f; 
            f=f-fract_bit;
            hex += dig[fract_bit];
        }

        return hex;
    }

    public static String toOctal(double dec)
    {
        int r,n;
        String oct="";
        n=(int)dec;

        char dig[]={'0','1','2','3','4','5','6','7'};
        while(n!=0)
        {
            r=n%8;
            oct=dig[r]+oct;
            n=n/8;
        }
        oct=oct+".";
        double f=dec-((int)dec);
        for(int i=0;i<5;i++)
        {
            f*=8;
            int fract_bit = (int) f; 
            f=f-fract_bit;
            oct += dig[fract_bit];
        }
        return oct;
    }
}