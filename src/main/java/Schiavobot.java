import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
        EditMessageText nmsg = new EditMessageText();

        System.out.println("Ho ricevuto un messaggio!");
        System.out.println(" Update :\n" +
                "Text :" + update.getMessage().getText());
        System.out.println("ChatID :" + update.getMessage().getChatId());
        System.out.println("Chat :" + update.getMessage().getChat());
        System.out.println("From :" + update.getMessage().getFrom());
        if (update.getMessage().hasSticker()) {
            System.out.println("Sticker file_id :" + update.getMessage().getSticker().getFileId());
            m.setChatId(update.getMessage().getChatId());
            m.setText("file_id :" + update.getMessage().getSticker().getFileId());
            safeSendUpdate(m, "");
        }

        else if (update.getMessage().hasDocument()) {
            System.out.println("Document file_id :" + update.getMessage().getDocument().getFileId());
            m.setChatId(update.getMessage().getChatId());
            m.setText("file_id :" + update.getMessage().getDocument().getFileId());
            safeSendUpdate(m, "");
        }

        else if (update.getMessage().hasPhoto()) {
            ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
            String photofile_id = "file_id :" + photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            System.out.println("Photo file_id :" + photofile_id);
            m.setChatId(update.getMessage().getChatId());
            m.setText(photofile_id);
            safeSendUpdate(m, "");
        }


        else if (updateHasText(update, "/chi")) {
            m.setChatId(update.getMessage().getChatId());
            m.setText("Questo è un progetto(schiavo, del gruppo(ci volevamo solo dare un nome boh) Ver.boH) frutto della curiosità di due ragazzi(ni) di scoprire un nuovo mondo: quello della programmazione.\n" +
                    "Ci interessiamo principalmente di java, ma vogliamo anche cominciare ad usare altri linguaggi.\n" +
                    "Questa è la parte funzionante su telegram tel proj, ma ce n'è un' altra, quella sui nostri computer(che solo noi abbiamo" + EmojiParser.parseToUnicode(":smiling_imp:") + ") , che continuamo ad ampliare.\n" +
                    "*Eh, che dici, Eu? No, non gliel'ho detto che possono scaricare il progetto intero con /src usando la password SonoScemo, ovvio! Che, pensi che sia scemo?*\n" +
                    "In essa mettiamo tutto quello che sappiamo fare, tanto per.\n" +
                    "Speriamo che Schiavo ti piaccia, anche se al momento la parte che puoi usare tu è MOLTO ristretta.\n" +
                    "Eu e Gabri\n" + EmojiParser.parseToUnicode(":stuck_out_tongue_winking_eye:"));

            safeSendUpdate(m, "Ops... Si è verificato u  errore...");
        }


        else if (updateHasText(update, "/aggiorna")) {
            m.setChatId(update.getMessage().getChatId());
            m.setText("Questa funzione non è ancora disponibile..." +
                    EmojiParser.parseToUnicode(":pensive:"));
            safeSendUpdate(m, "");
        }

        else if (updateHasText(update, "/src")) {
            m.setChatId(update.getMessage().getChatId());
            m.setText("Qual è la password?");
            safeSendUpdate(m, "");

            m.setChatId(update.getMessage().getChatId());
            m.setText("Fra 3..." + EmojiParser.parseToUnicode(":no_mouth:"));
            //InlineKeyboardMarkup inlk = new InlineKeyboardMarkup();
            //List<List<InlineKeyboardButton>> rowsInline = new ArrayList<Object>();
            //List<InlineKeyboardButton> rowInline = new ArrayList<Object>();
            //rowInline.add(String.valueOf(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text")));
            safeSendUpdate(m, "");

            m.setChatId(update.getMessage().getChatId());
            m.setText("EVVOLEVY");

            safeSendUpdate(m, "");
           sleepFor(5);
            d.setChatId(update.getMessage().getChatId());
            m.setText("Ok no, seriamente, la cosa si sta rivelando più difficile del previsto.\n" +
                    "Ti avviseremo *FORSE* appena sarà possibile\n" +
                    "GIURO CHE NON SONO SUPER PROTETTIVO DEL PROGETTO, OK? E' SOLO MOLTO DIFFICILE ED IO SONO SCEMO E AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH");
            safeSendUpdate(m, "");
           sleepFor(7);
            d.setDocument("BQACAgQAAxkBAAIPVl42g5wZ6YqeZkfOPcf0zYLKnqUcAAINBwAC2t3ZUTQjmtPCCD5tGAQ");
            d.setCaption("jk tieni. Non ho fatto tutte le modifiche necessarie per farlo funzionare al 100% ma sono troppo pigro per farle LOL");

            safeSendUpdate(d, "");
           sleepFor(3);
            m.setChatId(update.getMessage().getChatId());
            m.setText("Ah P.S. è un progetto Maven");
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
        else if (updateHasText(update, "Ok boomer")) {
            a.setChatId(update.getMessage().getChatId());
            a.setAnimation("CgACAgQAAxkBAAIPJ142d29dXa3U1rMglhTGC_DIdNWkAAJhBgACJMmwUQkLxGIFm4XaGAQ");
            safeSendUpdate(a, "");
        }

        else {
            m.setChatId(update.getMessage().getChatId());
            m.setText("Comando non riconosciuto" + EmojiParser.parseToUnicode(":fearful:") + "\n" +
                    "Prova con uno dei comandi specificati" + EmojiParser.parseToUnicode(":point_down:"));
            try {
                execute(m);
                System.out.println("Ho inviato una risposta!");
            } catch (TelegramApiException e) {
                System.out.println("Ops... Si è verificato un errore...");
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Schiaver_bot";
    }

    @Override
    public String getBotToken() {
        return "829542849:AAH3ax9KZ4rgAoVJqNYDTZNcLX2_H0T6Cek";
    }

    private boolean updateHasText(Update update, String text) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    private void safeSendUpdate(SendMessage m, String error) {
        try {
            execute(m);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }

    private void safeSendUpdate(SendDocument d, String error) {
        try {
            execute(d);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }

    private void safeSendUpdate(SendAnimation a, String error) {
        try {
            execute(a);
            System.out.println("I answered");
        } catch (TelegramApiException e) {
            if (!error.isEmpty())
                System.out.println(error);
            e.printStackTrace();
        }
    }
    private void sleepFor (int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}


