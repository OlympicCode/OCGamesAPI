package net.olympiccode.ocgamesapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        return false;
    }

    public String mainHelpMessage() {
        return "mainHelp";
    }

    public String adminHelpMessage() {
        return "adminHelp";
    }
}
