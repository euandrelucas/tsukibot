package commands;

import adgdeveloper.tsukibot.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.MiscUtil;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class cmdBotinfo implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        var servidores = event.getJDA().getGuilds().size();

        var mensagem = "nada";

        if(servidores == 1) {
            mensagem = "servidor";
        }

        if(servidores > 1) {
            mensagem = "servidores";
        }

        var eu = event.getJDA().getSelfUser().getEffectiveAvatarUrl();

        var embed = new EmbedBuilder();
        embed.setTitle("Tsuki | Botinfo");
        embed.setThumbnail(eu);
        embed.setDescription("Olá, meu nome é **Tsuki**, sou um bot para discord tenho 15 anos, fui criado no dia `27/01/2021` por `ADG`, atualmente estou em **"+ servidores + " " + mensagem + "** distribuindo felicidade para todos eles\n\nEu fui programado em <:jda:804063541983969332> [JDA](https://github.com/DV8FromTheWorld/JDA), ultilizando o java, alias eu sou open-source (caso queira ver clique [aqui](https://github.com/yADGithub/tsukibot))");
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
