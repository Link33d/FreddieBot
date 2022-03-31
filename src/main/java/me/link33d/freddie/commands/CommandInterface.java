package me.link33d.freddie.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.json.JSONObject;

public interface CommandInterface {
    public void performCommand(SlashCommandInteractionEvent event, Member m, TextChannel channel);
}
