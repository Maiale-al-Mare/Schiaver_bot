import com.vdurmont.emoji.EmojiParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.*;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.List;
import static java.lang.StrictMath.toIntExact;

public class Schiaver_bot2 extends TelegramLongPollingBot {

    Map request = new HashMap();
    Logger consoleLogger = LogManager.getLogger("console");
    Collection<String> mat = new LinkedList<String>();
    Collection<String> art = new LinkedList<String>();
    Collection<String> eng = new LinkedList<String>();
    Collection<String> ita = new LinkedList<String>();
    Collection<String> tec = new LinkedList<String>();
    Collection<String> sci = new LinkedList<String>();
    Collection<String> ger = new LinkedList<String>();
    Collection<String> spa = new LinkedList<String>();
    Collection<String> geo = new LinkedList<String>();
    Collection<String> his = new LinkedList<String>();
    Collection<String> othr = new LinkedList<String>();
    Collection<String> geom = new LinkedList<String>();
    Collection<String> matname = new LinkedList<String>();
    Collection<String> artname = new LinkedList<String>();
    Collection<String> engname = new LinkedList<String>();
    Collection<String> itaname = new LinkedList<String>();
    Collection<String> tecname = new LinkedList<String>();
    Collection<String> sciname = new LinkedList<String>();
    Collection<String> gername = new LinkedList<String>();
    Collection<String> spaname = new LinkedList<String>();
    Collection<String> geoname = new LinkedList<String>();
    Collection<String> hisname = new LinkedList<String>();
    Collection<String> othrname = new LinkedList<String>();
    Collection<String> geomname = new LinkedList<String>();
    private static final String CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT = "update_msg_text";
    private static final String CALLBACK_BUTTON_UPDATE_DAI_SCHERZO = "no_really";
    private static final String CALLBACK_BUTTON_UPDATE_THUMBSUP = "thumbsup";
    private static final String CALLBACK_BUTTON_UPDATE_FROWN_FACE = "frown";
    private static final String CALLBACK_BUTTON_UPDATE_MATHS = "maths";
    private static final String CALLBACK_BUTTON_UPDATE_ART = "art";
    private static final String CALLBACK_BUTTON_UPDATE_ENGLISH = "english";
    private static final String CALLBACK_BUTTON_UPDATE_ITALIAN = "italian";
    private static final String CALLBACK_BUTTON_UPDATE_TECHNOLOGY = "technology";
    private static final String CALLBACK_BUTTON_UPDATE_SCIENCE = "science";
    private static final String CALLBACK_BUTTON_UPDATE_GERMAN = "german";
    private static final String CALLBACK_BUTTON_UPDATE_SPANISH = "spanish";
    private static final String CALLBACK_BUTTON_UPDATE_GEOGRAPHY = "geography";
    private static final String CALLBACK_BUTTON_UPDATE_HISTORY = "history";
    private static final String CALLBACK_BUTTON_UPDATE_OTHER_INFO = "other_info";
    private static final String CALLBACK_BUTTON_UPDATE_GEOMETRY = "geometry";
    private static final String CALLBACK_BUTTON_UPDATE_MATHS_UPLOAD = "maths_u";
    private static final String CALLBACK_BUTTON_UPDATE_ART_UPLOAD = "art_u";
    private static final String CALLBACK_BUTTON_UPDATE_ENGLISH_UPLOAD = "english_u";
    private static final String CALLBACK_BUTTON_UPDATE_ITALIAN_UPLOAD = "italian_u";
    private static final String CALLBACK_BUTTON_UPDATE_TECHNOLOGY_UPLOAD = "technology_u";
    private static final String CALLBACK_BUTTON_UPDATE_SCIENCE_UPLOAD = "science_u";
    private static final String CALLBACK_BUTTON_UPDATE_GERMAN_UPLOAD = "german_u";
    private static final String CALLBACK_BUTTON_UPDATE_SPANISH_UPLOAD = "spanish_u";
    private static final String CALLBACK_BUTTON_UPDATE_GEOGRAPHY_UPLOAD = "geography_u";
    private static final String CALLBACK_BUTTON_UPDATE_HISTORY_UPLOAD = "history_u";
    private static final String CALLBACK_BUTTON_UPDATE_OTHER_INFO_UPLOAD = "other_info_u";
    private static final String CALLBACK_BUTTON_UPDATE_GEOMETRY_UPLOAD = "geometry_u";

    @Override
    public void onUpdateReceived(Update update) {
        try {
            new File("geography.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("italian.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("english.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("art.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("maths.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("geometry.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("technology.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("science.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("other.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("german.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("spanish.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("history.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("geographyname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("italianname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("englishname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("artname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("mathsname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("geometryname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("technologyname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("sciencename.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("othername.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("germanname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("spanishname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File("historyname.ser").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (art.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            art = fileid.readMapArt();
            consoleLogger.debug("Loaded " + art.size());
        }
        if (eng.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            eng = fileid.readMapArt();
            consoleLogger.debug("Loaded " + eng.size());
        }
        if (geo.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            geo = fileid.readMapArt();
            consoleLogger.debug("Loaded " + geo.size());
        }
        if (geom.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            geom = fileid.readMapArt();
            consoleLogger.debug("Loaded " + geom.size());
        }
        if (ger.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            ger = fileid.readMapArt();
            consoleLogger.debug("Loaded " + ger.size());
        }
        if (his.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            his = fileid.readMapArt();
            consoleLogger.debug("Loaded " + his.size());
        }
        if (ita.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            ita = fileid.readMapArt();
            consoleLogger.debug("Loaded " + ita.size());
        }
        if (othr.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            othr = fileid.readMapArt();
            consoleLogger.debug("Loaded " + othr.size());
        }
        if (sci.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            art = fileid.readMapArt();
            consoleLogger.debug("Loaded " + sci.size());
        }
        if (spa.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            art = fileid.readMapArt();
            consoleLogger.debug("Loaded " + spa.size());
        }
        if (tec.size() == 0) {
            consoleLogger.debug("Loading map");
            Fileid fileid = new Fileid();
            tec = fileid.readMapArt();
            consoleLogger.debug("Loaded " + tec.size());
        }
        User from = captureUserIds(update);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        int message_id = getMessageId(update);
        if (update.hasCallbackQuery() && !update.getCallbackQuery().getData().equals("") && update.getCallbackQuery().getInlineMessageId() == null) {
            update.getCallbackQuery().getMessage().getMessageId();
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
                        .setText("Ciao! Questo è il bot della 3^A.\n" +
                                "Fidati, sarà utile. I comandi sono elencati qui sotto, nella casella dei comandi" + EmojiParser.parseToUnicode(":point_down:\n" +
                                "*Per ulteriori informazioni, scrivi /help*"));
                new_message.setParseMode("Markdown");
                new_message.setReplyMarkup(markupInline);
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
            if (call_data.equals(CALLBACK_BUTTON_UPDATE_GEOMETRY)){
                SendDocument d = new SendDocument();
                try {
                    execute(d);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_ART_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di arte da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di arte da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (call_data.contains(CALLBACK_BUTTON_UPDATE_ENGLISH_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di inglese da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di inglese da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_GEOGRAPHY_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di geografia da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di geografia da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_GERMAN_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di tedesco da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di tedesco da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_HISTORY_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di storia da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di storia da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_ITALIAN_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di italiano da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di italiano da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_MATHS_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di matematica da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di matematica da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_OTHER_INFO_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale aggiuntivo da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale miscellaneo da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_SCIENCE_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di scienze da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "),  rispondi con il materiale di scienze da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_SPANISH_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di spagnolo da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di spagnolo da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_TECHNOLOGY_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di tecnica da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di tecnica da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_GEOMETRY_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di geometria da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di geometria da caricare"));
                }
                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        Long chatid = chat_id(update);
        Long group = -1001346073666L;
        if (!(chatid.equals(group)) && (chatid != -448643200L)) {
            System.out.println("lol");
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Questo bot va usato nel gruppo apposito!", "");
        } else if (updateHasText(update, "/start@schiavoduepuntozerorobot") || updateHasText(update, "Cavolo è 'sta cosa?") || updateHasText(update, "/start")) {
            SendMessage m = new SendMessage();
            SendSticker s = new SendSticker();
            long chat_id = update.getMessage().getChatId();
            safeSendUpdate(update, s, "", "CAACAgIAAxkBAAIPp142w9opqZieTbBK_5Do45KQxYJgAAIIAAPANk8Tb2wmC94am2kYBA");
            m.setChatId(chat_id);
            if (!update.getMessage().isUserMessage()) {
                m.setReplyToMessageId(message_id);
                m.setText("Ciao, Benvenuto allo schiavoduepuntozerorobot! Premi il bottone per saperne di più");
            }
            rowInline.add(new InlineKeyboardButton().setText("Cos..?").setCallbackData(CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT));
            rowInline.add(new InlineKeyboardButton().setText("No me ne vado").setCallbackData(CALLBACK_BUTTON_UPDATE_FROWN_FACE));
            rowsInline.add(rowInline);
            markupInline.setKeyboard(rowsInline);
            m.setReplyMarkup(markupInline);
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateHasText(update, "/cat@schiavoduepuntozerorobot") || updateHasText(update, "Gatto " + EmojiParser.parseToUnicode(":cat2:") + EmojiParser.parseToUnicode(":dash:")) || updateHasText(update, "/cat")) {
            String catjson = "";
            try {
                URL url = new URL("https://api.thecatapi.com/v1/images/search");
                URLConnection yc = null;
                yc = url.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                    catjson = catjson + inputLine;
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String unmunged = catjson.replaceAll("^\\[", "").replaceAll("\\]$", "");
            JSONObject obj = new JSONObject(unmunged);

            String pageName = obj.getString("url");
            consoleLogger.info(pageName);
            if (pageName.toLowerCase().endsWith(".jpg") || pageName.toLowerCase().endsWith(".jpeg") || pageName.toLowerCase().endsWith(".png")) {
                SendPhoto ph = new SendPhoto();
                ph.setPhoto(pageName);
                ph.setChatId(update.getMessage().getChatId());
                ph.setCaption("CAT!!");
                try {
                    execute(ph);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (updateHasText(update, "/dog@schiavoduepuntozerorobot") || updateHasText(update, "Cane " + EmojiParser.parseToUnicode(":dog2:") + EmojiParser.parseToUnicode(":dash:")) || updateHasText(update, "/dog")) {
            String dogjson = "";
            try {
                URL url = new URL("https://random.dog/woof.json");
                URLConnection yc = null;
                yc = url.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                    dogjson = dogjson + inputLine;
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            JSONObject obj = new JSONObject(dogjson);

            String pageName = obj.getString("url");
            consoleLogger.info(pageName);
            if (pageName.toLowerCase().endsWith(".jpg") || pageName.toLowerCase().endsWith(".jpeg") || pageName.toLowerCase().endsWith(".png")) {
                SendPhoto ph = new SendPhoto();
                ph.setPhoto(pageName);
                ph.setChatId(update.getMessage().getChatId());
                ph.setCaption("DOG!!");
                try {
                    execute(ph);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (pageName.toLowerCase().endsWith(".mp4") || pageName.toLowerCase().endsWith(".webm")) {
                SendVideo vid = new SendVideo();
                vid.setVideo(pageName);
                vid.setChatId(update.getMessage().getChatId());
                vid.setCaption("DOG!!");
                try {
                    execute(vid);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (pageName.toLowerCase().endsWith(".gif")) {
                SendAnimation gif = new SendAnimation();
                gif.setAnimation(pageName);
                gif.setChatId(update.getMessage().getChatId());
                gif.setCaption("DOG!!");
                try {
                    execute(gif);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (updateHasText(update, "/add") || updateHasText(update, "/add@schiavoduepuntozerorobot")) {
            SendMessage m = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                    .setText("Di quale materia vuoi aggiungere materiale?")
                    .row()
                    .button("Matematica", CALLBACK_BUTTON_UPDATE_MATHS_UPLOAD)
                    .button("Arte", CALLBACK_BUTTON_UPDATE_ART_UPLOAD)
                    .endRow()
                    .row()
                    .button("Inglese", CALLBACK_BUTTON_UPDATE_ENGLISH_UPLOAD)
                    .button("Italiano", CALLBACK_BUTTON_UPDATE_ITALIAN_UPLOAD)
                    .endRow()
                    .row()
                    .button("Tecnica", CALLBACK_BUTTON_UPDATE_TECHNOLOGY_UPLOAD)
                    .button("Scienze", CALLBACK_BUTTON_UPDATE_SCIENCE_UPLOAD)
                    .endRow()
                    .row()
                    .button("Tedesco", CALLBACK_BUTTON_UPDATE_GERMAN_UPLOAD)
                    .button("Spagnolo", CALLBACK_BUTTON_UPDATE_SPANISH_UPLOAD)
                    .endRow()
                    .row()
                    .button("Geografia", CALLBACK_BUTTON_UPDATE_GEOGRAPHY_UPLOAD)
                    .button("Geometria", CALLBACK_BUTTON_UPDATE_GEOMETRY_UPLOAD)
                    .endRow()
                    .row()
                    .button("Storia", CALLBACK_BUTTON_UPDATE_HISTORY_UPLOAD)
                    .button("Altro", CALLBACK_BUTTON_UPDATE_OTHER_INFO_UPLOAD)
                    .endRow()
                    .build();
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di arte")) {
            SendMessage m = new SendMessage();
            if (update.getMessage().hasDocument()||update.getMessage().hasPhoto()||update.getMessage().hasVideo()||update.getMessage().hasAudio()){
                Fileid fileid = new Fileid();
                System.out.println(art);
                if (update.getMessage().hasDocument()) {
                    if (!listContains(artname, update.getMessage().getDocument().getFileUniqueId())) {
                        System.out.println("file_unique_id: " + update.getMessage().getDocument().getFileUniqueId());
                        safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        artname.add(update.getMessage().getDocument().getFileUniqueId());
                        art.add(update.getMessage().getDocument().getFileId());
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapArt(art);
                        fileid.writeMapArtName(artname);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                } else if (update.getMessage().hasVideo()) {
                    if (!listContains(artname, update.getMessage().getVideo().getFileUniqueId())) {
                        safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        artname.add(update.getMessage().getVideo().getFileUniqueId());
                        art.add(update.getMessage().getVideo().getFileId());
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapArt(art);
                        fileid.writeMapArtName(artname);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                } else if (update.getMessage().hasPhoto()) {
                    ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
                    String photofile_id = photos.stream()
                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                            .findFirst()
                            .orElse(null).getFileId();
                    String photofile_unique_id = photos.stream()
                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                            .findFirst()
                            .orElse(null).getFileUniqueId();
                    System.out.println(photofile_id);
                    if (!listContains(artname, photofile_unique_id)) {
                        safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        art.add(photofile_id);
                        artname.add(photofile_unique_id);
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapArt(art);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                } else if (update.getMessage().hasAudio()){
                    if (!art.contains(update.getMessage().getAudio().getFileUniqueId())) {
                        safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        art.add(update.getMessage().getAudio().getFileId());
                        artname.add(update.getMessage().getAudio().getFileUniqueId());
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapArt(art);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                }
            } else {
                safeSendUpdate(update, m, "", "Questo tipo di contenuto non può essere salvato. Per favore manda un file generico (,pdf, .txt, .zip), un foto, un file di audio o un video", "");
            }
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di inglese")) {
            SendMessage m = new SendMessage();
            if (update.getMessage().hasDocument()||update.getMessage().hasPhoto()||update.getMessage().hasVideo()||update.getMessage().hasAudio()){
                Fileid fileid = new Fileid();
                System.out.println(eng);
                if (update.getMessage().hasDocument()) {
                    if (!listContains(engname, update.getMessage().getDocument().getFileUniqueId())) {
                        System.out.println("file_unique_id: " + update.getMessage().getDocument().getFileUniqueId());
                        safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        engname.add(update.getMessage().getDocument().getFileUniqueId());
                        eng.add(update.getMessage().getDocument().getFileId());
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapEnglish(eng);
                        fileid.writeMapEnglishName(engname);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                } else if (update.getMessage().hasVideo()) {
                    if (!listContains(engname, update.getMessage().getVideo().getFileUniqueId())) {
                        safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        engname.add(update.getMessage().getVideo().getFileUniqueId());
                        eng.add(update.getMessage().getVideo().getFileId());
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapEnglish(eng);
                        fileid.writeMapEnglishName(engname);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                } else if (update.getMessage().hasPhoto()) {
                    ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
                    String photofile_id = photos.stream()
                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                            .findFirst()
                            .orElse(null).getFileId();
                    String photofile_unique_id = photos.stream()
                            .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                            .findFirst()
                            .orElse(null).getFileUniqueId();
                    System.out.println(photofile_id);
                    if (!listContains(engname, photofile_unique_id)) {
                        safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        eng.add(photofile_id);
                        engname.add(photofile_unique_id);
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapEnglish(eng);
                        fileid.writeMapEnglishName(engname);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                } else if (update.getMessage().hasAudio()){
                    if (!listContains(engname, update.getMessage().getAudio().getFileUniqueId())) {
                        safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                        eng.add(update.getMessage().getAudio().getFileId());
                        engname.add(update.getMessage().getAudio().getFileUniqueId());
                        safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                        fileid.writeMapEnglish(eng);
                        fileid.writeMapEnglishName(engname);
                    } else {
                        safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                    }
                }
            } else {
                safeSendUpdate(update, m, "", "Questo tipo di contenuto non può essere salvato. Per favore manda un file generico (,pdf, .txt, .zip), un foto, un file di audio o un video", "");
            }
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di geografia")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di storia")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di geometria")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateHasText(update, "/howtoclassroom") || updateHasText(update, "/howtoclassroom@schiavoduepuntozerorobot")) {

        } else if (updateIsReplyHasText(update, "rispondi con il materiale di italiano")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di matematica")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale in più")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di scienze")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di tedesco")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di spagnolo")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");

            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di tecnica")) {
            GetFile gfile = new GetFile();
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione potrebbe impiegare un secondo, sii paziente...", "");
            System.out.println("Successfully downloaded file");
            safeSendUpdate(update, m, "", "Il materiale è stato salvato", "");
        } else if (updateHasText(update, "/clear") || updateHasText(update, "/clear@schiavoduepuntozerorobot")) {
            SendMessage m = new SendMessage();
            Fileid fileid = new Fileid();
            art.clear();
            fileid.writeMapArt(art);
            tec.clear();
            fileid.writeMapArt(tec);
            ger.clear();
            fileid.writeMapArt(ger);
            geo.clear();
            fileid.writeMapArt(geo);
            geom.clear();
            fileid.writeMapArt(geom);
            mat.clear();
            fileid.writeMapArt(mat);
            ita.clear();
            fileid.writeMapArt(ita);
            eng.clear();
            fileid.writeMapArt(eng);
            his.clear();
            fileid.writeMapArt(his);
            sci.clear();
            fileid.writeMapArt(sci);
            othr.clear();
            fileid.writeMapArt(othr);
            spa.clear();
            fileid.writeMapArt(spa);
            artname.clear();
            fileid.writeMapArt(art);
            tecname.clear();
            fileid.writeMapArt(tec);
            gername.clear();
            fileid.writeMapArt(ger);
            geoname.clear();
            fileid.writeMapArt(geo);
            geomname.clear();
            fileid.writeMapArt(geom);
            matname.clear();
            fileid.writeMapArt(mat);
            itaname.clear();
            fileid.writeMapArt(ita);
            engname.clear();
            fileid.writeMapArt(eng);
            hisname.clear();
            fileid.writeMapArt(his);
            sciname.clear();
            fileid.writeMapArt(sci);
            othrname.clear();
            fileid.writeMapArt(othr);
            spaname.clear();
            fileid.writeMapArt(spa);
            safeSendUpdate(update, m, "", "Tutti i file sono stati cancellati", "");
        } else if (updateHasText(update, "/urgenthelp@schiavoduepuntozerorobot") || updateHasText(update, "Urgenteee!") || updateHasText(update, "/urgenthelp")) {
            request.put(update.getMessage().getFrom().getFirstName(), message_id);
            SendMessage m = new SendMessage();
            ForceReplyKeyboard f = new ForceReplyKeyboard();
            m.setReplyToMessageId(message_id);
            f.setSelective(true);
            m.setReplyMarkup(f);
            safeSendUpdate(update, m, "", "Ok. Ora rispondi a questo messaggio con la tua richiesta urgente", "");
        } else if (update.getMessage().isReply() && update.getMessage().getReplyToMessage().getText().equals("Ok. Ora rispondi a questo messaggio con la tua richiesta urgente")) {
            SendMessage m = new SendMessage();
            java.util.Date time = new java.util.Date((long) update.getMessage().getDate() * 1000);
            safeSendUpdate(update, m, "", update.getMessage().getFrom().getFirstName() + "@" + time + ": " + update.getMessage().getText(), "-448643200L");
        } else if (updateHasText(update, "/msg") && chatid == -448643200L && update.getMessage().isReply()) {
            SendMessage m = new SendMessage();
            ForceReplyKeyboard f = new ForceReplyKeyboard();
            m.setReplyToMessageId(message_id);
            f.setSelective(true);
            m.setReplyMarkup(f);
            String[] command = update.getMessage().getReplyToMessage().getText().split("@");
            safeSendUpdate(update, m, "", "Dimmi la risposta alla richiesta di " + command[0].replace(" ", ""), "-448643200L");

        } else if (update.getMessage().isReply() && update.getMessage().getReplyToMessage().getText().contains("Dimmi la risposta alla richiesta di")) {
            SendMessage m = new SendMessage();
            //m.setReplyToMessageId(request.get(update.getMessage().getReplyToMessage().getText().replace("Dimmi la risposta alla richiesta di ", "")));
            m.setReplyToMessageId((Integer) request.get(update.getMessage().getReplyToMessage().getText().replace("Dimmi la risposta alla richiesta di ", "")));
            safeSendUpdate(update, m, "", "Risposta: ", "-1001346073666L");
            ForwardMessage f = new ForwardMessage();
            f.setMessageId(message_id);
            f.setChatId(-1001346073666L);
            f.setFromChatId(update.getMessage().getChatId());
            request.remove(update.getMessage().getReplyToMessage().getText().replace("Dimmi la risposta alla richiesta di ", ""));
            try {
                execute(f);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateHasText(update, "Compiti" + EmojiParser.parseToUnicode(":pencil:")) || updateHasText(update, "/compiti@schiavoduepuntozerorobot") || updateHasText(update, "/compiti")) {
            SendMessage m = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                    .setText("Quali compiti vuoi?")
                    .row()
                    .button("Matematica", CALLBACK_BUTTON_UPDATE_MATHS)
                    .button("Arte", CALLBACK_BUTTON_UPDATE_ART)
                    .endRow()
                    .row()
                    .button("Inglese", CALLBACK_BUTTON_UPDATE_ENGLISH)
                    .button("Italiano", CALLBACK_BUTTON_UPDATE_ITALIAN)
                    .endRow()
                    .row()
                    .button("Tecnica", CALLBACK_BUTTON_UPDATE_TECHNOLOGY)
                    .button("Scienze", CALLBACK_BUTTON_UPDATE_SCIENCE)
                    .endRow()
                    .row()
                    .button("Tedesco", CALLBACK_BUTTON_UPDATE_GERMAN)
                    .button("Spagnolo", CALLBACK_BUTTON_UPDATE_SPANISH)
                    .endRow()
                    .row()
                    .button("Geografia", CALLBACK_BUTTON_UPDATE_GEOGRAPHY)
                    .button("Geometria", CALLBACK_BUTTON_UPDATE_GEOMETRY)
                    .endRow()
                    .row()
                    .button("Storia", CALLBACK_BUTTON_UPDATE_HISTORY)
                    .button("Altro", CALLBACK_BUTTON_UPDATE_OTHER_INFO)
                    .endRow()
                    .build();
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateHasText(update, "/help@schiavoduepuntozerorobot") || updateHasText(update, "/help")) {
            ReplyKeyboardMarkup r = new ReplyKeyboardMarkup();
            SendMessage m = new SendMessage();
            List<KeyboardRow> keyboard = new ArrayList<>();
            r.setOneTimeKeyboard(true);
            KeyboardRow row = new KeyboardRow();
            m.setText("Ecco la lista dei comandi disponibili:");
            m.setChatId(update.getMessage().getChatId());
            row.add("Cavolo è 'sta cosa?");
            keyboard.add(row);
            row = new KeyboardRow();
            row.add("Meet");
            row.add("Compiti" + EmojiParser.parseToUnicode(":pencil:"));
            keyboard.add(row);
            row = new KeyboardRow();
            row.add("Gatto " + EmojiParser.parseToUnicode(":cat2:") + EmojiParser.parseToUnicode(":dash:"));
            row.add("Urgenteee!");
            row.add("Cane " + EmojiParser.parseToUnicode(":dog2:") + EmojiParser.parseToUnicode(":dash:"));
            keyboard.add(row);
            r.setKeyboard(keyboard);
            m.setReplyMarkup(r);
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "schiavoduepuntozerorobot";
    }

    @Override
    public String getBotToken() {
        return "1030259166:AAFuDWB-h-_sPVninl9abC24ib-OfrO_7Ak";
    }

    private void safeSendUpdate(Update update, SendMessage m, String error, String text, String chatid) {
        if (update.hasMessage()) {
            m.setText(text);
            if (chatid.equals("")) {
                m.setChatId(update.getMessage().getChatId());
            } else {
                m.setChatId(chatid);
            }
            try {
                execute(m);
                System.out.println("I answered");
            } catch (TelegramApiException e) {
                if (!error.isEmpty())
                    System.out.println(error);
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
            m.setText(text);
            if (chatid.equals("")) {
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
            } else {
                m.setChatId(chatid);
            }
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

    private boolean listContains(Collection toserach, String searchfor){
        boolean found = false;
        Iterator<String> searchIter = toserach.iterator();
        while(searchIter.hasNext())
            if (searchIter.next().equals(searchfor)) {
                found = true;
            }
        return found;
    }

    private boolean updateHasText(Update update, String text) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    private Integer getMessageId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getMessageId();
        } else if (update.hasCallbackQuery()) {
            if (update.getCallbackQuery().getInlineMessageId() != null) {
                System.out.println("Callback query was generated by an inline query");
            } else if (update.getCallbackQuery().getInlineMessageId() == null) {
                return (update.getCallbackQuery().getMessage().getMessageId());
            }
        } else {
            return 0;
        }
        return 0;
    }

    private boolean updateIsReplyHasText(Update update, String text) {
        if (update.getMessage().isReply() && update.getMessage().getReplyToMessage().getText().contains(text)) {
            return true;
        } else {
            return false;
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

    private long chat_id(Update update) {
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId();
        } else if (update.hasMessage()) {
            return update.getMessage().getChatId();
        } else {
            return 0;
        }
    }

    private User captureUserIds(Update update) {
        if (update.hasMessage()) {
            User from = update.getMessage().getFrom();
            return from;
        } else if (update.hasCallbackQuery()) {
            User from = update.getCallbackQuery().getFrom();
            return from;
        } else if (update.hasInlineQuery()) {
            User from = update.getInlineQuery().getFrom();
            return from;
        } else {
            return null;
        }
    }

    private void saveMaterial(Update update, Collection collection, Collection serialisedname){
        SendMessage m = new SendMessage();
        if (update.getMessage().hasDocument()||update.getMessage().hasPhoto()||update.getMessage().hasVideo()||update.getMessage().hasAudio()){
            Fileid fileid = new Fileid();
            if (update.getMessage().hasDocument()) {
                if (!listContains(serialisedname, update.getMessage().getDocument().getFileUniqueId())) {
                    safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                    serialisedname.add(update.getMessage().getDocument().getFileUniqueId());
                    collection.add(update.getMessage().getDocument().getFileId());
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                    fileid.writeMapEnglish(collection);
                    fileid.writeMapEnglishName(serialisedname);
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            } else if (update.getMessage().hasVideo()) {
                if (!listContains(serialisedname, update.getMessage().getVideo().getFileUniqueId())) {
                    safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                    serialisedname.add(update.getMessage().getVideo().getFileUniqueId());
                    collection.add(update.getMessage().getVideo().getFileId());
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                    fileid.writeMapEnglish(collection);
                    fileid.writeMapEnglishName(serialisedname);
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            } else if (update.getMessage().hasPhoto()) {
                ArrayList<PhotoSize> photos = (ArrayList<PhotoSize>) update.getMessage().getPhoto();
                String photofile_id = photos.stream()
                        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                        .findFirst()
                        .orElse(null).getFileId();
                String photofile_unique_id = photos.stream()
                        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                        .findFirst()
                        .orElse(null).getFileUniqueId();
                System.out.println(photofile_id);
                if (!listContains(serialisedname, photofile_unique_id)) {
                    safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                    collection.add(photofile_id);
                    serialisedname.add(photofile_unique_id);
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                    fileid.writeMapEnglish(collection);
                    fileid.writeMapEnglishName(serialisedname);
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            } else if (update.getMessage().hasAudio()){
                if (!listContains(serialisedname, update.getMessage().getAudio().getFileUniqueId())) {
                    safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiregare meno di un secondo...", "");
                    collection.add(update.getMessage().getAudio().getFileId());
                    serialisedname.add(update.getMessage().getAudio().getFileUniqueId());
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                    fileid.writeMapEnglish(collection);
                    fileid.writeMapEnglishName(serialisedname);
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            }
        } else {
            safeSendUpdate(update, m, "", "Questo tipo di contenuto non può essere salvato. Per favore manda un file generico (,pdf, .txt, .zip), un foto, un file di audio o un video", "");
        }
    }
    private void deleteMessage(Update update, DeleteMessage dmsg, String error) {
        try {
            execute(dmsg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println(error);
        }
    }
}
