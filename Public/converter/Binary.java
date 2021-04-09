package Public.converter;
public class Binary
{
    public static double toDecimal(double bin)
    {
        double dec_out,dec1=0.0,dec2=0.0;String bin_s,bin_in,bin_frac;int pi,i,p;char ch;
        bin_s=Double.toString(bin);
        pi=bin_s.indexOf(".");
        bin_in=bin_s.substring(0,pi);
        bin_frac=bin_s.substring(pi+1);
        p=bin_in.length();
        int k=0;
        for(i=(p-1);i>=0;i--)
        {
            ch=bin_in.charAt(i);
            if(Integer.parseInt(String.valueOf(ch))>1)
            {
                System.out.println("Invalid Binary No.");
                System.exit(0);
            }
            int temp=Integer.parseInt(String.valueOf(ch));
            dec1=dec1+(temp*Math.pow(2,k));
            k++;	
        }
        p=bin_frac.length();
        for(i=0;i<p;i++)
        {
            ch=bin_frac.charAt(i);
            if(Integer.parseInt(String.valueOf(ch))>1)
            {
                System.out.println("Invalid Binary No.");
                System.exit(0);
            }
            int temp=Integer.parseInt(String.valueOf(ch));
            dec2=dec2+(temp*Math.pow(2,-(i+1)));
        }
        dec_out=dec1+dec2;
        return dec_out;
    }
    
    public static String toOctal(double bin)
    {
        double dec=toDecimal(bin);
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
    
    public static String toHexadecimal(double bin)
    {
        double dec=Binary.toDecimal(bin);
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
}