
package com.sendmail;

public class MailSendDemo
{
    public static void main(String[] args)
    {
        try
        {
            TestSendMail.sendMail("xxx@gmail.com");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
