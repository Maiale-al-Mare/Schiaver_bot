import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardBuilder {

    private Long chatId;
    private String text;

    private List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
    private List<InlineKeyboardButton> row = null;

    private InlineKeyboardBuilder() {}

    public static InlineKeyboardBuilder create() {
        InlineKeyboardBuilder builder = new InlineKeyboardBuilder();
        return builder;
    }

    public static InlineKeyboardBuilder create(Long chatId) {
        InlineKeyboardBuilder builder = new InlineKeyboardBuilder();
        builder.setChatId(chatId);
        return builder;
    }

    public InlineKeyboardBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public InlineKeyboardBuilder setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public InlineKeyboardBuilder row() {
        this.row = new ArrayList<>();
        return this;
    }

    public InlineKeyboardBuilder button(String text, String callbackData) {
        row.add(new InlineKeyboardButton().setText(text).setCallbackData(callbackData));
        return this;
    }

    public InlineKeyboardBuilder endRow() {
        this.keyboard.add(this.row);
        this.row = null;
        return this;
    }

    public EditMessageText edit(String text){
        Update update = new Update();
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);

        EditMessageText newmessage = new EditMessageText();

        newmessage.setChatId(chatId);
        newmessage.setMessageId(update.getMessage().getMessageId());
        newmessage.setText(text);
        newmessage.setReplyMarkup(keyboardMarkup);


        return newmessage;
    }

    public SendMessage build() {
        SendMessage message = new SendMessage();

        message.setChatId(chatId);
        message.setText(text);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);

        message.setReplyMarkup(keyboardMarkup);

        return message;
    }

}

