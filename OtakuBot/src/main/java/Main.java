import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.File;
import java.io.IOException;

/**
 *  The Main class is responsible for initializing the Discord bot by reading the bot token from a JSON file and
 *  creating an instance of the AniListBot listener. To use this software, you need to create a personal bot token on the
 *  Discord Developer Portal. Follow the instructions provided at the link below to create your token:
 *  <a href="https://discord.com/developers/docs/intro">Discord Developer Portal</a>
 *  Once you have your personal bot token, create a JSON file on your desktop to store it. This JSON file should follow
 *  a specific format and include the bot token information. The Main class will read this file to retrieve the bot token.
 *  The path is configured for a Windows computer with one drive. Different computers may have different paths. This can be
 *  changed below.
 *
 * @author <a href="https://www.linkedin.com/in/gage-carpenter-07750a174/"> Gage Carpenter </a>
 */
public class Main {

    /**
     * The main method serves as the entry point of the application. It initializes the Discord bot by reading the bot token
     * from a JSON file and creates an instance of the AniListBot listener. The JSON file should contain the necessary
     * configuration information, including the Discord bot token.
     * The path to the JSON file is constructed using the user's home directory and the relative path to the file. Ensure that
     * the JSON file follows the required format and includes the "OTAKU_DISCORD_BOT_TOKEN" key with the corresponding Discord
     * bot token value.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            File configFile = new File(System.getProperty("user.home") + "/OneDrive/Desktop/Secrets.json"); //Path to discord bot token
            JDABuilder
                    .createDefault(mapper.readTree(configFile).get("OTAKU_DISCORD_BOT_TOKEN").asText()) //Token key in Secrets.json
                    .enableIntents(GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.DIRECT_MESSAGES,
                            GatewayIntent.MESSAGE_CONTENT
                    ) // Enable intents including message content
                    .addEventListeners(new AniListBot())
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
