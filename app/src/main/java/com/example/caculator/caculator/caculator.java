package com.example.caculator.caculator;

import java.util.Scanner;

public class caculator
{
    int i = 0;
    public String e = null;

    public void claer ()
    {
        e = null;
        i = 0;
    }
    public void backspace ()
    {
        if (e != null )
        {
            if(e.length() > 0)
            e = e.substring(0,e.length()-1);
        }
    }
    public void editExpree(String ex)
    {
        if (e == null)
            e = ex;
        else
            e = e+ex;
    }
    public String exe ()
    {
        if (e == null)
            return "";
        i = 0;
        try
        {
            String s = Double.toString(this.plus());

            return s;
        }
        catch(Exception e) {
           return null;
        }
    }
    public String gete()
    {
        if (e == null)
            return "";
        return e;
    }
    private double getNumber()
    {
        double ret = 0;
        if (e.charAt(i) == '(')
        {
            i++;
            ret = plus();
        }
        else if (e.charAt(i) == 'l')
        {
            i += 2;
            ret = Math.log(getNumber());
        }
        else if (e.charAt(i) == 'P')
        {
            i += 2;
            ret = Math.PI;
        }
        else if (e.charAt(i) == 'e')
        {
            i ++;
            ret = Math.E;
        }
        else if (e.charAt(i) == 'c')
        {
            i += 3;
            ret = Math.cos(getNumber());
        }
        else if (e.charAt(i) == 's')
        {
            i += 3;
            ret = Math.sin(getNumber());
        }
        else if (e.charAt(i) == 't')
        {
            i += 3;
            ret = Math.tan(getNumber());
        }
        else
        {
            int j = i;
            for (;i<e.length() &&  ((i ==j && e.charAt(i) == '-') || (i != j && (e.charAt(i) == '.')) || e.charAt(i) >= '0' && e.charAt(i) <= '9');i++);
            //		System.out.println(e.substring(j,i));
            ret = Double.parseDouble(e.substring(j,i));
        }

        if (i < e.length() && e.charAt(i) == '^')
        {
            i++;
            return Math.pow(ret,getNumber());
        }

        return ret;
    }
    private double plus ()
    {
        if(i>=e.length())
            return 0;
        if( e.charAt(i) == ')')
        {
            i++;
            return 0;
        }
        if( e.charAt(i) == '+')
        {
            i++;
        }
        return mult()+plus();
    }
    private double mult	()
    {
        if(i>=e.length())
            return 1;
        if( e.charAt(i) == ')')
        {
            return 1;
        }
        double r = 1;
        if (e.charAt(i) == '-')
        {
            i++;
            r = -1.0*getNumber();
        }
        else if (e.charAt(i) == '/')
        {
            i++;
            r = 1.0 / getNumber();
        }
        else if (e.charAt(i) == '*')
        {
            i++;
            r = getNumber();
        }
        else
        {
            r = getNumber();
        }
        if (i < e.length()&&(e.charAt(i) == '+' ||e.charAt(i) == '-'))
        {
            return r;
        }
        return r*mult();
    }

}

