package me.link33d.freddie.utils;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface CommandInterface {
    void run(SlashCommandInteractionEvent event, Member m, TextChannel channel);
}
