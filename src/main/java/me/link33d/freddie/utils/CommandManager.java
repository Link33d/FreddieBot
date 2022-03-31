package me.link33d.freddie.utils;


import me.link33d.freddie.FreddieBot;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import me.link33d.freddie.commands.*;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandManager extends ListenerAdapter {

    private Map<String, CommandInterface> commandsMap;
    CommandListUpdateAction commands = FreddieBot.jda.updateCommands();

    public CommandManager() {

        commandsMap = new ConcurrentHashMap<>();

        registerCommand(new PingCommand(), Commands.slash("ping", "See my ping!"));

        commands.queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        String commandName = event.getName();

        CommandInterface command;

        if ((command = commandsMap.get(commandName)) != null) {
            command.run(event, event.getMember(), event.getTextChannel());
        }
    }

    private void registerCommand(CommandInterface command, SlashCommandData commandOptions) {
        this.commandsMap.put(commandOptions.getName(), command);
        commands.addCommands(commandOptions);
    }
}
