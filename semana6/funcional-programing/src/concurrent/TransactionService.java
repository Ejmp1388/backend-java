package concurrent;


public class TransactionService {

    private final EmailService emailService=new EmailService();
    private final SmsService smsService=new SmsService();

    public void doTransaction(){
        System.out.println("Por enviar notificaciones");
        Thread t1=new Thread(()->emailService.sendEmail()); //demora 7 seg
        Thread t2=new Thread(()->smsService.sendSms()); //demora 4 seg
        t1.start();// esto ya no es problema del hilo main
        t2.start();// esto tampoco ya no es problema del hilo main

        //voy a esperar que t1 termine
        try {t1.join();} catch (InterruptedException e) { }//main queda bloqueado

        // emailService.sendEmail();
       // smsService.sendSms();


        System.out.println("notifiaciones enviadas");

    }
}
