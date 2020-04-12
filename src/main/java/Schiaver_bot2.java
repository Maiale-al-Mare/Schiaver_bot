import com.vdurmont.emoji.EmojiParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatAdministrators;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.media.*;
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
    LinkedList<String> mat = new LinkedList<>();
    LinkedList<String> art = new LinkedList<>();
    Integer currentIndex = 0;
    LinkedList<String> eng = new LinkedList<>();
    LinkedList<String> ita = new LinkedList<>();
    LinkedList<String> tec = new LinkedList<>();
    LinkedList<String> sci = new LinkedList<>();
    LinkedList<String> ger = new LinkedList<>();
    LinkedList<String> spa = new LinkedList<>();
    LinkedList<String> geo = new LinkedList<>();
    LinkedList<String> his = new LinkedList<>();
    LinkedList<String> rel = new LinkedList<>();
    LinkedList<String> othr = new LinkedList<>();
    LinkedList<String> geom = new LinkedList<>();
    LinkedList<String> matname = new LinkedList<>();
    LinkedList<String> relname = new LinkedList<>();
    LinkedList<String> artname = new LinkedList<>();
    LinkedList<String> engname = new LinkedList<>();
    LinkedList<String> itaname = new LinkedList<>();
    LinkedList<String> tecname = new LinkedList<>();
    LinkedList<String> sciname = new LinkedList<>();
    LinkedList<String> gername = new LinkedList<>();
    LinkedList<String> spaname = new LinkedList<>();
    LinkedList<String> geoname = new LinkedList<>();
    LinkedList<String> hisname = new LinkedList<>();
    LinkedList<String> othrname = new LinkedList<>();
    LinkedList<String> geomname = new LinkedList<>();
    private static final String CALLBACK_BUTTON_UPDATE_CANCEL = "cancel";
    private static final String CALLBACK_BUTTON_UPDATE_ART_NEXT = "art_n";
    private static final String CALLBACK_BUTTON_UPDATE_ENGLISH_NEXT = "eng_n";
    private static final String CALLBACK_BUTTON_UPDATE_ITALIAN_NEXT = "ita_n";
    private static final String CALLBACK_BUTTON_UPDATE_TECHNOLOGY_NEXT = "tec_n";
    private static final String CALLBACK_BUTTON_UPDATE_MATHS_NEXT = "mat_n";
    private static final String CALLBACK_BUTTON_UPDATE_RELIGION_NEXT = "rel_n";
    private static final String CALLBACK_BUTTON_UPDATE_SCIENCE_NEXT = "sci_n";
    private static final String CALLBACK_BUTTON_UPDATE_GERMAN_NEXT = "ger_n";
    private static final String CALLBACK_BUTTON_UPDATE_SPANISH_NEXT = "spa_n";
    private static final String CALLBACK_BUTTON_UPDATE_HISTORY_NEXT = "his_n";
    private static final String CALLBACK_BUTTON_UPDATE_GEOGRAPHY_NEXT = "geo_n";
    private static final String CALLBACK_BUTTON_UPDATE_OTHER_INFO_NEXT = "othr_n";
    private static final String CALLBACK_BUTTON_UPDATE_GEOMETRY_NEXT = "geom_n";
    private static final String CALLBACK_BUTTON_UPDATE_ART_PREVIOUS = "art_p";
    private static final String CALLBACK_BUTTON_UPDATE_ENGLISH_PREVIOUS = "eng_p";
    private static final String CALLBACK_BUTTON_UPDATE_ITALIAN_PREVIOUS = "ita_p";
    private static final String CALLBACK_BUTTON_UPDATE_TECHNOLOGY_PREVIOUS = "tec_p";
    private static final String CALLBACK_BUTTON_UPDATE_MATHS_PREVIOUS = "mat_p";
    private static final String CALLBACK_BUTTON_UPDATE_RELIGION_PREVIOUS = "rel_p";
    private static final String CALLBACK_BUTTON_UPDATE_SCIENCE_PREVIOUS = "sci_p";
    private static final String CALLBACK_BUTTON_UPDATE_GERMAN_PREVIOUS = "ger_p";
    private static final String CALLBACK_BUTTON_UPDATE_SPANISH_PREVIOUS = "spa_p";
    private static final String CALLBACK_BUTTON_UPDATE_HISTORY_PREVIOUS = "his_p";
    private static final String CALLBACK_BUTTON_UPDATE_GEOGRAPHY_PREVIOUS = "geo_p";
    private static final String CALLBACK_BUTTON_UPDATE_OTHER_INFO_PREVIOUS = "othr_p";
    private static final String CALLBACK_BUTTON_UPDATE_GEOMETRY_PREVIOUS = "geom_p";
    private static final String CALLBACK_BUTTON_UPDATE_MESSAGE_TEXT = "update_msg_text";
    private static final String CALLBACK_BUTTON_UPDATE_DAI_SCHERZO = "no_really";
    private static final String CALLBACK_BUTTON_UPDATE_THUMBSUP = "thumbsup";
    private static final String CALLBACK_BUTTON_UPDATE_FROWN_FACE = "frown";
    private static final String CALLBACK_BUTTON_UPDATE_MATHS = "maths";
    private static final String CALLBACK_BUTTON_UPDATE_ART = "art";
    private static final String CALLBACK_BUTTON_UPDATE_ENGLISH = "english";
    private static final String CALLBACK_BUTTON_UPDATE_ITALIAN = "italian";
    private static final String CALLBACK_BUTTON_UPDATE_TECHNOLOGY = "technology";
    private static final String CALLBACK_BUTTON_UPDATE_RELIGION = "religion";
    private static final String CALLBACK_BUTTON_UPDATE_SCIENCE = "science";
    private static final String CALLBACK_BUTTON_UPDATE_GERMAN = "german";
    private static final String CALLBACK_BUTTON_UPDATE_SPANISH = "spanish";
    private static final String CALLBACK_BUTTON_UPDATE_GEOGRAPHY = "geography";
    private static final String CALLBACK_BUTTON_UPDATE_HISTORY = "history";
    private static final String CALLBACK_BUTTON_UPDATE_OTHER_INFO = "other_info";
    private static final String CALLBACK_BUTTON_UPDATE_GEOMETRY = "geometry";
    private static final String CALLBACK_BUTTON_DELETE_MATHS = "maths";
    private static final String CALLBACK_BUTTON_DELETE_ART = "art_d";
    private static final String CALLBACK_BUTTON_DELETE_ENGLISH = "english_d";
    private static final String CALLBACK_BUTTON_DELETE_ITALIAN = "italian_d";
    private static final String CALLBACK_BUTTON_DELETE_TECHNOLOGY = "technology_d";
    private static final String CALLBACK_BUTTON_DELETE_RELIGION = "religion_d";
    private static final String CALLBACK_BUTTON_DELETE_SCIENCE = "science_d";
    private static final String CALLBACK_BUTTON_DELETE_GERMAN = "german_d";
    private static final String CALLBACK_BUTTON_DELETE_SPANISH = "spanish_d";
    private static final String CALLBACK_BUTTON_DELETE_GEOGRAPHY = "geography_d";
    private static final String CALLBACK_BUTTON_DELETE_HISTORY = "history_d";
    private static final String CALLBACK_BUTTON_DELETE_OTHER_INFO = "other_info_d";
    private static final String CALLBACK_BUTTON_DELETE_GEOMETRY = "geometry_d";
    private static final String CALLBACK_BUTTON_UPDATE_MATHS_UPLOAD = "maths_u";
    private static final String CALLBACK_BUTTON_UPDATE_ART_UPLOAD = "art_u";
    private static final String CALLBACK_BUTTON_UPDATE_ENGLISH_UPLOAD = "english_u";
    private static final String CALLBACK_BUTTON_UPDATE_ITALIAN_UPLOAD = "italian_u";
    private static final String CALLBACK_BUTTON_UPDATE_TECHNOLOGY_UPLOAD = "technology_u";
    private static final String CALLBACK_BUTTON_UPDATE_SCIENCE_UPLOAD = "science_u";
    private static final String CALLBACK_BUTTON_UPDATE_GERMAN_UPLOAD = "german_u";
    private static final String CALLBACK_BUTTON_UPDATE_RELIGION_UPLOAD = "religion_u";
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
            new File("religion.ser").createNewFile();
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
            new File("religionname.ser").createNewFile();
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
            try {

                File file = new File("art.ser");
                if (!(file.length() == 0)) {
                    consoleLogger.debug("Loading map");
                    Fileid fileid = new Fileid();
                    art = fileid.readMapArt();
                    consoleLogger.debug("Loaded " + art.size());
                } else {
                    System.out.println("File is empty");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (eng.size() == 0) {
            File file = new File("english.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                eng = fileid.readMapEnglish();
                consoleLogger.debug("Loaded " + eng.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (geo.size() == 0) {
            File file = new File("geography.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                geo = fileid.readMapGeography();
                consoleLogger.debug("Loaded " + geo.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (geom.size() == 0) {
            File file = new File("geometry.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                geom = fileid.readMapGeometry();
                consoleLogger.debug("Loaded " + geom.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (ger.size() == 0) {
            File file = new File("german.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                ger = fileid.readMapGerman();
                consoleLogger.debug("Loaded " + ger.size());
            } else {
                System.out.println("Fild is empty");
            }
        }
        if (his.size() == 0) {
            File file = new File("history.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                his = fileid.readMapHistory();
                consoleLogger.debug("Loaded " + his.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (ita.size() == 0) {
            File file = new File("italian.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                ita = fileid.readMapItalian();
                consoleLogger.debug("Loaded " + ita.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (rel.size() == 0) {
            File file = new File("religion.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                rel = fileid.readMapReligion();
                consoleLogger.debug("Loaded " + rel.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (othr.size() == 0) {
            File file = new File("other.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                othr = fileid.readMapOther();
                consoleLogger.debug("Loaded " + othr.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (sci.size() == 0) {
            File file = new File("science.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                sci = fileid.readMapScience();
                consoleLogger.debug("Loaded " + sci.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (spa.size() == 0) {
            File file = new File("spanish.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                spa = fileid.readMapSpanish();
                consoleLogger.debug("Loaded " + spa.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (tec.size() == 0) {
            File file = new File("technology.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                tec = fileid.readMapTechnology();
                consoleLogger.debug("Loaded " + tec.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (artname.size() == 0) {
            File file = new File("artname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                artname = fileid.readMapArtName();
                consoleLogger.debug("Loaded " + artname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (engname.size() == 0) {
            File file = new File("englishname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                engname = fileid.readMapEnglishName();
                consoleLogger.debug("Loaded " + engname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (geoname.size() == 0) {
            consoleLogger.debug("Loading map");
            File file = new File("geographyname.ser");
            if (!(file.length() == 0)) {
                Fileid fileid = new Fileid();
                geoname = fileid.readMapGeographyName();
                consoleLogger.debug("Loaded " + geoname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (geomname.size() == 0) {
            File file = new File("geometryname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                geomname = fileid.readMapGeometryName();
                consoleLogger.debug("Loaded " + geomname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (gername.size() == 0) {
            File file = new File("germanname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                gername = fileid.readMapGermanName();
                consoleLogger.debug("Loaded " + gername.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (hisname.size() == 0) {
            File file = new File("historyname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                hisname = fileid.readMapHistoryName();
                consoleLogger.debug("Loaded " + hisname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (itaname.size() == 0) {
            File file = new File("italianname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                itaname = fileid.readMapItalianName();
                consoleLogger.debug("Loaded " + itaname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (relname.size() == 0) {
            File file = new File("religionname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                relname = fileid.readMapReligionName();
                consoleLogger.debug("Loaded " + relname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (othrname.size() == 0) {
            File file = new File("othername.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                othrname = fileid.readMapOther();
                consoleLogger.debug("Loaded " + othrname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (sciname.size() == 0) {
            File file = new File("sciencename.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                sciname = fileid.readMapScience();
                consoleLogger.debug("Loaded " + sciname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (spaname.size() == 0) {
            File file = new File("spanishname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                spaname = fileid.readMapSpanish();
                consoleLogger.debug("Loaded " + spaname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        if (tecname.size() == 0) {
            File file = new File("technologyname.ser");
            if (!(file.length() == 0)) {
                consoleLogger.debug("Loading map");
                Fileid fileid = new Fileid();
                tecname = fileid.readMapTechnology();
                consoleLogger.debug("Loaded " + tecname.size());
            } else {
                System.out.println("File is empty");
            }
        }
        User from = captureUserIds(update);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        GetChatAdministrators chatAdministrators = new GetChatAdministrators();
        chatAdministrators.setChatId(chat_id(update));
        int message_id = getMessageId(update);
        try {
            System.out.println(userStatus(update));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        if (update.hasCallbackQuery() && !update.getCallbackQuery().getData().equals("") && update.getCallbackQuery().getInlineMessageId() == null) {
            String call_data = update.getCallbackQuery().getData();
            System.out.println(call_data);
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

            if (call_data.equals(CALLBACK_BUTTON_UPDATE_ART_NEXT)) {
                try {
                    getNext(update, art, currentIndex, "art");
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (call_data.equals(CALLBACK_BUTTON_UPDATE_ART_PREVIOUS)) {
                getPrevious(update, art, "art");
            }

            if (call_data.equals(CALLBACK_BUTTON_UPDATE_CANCEL)) {
                DeleteMessage d = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, d, "");
            }

            if (call_data.equals(CALLBACK_BUTTON_UPDATE_ART)) {
                try {
                    getResources(update, art, "art");
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

            if (call_data.equals(CALLBACK_BUTTON_DELETE_ART)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                art.clear();
                fileid.writeMapArt(art);
                artname.clear();
                fileid.writeMapArtName(artname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per arte sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_OTHER_INFO)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                othr.clear();
                fileid.writeMapArt(othr);
                othrname.clear();
                fileid.writeMapArtName(othrname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file aggiuntivi sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_ENGLISH)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                eng.clear();
                fileid.writeMapArt(eng);
                engname.clear();
                fileid.writeMapArtName(engname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per inglese sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_GEOGRAPHY)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                geo.clear();
                fileid.writeMapArt(geo);
                geoname.clear();
                fileid.writeMapArtName(geoname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per geografia sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_GEOMETRY)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                geom.clear();
                fileid.writeMapArt(geom);
                geomname.clear();
                fileid.writeMapArtName(geomname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per geometria sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_GERMAN)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                ger.clear();
                fileid.writeMapArt(ger);
                gername.clear();
                fileid.writeMapArtName(gername);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per tedesco sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_HISTORY)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                his.clear();
                fileid.writeMapArt(his);
                hisname.clear();
                fileid.writeMapArtName(hisname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per storia sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_ITALIAN)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                ita.clear();
                fileid.writeMapArt(ita);
                itaname.clear();
                fileid.writeMapArtName(itaname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per italiano sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_MATHS)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                mat.clear();
                fileid.writeMapArt(mat);
                matname.clear();
                fileid.writeMapArtName(matname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per matematica sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_RELIGION)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                rel.clear();
                fileid.writeMapArt(rel);
                relname.clear();
                fileid.writeMapArtName(relname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per religione sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_SCIENCE)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                sci.clear();
                fileid.writeMapArt(sci);
                sciname.clear();
                fileid.writeMapArtName(sciname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per scienze sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_SPANISH)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                spa.clear();
                fileid.writeMapArt(spa);
                spaname.clear();
                fileid.writeMapArtName(spaname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per spagnolo sono stati cancellati", "");
            }

            if (call_data.equals(CALLBACK_BUTTON_DELETE_TECHNOLOGY)) {
                SendMessage m = new SendMessage();
                Fileid fileid = new Fileid();
                tec.clear();
                fileid.writeMapArt(tec);
                tecname.clear();
                fileid.writeMapArtName(tecname);
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                safeSendUpdate(update, m, "", "Tutti i file per arte sono stati cancellati", "");
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
            if (call_data.contains(CALLBACK_BUTTON_UPDATE_RELIGION_UPLOAD)) {
                ForceReplyKeyboard f = new ForceReplyKeyboard();
                DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
                deleteMessage(update, dmsg, "");
                SendMessage m = new SendMessage();
                f.setSelective(true);
                m.setReplyMarkup(f);
                m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                if (from.getUserName() != null) {
                    m.setText("@" + from.getUserName() + ", rispondi con il materiale di religione da caricare");
                } else {
                    m.setParseMode("Markdown");
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale di religione da caricare"));
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
                    m.setText(("[" + from.getFirstName() + "](tg://user?id=" + from.getId() + "), rispondi con il materiale aggiuntivo da caricare"));
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
        } else if (updateHasText(update, "/dice") || updateHasText(update, "/dice@schiavoduepuntozerorobot")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            SendDice dice = new SendDice()
                    .setChatId(chat_id(update));
            try {
                execute(dice);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            deleteMessage(update, dmsg, "");
        } else if (updateIsReplyHasText(update, "/bandice") || updateIsReplyHasText(update, "/bandice@schiavoduepuntozerorobot")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            SendSticker s = new SendSticker();
            s.setReplyToMessageId(update.getMessage().getReplyToMessage().getMessageId());
            safeSendUpdate(update, s, "", "CAACAgQAAxkBAAIG4l6MeFZqDOTaWAzeo6U6iBfr9bMhAAI_AAPI-uwTlXsuO2DmcrQYBA");
            deleteMessage(update, dmsg, "");
        } else if (updateHasText(update, "/bandice") || updateHasText(update, "/bandice@schiavoduepuntozerorobot")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            SendSticker s = new SendSticker();
            safeSendUpdate(update, s, "", "CAACAgQAAxkBAAIG4l6MeFZqDOTaWAzeo6U6iBfr9bMhAAI_AAPI-uwTlXsuO2DmcrQYBA");
            deleteMessage(update, dmsg, "");
        } else if (updateIsReplyHasText(update, "/weirddice") || updateIsReplyHasText(update, "/weirddice@schiavoduepuntozerorobot")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            SendSticker s = new SendSticker();
            s.setReplyToMessageId(update.getMessage().getReplyToMessage().getMessageId());
            safeSendUpdate(update, s, "", "CAACAgQAAxkBAAIG416MeJGajFOyTLvNXVw_g5IJkjL-AAJAAAPI-uwTAAFLxlIqCqyuGAQ");
            deleteMessage(update, dmsg, "");
        } else if (updateHasText(update, "/weirddice") || updateHasText(update, "/weirddice@schiavoduepuntozerorobot")) {
            DeleteMessage dmsg = new DeleteMessage(update.getMessage().getChatId(), update.getMessage().getMessageId());
            SendSticker s = new SendSticker();
            safeSendUpdate(update, s, "", "CAACAgQAAxkBAAIG416MeJGajFOyTLvNXVw_g5IJkjL-AAJAAAPI-uwTAAFLxlIqCqyuGAQ");
            deleteMessage(update, dmsg, "");
        } else if (updateHasText(update, "/add") || updateHasText(update, "/add@schiavoduepuntozerorobot")) {
            SendMessage m = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                    .setText("Di quale materia vuoi aggiungere materiale? (Nessun limite di grandezza!)")
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
                    .button("Religione", CALLBACK_BUTTON_UPDATE_RELIGION_UPLOAD)
                    .endRow()
                    .row()
                    .button("Altro", CALLBACK_BUTTON_UPDATE_OTHER_INFO_UPLOAD)
                    .endRow()
                    .build();
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di arte")) {
            saveMaterial(update, art, artname, "art");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di inglese")) {
            saveMaterial(update, eng, engname, "eng");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di geografia")) {
            saveMaterial(update, geo, geoname, "geo");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di storia")) {
            saveMaterial(update, his, hisname, "his");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di geometria")) {
            saveMaterial(update, geom, geomname, "geom");
        } else if (updateHasText(update, "/howtoclassroom") || updateHasText(update, "/howtoclassroom@schiavoduepuntozerorobot")) {

        } else if (updateIsReplyHasText(update, "rispondi con il materiale di italiano")) {
            saveMaterial(update, ita, itaname, "ita");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di matematica")) {
            saveMaterial(update, mat, matname, "mat");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale aggiuntivo")) {
            saveMaterial(update, othr, othrname, "othr");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di scienze")) {
            saveMaterial(update, sci, sciname, "sci");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di tedesco")) {
            saveMaterial(update, ger, gername, "ger");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di spagnolo")) {
            saveMaterial(update, spa, spaname, "spa");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di tecnica")) {
            saveMaterial(update, tec, tecname, "tec");
        } else if (updateIsReplyHasText(update, "rispondi con il materiale di religione")) {
            saveMaterial(update, rel, relname, "rel");
        } else if (updateHasText(update, "/clear") || updateHasText(update, "/clear@schiavoduepuntozerorobot")) {
            SendMessage m = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                    .setText("Di quale materia devi cancellare i file?")
                    .row()
                    .button("Matematica", CALLBACK_BUTTON_DELETE_MATHS)
                    .button("Arte", CALLBACK_BUTTON_DELETE_ART)
                    .endRow()
                    .row()
                    .button("Inglese", CALLBACK_BUTTON_DELETE_ENGLISH)
                    .button("Italiano", CALLBACK_BUTTON_DELETE_ITALIAN)
                    .endRow()
                    .row()
                    .button("Tecnica", CALLBACK_BUTTON_DELETE_TECHNOLOGY)
                    .button("Scienze", CALLBACK_BUTTON_DELETE_SCIENCE)
                    .endRow()
                    .row()
                    .button("Tedesco", CALLBACK_BUTTON_DELETE_GERMAN)
                    .button("Spagnolo", CALLBACK_BUTTON_DELETE_SPANISH)
                    .endRow()
                    .row()
                    .button("Geografia", CALLBACK_BUTTON_DELETE_GEOGRAPHY)
                    .button("Geometria", CALLBACK_BUTTON_DELETE_GEOMETRY)
                    .endRow()
                    .row()
                    .button("Storia", CALLBACK_BUTTON_DELETE_HISTORY)
                    .button("Religione", CALLBACK_BUTTON_DELETE_RELIGION)
                    .endRow()
                    .row()
                    .button("Altro", CALLBACK_BUTTON_DELETE_OTHER_INFO)
                    .endRow()
                    .build();
            try {
                execute(m);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (updateHasText(update, "/urgenthelp@schiavoduepuntozerorobot") || updateHasText(update, "Urgenteee!") || updateHasText(update, "/urgenthelp")) {
            request.put(update.getMessage().getFrom().getFirstName(), message_id);
            SendMessage m = new SendMessage();
            ForceReplyKeyboard f = new ForceReplyKeyboard();
            m.setReplyToMessageId(message_id);
            f.setSelective(true);
            m.setReplyMarkup(f);
            safeSendUpdate(update, m, "", "Ok. Ora rispondi a questo messaggio con la tua richiesta urgente", "");
        } else if (updateIsReplyHasText(update, "Ok. Ora rispondi a questo messaggio con la tua richiesta urgente")) {
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

        } else if (updateIsReplyHasText(update, "Dimmi la risposta alla richiesta di")) {
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
        } else if (updateHasText(update, "Materiale" + EmojiParser.parseToUnicode(":pencil:")) || updateHasText(update, "/material@schiavoduepuntozerorobot") || updateHasText(update, "/material")) {
            SendMessage m = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                    .setText("Che materiale ti serve?")
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
                    .button("Religione", CALLBACK_BUTTON_UPDATE_RELIGION)
                    .endRow()
                    .row()
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
            row.add("Materiale" + EmojiParser.parseToUnicode(":pencil:"));
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

    private boolean listContains(Collection toserach, String searchfor) {
        boolean found = false;
        Iterator<String> searchIter = toserach.iterator();
        while (searchIter.hasNext())
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
        if (update.hasMessage() && update.getMessage().isReply() && update.getMessage().getReplyToMessage().getText().contains(text)) {
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

    private void saveMaterial(Update update, LinkedList Collection, LinkedList serialisedname, String nameofCollection) {
        SendMessage m = new SendMessage();
        if (update.getMessage().hasDocument() || update.getMessage().hasPhoto() || update.getMessage().hasVideo() || update.getMessage().hasAudio()) {
            Fileid fileid = new Fileid();
            if (update.getMessage().hasDocument()) {
                if (!listContains(serialisedname, update.getMessage().getDocument().getFileUniqueId())) {
                    System.out.println("Document file_id: " + update.getMessage().getDocument().getFileId());
                    safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiegare meno di un secondo...", "");
                    serialisedname.add(update.getMessage().getDocument().getFileUniqueId());
                    Collection.add(update.getMessage().getDocument().getFileId());
                    if (nameofCollection.equals("eng")) {
                        fileid.writeMapEnglish(Collection);
                        fileid.writeMapEnglishName(serialisedname);
                    } else if (nameofCollection.equals("art")) {
                        fileid.writeMapArt(Collection);
                        fileid.writeMapArtName(serialisedname);
                    } else if (nameofCollection.equals("geo")) {
                        fileid.writeMapGeography(Collection);
                        fileid.writeMapGeographyName(serialisedname);
                    } else if (nameofCollection.equals("geom")) {
                        fileid.writeMapGeometry(Collection);
                        fileid.writeMapGeometryName(serialisedname);
                    } else if (nameofCollection.equals("ger")) {
                        fileid.writeMapGerman(Collection);
                        fileid.writeMapGermanName(serialisedname);
                    } else if (nameofCollection.equals("his")) {
                        fileid.writeMapHistory(Collection);
                        fileid.writeMapHistoryName(serialisedname);
                    } else if (nameofCollection.equals("ita")) {
                        fileid.writeMapItalian(Collection);
                        fileid.writeMapItalianName(serialisedname);
                    } else if (nameofCollection.equals("mat")) {
                        fileid.writeMapMaths(Collection);
                        fileid.writeMapMathsName(serialisedname);
                    } else if (nameofCollection.equals("othr")) {
                        fileid.writeMapOther(Collection);
                        fileid.writeMapOtherName(serialisedname);
                    } else if (nameofCollection.equals("rel")) {
                        fileid.writeMapReligion(Collection);
                        fileid.writeMapReligionName(serialisedname);
                    } else if (nameofCollection.equals("sci")) {
                        fileid.writeMapScience(Collection);
                        fileid.writeMapScienceName(serialisedname);
                    } else if (nameofCollection.equals("spa")) {
                        fileid.writeMapSpanish(Collection);
                        fileid.writeMapSpanishName(serialisedname);
                    } else if (nameofCollection.equals("tec")) {
                        fileid.writeMapTechnology(Collection);
                        fileid.writeMapTechnologyName(serialisedname);
                    }
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            } else if (update.getMessage().hasVideo()) {
                if (!listContains(serialisedname, update.getMessage().getVideo().getFileUniqueId())) {
                    System.out.println("Video file_id" + update.getMessage().getVideo().getFileId());
                    safeSendUpdate(update, m, "", "Sto salvando il file. Questa operazione dovrebbe impiegare meno di un secondo...", "");
                    serialisedname.add(update.getMessage().getVideo().getFileUniqueId());
                    Collection.add(update.getMessage().getVideo().getFileId());
                    if (nameofCollection.equals("eng")) {
                        fileid.writeMapEnglish(Collection);
                        fileid.writeMapEnglishName(serialisedname);
                    } else if (nameofCollection.equals("art")) {
                        fileid.writeMapArt(Collection);
                        fileid.writeMapArtName(serialisedname);
                    } else if (nameofCollection.equals("geo")) {
                        fileid.writeMapGeography(Collection);
                        fileid.writeMapGeographyName(serialisedname);
                    } else if (nameofCollection.equals("geom")) {
                        fileid.writeMapGeometry(Collection);
                        fileid.writeMapGeometryName(serialisedname);
                    } else if (nameofCollection.equals("ger")) {
                        fileid.writeMapGerman(Collection);
                        fileid.writeMapGermanName(serialisedname);
                    } else if (nameofCollection.equals("his")) {
                        fileid.writeMapHistory(Collection);
                        fileid.writeMapHistoryName(serialisedname);
                    } else if (nameofCollection.equals("ita")) {
                        fileid.writeMapItalian(Collection);
                        fileid.writeMapItalianName(serialisedname);
                    } else if (nameofCollection.equals("mat")) {
                        fileid.writeMapMaths(Collection);
                        fileid.writeMapMathsName(serialisedname);
                    } else if (nameofCollection.equals("othr")) {
                        fileid.writeMapOther(Collection);
                        fileid.writeMapOtherName(serialisedname);
                    } else if (nameofCollection.equals("rel")) {
                        fileid.writeMapReligion(Collection);
                        fileid.writeMapReligionName(serialisedname);
                    } else if (nameofCollection.equals("sci")) {
                        fileid.writeMapScience(Collection);
                        fileid.writeMapScienceName(serialisedname);
                    } else if (nameofCollection.equals("spa")) {
                        fileid.writeMapSpanish(Collection);
                        fileid.writeMapSpanishName(serialisedname);
                    } else if (nameofCollection.equals("tec")) {
                        fileid.writeMapTechnology(Collection);
                        fileid.writeMapTechnologyName(serialisedname);
                    }
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            } else if (update.getMessage().hasPhoto()) {
                Collection<PhotoSize> photos = (Collection<PhotoSize>) update.getMessage().getPhoto();
                String photofile_id = photos.stream()
                        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                        .findFirst()
                        .orElse(null).getFileId();
                String photofile_unique_id = photos.stream()
                        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                        .findFirst()
                        .orElse(null).getFileUniqueId();
                System.out.println("Photo file_id: " + photofile_id);
                if (!listContains(serialisedname, photofile_unique_id)) {
                    safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiegare meno di un secondo...", "");
                    Collection.add(photofile_id);
                    serialisedname.add(photofile_unique_id);
                    if (nameofCollection.equals("eng")) {
                        fileid.writeMapEnglish(Collection);
                        fileid.writeMapEnglishName(serialisedname);
                    } else if (nameofCollection.equals("art")) {
                        fileid.writeMapArt(Collection);
                        fileid.writeMapArtName(serialisedname);
                    } else if (nameofCollection.equals("geo")) {
                        fileid.writeMapGeography(Collection);
                        fileid.writeMapGeographyName(serialisedname);
                    } else if (nameofCollection.equals("geom")) {
                        fileid.writeMapGeometry(Collection);
                        fileid.writeMapGeometryName(serialisedname);
                    } else if (nameofCollection.equals("ger")) {
                        fileid.writeMapGerman(Collection);
                        fileid.writeMapGermanName(serialisedname);
                    } else if (nameofCollection.equals("his")) {
                        fileid.writeMapHistory(Collection);
                        fileid.writeMapHistoryName(serialisedname);
                    } else if (nameofCollection.equals("ita")) {
                        fileid.writeMapItalian(Collection);
                        fileid.writeMapItalianName(serialisedname);
                    } else if (nameofCollection.equals("mat")) {
                        fileid.writeMapMaths(Collection);
                        fileid.writeMapMathsName(serialisedname);
                    } else if (nameofCollection.equals("othr")) {
                        fileid.writeMapOther(Collection);
                        fileid.writeMapOtherName(serialisedname);
                    } else if (nameofCollection.equals("rel")) {
                        fileid.writeMapReligion(Collection);
                        fileid.writeMapReligionName(serialisedname);
                    } else if (nameofCollection.equals("sci")) {
                        fileid.writeMapScience(Collection);
                        fileid.writeMapScienceName(serialisedname);
                    } else if (nameofCollection.equals("spa")) {
                        fileid.writeMapSpanish(Collection);
                        fileid.writeMapSpanishName(serialisedname);
                    } else if (nameofCollection.equals("tec")) {
                        fileid.writeMapTechnology(Collection);
                        fileid.writeMapTechnologyName(serialisedname);
                    }
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            } else if (update.getMessage().hasAudio()) {
                if (!listContains(serialisedname, update.getMessage().getAudio().getFileUniqueId())) {
                    System.out.println(update.getMessage().getAudio().getFileId());
                    safeSendUpdate(update, m, "", "Sto scaricando il file. Questa operazione dovrebbe impiegare meno di un secondo...", "");
                    Collection.add(update.getMessage().getAudio().getFileId());
                    serialisedname.add(update.getMessage().getAudio().getFileUniqueId());
                    if (nameofCollection.equals("eng")) {
                        fileid.writeMapEnglish(Collection);
                        fileid.writeMapEnglishName(serialisedname);
                    } else if (nameofCollection.equals("art")) {
                        fileid.writeMapArt(Collection);
                        fileid.writeMapArtName(serialisedname);
                    } else if (nameofCollection.equals("geo")) {
                        fileid.writeMapGeography(Collection);
                        fileid.writeMapGeographyName(serialisedname);
                    } else if (nameofCollection.equals("geom")) {
                        fileid.writeMapGeometry(Collection);
                        fileid.writeMapGeometryName(serialisedname);
                    } else if (nameofCollection.equals("ger")) {
                        fileid.writeMapGerman(Collection);
                        fileid.writeMapGermanName(serialisedname);
                    } else if (nameofCollection.equals("his")) {
                        fileid.writeMapHistory(Collection);
                        fileid.writeMapHistoryName(serialisedname);
                    } else if (nameofCollection.equals("ita")) {
                        fileid.writeMapItalian(Collection);
                        fileid.writeMapItalianName(serialisedname);
                    } else if (nameofCollection.equals("mat")) {
                        fileid.writeMapMaths(Collection);
                        fileid.writeMapMathsName(serialisedname);
                    } else if (nameofCollection.equals("othr")) {
                        fileid.writeMapOther(Collection);
                        fileid.writeMapOtherName(serialisedname);
                    } else if (nameofCollection.equals("rel")) {
                        fileid.writeMapReligion(Collection);
                        fileid.writeMapReligionName(serialisedname);
                    } else if (nameofCollection.equals("sci")) {
                        fileid.writeMapScience(Collection);
                        fileid.writeMapScienceName(serialisedname);
                    } else if (nameofCollection.equals("spa")) {
                        fileid.writeMapSpanish(Collection);
                        fileid.writeMapSpanishName(serialisedname);
                    } else if (nameofCollection.equals("tec")) {
                        fileid.writeMapTechnology(Collection);
                        fileid.writeMapTechnologyName(serialisedname);
                    }
                    safeSendUpdate(update, m, "", "Il file è stato salvato", "");
                } else {
                    safeSendUpdate(update, m, "", "Il materiale è già stato salvato!", "");
                }
            }
        } else {
            safeSendUpdate(update, m, "", "Questo tipo di contenuto non può essere salvato. Per favore manda un file generico (pdf, .txt, .zip...), una foto, un file di audio o un video", "");
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

    private String userStatus(Update update) throws TelegramApiException {
        GetChatMember getChatMember = new GetChatMember();
        if (update.hasMessage()) {
            getChatMember.setChatId(chat_id(update));
            getChatMember.setUserId(update.getMessage().getFrom().getId());
            ChatMember member = execute(getChatMember);
            return member.getStatus();
        } else if (update.hasCallbackQuery()) {
            getChatMember.setChatId(chat_id(update));
            getChatMember.setUserId(update.getCallbackQuery().getMessage().getFrom().getId());
            ChatMember member = execute(getChatMember);
            return member.getStatus();
        } else {
            return null;
        }
    }

    private ArrayList<ChatMember> chatAdmins(Update update, GetChatAdministrators chatAdministrators) throws TelegramApiException {
        chatAdministrators.setChatId(update.getMessage().getChatId());
        ArrayList<ChatMember> chatMemberArray = execute(chatAdministrators);
        System.out.println(chatMemberArray);
        return chatMemberArray;
    }

    private void getResources(Update update, LinkedList<String> list, String listname) throws TelegramApiException {
        DeleteMessage dmsg = new DeleteMessage(update.getCallbackQuery().getMessage().getChatId(), update.getCallbackQuery().getMessage().getMessageId());
        deleteMessage(update, dmsg, "");
        if (list.size() == 1) {
            if (list.getFirst().startsWith("BQACAgQAA")) {
                SendDocument d = new SendDocument();
                InputFile f = new InputFile();
                f.setMedia(list.get(0));
                d.setDocument(f);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                d.setCaption("Questo è l'unico file che ho trovato");
                try {
                    execute(d);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (list.getFirst().startsWith("AgACAgQAA")) {
                SendPhoto d = new SendPhoto();
                InputFile f = new InputFile();
                f.setMedia(list.get(0));
                d.setPhoto(f);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                d.setCaption("Questo è l'unico file che ho trovato");
                try {
                    execute(d);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (list.getFirst().startsWith("CQACAgQAA")) {
                SendAudio d = new SendAudio();
                InputFile f = new InputFile();
                f.setMedia(list.get(0));
                d.setAudio(f);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                d.setCaption("Questo è l'unico file che ho trovato");
                try {
                    execute(d);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (list.getFirst().startsWith("CgACAgQAA")) {
                SendVideo d = new SendVideo();
                InputFile f = new InputFile();
                f.setMedia(list.get(0));
                d.setVideo(f);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                d.setCaption("Questo è l'unico file che ho trovato");
                try {
                    execute(d);
                } catch (TelegramApiException e) {
                    e.printStackTrace();

                }
            }
        } else if (list.size() != 0 && list.size() != 1) {
            ListIterator<String> iterate = list.listIterator();
            String file_id = iterate.next();
            System.out.println(file_id);
            if (list.getFirst().startsWith("BQACAgQAA")) {
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                SendDocument d = new SendDocument();
                rowInline.add(new InlineKeyboardButton().setText("«").setCallbackData(listname + "_p"));
                rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(":x:")).setCallbackData(CALLBACK_BUTTON_UPDATE_CANCEL));
                rowInline.add(new InlineKeyboardButton().setText("»").setCallbackData(listname + "_n"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                d.setReplyMarkup(markupInline);
                d.setDocument(file_id);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                execute(d);
            } else if (list.getFirst().startsWith("AgACAgQAA")) {
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                SendAudio d = new SendAudio();
                rowInline.add(new InlineKeyboardButton().setText("«").setCallbackData(listname + "_p"));
                rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(":x:")).setCallbackData(CALLBACK_BUTTON_UPDATE_CANCEL));
                rowInline.add(new InlineKeyboardButton().setText("»").setCallbackData(listname + "_n"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                d.setReplyMarkup(markupInline);
                d.setAudio(file_id);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                execute(d);
            } else if (list.getFirst().startsWith("CQACAgQAA")) {
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                SendAudio d = new SendAudio();
                rowInline.add(new InlineKeyboardButton().setText("«").setCallbackData(listname + "_p"));
                rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(":x:")).setCallbackData(CALLBACK_BUTTON_UPDATE_CANCEL));
                rowInline.add(new InlineKeyboardButton().setText("»").setCallbackData(listname + "_n"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                d.setReplyMarkup(markupInline);
                d.setAudio(file_id);
                d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                execute(d);
            } else if (list.getFirst().startsWith("BAACAgQAA")) {
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    SendVideo d = new SendVideo();
                    rowInline.add(new InlineKeyboardButton().setText("«").setCallbackData(listname + "_p"));
                    rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(":x:")).setCallbackData(CALLBACK_BUTTON_UPDATE_CANCEL));
                    rowInline.add(new InlineKeyboardButton().setText("»").setCallbackData(listname + "_n"));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                    d.setReplyMarkup(markupInline);
                    d.setVideo(file_id);
                    d.setChatId(update.getCallbackQuery().getMessage().getChatId());
                    execute(d);
            }
        } else {
            SendMessage m = new SendMessage();
            safeSendUpdate(update, m, "", "Non ci sono materiali per questo corso", "");
        }
    }

    private void getPrevious(Update update, LinkedList list, String listname){
        Iterator<String> iterate = list.descendingIterator();
        System.out.println(list);
        String next = iterate.next();
        String lol = iterate.next();
        System.out.println(lol);
        System.out.println(next);
        EditMessageMedia media = new EditMessageMedia();
        if (next.startsWith("BQACAgQAA")) {
            if (iterate.hasNext() && update.getCallbackQuery().getMessage().getDocument().getFileId() != lol) {
                InputMediaDocument d = new InputMediaDocument();
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("«").setCallbackData(listname + "_p"));
                rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(":x:")).setCallbackData(CALLBACK_BUTTON_UPDATE_CANCEL));
                rowInline.add(new InlineKeyboardButton().setText("»").setCallbackData(listname + "_n"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                d.setMedia(lol);
                media.setChatId(update.getCallbackQuery().getMessage().getChatId());
                media.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
                media.setMedia(d);
                media.setReplyMarkup(markupInline);
            }
        }
    }


    private void getNext(Update update, ListIterator <String> iterate, String listname) throws TelegramApiException {
        EditMessageMedia media = new EditMessageMedia();
        String lol = iterate.next();
        System.out.println("*********" + lol);
        if (lol.startsWith("BQACAgQAA")) {
            if (iterate.hasPrevious() && update.getCallbackQuery().getMessage().getDocument().getFileId() != lol) {
                InputMediaDocument d = new InputMediaDocument();
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("«").setCallbackData(listname + "_p"));
                rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(":x:")).setCallbackData(CALLBACK_BUTTON_UPDATE_CANCEL));
                rowInline.add(new InlineKeyboardButton().setText("»").setCallbackData(listname + "_n"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                d.setMedia(lol);
                media.setChatId(update.getCallbackQuery().getMessage().getChatId());
                media.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
                media.setMedia(d);
                media.setReplyMarkup(markupInline);
            }
        } else if (lol.startsWith("BQACAgQAA")) {
            InputMediaPhoto d = new InputMediaPhoto();
            d.setMedia(lol);
            media.setChatId(update.getCallbackQuery().getMessage().getChatId());
            media.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            media.setMedia(d);
        } else if (lol.startsWith("CQACAgQAA")) {
            InputMediaAudio d = new InputMediaAudio();
            d.setMedia(lol);
            media.setChatId(update.getCallbackQuery().getMessage().getChatId());
            media.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            media.setMedia(d);
        } else if (lol.startsWith("CgACAgQAA")) {
            InputMediaVideo d = new InputMediaVideo();
            d.setMedia(lol);
            media.setChatId(update.getCallbackQuery().getMessage().getChatId());
            media.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            media.setMedia(d);
        }
        execute(media);
    }


    private boolean isAdmin(Update update) throws TelegramApiException {
        if (update.hasMessage()) {
            GetChatAdministrators admin = new GetChatAdministrators()
                    .setChatId(update.getMessage().getChatId());
            ArrayList<ChatMember> alladmins = execute(admin);
            if (alladmins.contains(update.getMessage().getFrom().getUserName())) {
                return true;
            } else {
                return false;
            }
        } else if (update.hasCallbackQuery()) {
            GetChatAdministrators admin = new GetChatAdministrators()
                    .setChatId(update.getCallbackQuery().getMessage().getChatId());
            ArrayList<ChatMember> alladmins = execute(admin);
            if (alladmins.contains(update.getMessage().getFrom().getUserName())) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}

