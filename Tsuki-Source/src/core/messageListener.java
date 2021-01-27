package core;

import adgdeveloper.tsukibot.commandHandler;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.UTILS;

public class messageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;
        }

        if(event.getChannelType() == ChannelType.PRIVATE) {
            event.getAuthor().openPrivateChannel().complete().sendMessage(
                    ":x: **" + event.getAuthor().getName() + "** **|** Desculpa mais não aceito mensagens privadas :("
            ).queue();
            return;
            // event.getMessage().getContentDisplay()

        }

        String message = event.getMessage().getContentDisplay();

        if(message.startsWith(UTILS.getPrefix) && event.getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            commandHandler.handleCommand(commandHandler.parser.parse(message, event));
        }



    }

}
