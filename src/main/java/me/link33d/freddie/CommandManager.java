package me.link33d.freddie;


import me.link33d.freddie.commands.CommandInterface;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import me.link33d.freddie.commands.*;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandManager extends ListenerAdapter {

    private Map<String, CommandInterface> commandsMap;

    public CommandManager() {

        commandsMap = new ConcurrentHashMap<>();

        this.commandsMap.put("ping", new PingCommand());

        CommandListUpdateAction commands = FreddieBot.jda.updateCommands();

        commands.addCommands(Commands.slash("ping", "See my ping!"));

        commands.queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        String commandName = event.getName();

        CommandInterface command;

        if ((command = commandsMap.get(commandName)) != null) {
            command.performCommand(event, event.getMember(), event.getTextChannel());
        }
    }
}
