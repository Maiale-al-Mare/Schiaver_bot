import com.vdurmont.emoji.EmojiParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.PromoteChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.UnbanChatMember;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.StrictMath.toIntExact;

public class Schiavobot extends TelegramLongPollingBot {

    // Used for tracking userIds from user name - used for banning
    Map<String, Integer> map1 = null;
    Logger logger = LogManager.getLogger("Schiavo");
    Logger userLog = LogManager.getLogger("UserInfo");
    Logger consoleLogger = LogManager.getLogger("console");

    private static final String CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT = "update_msg_text";
    private static final String CALLBACK_BUTTON_UPDATE_DAI_SCHERZO = "no_really";
    private static final String CALLBACK_BUTTON_UPDATE_THUMBSUP = "thumbsup";
    private static final String CALLBACK_BUTTON_UPDATE_UNBAN_CMD = "unban_user";
    private static final String CALLBACK_BUTTON_UPDATE_FROWN_FACE = "frown";
    private static final String CALLBACK_BUTTON_UPDATE_UNMUTE = "unmute";
    private static final String CALLBACK_BUTTON_UPDATE_BACK = "back";

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
        SendChatAction action = new SendChatAction();
        ZonedDateTime t = ZonedDateTime.now();
        KickChatMember k = new KickChatMember();
        UnbanChatMember unb = new UnbanChatMember();
        ForwardMessage f = new ForwardMessage();
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        int message_id = getMessageId(update);
        PromoteChatMember promoteChatMember = new PromoteChatMember();
        User from = captureUserIds(update);
        int ismessagingcreator = 0;

        if (map1 == null) {
            consoleLogger.debug("Loading map");
            MapSerializer mapSerializer = new MapSerializer();
            map1 = mapSerializer.readMap();
            consoleLogger.debug("Loaded " + map1.size());
        }

        if (!map1.containsKey("@" + from.getUserName())) {
            map1.put("@" + from.getUserName(), from.getId());
            consoleLogger.debug("Added " + from.getUserName());
            MapSerializer mapSerializer = new MapSerializer();
            mapSerializer.writeMap(map1);
        }

        if (update.hasCallbackQuery() && !update.getCallbackQuery().getData().equals("")) {
            String call_data = update.getCallbackQuery().getData();
            System.out.println("Callback query found");
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            if (call_data.equals(CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT)) {
                rowInline.add(new InlineKeyboardButton().setText("Ok").setCallbackData(CALLBACK_BUTTON_UPDATE_THUMBSUP));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText("Questo è un progetto(schiavo, del gruppo(ci volevamo solo dare un nome boh) Ver.boH) frutto della curiosità di due ragazzi(ni) di scoprire un nuovo mondo: quello della programmazione.\n" +
                                "Ci interessiamo principalmente di java, ma vogliamo anche cominciare ad usare altri linguaggi.\n" +
                                "Questa è la parte funzionante su telegram del proj, ma ce n'è un' altra, quella sui nostri computer(che solo noi abbiamo" + EmojiParser.parseToUnicode(":smiling_imp:") + ") , che continuamo ad ampliare.\n" +
                                "In essa mettiamo tutto quello che sappiamo fare, tanto per.\n" +
                                "Speriamo che Schiavo ti piaccia, anche se al momento la parte che puoi usare tu è MOLTO ristretta.\n" +
                                "_Eh, che dici, Eu? No, non gliel'ho detto che possono scaricare il progetto intero con /src usando la password SonoScemo, ovvio! Che, pensi che sia scemo?_\n" +
                                "Eu e Gabri\n" + EmojiParser.parseToUnicode(":stuck_out_tongue_winking_eye:"));
                new_message.setParseMode("Markdown");
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (call_data.equals(CALLBACK_BUTTON_UPDATE_BACK)){
                ismessagingcreator = 0;
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText("Annullato");
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.equals(CALLBACK_BUTTON_UPDATE_FROWN_FACE)) {
                rowInline.add(new InlineKeyboardButton().setText("No dai scherzo").setCallbackData(CALLBACK_BUTTON_UPDATE_DAI_SCHERZO));
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
            if (call_data.equals(CALLBACK_BUTTON_UPDATE_THUMBSUP)) {
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(EmojiParser.parseToUnicode(":+1:"));
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.equals(CALLBACK_BUTTON_UPDATE_DAI_SCHERZO)) {
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(":^)");
                rowInline.add(new InlineKeyboardButton().setText("Allora, mi fai vedere o no?").setCallbackData(CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (call_data.contains(CALLBACK_BUTTON_UPDATE_UNMUTE)) {
                String user = call_data.substring(7);
                System.out.println(user);
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText("L'utente " + user + " può di nuovo esprimersi");
                ChatPermissions permissions = new ChatPermissions();
                permissions.setCanAddWebPagePreviews(true);
                permissions.setCanChangeInfo(false);
                permissions.setCanInviteUsers(true);
                permissions.setCanPinMessages(false);
                permissions.setCanSendMessages(true);
                permissions.setCanSendOtherMessages(true);
                permissions.setCanSendPolls(true);
                permissions.setGetCanSendMediaMessages(true);
                RestrictChatMember r = new RestrictChatMember();
                r.setPermissions(permissions);
                r.setUserId(Integer.valueOf((Integer) map1.get(user)));
                r.setChatId(update.getMessage().getChatId());
                try {
                    execute(new_message);
                    execute(r);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (call_data.startsWith(CALLBACK_BUTTON_UPDATE_UNBAN_CMD)) {
                String user = call_data.replaceAll(CALLBACK_BUTTON_UPDATE_UNBAN_CMD + ":", "");
                System.out.println(user);
                unb.setChatId(update.getCallbackQuery().getMessage().getChatId());
                unb.setUserId((Integer) map1.get(user));

                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText("L'utente " + user + " può di nuovo unirsi al gruppo");
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(unb);
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
            //System.out.println("Status: " + chatMember.getStatus());

            if (updateHasText(update, "/start") || updateHasText(update, "/start@Schiaver_bot") || updateHasText(update, "Chi?" + EmojiParser.parseToUnicode(":eyes:"))) {
                long chat_id = update.getMessage().getChatId();
                safeSendUpdate(update, s, "", "CAACAgIAAxkBAAIPp142w9opqZieTbBK_5Do45KQxYJgAAIIAAPANk8Tb2wmC94am2kYBA");
                m.setChatId(chat_id);
                if (!update.getMessage().isUserMessage()) {
                    m.setReplyToMessageId(message_id);
                    m.setText("Ciao ,Benvenuto allo Schiaver_bot! Premi il bottone per saperne di più");
                } else {
                    m.setText("Ciao, @" + update.getMessage().getChat().getUserName() + ", Benvenuto allo Schiaver_bot! Premi il bottone per saperne di più");

                }
                rowInline.add(new InlineKeyboardButton().setText("Chi?").setCallbackData(CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT));
                rowInline.add(new InlineKeyboardButton().setText("No me ne vado").setCallbackData(CALLBACK_BUTTON_UPDATE_FROWN_FACE));
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

        while (ismessagingcreator == 1){
            f.setFromChatId(update.getMessage().getChatId());
            f.setChatId((long) -458202455);
            f.setMessageId(update.getMessage().getMessageId());
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
        } else if (update.getMessage().getText().contains("/promuovi")) {
            String command = update.getMessage().getText();
            System.out.println(command);
            String usertopromote = command.substring(23);
            System.out.println(usertopromote);
            promoteChatMember.setChatId(update.getMessage().getChatId());
            promoteChatMember.setUserId(Integer.valueOf((Integer) map1.get(usertopromote)));
            promoteChatMember.setCanChangeInformation(false);
            promoteChatMember.setCanDeleteMessages(true);
            promoteChatMember.setCanEditMessages(true);
            promoteChatMember.setCanInviteUsers(false);
            promoteChatMember.setCanPinMessages(true);
            promoteChatMember.setCanPostMessages(true);
            promoteChatMember.setCanPromoteMembers(false);
            promoteChatMember.setCanRestrictMembers(true);
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            deleteMessage(update, dmsg, "");
            try {
                execute(promoteChatMember);
                safeSendUpdate(update, m, "", "Utente " + usertopromote + " promosso ad amministratore, anche se senza pieni poteri (⌐■-■)");
            } catch (TelegramApiException e) {
                e.printStackTrace();
                m.setParseMode("HTML");
                safeSendUpdate(update, m, "", "Errore! Controlla <b>che tu sia amministratore</b>, che la persona da promuovere non lo sia e che essa abbia già mandato un messaggio in questo gruppo");
            }
        } else if (updateHasText(update, "/help") || updateHasText(update, "/help@Schiaver_bot")) {
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow row = new KeyboardRow();
            m.setText("Ecco la lista dei comandi disponibili:");
            m.setChatId(update.getMessage().getChatId());
            row.add("Chi? " + EmojiParser.parseToUnicode(":eyes:"));
            row.add("Ok boomer");
            keyboard.add(row);
            row = new KeyboardRow();
            row.add("Src");
            row.add("Ban >:^(");
            keyboard.add(row);
            KeyboardRow anotherrow = new KeyboardRow();
            anotherrow.add("Promuovi");
            anotherrow.add("Kek");
            keyboard.add(anotherrow);
            KeyboardRow row1 = new KeyboardRow();
            row1.add("Muta " + EmojiParser.parseToUnicode(":microphone:"));
            row1.add("Kill chat " + EmojiParser.parseToUnicode(":hocho:"));
            keyboard.add(row1);
            KeyboardRow row2 = new KeyboardRow();
            row2.add("Revive chat " + EmojiParser.parseToUnicode(":sparkles:") + EmojiParser.parseToUnicode(":star:"));
            row2.add("Altro " + EmojiParser.parseToUnicode(":no_mouth:"));
            keyboard.add(row2);
            KeyboardRow row3 = new KeyboardRow();
            row3.add("Contatta lo sviluppatore " + EmojiParser.parseToUnicode(":wink:"));
            keyboard.add(row3);
            keyboardMarkup.setKeyboard(keyboard);
            m.setReplyMarkup(keyboardMarkup);
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateHasText(update, "Chi? " + EmojiParser.parseToUnicode(":eyes:"))) {
            m.setParseMode("Markdown");
            safeSendUpdate(update, m, "", "Questo è un progetto(schiavo, del gruppo(ci volevamo solo dare un nome boh) Ver.boH) frutto della curiosità di due ragazzi(ni) di scoprire un nuovo mondo: quello della programmazione.\n" +
                    "Ci interessiamo principalmente di java, ma vogliamo anche cominciare ad usare altri linguaggi.\n" +
                    "Questa è la parte funzionante su telegram del proj, ma ce n'è un' altra, quella sui nostri computer(che solo noi abbiamo" + EmojiParser.parseToUnicode(":smiling_imp:") + ") , che continuamo ad ampliare.\n" +
                    "In essa mettiamo tutto quello che sappiamo fare, tanto per.\n" +
                    "Speriamo che Schiavo ti piaccia, anche se al momento la parte che puoi usare tu è MOLTO ristretta.\n" +
                    "_Eh, che dici, Eu? No, non gliel'ho detto che possono scaricare il progetto intero con /src usando la password SonoScemo, ovvio! Che, pensi che sia scemo?_\n" +
                    "Eu e Gabri\n" + EmojiParser.parseToUnicode(":stuck_out_tongue_winking_eye:"));
        } else if (update.getMessage().hasSticker()) {
            System.out.println("Sticker file_id: " + "file_id:\n" + update.getMessage().getSticker().getFileId());
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getSticker().getFileId());
        } else if (updateHasText(update, "Muta " + EmojiParser.parseToUnicode(":microphone:"))) {
            safeSendUpdate(update, m, "", "Usa questo comando nei gruppi per mutare le persone >:^)\n" +
                    "Devi essere amministratore per usarlo.\n" +
                    " Usa il formato '/muta@Schiaver_bot:@username' per mutare le persone senza precisare la durata della loro sofferenza (ricordati di smutarle manualmente!) o '/muta@Schiaver_bot!@username' per mutarle per un'ora");
        } else if (updateHasText(update, "Promuovi")) {
            safeSendUpdate(update, m, "", "Usa questo comando nei gruppi per promuovere le persone allo stato di amministratore se lo sei già tu (senza potere assoluto, però! Quello spetta al bot (⌐■-■))\n" +
                    "Usa il formato '/promuovi:@username'");
        } else if (updateHasText(update, "Kill chat " + EmojiParser.parseToUnicode(":hocho:"))) {
            m.setParseMode("HTML");
            safeSendUpdate(update, m, "", "<b>!!WIP!!</b>\n" +
                    "Se sei un amministratore, usa questo comando per DISTRUGGERE LA CHAT INTERA PER MOTIVI CHE NON DEVONO ESSERE SPECIFICATI (mutare tutti gli utenti di una chat)\n" +
                    "<b>Ripeto, è ancora un WIP!</b>\n" +
                    " Devo ancora imparare ad usare MongoDB e tutta quella roba bella");
        } else if (updateHasText(update, "Contatta lo sviluppatore " + EmojiParser.parseToUnicode(":wink:"))){
            ismessagingcreator = 1;
            SendMessage message = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                    .setText("Ora stai parlando con lo sviluppatore. Premi il bottone per annullare")
                    .row()
                    .button("Annulla", CALLBACK_BUTTON_UPDATE_BACK)
                    .endRow()
                    .build();
            try{
                execute(message);
            }catch(TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateHasText(update, "Revive chat " + EmojiParser.parseToUnicode(":sparkles:") + EmojiParser.parseToUnicode(":star:"))) {
            m.setParseMode("HTML");
            safeSendUpdate(update, m, "", "<b>!!WIP!!</b>\n" +
                    "Usa questo comando nei gruppi per annullare gli effetti del killchat se sei un amministratore.\n" +
                    "<b>Ripeto, è ancora un WIP!</b>\n" +
                    " Devo ancora imparare ad usare MongoDB e tutta quella roba bella");
        } else if (update.getMessage().hasVideoNote()) {
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getVideoNote().getFileId());
        } else if (update.getMessage().hasVoice()) {
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getVoice().getFileId());
        } else if (update.getMessage().getText().contains("/muta") && !update.getMessage().isUserMessage()) {
            String command = update.getMessage().getText();
            String usertomute = command.substring(19);
            System.out.println(usertomute);
            ChatPermissions permissions = new ChatPermissions();
            permissions.setCanAddWebPagePreviews(false);
            permissions.setCanChangeInfo(false);
            permissions.setCanInviteUsers(false);
            permissions.setCanPinMessages(false);
            permissions.setCanSendMessages(false);
            permissions.setCanSendOtherMessages(false);
            permissions.setCanSendPolls(false);
            permissions.setGetCanSendMediaMessages(false);
            RestrictChatMember r = new RestrictChatMember();
            if (update.getMessage().getText().contains("!")) {
                r.setUntilDate(t.plusHours(1));
            }

            r.setPermissions(permissions);
            r.setUserId((Integer) map1.get(usertomute));
            r.setChatId(update.getMessage().getChatId());
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            deleteMessage(update, dmsg, "");
            try {
                execute(r);
                if (update.getMessage().getText().contains("!")) {
                    SendMessage message = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                            .setText("Utente " + usertomute + " mutato per un'ora (⌐■-■)")
                            .row()
                            .button("Annulla", CALLBACK_BUTTON_UPDATE_UNMUTE + "!" + usertomute)
                            .setChatId(update.getMessage().getChatId())
                            .endRow()
                            .build();
                    execute(message);
                } else {
                    SendMessage message = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                            .setText("Utente " + usertomute + " mutato (⌐■-■)")
                            .row()
                            .button("Annulla", CALLBACK_BUTTON_UPDATE_UNMUTE + ":" + usertomute)
                            .setChatId(update.getMessage().getChatId())
                            .endRow()
                            .build();
                    execute(message);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
                safeSendUpdate(update, m, "", "Errore! Ricontrolla il messajjone e tutte quelle cose belle da ricontrollare LOL");
            }
        } else if (updateHasText(update, "Altro " + EmojiParser.parseToUnicode(":no_mouth:"))) {
            m.setParseMode("HTML");
            safeSendUpdate(update, m, "", "1. file_id: Quando mandi un file, sarà stampato il suo file_id (se non programmi, non credo ti serva, però è lì in caso contrario!)\n" +
                    "2. Paypal: Se per qualche strano motivo volessi donarmi <b>solo ed esclusivamente abbondanti somme di denaro</b> (scherzo xD), puoi usuare il mio link paypal.me: paypal.me/gabosparkes");
        } else if (update.hasMessage() && update.getMessage().getText().toLowerCase().equals("una parolaccia")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            deleteMessage(update, dmsg, "");
        } else if (updateHasText(update, "/muta") && update.getMessage().isUserMessage()) {
            safeSendUpdate(update, m, "", "Questo comando va usato nei gruppi!");
        } else if (updateHasText(update, "/muta@Schiaver_bot") && !update.getMessage().isUserMessage()) {
            safeSendUpdate(update, m, "", "Vedi la lista dei comandi sotto                      " + EmojiParser.parseToUnicode(":point_down:"));
        } else if (update.getMessage().hasAudio()) {
            System.out.println("Audio file_id: " + update.getMessage().getAudio().getFileId());
            m.setReplyToMessageId(message_id);
            safeSendUpdate(update, m, "", "file_id:\n" + update.getMessage().getAudio().getFileId());
        } else if (updateHasText(update, "Ban >:^(")) {
            safeSendUpdate(update, m, "", "Puoi usare il comando /ban per bannare le persone nei gruppi se sei un amministratore. Usa il formato '/ban@Schiaver_bot:@username:tempo'\n" +
                    "Al posto di 'tempo' scrivi: !numerodiminuti, ?numerodiore o #numerodigiorni\n" +
                    "Nota che se banni le persone per meno di 30 secondi o più di 366 giorni, saranno bannati per sempre " + EmojiParser.parseToUnicode(":turkey:"));
        } else if (updateHasText(update, "/kek") || updateHasText(update, "/kek@Schiaver_bot") || updateHasText(update, "Kek")) {
            safeSendUpdate(update, p, "", "AgACAgQAAxkBAAIQRV42_rH0FLQiWjBfSMmKWOtVk2RqAAITszEbJMmwUcKpMtFGG3lnTUC2GwAEAQADAgADeQADSY8CAAEYBA", "La bandiera dell' amato Kekistan");
            sleepFor(1);
            safeSendUpdate(update, aud, action, "", "CQACAgQAAxkBAAIQQ142_cm5bRa1_1CY67AFd9smUzw_AAK3BgACJMm4UZBThC9zFqGuGAQ", "Alziamoci tutti e mettiamo la mano sul cuore per il suo inno. Shadilay, fratelli");
            sleepFor(5);
            safeSendUpdate(update, m, "", "Ok scusa fa abbastanza schifus");
        } else if (updateHasText(update, "/src") || updateHasText(update, "/src@Schiaver_bot") || updateHasText(update, "Src")) {
            safeSendUpdate(update, m, "", "Comunque stavo scherzando, non c'è bisogno di una password");
            sleepFor(1);
            m.setParseMode("HTML");
            safeSendUpdate(update, m, "", "Però la cosa si sta rivelando più difficile del previsto:/\n" +
                    "Ti avviseremo <b>FORSE</b> appena sarà possibile\n" +
                    "GIURO CHE NON SONO SUPER PROTETTIVO DEL PROGETTO, OK? E' SOLO MOLTO DIFFICILE ED IO SONO SCEMO E AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH");
            sleepFor(7);
            safeSendUpdate(update, d, action, "", "BQACAgQAAxkBAAIPVl42g5wZ6YqeZkfOPcf0zYLKnqUcAAINBwAC2t3ZUTQjmtPCCD5tGAQ", "jk tieni. Non ho fatto tutte le modifiche necessarie per farlo funzionare al 100% ma sono troppo pigro per farle LOL");
            sleepFor(3);
            safeSendUpdate(update, m, "", "Ah P.S. è un progetto Maven");
            sleepFor(3);
            safeSendUpdate(update, m, "", "Ah P.P.S. qui è il link al progetto su GitHub: https://github.com/Maiale-al-Mare/Schiaver_bot/");
        } else if (updateHasText(update, "Ok boomer")) {
            safeSendUpdate(update, a, "", "CgACAgQAAxkBAAIPJ142d29dXa3U1rMglhTGC_DIdNWkAAJhBgACJMmwUQkLxGIFm4XaGAQ", "");
        } else if (update.getMessage().getText().contains("/ban@Schiaver_bot") && !update.getMessage().isUserMessage()) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            String user = update.getMessage().getText();
            String cleanedCommand = user.replace("/ban@Schiaver_bot:", "");
            String[] split = cleanedCommand.split(":");
            String userToBan = split[0];
            System.out.println(userToBan);
            String timeString = split[1];
            if (timeString.contains("!")) {
                String time = timeString.replace("!", "");
                long tim3 = Long.valueOf(time).longValue();
                k.setUntilDate(t.plusMinutes(tim3));

                /*long unixSeconds = Long.valueOf(String.valueOf(t.plusMinutes(tim3)));
                Date date = new java.util.Date(unixSeconds * 1000L);
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
                sdf.setTimeZone(java.util.TimeZone.getTimeZoFne("GMT+1"));
                String formattedDate = sdf.format(date);
                System.out.println("Utente bannato fino a " + formattedDate);
                String message = "Utente " + userToBan + " bannato fino al " + formattedDate + " (⌐■-■)";
                m.setText(message);*/
            }
            if (timeString.contains("?")) {
                String time = timeString.replace("?", "");
                long tim3 = Long.valueOf(time).longValue();
                k.setUntilDate(t.plusHours(tim3));

                /*long unixSeconds = Long.valueOf(String.valueOf(t.plusHours(tim3)));
                Date date = new java.util.Date(unixSeconds * 1000L);
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
                sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+1"));
                String formattedDate = sdf.format(date);
                System.out.println("Utente bannato fino a " + formattedDate);
                String message = "Utente " + userToBan + " bannato fino al " + formattedDate + " (⌐■-■)";
                m.setText(message);*/
            }
            if (timeString.contains("#")) {
                String time = timeString.replace("#", "");
                long tim3 = Long.valueOf(time).longValue();
                k.setUntilDate(t.plusDays(tim3));

                /*long unixSeconds = Long.valueOf(String.valueOf(t.plusDays(tim3)));
                Date date = new java.util.Date(unixSeconds * 1000L);
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
                sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+1"));
                String formattedDate = sdf.format(date);
                System.out.println("Utente bannato fino a " + formattedDate);
                rowInline.add(new InlineKeyboardButton().setText("Annulla").setCallbackData(CALLBACK_BUTTON_UPDATE_UNBAN_CMD + ":" + userToBan));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                m.setChatId(update.getMessage().getChatId());
                m.setReplyMarkup(markupInline);
                String message = "Utente " + userToBan + " bannato fino al " + formattedDate + " (⌐■-■)";
                m.setText(Utente " + userToBan + " bannato fino al " + formattedDate + " (⌐■-■));*/
            }

            k.setChatId(update.getMessage().getChatId());
            k.setUserId((Integer) map1.get(userToBan));
            deleteMessage(update, dmsg, "");
            try {
                execute(k);
                try {

                    rowInline.add(new InlineKeyboardButton().setText("Annulla").setCallbackData(CALLBACK_BUTTON_UPDATE_UNBAN_CMD + ":" + userToBan));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                    m.setChatId(update.getMessage().getChatId());
                    m.setReplyMarkup(markupInline);
                    m.setText("Utente " + userToBan + " bannato (⌐■-■)");
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
                m.setParseMode("HTML");
                safeSendUpdate(update, m, "", "Errore! Controlla di aver scritto bene il messaggio, <b>che tu sia amministratore</b> ,che la persona da bannare non lo sia e che questa abbia mandato un messaggio in questo gruppo");
            }
        } else if (updateHasText(update, "/ban") && update.getMessage().isUserMessage()) {
            safeSendUpdate(update, m, "", "Questo comando va usato nei gruppi!");
        } else {
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


    private void deleteMessage(Update update, DeleteMessage dmsg, String error) {
        System.out.println("Message ID: " + update.getMessage().getMessageId());
        try {
            execute(dmsg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println(error);
        }
    }

    private void safeSendUpdate(Update update, SendDocument d, SendChatAction action, String error, String file_id, String caption) {
        action.setChatId(update.getMessage().getChatId());
        action.setAction(ActionType.UPLOADDOCUMENT);
        d.setDocument(file_id);
        d.setChatId(update.getMessage().getChatId());
        d.setCaption(caption);
        try {
            execute(d);
            execute(action);
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

    private void safeSendUpdate(Update update, SendAudio aud, SendChatAction action, String error, String file_id, String caption) {
        action.setAction(ActionType.UPLOADAUDIO);
        action.setChatId(update.getMessage().getChatId());
        aud.setAudio(file_id);
        aud.setChatId(update.getMessage().getChatId());
        aud.setCaption(caption);
        try {
            execute(aud);
            execute(action);
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
            e.printStackTrace();
        }
    }
    private User captureUserIds(Update update) {
        if (update.hasMessage()) {
            User from = update.getMessage().getFrom();
            return from;
        }
        else {
            User from = update.getCallbackQuery().getFrom();
            return from;
        }
    }
}








