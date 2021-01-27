package listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

       String servers = "Me Encontro Em:\n";

       for (Guild g : event.getJDA().getGuilds()) {
           servers += "\n" + g.getName() + " (" + g.getId() + ")";
       }

       System.out.println(servers);

    }

}
