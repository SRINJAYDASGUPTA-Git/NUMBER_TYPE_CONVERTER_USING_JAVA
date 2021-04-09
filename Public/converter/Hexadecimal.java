package Public.converter;
class Hexadecimal
{
    public static int toDecimal(String hexin)
    {
        String hex="0123456789ABCDEF";
        int dec=0,i,p,n,k;
        hexin=hexin.toUpperCase();
        p=hexin.length();
        k=p-1;
        for(i=0;i<p;i++)
        {
            char ch=hexin.charAt(i);
            if((int)ch>(int)('F'))
            {
                System.out.println("Invalid Hexadecimal no.");
                System.exit(0);
            }
            n=hex.indexOf(ch);
            dec=dec+(int)(n*(Math.pow(16,k)));
            k--;
            if(k<0)
                break;
        }
        return dec;
    }
    
     public static String toBinary(String hex)
    {
        double dec=toDecimal(hex);
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
    
    public static String toOctal(String hex)
    {
        double dec=toDecimal(hex);
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