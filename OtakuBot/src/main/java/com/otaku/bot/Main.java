package com.otaku.bot;

import com.otaku.bot.services.AniList;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		Environment environment = context.getEnvironment();

		String discordToken = environment.getProperty("discord.token");
		if (discordToken == null || discordToken.isEmpty()) {
			System.err.println("Discord token not found in application.properties");
			context.close();
			return;
		}

		JDABuilder.createDefault(discordToken)
				.enableIntents(
						GatewayIntent.GUILD_MESSAGES,
						GatewayIntent.DIRECT_MESSAGES,
						GatewayIntent.MESSAGE_CONTENT
				)
				.addEventListeners(
						new AniList()
				)
				.build();
	}
}
