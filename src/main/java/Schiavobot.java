import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class Schiavobot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage m = new SendMessage();
        SendAnimation a = new SendAnimation();
        SendDocument d = new SendDocument();
        SendSticker s = new SendSticker();
        EditMessageText nmsg = new EditMessageText();

        System.out.println("Ho ricevuto un messaggio!");
        System.out.println(" Update :\n" +
                "Text :" + update.getMessage().getText());
        System.out.println("ChatID :" + update.getMessage().getChatId());
        System.out.println("Chat :" + update.getMessage().getChat());
        System.out.println("From :" + update.getMessage().getFrom());
        if (update.getMessage().hasSticker()) {
            System.out.println("Sticker file_id :" + update.getMessage().getSticker().getFileId());
            safeSendUpdate(update, m, "", update.getMessage().getSticker().getFileId());
        } else if (update.getMessage().hasDocument()) {
            System.out.println("Document file_id :" + update.getMessage().getDocument().getFileId());
            safeSendUpdate(update, m, "", update.getMessage().getDocument().getFileId());
        } else if (update.getMessage().hasPhoto()) {
            ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
            String photofile_id = "file_id :" + photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            System.out.println("Photo file_id :" + photofile_id);
            safeSendUpdate(update, m, "", photofile_id);
        } else if (updateHasText(update, "/chi")) {
            safeSendUpdate(update, m, "", "Questo è un progetto(schiavo, del gruppo(ci volevamo solo dare un nome boh) Ver.boH) frutto della curiosità di due ragazzi(ni) di scoprire un nuovo mondo: quello della programmazione.\n" +
                    "Ci interessiamo principalmente di java, ma vogliamo anche cominciare ad usare altri linguaggi.\n" +
                    "Questa è la parte funzionante su telegram tel proj, ma ce n'è un' altra, quella sui nostri computer(che solo noi abbiamo" + EmojiParser.parseToUnicode(":smiling_imp:") + ") , che continuamo ad ampliare.\n" +
                    "*Eh, che dici, Eu? No, non gliel'ho detto che possono scaricare il progetto intero con /src usando la password SonoScemo, ovvio! Che, pensi che sia scemo?*\n" +
                    "In essa mettiamo tutto quello che sappiamo fare, tanto per.\n" +
                    "Speriamo che Schiavo ti piaccia, anche se al momento la parte che puoi usare tu è MOLTO ristretta.\n" +
                    "Eu e Gabri\n" + EmojiParser.parseToUnicode(":stuck_out_tongue_winking_eye:"));

        } else if (updateHasText(update, "/start") || updateHasText(update, "Ciao")) {
            safeSendUpdate(update, s, "", "CAACAgIAAxkBAAIPp142w9opqZieTbBK_5Do45KQxYJgAAIIAAPANk8Tb2wmC94am2kYBA");
            sleepFor(1);
            safeSendUpdate(update, m, "", "Ciao! Benvenuto allo Schiaver_bot!\nManda /chi per avere ulteriori informazioni");
        } else if (updateHasText(update, "/aggiorna")) {
            safeSendUpdate(update, m, "", "Questa funzione non è ancora disponibile..." + EmojiParser.parseToUnicode(":pensive:"));
        } else if (updateHasText(update, "/src")) {
            safeSendUpdate(update, m, "", "Comunque stavo scherzando, non c'è bisogno di una password");
            sleepFor(1);
            safeSendUpdate(update, m, "", "Però la cosa si sta rivelando più difficile del previsto:/\n" +
                    "Ti avviseremo *FORSE* appena sarà possibile\n" +
                    "GIURO CHE NON SONO SUPER PROTETTIVO DEL PROGETTO, OK? E' SOLO MOLTO DIFFICILE ED IO SONO SCEMO E AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH");
            sleepFor(7);
            safeSendUpdate(update, d, "", "BQACAgQAAxkBAAIPVl42g5wZ6YqeZkfOPcf0zYLKnqUcAAINBwAC2t3ZUTQjmtPCCD5tGAQ", "jk tieni. Non ho fatto tutte le modifiche necessarie per farlo funzionare al 100% ma sono troppo pigro per farle LOL");
            sleepFor(3);
            safeSendUpdate(update, m, "", "Ah P.S. è un progetto Maven");
            sleepFor(3);
            safeSendUpdate(update, m, "", "Ah P.P.S. qui è il link al progetto su GitHub: https://github.com/Maiale-al-Mare/Schiaver_bot/");
        } else if (updateHasText(update, "Ok boomer")) {
            safeSendUpdate(update, a, "", "CgACAgQAAxkBAAIPJ142d29dXa3U1rMglhTGC_DIdNWkAAJhBgACJMmwUQkLxGIFm4XaGAQ", "");
        } else {
            safeSendUpdate(update, m, "", "Comando non riconosciiuto" + EmojiParser.parseToUnicode(":fearful:") + "\n" + "Prova con uno dei comandi specificati" + EmojiParser.parseToUnicode(":point_down:"));
        }
    }

    @Override
    public String getBotUsername() {
        return "Schiaver_bot";
    }

    @Override
    public String getBotToken() {
        return "bot token";
    }

    private boolean updateHasText(Update update, String text) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    private void safeSendUpdate(Update update, SendMessage m, String error, String message) {
        m.setText(message);
        m.setChatId(update.getMessage().getChatId());
        try {
            execute(m);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }

    private void safeSendUpdate(Update update, SendDocument d, String error, String file_id, String caption) {
        d.setDocument(file_id);
        d.setChatId(update.getMessage().getChatId());
        d.setCaption(caption);
        try {
            execute(d);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }

    private void safeSendUpdate(Update update, SendAnimation a, String error, String file_id, String caption) {
        a.setAnimation(file_id);
        a.setChatId(update.getMessage().getChatId());
        a.setCaption(caption);
        try {
            execute(a);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }

    private void safeSendUpdate(Update update, SendSticker s, String error, String file_id) {
        s.setSticker(file_id);
        s.setChatId(update.getMessage().getChatId());
        try {
            execute(s);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }

    private void sleepFor(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}


