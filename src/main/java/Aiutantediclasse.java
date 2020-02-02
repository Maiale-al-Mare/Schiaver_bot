import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.vdurmont.emoji.EmojiParser;


public class Aiutantediclasse extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Ho ricevuto un messaggio!");
        System.out.println(update);
        System.out.println(update.getMessage().getText());
        SendMessage m = new SendMessage();
     if(update.getMessage().getText().equals("/start")&&(update.getMessage().isChannelMessage())){
         m.setChatId(update.getMessage().getChatId());
         m.setText("Ciao!Questo bot va usato nei gruppi!");
         try{
             execute(m);
         }catch(TelegramApiException e){
             e.printStackTrace();
         }

     }
    }

    @Override
    public String getBotUsername() {
        return "@aiutantediclasse_bot";
    }

    @Override
    public String getBotToken() {
        return "939489838:AAE0njH1ssdeR62HqZeI6sOwl57v3fJZZFg";
    }
}
