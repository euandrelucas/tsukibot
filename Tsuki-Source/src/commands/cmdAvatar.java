package commands;

import adgdeveloper.tsukibot.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdAvatar implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        var user = event.getAuthor();

        // event.getAuthor().getAvatarUrl();
        if(args.length >= 1) {
            user = event.getJDA().getUserById(args[0]);
        }

        if(user == null) {
            user = event.getAuthor();
        }

        //var foto = user.getEffectiveAvatarUrl();

        var formato = ".png";

        if(user.getAvatarId().startsWith("a_")) {
            formato = ".gif";
        }

        var foto = "https://cdn.discordapp.com/avatars/"+ user.getId() +"/"+ user.getAvatarId() + formato +"?size=2048";

        var eu = event.getJDA().getSelfUser().getEffectiveAvatarUrl();

        var embed = new EmbedBuilder();
        embed.setTitle("Tsuki | Avatar");
        embed.setDescription("> <:wumplus:801507706807517234> • Avatar de: **"+ user.getName() +"**\n[Clique Aqui](" + foto + ") para baixar!\n");
        embed.setThumbnail(eu);
        embed.setImage(foto);
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
