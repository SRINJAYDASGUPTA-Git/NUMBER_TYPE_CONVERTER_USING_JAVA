package Public.converter;
public class Octal
{
    public static double toDecimal(double oct)
    {
        double dec_out,dec1=0.0,dec2=0.0;String oct_s,oct_in,oct_frac;int pi,i,p;char ch;
        oct_s=Double.toString(oct);
        pi=oct_s.indexOf(".");
        oct_in=oct_s.substring(0,pi);
        oct_frac=oct_s.substring(pi+1);
        p=oct_in.length();
        int k=0;
        for(i=(p-1);i>=0;i--)
        {
            ch=oct_in.charAt(i);
            if(Integer.parseInt(String.valueOf(ch))>7)
            {
                System.out.println("Invalid Octal No.");
                System.exit(0);
            }
            int temp=Integer.parseInt(String.valueOf(ch));
            dec1=dec1+(temp*Math.pow(8,k));
            k++;	
        }
        p=oct_frac.length();
        for(i=0;i<p;i++)
        {
            ch=oct_frac.charAt(i);
            if(Integer.parseInt(String.valueOf(ch))>7)
            {
                System.out.println("Invalid Octal No.");
                System.exit(0);
            }
            int temp=Integer.parseInt(String.valueOf(ch));
            dec2=dec2+(temp*Math.pow(8,-(i+1)));
        }
        dec_out=dec1+dec2;
        return dec_out;
    }
    
    public static String toBinary(double oct)
    {
        double dec=toDecimal(oct);
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
    
    public static String toHexadecimal(double oct)
    {
        double dec=toDecimal(oct);
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