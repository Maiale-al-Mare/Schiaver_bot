import com.vdurmont.emoji.EmojiParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMembersCount;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.StrictMath.toIntExact;

public class Schiavobot extends TelegramLongPollingBot {

    Logger logger = LogManager.getLogger("Schiavo");
    Logger userLog = LogManager.getLogger("UserInfo");

    @Override
    public void onUpdateReceived(Update update) {

        logger.info("Got an update to process");
        userLog.info("This is a message that goes into the user log");

        SendMessage m = new SendMessage();
        SendAnimation a = new SendAnimation();
        SendDocument d = new SendDocument();
        SendSticker s = new SendSticker();
        SendAudio aud = new SendAudio();
        SendPhoto p = new SendPhoto();
        RestrictChatMember r = new RestrictChatMember();
        ZonedDateTime t = ZonedDateTime.now();
        KickChatMember k = new KickChatMember();
        GetChatMembersCount gchm = new GetChatMembersCount();
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        GetChatMember chm = new GetChatMember();


        int message_id = getMessageId(update);

        if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            if (call_data.equals("update_msg_text")) {
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

        if (update.hasMessage() && update.getMessage().hasText()) {

            System.out.println("Ho ricevuto un messaggio!");
            System.out.println(" Update :\n" +
                    "Text :" + update.getMessage().getText());
            System.out.println("ChatID :" + update.getMessage().getChatId());
            System.out.println("Chat :" + update.getMessage().getChat());
            System.out.println("From :" + update.getMessage().getFrom());


            if (updateHasText(update, "/start") || update.getMessage().getText().contains("Ciao") || updateHasText(update, "/start@Schiaver_bot")) {
                long chat_id = update.getMessage().getChatId();
                safeSendUpdate(update, s, "", "CAACAgIAAxkBAAIPp142w9opqZieTbBK_5Do45KQxYJgAAIIAAPANk8Tb2wmC94am2kYBA");
                sleepFor(1);
                m.setChatId(chat_id);
                if (!update.getMessage().isUserMessage()) {
                    m.setReplyToMessageId(message_id);
                    m.setText("Ciao ,Benvenuto allo Schiaver_bot! Premi il bottone per saperne di più");
                } else {
                    m.setText("Ciao, @" + update.getMessage().getChat().getUserName() + ", Benvenuto allo Schiaver_bot! Premi il bottone per saperne di più");

                }
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
            }
        }

        if (update.hasMessage() && update.getMessage().hasDocument()) {
            System.out.println("Document file_id: " + update.getMessage().getDocument().getFileId());
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id: \n" + update.getMessage().getDocument().getFileId());
        } else if (update.getMessage().hasPhoto()) {
            ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
            String photofile_id = "file_id:\n" + photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getFileId();
            m.setReplyToMessageId(message_id);
            System.out.println("Photo file_id: " + photofile_id);
            safeSendUpdate(update, m, "", photofile_id);
        } else if (update.getMessage().hasSticker()) {
            System.out.println("Sticker file_id: " + "file_id:\n" + update.getMessage().getSticker().getFileId());
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getSticker().getFileId());
        } else if (update.getMessage().hasVideoNote()) {
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getVideoNote().getFileId());
        } else if (update.getMessage().hasVoice()) {
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getVoice().getFileId());
        } else if (update.hasMessage() && update.getMessage().getText().toLowerCase().equals("una parolaccia")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            deleteMessage(update, dmsg, "");
        } else if (update.getMessage().hasAudio()) {
            System.out.println("Audio file_id: " + update.getMessage().getAudio().getFileId());
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getAudio().getFileId());
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
        } else if (update.getMessage().getText().contains("/ban") || update.getMessage().getText().contains("/ban@Schiaver_bot") && !update.getMessage().isUserMessage()) {
            String user = update.getMessage().getText();
            String nearlythere = user.replace("/ban@Schiaver_bot:", "@");
            System.out.println(nearlythere);
            String username = nearlythere.substring(0, nearlythere.indexOf("!"));
            System.out.println(username);
            String usernam3 = username.replace(":", "");
            System.out.println(usernam3);
            String[] splitbits = user.split(":");
            if (update.getMessage().getText().contains("!")) {
                String time = nearlythere.replace(username + "!", "");
                long tim3 = Long.valueOf(time).longValue();
                k.setUntilDate(t.plusMinutes(tim3));
            }
            if (update.getMessage().getText().contains("?")) {
                String time = nearlythere.replace(username + "?", "");
                long tim3 = Long.valueOf(time).longValue();
                k.setUntilDate(t.plusHours(tim3));

            }
            if (update.getMessage().getText().contains("#")) {
                String time = nearlythere.replace(username + "#", "");
                long tim3 = Long.valueOf(time).longValue();
                k.setUntilDate(t.plusDays(tim3));
            }
            k.setChatId(update.getMessage().getChatId());
            k.setUserId(update.getMessage().getFrom().getId());
            System.out.println(update.getMessage().getChat().getUserName());
            try {
                execute(k);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                safeSendUpdate(update, m, "", "Errore! Controlla di aver scritto bene il messaggio e che la persona da bannare non sia un amministratore");
            }


            if (!(splitbits.length == 3)) {
                safeSendUpdate(update, m, "", "Devi inserire 3 parametri!(separatore :)");
            }


            /*Date until = t.plusHours();
            k.setUserId(k.getUserId());
            k.setChatId();
            k.setUntilDate()*/
        } else if (update.getMessage().getText().contains("/ban")&&update.getMessage().isUserMessage()) {
            safeSendUpdate(update, m, "", "Questo comando va usato nei gruppi!");
        /*}else if(update.getMessage().getText().contains("/mute")){
          String user = update.getMessage().getText();
          String usertowarn = user.replace("/mute:", "");
          r.setChatId(update.getMessage().getChatId());
          r.setCanAddWebPagePreviews(false);
          r.setCanSendMediaMessages(false);
          r.setCanSendMessages(false);
          r.setCanSendOtherMessages(false);
          r.setUserId(update.getMessage().getFrom().getId());
          try{
              execute(r);
          }catch (TelegramApiException e){
              e.printStackTrace();
          }
*/
    }else {
            if (update.getMessage().isChannelMessage() || update.getMessage().isSuperGroupMessage() || update.getMessage().isGroupMessage() || update.getMessage().getText().equals("/start") || update.getMessage().getText().equals("/start@Schiaver_bot")) {
                System.out.println("Ok");
            } else {
                safeSendUpdate(update, m, "", "Comando non riconosciuto" + EmojiParser.parseToUnicode(":fearful:") + "\n" + "Prova con uno dei comandi specificati                          " + EmojiParser.parseToUnicode(":point_down:"));
            }
        }
    }

    private int getMessageId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getMessageId();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getMessageId();
        } else {
            return 0;
        }
    }

    @Override
    public String getBotUsername() {
        return "Schiaver_bot";
    }

    @Override
    public String getBotToken() {
        return "829542849:AAHX39ouckndL1HUiUopUcpO-JPRqeEGTvo";
    }

    private boolean updateHasText(Update update, String text) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    private void inlineKeyboardMarkup(int numberoftimes, String buttontext, String callbackdata) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(buttontext).setCallbackData(callbackdata));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
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
        if (update.hasMessage()) {
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
        } else {
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


