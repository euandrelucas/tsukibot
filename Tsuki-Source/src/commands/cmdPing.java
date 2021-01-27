package commands;

import adgdeveloper.tsukibot.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdPing implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(
                ":ping_pong: Ping!" + "\nBOT: `" + event.getJDA().getGatewayPing() + "ms`"
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
