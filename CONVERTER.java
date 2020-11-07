import java.util.*;
public class myproject {
    static Scanner sc=new Scanner(System.in);// 1st SCANNER
    static Scanner sc1=new Scanner(System.in);// 2nd SCANNER TO PREVENT THE WELL KNOWN SCANNER PROBLEM(?)
    static int tn,cn,i,signfig;// tn=THE TYPE OF THE NUMBER ;cn=THE TYPE TO BE CONVERTED;i=loop
                               // variable;signfig=the number of significant figures after '.' if'.' is
                               // available
    static String n;// TO INPUT THE NUMBER
    static boolean decimal, programterminator = false;// decimal=TO CHECK IF DECIMAL IS AVAILABLE;programterminator=TO
                                                      // TERMINATE THE PROGRAM

    public static void main(String[] args)
        {
            decimal=false;
            if(programterminator==false)
            {
                INPUT();
                if(programterminator==false)
                {
                    Convert(n,tn,cn);
                    Display();
                }
            }
            else
            {
                System.out.println("*PROGRAM TERMINATED*");
            }
        }

    private static void INPUT()
        {
            System.out.println("ENTER The Type of the number");
            System.out.println("ENTER\n1. FOR DECIMAL\n2. FOR BINARY\n3. FOR OCTAL\n4. FOR HEXADECIMAL\n0. TO TERMINATE THE PROGRAM");
            int space=1;
            boolean check=false;
            while(!((tn=sc.nextInt())>0&&tn<=4))
            {
                if(tn!=0)
                {
                    System.out.println("WRONG CHOICE");
                }
                else
                {
                    programterminator=true;
                    break;
                }
            }
            if(programterminator==false)
            {
                System.out.println("ENTER THE NUMBER");
                while(space>0||check==false)
                {
                    space=0;
                    n=sc1.nextLine().trim();
                    if(n.length()==1&&n.charAt(0)=='0')
                    {
                        programterminator=true;
                        break;
                    }
                    for(i=0;i<n.length();i++)
                    {
                        if(n.charAt(i)==' ')
                        {
                            space++;
                        }
                    }
                    if(space>0)
                    {
                        System.out.println("THERE CANNOT BE ANY BLANK SPACE IN A NUMBER");
                    }
                    n=n.replace('a','A');
                    n=n.replace('b','B');
                    n=n.replace('c','C');
                    n=n.replace('d','D');
                    n=n.replace('e','E');
                    check=Check(n,tn);
                    if(check==false)
                    {
                        System.out.println("THE TYPE DOES NOT MATCH");
                    }
                    else if(check==true&&decimal==true)
                    {
                        System.out.println("ENTER THE NUMBER OF SIGNIFICANT FIGURES AFTER DECIMAL");
                        signfig=sc.nextInt();
                    }
                }
                if(programterminator==false)
                {
                    System.out.println("ENTER THE TYPE TO BE CONVERTED");
                    System.out.println("ENTER\n1. FOR DECIMAL\n2. FOR BINARY\n3. FOR OCTAL\n4. FOR HEXADECIMAL\n0. TO TERMINATE THE PROGRAM");
                    while(!((cn=sc.nextInt())>0&&cn<=4))
                    {
                        if(cn!=0)
                        {
                            System.out.println("WRONG CHOICE");
                        }
                        else
                        {
                            programterminator=true;
                            main(null);
                            break;
                        }
                    }
                    if(n.charAt(0)=='.')
                    {
                        n="0"+n;
                    }
                    if(n.substring(n.indexOf('.')+1,n.length()).length()<=1&&n.charAt(n.indexOf('.')+1)=='0')
                    {
                        n=n.substring(0,n.indexOf('.'));
                    }
                }
                else
                {
                    main(null);
                }
            }
            else
            {
                main(null);
            }
        }

    static boolean Check(String st, int type)// TO CHECK IF THE TYPE OF THE NUMBER IS SAME AS THE TYPE STATED BY THE
                                             // USER
    {
        boolean d = false;
        int deci = 0;
        if (type == 1) {
            for (i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '1' || st.charAt(i) == '2' || st.charAt(i) == '3' || st.charAt(i) == '4'
                        || st.charAt(i) == '5' || st.charAt(i) == '6' || st.charAt(i) == '7' || st.charAt(i) == '8'
                        || st.charAt(i) == '9' || st.charAt(i) == '0' || st.charAt(i) == '.') {
                    if (st.charAt(i) == '.') {
                        deci++;
                    }
                    d = true;
                } else {
                    d = false;
                    break;
                }
            }
        } else if (type == 2) {
            for (i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '1' || st.charAt(i) == '0' || st.charAt(i) == '.') {
                    if (st.charAt(i) == '.') {
                        deci++;
                    }
                    d = true;
                } else {
                    d = false;
                    break;
                }
            }
        } else if (type == 3) {
            for (i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '1' || st.charAt(i) == '2' || st.charAt(i) == '3' || st.charAt(i) == '4'
                        || st.charAt(i) == '5' || st.charAt(i) == '6' || st.charAt(i) == '7' || st.charAt(i) == '0'
                        || st.charAt(i) == '.') {
                    if (st.charAt(i) == '.') {
                        deci++;
                    }
                    d = true;
                } else {
                    d = false;
                    break;
                }
            }
        } else {
            for (i = 0; i < st.length(); i++) {
                if (st.charAt(i) == '1' || st.charAt(i) == '2' || st.charAt(i) == '3' || st.charAt(i) == '4'
                        || st.charAt(i) == '5' || st.charAt(i) == '6' || st.charAt(i) == '7' || st.charAt(i) == '8'
                        || st.charAt(i) == '9' || st.charAt(i) == '0' || st.charAt(i) == '.' || st.charAt(i) == 'A'
                        || st.charAt(i) == 'B' || st.charAt(i) == 'C' || st.charAt(i) == 'D' || st.charAt(i) == 'E') {
                    if (st.charAt(i) == '.') {
                        deci++;
                    }
                    d = true;
                } else {
                    d = false;
                    break;
                }
            }
        }
        if (deci > 1) {
            d = false;
        }
        if (deci == 1) {
            decimal = true;
        }
        return (d);
    }

    static String Convert(String tempn, int type, int convtype)// TO CONVERT IT TO THE DESIRED TYPE
    {
        tn = type;
        cn = convtype;
        String con1 = "";
        String con2 = "";
        int div = 1, m1 = 1;
        if (type != cn) {
            if (decimal == true) {
                con1 = tempn.substring(0, tempn.indexOf('.'));
                con2 = "0." + tempn.substring(tempn.indexOf('.') + 1, tempn.length());
            } else {
                con1 = tempn;
            }
            if (type == 1) {
                tempn = n;
                if (convtype == 2) {
                    div = 2;
                } else if (convtype == 3) {
                    div = 8;
                } else if (convtype == 4) {
                    div = 16;
                }
                if (decimal == true) {
                    String hex = "", bin = "";
                    while (Integer.parseInt(con1) != 0) {
                        if (convtype == 4) {
                            String temp = Double.toString(Integer.parseInt(con1) % div);
                            temp = temp.substring(0, temp.indexOf('.'));
                            if (Integer.parseInt(temp) >= 10) {
                                temp = Character.toString((char) (Integer.parseInt(temp) + (55)));
                            }
                            hex = temp + hex;
                        } else {
                            bin = Double.toString(Integer.parseInt(con1) % div).substring(0, 1) + bin;
                        }
                        con1 = Integer.toString(Integer.parseInt(con1) / div);
                    }
                    hex = hex + ".";
                    bin = bin + ".";
                    i = 0;
                    while (Double.parseDouble(con2) != 0) {
                        i++;
                        con2 = Double.toString(Double.parseDouble(con2) * div);
                        if (convtype == 4) {
                            if (Integer.parseInt(con2.substring(0, con2.indexOf('.'))) >= 10) {
                                hex = hex + (char) ((Integer.parseInt(con2.substring(0, con2.indexOf('.')))) + 55);
                            } else {
                                hex = hex + con2.substring(0, con2.indexOf('.'));
                            }
                            con2 = con2.substring(con2.indexOf('.'), con2.length());
                        } else {
                            bin = bin + (Integer.parseInt(con2.substring(0, 1)));
                            con2 = con2.substring(con2.indexOf('.'), con2.length());
                        }
                        if (i >= signfig) {
                            break;
                        }
                    }
                    if (convtype == 4) {
                        n = hex;
                    } else {
                        n = bin;
                    }
                } else {
                    String hex = "", bin = "";
                    while (Integer.parseInt(con1) != 0) {
                        if (convtype == 4) {
                            String temp = Double.toString(Integer.parseInt(con1) % div);
                            temp = temp.substring(0, temp.indexOf('.'));
                            if (Integer.parseInt(temp) >= 10) {
                                temp = Character.toString((char) (Integer.parseInt(temp) + (55)));
                            }
                            hex = temp + hex;
                        } else {
                            bin = Double.toString(Integer.parseInt(con1) % div).substring(0, 1) + bin;
                        }
                        con1 = Integer.toString(Integer.parseInt(con1) / div);
                    }
                    if (convtype == 4) {
                        n = hex;
                    } else {
                        n = bin;
                    }
                }
            } else {
                if (type == 2) {
                    m1 = 2;
                } else if (type == 3) {
                    m1 = 8;
                }
                if (type == 4) {
                    m1 = 16;
                    if (decimal == true) {
                        long lt = 0;
                        double dt = 0;
                        for (i = 0; i < con1.length(); i++) {
                            int temp = 0;
                            if (con1.charAt(con1.length() - 1 - i) == 'A' || con1.charAt(con1.length() - 1 - i) == 'B'
                                    || con1.charAt(con1.length() - 1 - i) == 'C'
                                    || con1.charAt(con1.length() - 1 - i) == 'D'
                                    || con1.charAt(con1.length() - 1 - i) == 'E') {
                                temp = (int) (con1.charAt(con1.length() - 1 - i) - 55);
                            } else {
                                temp = Integer.parseInt(Character.toString(con1.charAt(con1.length() - 1 - i)));
                            }
                            lt = lt + (long) (temp * (Math.pow(m1, i)));
                        }
                        i = 0;
                        while (Double.parseDouble(con2) != 0) {
                            i++;
                            int temp = 0;
                            if (con2.charAt(con2.length() - 1 - i) == 'A' || con2.charAt(con2.length() - 1 - i) == 'B'
                                    || con2.charAt(con2.length() - 1 - i) == 'C'
                                    || con2.charAt(con2.length() - 1 - i) == 'D'
                                    || con2.charAt(con2.length() - 1 - i) == 'E') {
                                temp = (int) (con2.charAt(con2.length() - 1 - i) - 55);
                            } else {
                                temp = Integer.parseInt(Character.toString(con2.charAt(con2.length() - 1 - i)));
                            }
                            dt = dt + (temp / (Math.pow(m1, i + 1)));
                            if (i >= signfig) {
                                break;
                            }
                        }
                        n = Long.toString(lt) + Double.toString(dt).substring(Double.toString(dt).indexOf('.'),
                                Double.toString(dt).length());
                        tn = 1;
                        Convert(n, tn, cn);
                    } else {
                        long lt = 0;
                        for (i = 0; i < tempn.length(); i++) {
                            int temp = 0;
                            if (tempn.charAt(tempn.length() - 1 - i) == 'A'
                                    || tempn.charAt(tempn.length() - 1 - i) == 'B'
                                    || tempn.charAt(tempn.length() - 1 - i) == 'C'
                                    || tempn.charAt(tempn.length() - 1 - i) == 'D'
                                    || tempn.charAt(tempn.length() - 1 - i) == 'E') {
                                temp = (int) (tempn.charAt(tempn.length() - 1 - i) - 55);
                            } else {
                                temp = Integer.parseInt(Character.toString(tempn.charAt(tempn.length() - 1 - i)));
                            }
                            lt = lt + (long) (temp * (Math.pow(m1, i)));
                        }
                        n = Long.toString(lt);
                        tn = 1;
                        Convert(n, tn, cn);
                    }
                } else {
                    if (decimal == true) {
                        long lt = 0;
                        double dt = 0;
                        for (i = 0; i < con1.length(); i++) {
                            lt = lt + (Long.parseLong(Character.toString(con1.charAt(con1.length() - 1 - i)))
                                    * (long) (Math.pow(m1, i)));
                        }
                        for (i = 0; i < con2.length() - 2; i++) {
                            dt = dt + ((Double.parseDouble(Character.toString(con2.charAt(i + 2)))
                                    / Math.pow(m1, i + 1)));
                        }
                        n = Double.toString((double) lt + dt);
                        tn = 1;
                        Convert(n, tn, cn);
                    } else {
                        long lt = 0;
                        for (i = 0; i < tempn.length(); i++) {
                            lt = lt + (Long.parseLong(Character.toString(con1.charAt(con1.length() - 1 - i)))
                                    * (long) (Math.pow(m1, i)));
                        }
                        n = Long.toString(lt);
                        tn = 1;
                        Convert(n, tn, cn);
                    }
                }
            }
        }
        return (tempn);
    }

    private static void Display() {
        System.out.println("THE NUMBER IS " + n);
        System.out.println("ELSE ENTER 0 TO EXIT\nelse enter something else to continue");
        char st = sc.next().trim().charAt(0);
        System.out.println(st);
        if (st == '0') {
            System.out.println("*PROGRAM TERMINATED*");
            System.exit(0);
        } else {
            main(null);
        }
    }
}
