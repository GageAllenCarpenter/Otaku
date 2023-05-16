import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AniListBot extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String messageContent = event.getMessage().getContentRaw();
        if (messageContent.startsWith("!anime")) {
            String query = messageContent.substring(7).trim();
            // Perform API request to AniList with the query
            // Parse the response and send the information back to the Discord channel
            // You can use a library like Retrofit or OkHttp for making HTTP requests to the AniList API
        }
    }
}
