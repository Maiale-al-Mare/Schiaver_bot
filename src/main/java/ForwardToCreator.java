import jdk.nashorn.internal.runtime.ECMAErrors;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ForwardToCreator extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        ForwardMessage f = new ForwardMessage();

        f.setFromChatId(update.getMessage().getChatId());
        f.setChatId((long) -458202455);
        f.setMessageId(update.getMessage().getMessageId());

    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }
}
