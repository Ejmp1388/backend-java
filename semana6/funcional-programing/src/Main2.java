import concurrent.EmailService;
import concurrent.ReportService;
import concurrent.SmsService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      //  ExecutorService pool= Executors.newFixedThreadPool(2);
        EmailService emailService=new EmailService();
        SmsService smsService=new SmsService();
        ReportService reportService=new ReportService();

        Supplier<Boolean> reportSupplier=()->reportService.report();
        Consumer<Boolean> consumer=booleano ->System.out.println("el resultado fue "+booleano);
        //le digo que debe hacer asincronamente
        CompletableFuture<Boolean> reportCompletableFuture=CompletableFuture.supplyAsync(reportSupplier);//supplier respuesta del reporte
        //asincronamente le digo que hacer con el resultado
        reportCompletableFuture.thenAccept(consumer);// impre reporte cuando llegue

        //veresion resumida
        CompletableFuture.supplyAsync(()->reportService.report())
                .thenAccept(booleano ->System.out.println("el resultado resumido fue "+booleano));
        System.out.println("no interrumple hilo principal");

        //cuenta cantidad caractres de salida
        Function<String, Integer> contarCaracteres=str->str.length();
        Consumer<Integer> impresor=numero->System.out.println(numero);
        CompletableFuture.supplyAsync(()->reportService.report2())
                .thenApply(contarCaracteres)
                .thenAccept(impresor);

        Thread.sleep(7000);
    }
}
