package pl.rmv.schat;

import pl.rmv.schat.context.ApplicationContext;
import pl.rmv.schat.model.Status;

import java.util.Random;

public class Run {
    public static void main(String[] args) {
        Chat chat = ApplicationContext.getInstance().getChat();

        chat.registration("lena");
        chat.registration("adam");
        chat.registration("franek");
        chat.registration("dominika");

        chat.sendMessage("adam", "Cześć");
        timeout();
        chat.sendMessage("adam", "Kiedy do domu?");
        timeout();
        chat.sendMessage("lena", "Na Świętego Mikołaja =)");
        timeout();
        chat.sendMessage("dominika", "No to się poczeka =)");
        chat.changeStatus("dominika", Status.OFFLINE);
        timeout();
        chat.sendMessage("franek", "Eee tam, idę teraz!");
        chat.changeStatus("adam", Status.OFFLINE);
        chat.changeStatus("franek", Status.OFFLINE);
        chat.changeStatus("dominika", Status.ONLINE);
        timeout();
        chat.sendMessage("dominika", "Nie dostaniesz prezentu! =)");
    }

    private static void timeout() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(9000-3000+1)+3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------");
    }
}
