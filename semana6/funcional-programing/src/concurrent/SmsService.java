package concurrent;

public class SmsService {
    public void sendSms(){
        System.out.println("empece a Enviar sms");
        try {
            Thread.sleep(4000);

        }catch (InterruptedException ex){

        }
        System.out.println("Envie sms");
    }
}
