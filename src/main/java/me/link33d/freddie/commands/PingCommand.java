package me.link33d.freddie.commands;

import me.link33d.freddie.utils.CommandInterface;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PingCommand implements CommandInterface {

    @Override
    public void run(SlashCommandInteractionEvent event, Member m, TextChannel channel) {
        event.reply("My ping is: " + event.getJDA().getGatewayPing() + "ms").queue();
    }
}
