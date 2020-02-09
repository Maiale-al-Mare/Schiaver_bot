import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.StrictMath.toIntExact;

public class Schiavobot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage m = new SendMessage();
        SendAnimation a = new SendAnimation();
        SendDocument d = new SendDocument();
        SendSticker s = new SendSticker();
        SendAudio aud = new SendAudio();
        SendPhoto p = new SendPhoto();

        if (update.hasMessage() && update.getMessage().hasText()) {
            System.out.println("Ho ricevuto un messaggio!");
            System.out.println(" Update :\n" +
                    "Text :" + update.getMessage().getText());
            System.out.println("ChatID :" + update.getMessage().getChatId());
            System.out.println("Chat :" + update.getMessage().getChat());
            System.out.println("From :" + update.getMessage().getFrom());

            if (update.getMessage().hasSticker()) {
                System.out.println("Sticker file_id: " + "file_id:\n" + update.getMessage().getSticker().getFileId());
                safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getSticker().getFileId());
            } else if (updateHasText(update, "/start") || update.getMessage().getText().contains("Ciao") || updateHasText(update, "/start@Schiaver_bot")) {
                long chat_id = update.getMessage().getChatId();
                safeSendUpdate(update, s, "", "CAACAgIAAxkBAAIPp142w9opqZieTbBK_5Do45KQxYJgAAIIAAPANk8Tb2wmC94am2kYBA");
                sleepFor(1);
                m.setChatId(chat_id);
                if(!update.getMessage().isUserMessage()){
                    int message_id = update.getMessage().getMessageId();
                    m.setReplyToMessageId(message_id);
                    m.setText("Ciao ,Benvenuto allo Schiaver_bot! Premi il bottone per saperne di più");
                }else{
                    m.setText("Ciao, @" + update.getMessage().getChat().getUserName() + ", Benvenuto allo Schiaver_bot! Premi il bottone per saperne di più");

                }
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Chi?").setCallbackData("update_msg_text"));
                rowInline.add(new InlineKeyboardButton().setText("No me ne vado").setCallbackData("1"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                m.setReplyMarkup(markupInline);
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (call_data.equals("update_msg_text")) {
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Ok").setCallbackData("2"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText("Questo è un progetto(schiavo, del gruppo(ci volevamo solo dare un nome boh) Ver.boH) frutto della curiosità di due ragazzi(ni) di scoprire un nuovo mondo: quello della programmazione.\n" +
                                "Ci interessiamo principalmente di java, ma vogliamo anche cominciare ad usare altri linguaggi.\n" +
                                "Questa è la parte funzionante su telegram del proj, ma ce n'è un' altra, quella sui nostri computer(che solo noi abbiamo" + EmojiParser.parseToUnicode(":smiling_imp:") + ") , che continuamo ad ampliare.\n" +
                                "*Eh, che dici, Eu? No, non gliel'ho detto che possono scaricare il progetto intero con /src usando la password SonoScemo, ovvio! Che, pensi che sia scemo?*\n" +
                                "In essa mettiamo tutto quello che sappiamo fare, tanto per.\n" +
                                "Speriamo che Schiavo ti piaccia, anche se al momento la parte che puoi usare tu è MOLTO ristretta.\n" +
                                "Eu e Gabri\n" + EmojiParser.parseToUnicode(":stuck_out_tongue_winking_eye:"));
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.equals("1")) {
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("No dai scherzo").setCallbackData("3"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(":( no dai");
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.equals("2")) {
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(EmojiParser.parseToUnicode(":+1:"));
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.equals("3")) {
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Allora, mi fai vedere o no?").setCallbackData("update_msg_text"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(":^)");
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        if (update.hasMessage()&&update.getMessage().hasDocument()) {
                System.out.println("Document file_id: " + update.getMessage().getDocument().getFileId());
                safeSendUpdate(update, m, "", "file_id: \n" + update.getMessage().getDocument().getFileId());
            } else if (update.getMessage().hasPoll()) {
            System.out.println("Poll found");
                safeSendUpdate(update, m, "", "I sondaggi non sono ancora supportati");
            } else if (update.hasMessage()&&update.getMessage().getText().toLowerCase().equals("una parolaccia")) {
                DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
            } else if (update.getMessage().hasAudio()) {
                System.out.println("Audio file_id: " + update.getMessage().getAudio().getFileId());
                safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getAudio().getFileId());
            } else if (update.getMessage().hasPhoto()) {
                ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
                String photofile_id = "file_id:\n" + photos.stream()
                        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                        .findFirst()
                        .orElse(null).getFileId();
                System.out.println("Photo file_id: " + photofile_id);
                safeSendUpdate(update, m, "", photofile_id);
            } else if (updateHasText(update, "/kek") || updateHasText(update, "/kek@Schiaver_bot")) {
                safeSendUpdate(update, p, "", "AgACAgQAAxkBAAIQRV42_rH0FLQiWjBfSMmKWOtVk2RqAAITszEbJMmwUcKpMtFGG3lnTUC2GwAEAQADAgADeQADSY8CAAEYBA", "La bandiera dell' amato Kekistan");
                sleepFor(1);
                safeSendUpdate(update, aud, "", "CQACAgQAAxkBAAIQQ142_cm5bRa1_1CY67AFd9smUzw_AAK3BgACJMm4UZBThC9zFqGuGAQ", "Alziamoci tutti e mettiamo la mano sul cuore per il suo inno. Shadilay, fratelli");
                sleepFor(5);
                safeSendUpdate(update, m, "", "Ok scusa fa abbastanza schifus");
            } else if (updateHasText(update, "/src") || updateHasText(update, "/src@Schiaver_bot")) {
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
            } else if (update.getMessage().getText().contains("/ban") || update.getMessage().getText().contains("/ban@Schiaver_bot")) {
                safeSendUpdate(update, m, "", "Ehi, perché hai così tanta fretta di bannare le persone?");
            }else {
                if (update.getMessage().isChannelMessage() || update.getMessage().isSuperGroupMessage() || update.getMessage().isGroupMessage()||update.getMessage().getText().equals("/start")||update.getMessage().getText().equals("/start@Schiaver_bot")) {
                    System.out.println("Ok");
                } else {
                    safeSendUpdate(update, m, "", "Comando non riconosciuto" + EmojiParser.parseToUnicode(":fearful:") + "\n" + "Prova con uno dei comandi specificati                          " + EmojiParser.parseToUnicode(":point_down:"));
                }
            }
        }






    @Override
    public String getBotUsername() {
        return "Schiaver_bot";
    }

    @Override
    public String getBotToken() {
        return "829542849:AAFbMgEt-s2qgaf6W3C_Av3JQ832k1tBZ3A";
    }

    private boolean updateHasText(Update update, String text) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    private void deleteMessage(Update update, DeleteMessage dmsg, String error) {
        System.out.println("Message ID: " + update.getMessage().getMessageId());
        try {
            execute(dmsg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println(error);
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

    private void safeSendUpdate(Update update, SendMessage m, String error, String text) {
        if(update.hasMessage()){
            m.setText(text);
            m.setChatId(update.getMessage().getChatId());
            try {
                execute(m);
                System.out.println("I answered");
            } catch (TelegramApiException e) {
                if (!error.isEmpty())
                    System.out.println(error);
                e.printStackTrace();
            }
        }else{
            System.out.println("No update found!");
        }
    }

    private void safeSendUpdate(Update update, SendAudio aud, String error, String file_id, String caption) {
        aud.setAudio(file_id);
        aud.setChatId(update.getMessage().getChatId());
        aud.setCaption(caption);
        try {
            execute(aud);
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

    private void safeSendUpdate(Update update, SendPhoto p, String error, String file_id, String caption) {
        p.setPhoto(file_id);
        p.setChatId(update.getMessage().getChatId());
        p.setCaption(caption);
        try {
            execute(p);
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


