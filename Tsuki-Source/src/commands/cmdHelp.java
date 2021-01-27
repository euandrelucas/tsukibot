package commands;

import adgdeveloper.tsukibot.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdHelp implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        var foto = event.getJDA().getSelfUser().getEffectiveAvatarUrl();

        var embed = new EmbedBuilder();
                embed.setTitle("Tsuki | Help");
                embed.setThumbnail(foto);
                embed.setDescription("> **COMANDOS**\n" +
                        "\n`t!help` - Mostra os Comandos" +
                        "\n`t!ping` - Mostra a latência do bot" +
                        "\n`t!avatar` - Mostra o seu avatar");
                embed.setColor(Color.RED);
        event.getTextChannel().sendMessage(
                embed.build()
        ).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
