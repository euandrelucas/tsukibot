package adgdeveloper.tsukibot;

import commands.cmdHelp;
import commands.cmdPing;
import core.messageListener;
import listeners.ReadyListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class MainExample {

    static JDA jda;

    public static void main(String[] args) {

        String token = "You Bot Token Here :)";

        JDABuilder builder = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .setAutoReconnect(true);

        builder.setActivity(Activity.watching("Televisão :)"));

        builder.addEventListeners(new ReadyListener());
        builder.addEventListeners(new messageListener());

        commandHandler.commands.put("help", new cmdHelp());
        commandHandler.commands.put("ping", new cmdPing());

        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
