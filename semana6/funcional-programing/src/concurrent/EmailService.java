package concurrent;

public class EmailService {
    public void sendEmail(){
        System.out.println("empece a enviar el correo");
        try {
            Thread.sleep(7000);

        }catch (InterruptedException ex){

        }

        System.out.println("Correo enviado");
    }
}
