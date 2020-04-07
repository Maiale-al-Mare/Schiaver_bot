import com.vdurmont.emoji.EmojiParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultGif;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultMpeg4Gif;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DogTron extends TelegramLongPollingBot {


    Map<String, Integer> map2 = null;
    private static final String CALLBACK_BUTTON_UPDATE_AWW = "awww";
    Logger consoleLogger = LogManager.getLogger("console");

    @Override
    public void onUpdateReceived(Update update) {


        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        User from = captureUserIds(update);

        if (update.hasMessage()) {
            if (updateHasText(update, "/dog") || updateHasText(update, "/dog@DogTronRobot")) {
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
            } else if (updateHasText(update, "/cat") || updateHasText(update, "/cat@DogTronRobot")) {
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
            } else if (updateHasText(update, "/start")) {
                SendMessage m = new SendMessage();
                safeSendUpdate(update, m, "", "Hi! I'm DogTron. Whenever you're feeling down (or any time at all, really), I can cheer you up by sending you cute dog GIFs and photos.\n" +
                        "Regardless of what they say, dogs and cats can get along, and to prove that I'll also send you cat pictures! " + EmojiParser.parseToUnicode(":cat:") + "\nJust ask!");
            } else if (updateHasText(update, "/help")){
                SendMessage m = new SendMessage();
                rowInline.add(new InlineKeyboardButton().setText("Try me inline!").setSwitchInlineQuery("dog"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                m.setReplyMarkup(markupInline);
                m.setParseMode("HTML");
                safeSendUpdate(update, m, "", "Hi! The available commands are /help (obviously), /start, /dog and /cat. They're all quite self-explanatory...\n" +
                        "I also work inline! Just type '@DogeTronRobot cat' or '@DogeTronRobot dog' in <b>any chat, even ones I'm not a member of</b>, to generate DA GUD STUFF with a button under it.\n" +
                        "Users will be able to 'awww' it by pressing the aformentioned button and the cuteness counter will increase by one.\n" +
                        "Try it!");
            } else {
                if (update.getMessage().hasPhoto()) {
                    SendMessage m = new SendMessage();
                    safeSendUpdate(update, m, "", "That photo's really great, I know");
                } else if (update.getMessage().hasAnimation()) {
                    SendMessage m = new SendMessage();
                    safeSendUpdate(update, m, "", "Yeah, that GIF's great");
                } else if (update.getMessage().hasVideo()){
                    SendMessage m = new SendMessage();
                    safeSendUpdate(update, m, "", "Nice video!");
                } else {
                    SendMessage m = new SendMessage();
                    safeSendUpdate(update, m, "", "Command not recognised!");
                }
            }
        }

        if (update.hasInlineQuery()) {
            System.out.println("Inline query found");
            String query = update.getInlineQuery().getQuery();
            AnswerInlineQuery q = new AnswerInlineQuery();
            if (query.equals("dog")) {
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
                if (pageName.toLowerCase().contains(".jpg") || pageName.contains(".jpeg") || pageName.contains(".png")) {
                    rowInline.add(new InlineKeyboardButton().setText("Awww! :3 ").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":0:null"));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                    InlineQueryResultPhoto ph = new InlineQueryResultPhoto()
                            .setCaption("DOG!!")
                            .setThumbUrl(pageName)
                            .setId(update.getInlineQuery().getId())
                            .setMimeType("photo")
                            .setReplyMarkup(markupInline)
                            .setTitle("Random dogs")
                            .setPhotoUrl(pageName);
                    q.setResults(ph);
                    q.setInlineQueryId(update.getInlineQuery().getId());
                    q.setPersonal(false);
                    q.setCacheTime((int) 0.01);
                    try {
                        execute(q);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pageName.contains(".gif")) {
                    rowInline.add(new InlineKeyboardButton().setText("Awww! :3 ").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":0:null"));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                    InlineQueryResultGif gif = new InlineQueryResultGif()
                            .setCaption("DOG!!")
                            .setThumbUrl(pageName)
                            .setId(update.getInlineQuery().getId())
                            .setTitle("Random dogs")
                            .setReplyMarkup(markupInline)
                            .setGifUrl(pageName);
                    q.setResults(gif);
                    q.setInlineQueryId(update.getInlineQuery().getId());
                    q.setPersonal(false);
                    q.setCacheTime((int) 0.01);
                    try {
                        execute(q);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pageName.contains(".mp4") || pageName.contains(".webm")) {
                    rowInline.add(new InlineKeyboardButton().setText("Awww! :3 ").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":0:null"));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                    InlineQueryResultMpeg4Gif vid = new InlineQueryResultMpeg4Gif()
                            .setCaption("DOG!!")
                            .setThumbUrl(pageName)
                            .setId(update.getInlineQuery().getId())
                            .setTitle("Random dogs")
                            .setReplyMarkup(markupInline)
                            .setMpeg4Url(pageName);
                    q.setResults(vid);
                    q.setInlineQueryId(update.getInlineQuery().getId());
                    q.setPersonal(false);
                    q.setCacheTime((int) 0.01);
                    try {
                        execute(q);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            } else if (query.equals("cat")) {
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
                rowInline.add(new InlineKeyboardButton().setText("Awww! :3 ").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":0:null"));
                rowsInline.add(rowInline);
                markupInline.setKeyboard(rowsInline);
                InlineQueryResultPhoto ph = new InlineQueryResultPhoto()
                        .setPhotoUrl(pageName)
                        .setMimeType("photo")
                        .setThumbUrl(pageName)
                        .setId(update.getInlineQuery().getId())
                        .setCaption("CAT!!")
                        .setReplyMarkup(markupInline)
                        .setTitle("Random cats");
                q.setResults(ph);
                q.setInlineQueryId(update.getInlineQuery().getId());
                q.setPersonal(false);
                q.setCacheTime((int) 0.01);
                try {
                    execute(q);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                sleepFor(2);
                InputTextMessageContent input = new InputTextMessageContent();
                input.setParseMode("HTML");
                input.setMessageText("Hi, everyone! <b>Make sure you write 'dog' or 'cat' after my username if you want to use me in inline mode!</b>");
                InlineQueryResultPhoto ph = new InlineQueryResultPhoto()
                        .setPhotoUrl("http://catchingfire.ca/wp-content/uploads/2016/09/question-mark-square-01.png")
                        .setMimeType("photo")
                        .setTitle("Huh?")
                        .setId(update.getInlineQuery().getId())
                        .setThumbUrl("http://catchingfire.ca/wp-content/uploads/2016/09/question-mark-square-01.png")
                        .setId(update.getInlineQuery().getId())
                        .setInputMessageContent(input);
                q.setResults(ph);
                q.setInlineQueryId(update.getInlineQuery().getId());
                q.setPersonal(false);
                q.setCacheTime((int) 0.01);
                try {
                    execute(q);
                    System.out.println("Query not valid");
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        if (update.hasCallbackQuery() && !update.getCallbackQuery().getData().equals("")) {
            String call_data = update.getCallbackQuery().getData();
            if (call_data.startsWith(CALLBACK_BUTTON_UPDATE_AWW)) {
                if (map2 == null) {
                    consoleLogger.debug("Loading map");
                    Userserializer userserializer = new Userserializer();
                    map2 = userserializer.readMap();
                    consoleLogger.debug("Loaded " + map2.size());
                }
                System.out.println(call_data);
                String[] awwcount = update.getCallbackQuery().getData().split(":");
                int totalaww = Integer.parseInt(awwcount[1]);
                if (!call_data.contains(String.valueOf(from.getId()))) {
                    String userswhoanswered = awwcount[2].replaceAll("null", " ");
                    System.out.println(userswhoanswered);
                    totalaww++;
                    rowInline.add(new InlineKeyboardButton().setText("Awww! :3 " + "(" + totalaww + ")").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":" + totalaww + ":" + from.getId() + userswhoanswered));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                } else if (call_data.contains(String.valueOf(from.getId()))) {
                    String userswhoanswered = awwcount[2].replaceAll("null", " ");
                    String userswhoansweredminusyou = userswhoanswered.replaceAll(String.valueOf(from.getId()), "");
                    totalaww--;
                    if (totalaww != 0) {
                        rowInline.add(new InlineKeyboardButton().setText("Awww! :3 " + "(" + totalaww + ")").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":" + totalaww + ":" + userswhoansweredminusyou));
                    } else {
                        rowInline.add(new InlineKeyboardButton().setText("Awww! :3 ").setCallbackData(CALLBACK_BUTTON_UPDATE_AWW + ":0:null"));
                    }
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                }
                EditMessageReplyMarkup new_message = new EditMessageReplyMarkup()
                        .setInlineMessageId(update.getCallbackQuery().getInlineMessageId())
                        .setReplyMarkup(markupInline);
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "DogTronRobot";
    }

    @Override
    public String getBotToken() {
        return "994725858:AAFrJRBdHuK8BwQTfU27iFK58OqPhNXBALI";
    }

    private boolean updateHasText(Update update, String text) {
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
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

    private void sleepFor(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
